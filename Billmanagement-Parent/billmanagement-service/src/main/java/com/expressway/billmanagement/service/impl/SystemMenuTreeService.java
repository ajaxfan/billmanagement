package com.expressway.billmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expressway.billmanagement.data.mappers.SystemGroupMenuMapper;
import com.expressway.billmanagement.data.mappers.SystemMenuItemMapper;
import com.expressway.billmanagement.data.mappers.SystemMenuMapper;
import com.expressway.billmanagement.data.mappers.SystemMenuMenuitemMapper;
import com.expressway.billmanagement.data.models.SystemGroupMenu;
import com.expressway.billmanagement.data.models.SystemMenu;
import com.expressway.billmanagement.data.models.SystemMenuItem;
import com.expressway.billmanagement.data.models.SystemMenuMenuitem;
import com.expressway.billmanagement.service.ISystemMenuTreeService;
import com.expressway.billmanagement.service.tree.NormalNode;
import com.expressway.billmanagement.service.tree.inters.INode;

import tk.mybatis.mapper.entity.Example;

/**
 * 系统功能树
 *
 * @author FXStudio.Ajaxfan
 */
@Service
final class SystemMenuTreeService implements ISystemMenuTreeService {
	private @Autowired SystemGroupMenuMapper systemGroupMenuMapper;
	private @Autowired SystemMenuMapper systemMenuMapper;
	private @Autowired SystemMenuMenuitemMapper systemMenuMenuitemMapper;
	private @Autowired SystemMenuItemMapper systemMenuItemMapper;

	/**
	 * 生成系统功能树结构
	 *
	 * @param depid
	 *            用户组ID
	 * @return
	 */
	@Override
	public List<INode> getSystemMenu(String depid) {
		List<INode> list = new ArrayList<INode>();
		// 通过管理表，获得用户可访问的所有菜单
		for (SystemGroupMenu dm : getDeptMenus(depid)) {
			SystemMenu sm = systemMenuMapper.selectByPrimaryKey(dm.getMenuid());// 菜单对象
			NormalNode menuNode = new NormalNode();// 生成节点对象
			menuNode.setText(sm.getMenuname());// 设置节点名称

			// 生成菜单项
			for (SystemMenuMenuitem smmi : getSystemMenuItems(sm.getSysid())) {
				SystemMenuItem smi = systemMenuItemMapper.selectByPrimaryKey(smmi.getItemid());
				NormalNode node = new NormalNode();
				node.setSn(smi.getSysid());
				node.setText(smi.getItemname());
				node.setUrl(smi.getItemlink());

				menuNode.addChild(node);
			}
			list.add(menuNode);
		}
		return list;
	}

	/**
	 * 部门 <-> 系统功能菜单对应关系
	 *
	 * @param depid
	 * @return
	 */
	private List<SystemGroupMenu> getDeptMenus(String groupid) {
		Example condition = new Example(SystemGroupMenu.class);
		condition.createCriteria().andEqualTo("groupid", groupid);

		return systemGroupMenuMapper.selectByExample(condition);
	}

	/**
	 * 菜单，菜单项对应关系
	 *
	 * @param depid
	 * @return
	 */
	private List<SystemMenuMenuitem> getSystemMenuItems(String menuid) {
		Example condition = new Example(SystemMenuMenuitem.class);
		condition.createCriteria().andEqualTo("menuid", menuid);

		return systemMenuMenuitemMapper.selectByExample(condition);
	}
}
