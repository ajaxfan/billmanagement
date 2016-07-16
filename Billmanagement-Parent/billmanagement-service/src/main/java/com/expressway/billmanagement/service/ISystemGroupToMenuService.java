package com.expressway.billmanagement.service;

import com.expressway.billmanagement.service.messages.FeedBackMessage;

/**
 * 维护部门菜单对照关系
 * 
 * @author FXStudio.Ajaxfan
 */
public interface ISystemGroupToMenuService {
    /**
     * 变更部门菜单关系
     * 
     * @param sysid
     * @param menuIds
     * @return
     */
    public FeedBackMessage addOrUpdate(String sysid, String[] menuIds);

    /**
     * 删除指定用户组的对照关系
     * 
     * @param sysid
     * @return
     */
    public FeedBackMessage del(String sysid);
}
