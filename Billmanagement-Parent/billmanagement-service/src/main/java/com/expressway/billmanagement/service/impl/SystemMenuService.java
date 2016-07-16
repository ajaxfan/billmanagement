package com.expressway.billmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expressway.billmanagement.data.mappers.SystemMenuMapper;
import com.expressway.billmanagement.data.models.SystemMenu;
import com.expressway.billmanagement.data.models.SystemMenuItem;
import com.expressway.billmanagement.data.models.SystemMenuMenuitem;
import com.expressway.billmanagement.service.ISystemMenuItemService;
import com.expressway.billmanagement.service.ISystemMenuService;
import com.expressway.billmanagement.service.ISystemMenuToMenuItemService;
import com.expressway.billmanagement.service.messages.FeedBackMessage;
import com.expressway.billmanagement.service.tree.CheckedNode;
import com.expressway.billmanagement.service.tree.inters.INode;

/**
 * 菜单管理
 *
 * @author FXStudio.Ajaxfan
 */
@Service
final class SystemMenuService implements ISystemMenuService {
    /** 菜单数据DAO */
    private @Autowired SystemMenuMapper systemMenuMapper;
    /** 菜单与菜单项对照关系服务 */
    private @Autowired ISystemMenuToMenuItemService systemMenuToMenuItemService;
    /** 菜单项数据DAO */
    private @Autowired ISystemMenuItemService systemMenuItemService;

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
    public FeedBackMessage addOrUpdate(SystemMenu menu, String[] itemIds) {
        // 新增菜单对象
        systemMenuMapper.insert(menu);

        // 新增菜单与菜单项对信号关系信息
        systemMenuToMenuItemService.addOrUpdate(menu.getSysid(), itemIds);

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
        systemMenuToMenuItemService.del(sysid);

        return new FeedBackMessage(true);
    }

    /**
     * 生产菜单树(将菜单信息转换为树形结构)
     *
     * @param sysid
     * @return
     */
    @Override
    public List<INode> extratMenus(String sysid) {
        // 菜单树对象
        List<INode> list = new ArrayList<INode>();

        // 已经选中菜单项
        List<SystemMenuMenuitem> checkeds = systemMenuToMenuItemService.getList(sysid);

        // 遍历系统中所有已维护的菜单项，用它们和之前获得数据作比对
        // 从而判断哪些菜单项应该处于选中状态
        for (SystemMenuItem smi : systemMenuItemService.getAll()) {
            CheckedNode node = new CheckedNode();// 带有Check状态的树节点
            node.setSn(smi.getSysid());// 节点ID
            node.setText(smi.getItemname());// 节点名称
            node.setChecked(isChecked(smi.getSysid(), checkeds));// 节点被选中

            list.add(node);
        }
        return list;
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
