package com.expressway.billmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expressway.billmanagement.data.mappers.SystemMenuItemMapper;
import com.expressway.billmanagement.data.mappers.SystemMenuMapper;
import com.expressway.billmanagement.data.mappers.SystemMenuMenuitemMapper;
import com.expressway.billmanagement.data.models.SystemMenu;
import com.expressway.billmanagement.data.models.SystemMenuItem;
import com.expressway.billmanagement.data.models.SystemMenuMenuitem;
import com.expressway.billmanagement.service.ISystemMenuService;
import com.expressway.billmanagement.service.messages.FeedBackMessage;
import com.expressway.billmanagement.service.protocal.ConditionFiled;
import com.expressway.billmanagement.service.tree.CheckedNode;
import com.expressway.billmanagement.service.tree.inters.INode;

import tk.mybatis.mapper.entity.Example;

/**
 * 菜单管理
 *
 * @author FXStudio.Ajaxfan
 */
@Service
final class SystemMenuService implements ISystemMenuService {
	private @Autowired SystemMenuMapper systemMenuMapper;
	private @Autowired SystemMenuMenuitemMapper systemMenuMenuitemMapper;
	private @Autowired SystemMenuItemMapper systemMenuItemMapper;

	/**
	 * 添加新的菜单
	 *
	 * @param menu
	 *            菜单对象
	 * @param itemIds
	 *            菜单项Id集合
	 * @return 消息
	 */
	@Override
	@Transactional
	public FeedBackMessage add(SystemMenu menu, String[] itemIds) {
		systemMenuMapper.insertSelective(menu);
		addRelative(menu.getSysid(), itemIds);

		return new FeedBackMessage(true);
	}

	/**
	 * 删除菜单
	 *
	 * @param sysid
	 *            菜单ID
	 * @return 消息
	 */
	@Override
	@Transactional
	public FeedBackMessage del(String sysid) {
		// 删除菜单记录
		systemMenuMapper.deleteByPrimaryKey(sysid);
		// 删除菜单和菜单项的关系记录
		delRelative(sysid);

		return new FeedBackMessage(true);
	}

	/**
	 * 修改菜单信息
	 *
	 * @param menu
	 *            菜单对象
	 * @param itemIds
	 *            菜单项ID集合
	 * @return 消息
	 */
	@Override
	@Transactional
	public FeedBackMessage update(SystemMenu menu, String[] itemIds) {
		// 变更菜单信息
		systemMenuMapper.updateByPrimaryKey(menu);
		// 删除菜单和菜单项的关系记录
		delRelative(menu.getSysid());
		// 添加新的关系记录
		addRelative(menu.getSysid(), itemIds);

		return new FeedBackMessage(true);
	}

	/**
	 * 展开菜单
	 *
	 * @param sysid
	 * @return
	 */
	@Override
	public List<INode> extratMenus(String sysid) {
		// 菜单树对象
		List<INode> list = new ArrayList<INode>();
		// 查询条件
		Example condition = new Example(SystemMenuMenuitem.class);
		condition.createCriteria().andEqualTo("menuid", sysid);
		// 已经选中菜单项
		List<SystemMenuMenuitem> checkeds = systemMenuMenuitemMapper.selectByExample(condition);

		for (SystemMenuItem smi : systemMenuItemMapper.selectAll()) {
			CheckedNode node = new CheckedNode();// 带有Check状态的树节点
			node.setSn(smi.getSysid());// 节点ID
			node.setText(smi.getItemname());// 节点名称
			node.setChecked(isChecked(smi.getSysid(), checkeds));// 节点被选中

			list.add(node);
		}
		return list;
	}

	/**
	 * @param cf
	 * @return
	 */
	@Override
	public List<SystemMenu> findRecords(ConditionFiled cf) {
		return systemMenuMapper.selectByExampleAndRowBounds(null,
				new RowBounds(cf.getStart(), cf.getLimit() - cf.getStart()));
	}

	@Override
	@Deprecated
	public Integer getSize(ConditionFiled cf) {
		throw new UnsupportedOperationException();
	}

	// ---------------------------------------------------- 私有方法
	/**
	 * 删除菜单和菜单项对应关系记录
	 *
	 * @param sysid
	 *            菜单主键
	 */
	private void delRelative(String sysid) {
		Example condition = new Example(SystemMenuMenuitem.class);
		condition.createCriteria().andEqualTo("menuid", sysid);
		systemMenuMenuitemMapper.deleteByExample(condition);
	}

	/**
	 * 添加关系记录
	 *
	 * @param menuId
	 *            菜单ID
	 * @param itemIds
	 *            菜单项ID集合
	 */
	private void addRelative(String menuId, String[] itemIds) {
		for (String itemId : itemIds) {
			SystemMenuMenuitem relation = new SystemMenuMenuitem();
			relation.setMenuid(menuId);
			relation.setItemid(itemId);

			systemMenuMenuitemMapper.insertSelective(relation);
		}
	}

	/**
	 * 节点是否被选中
	 *
	 * @param sysid
	 * @param items
	 * @return
	 */
	private boolean isChecked(String sysid, List<SystemMenuMenuitem> items) {
		for (SystemMenuMenuitem smmi : items) {
			if (sysid.equals(smmi.getItemid())) {
				return true;
			}
		}
		return false;
	}
}
