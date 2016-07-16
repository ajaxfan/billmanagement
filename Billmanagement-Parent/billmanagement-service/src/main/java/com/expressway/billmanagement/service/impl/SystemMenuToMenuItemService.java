package com.expressway.billmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expressway.billmanagement.data.Condition;
import com.expressway.billmanagement.data.mappers.SystemMenuMenuitemMapper;
import com.expressway.billmanagement.data.models.SystemGroupMenu;
import com.expressway.billmanagement.data.models.SystemMenuMenuitem;
import com.expressway.billmanagement.service.ISystemMenuToMenuItemService;
import com.expressway.billmanagement.service.messages.FeedBackMessage;

/**
 * 维护菜单与菜单组对信号关系
 *
 * @author FXStudio.Ajaxfan
 */
@Service
final class SystemMenuToMenuItemService implements ISystemMenuToMenuItemService {
    /** 菜单与菜单组对信号关系Dao */
    private @Autowired SystemMenuMenuitemMapper systemMenuMenuitemMapper;

    /**
     * 变更部门菜单关系
     *
     * @param sysid
     * @param items
     * @return
     */
    @Override
    @Transactional
    public FeedBackMessage addOrUpdate(String sysid, String[] items) {
        // 删除以前维护的关系记录
        del(sysid);

        // 维护用户组和菜单对象的对照关系
        for (String itemid : items) {
            SystemMenuMenuitem menu = new SystemMenuMenuitem();
            menu.setMenuid(sysid);
            menu.setItemid(itemid);

            systemMenuMenuitemMapper.insert(menu);
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
        condition.createCriteria().andEqualTo("menuid", sysid);
        systemMenuMenuitemMapper.deleteByExample(condition);

        return new FeedBackMessage(true);
    }

    /**
     * 查询和某个菜单对应的所有菜单项
     * 
     * @param sysid
     * @return
     */
    @Override
    public List<SystemMenuMenuitem> getList(String sysid) {
        Condition condition = new Condition(SystemMenuMenuitem.class);
        condition.createCriteria().andEqualTo("menuid", sysid);

        return systemMenuMenuitemMapper.selectByExample(condition);
    }

    /**
     * @param menuid
     * @return
     */
    @Override
    public List<SystemMenuMenuitem> getMenu2MenuItems(String menuid) {
        Condition condition = new Condition(SystemMenuMenuitem.class);
        condition.createCriteria().andEqualTo("menuid", menuid);
        
        return systemMenuMenuitemMapper.selectByExample(condition);
    }
}
