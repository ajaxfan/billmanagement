package com.expressway.billmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expressway.billmanagement.data.Condition;
import com.expressway.billmanagement.data.mappers.SystemGroupMenuMapper;
import com.expressway.billmanagement.data.models.SystemGroupMenu;
import com.expressway.billmanagement.service.ISystemGroupMenuService;
import com.expressway.billmanagement.service.messages.FeedBackMessage;

/**
 * 维护部门菜单对照关系
 *
 * @author FXStudio.Ajaxfan
 */
@Service
final class SystemGroupMenuService implements ISystemGroupMenuService {
    /** 部门菜单Dao */
    private @Autowired SystemGroupMenuMapper deptMenuMapper;

    /**
     * 变更部门菜单关系
     *
     * @param sysid
     * @param menuIds
     * @return
     */
    @Override
    @Transactional
    public FeedBackMessage update(String sysid, String[] menuIds) {
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
}
