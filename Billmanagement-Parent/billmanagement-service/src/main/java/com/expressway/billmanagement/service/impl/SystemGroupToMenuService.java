package com.expressway.billmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expressway.billmanagement.data.Condition;
import com.expressway.billmanagement.data.mappers.SystemGroupMenuMapper;
import com.expressway.billmanagement.data.models.SystemGroupMenu;
import com.expressway.billmanagement.data.models.SystemMenu;
import com.expressway.billmanagement.data.models.SystemMenuItem;
import com.expressway.billmanagement.data.models.SystemMenuMenuitem;
import com.expressway.billmanagement.service.ISystemGroupToMenuService;
import com.expressway.billmanagement.service.ISystemMenuItemService;
import com.expressway.billmanagement.service.ISystemMenuService;
import com.expressway.billmanagement.service.ISystemMenuToMenuItemService;
import com.expressway.billmanagement.service.messages.FeedBackMessage;
import com.expressway.billmanagement.service.tree.CheckedNode;
import com.expressway.billmanagement.service.tree.NormalNode;
import com.expressway.billmanagement.service.tree.inters.INode;

/**
 * 维护部门菜单对照关系
 *
 * @author FXStudio.Ajaxfan
 */
@Service
final class SystemGroupToMenuService implements ISystemGroupToMenuService {
    /** 部门菜单Dao */
    private @Autowired SystemGroupMenuMapper deptMenuMapper;

    private @Autowired ISystemMenuService systemMenuService;

    private @Autowired ISystemMenuToMenuItemService systemMenuToMenuItemService;

    private @Autowired ISystemMenuItemService systemMenuItemService;

    /**
     * 变更部门菜单关系
     *
     * @param sysid
     * @param menuIds
     * @return
     */
    @Override
    @Transactional
    public FeedBackMessage addOrUpdate(String sysid, String[] menuIds) {
        // 删除以前维护的关系记录
        del(sysid);

        // 维护用户组和菜单对象的对照关系
        for (String menuId : menuIds) {
            SystemGroupMenu deptMenu = new SystemGroupMenu();
            deptMenu.setGroupid(sysid);
            deptMenu.setMenuid(menuId);

            deptMenuMapper.insert(deptMenu);
        }
        return new FeedBackMessage(true);
    }

    /**
     * 删除指定用户组的对照关系
     * 
     * @param sysid
     * @return
     */
    @Override
    @Transactional
    public FeedBackMessage del(String sysid) {
        Condition condition = new Condition(SystemGroupMenu.class);
        condition.createCriteria().andEqualTo("groupid", sysid);
        deptMenuMapper.deleteByExample(condition);

        return new FeedBackMessage(true);
    }

    /**
     * 系统菜单
     *
     * @param groupId
     * @return
     */
    @Override
    public List<INode> getSystemMenu(String groupId) {
        List<INode> tree = new ArrayList<INode>();
        List<SystemGroupMenu> groupMenus = getGroupMenus(groupId);

        // 菜单
        for (SystemMenu sm : systemMenuService.getAll()) {
            CheckedNode menuNode = new CheckedNode();
            menuNode.setSn(sm.getSysid());
            menuNode.setText(sm.getMenuname());
            menuNode.setChecked(isChecked(sm.getSysid(), groupMenus));

            // 菜单项
            for (SystemMenuMenuitem smmi : getSystemMenuItems(sm.getSysid())) {
                SystemMenuItem smi = systemMenuItemService.findMenuItem(smmi.getItemid());

                NormalNode node = new NormalNode();
                node.setSn(smi.getSysid());
                node.setText(smi.getItemname());

                menuNode.addChild(node);
            }
            tree.add(menuNode);
        }

        return tree;
    }

    /**
     * @param groupId
     * @return
     */
    private List<SystemGroupMenu> getGroupMenus(String groupId) {
        Condition condition = new Condition(SystemGroupMenu.class);
        condition.createCriteria().andEqualTo("groupid", groupId);

        return deptMenuMapper.selectByExample(condition);
    }

    /**
     * @param sysid
     * @param list
     * @return
     */
    private boolean isChecked(String sysid, List<SystemGroupMenu> list) {
        for (SystemGroupMenu sgm : list) {
            if (sysid.equals(sgm.getMenuid())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param menuid
     * @return
     */
    private List<SystemMenuMenuitem> getSystemMenuItems(String menuid) {
        return systemMenuToMenuItemService.getList(menuid);
    }
}
