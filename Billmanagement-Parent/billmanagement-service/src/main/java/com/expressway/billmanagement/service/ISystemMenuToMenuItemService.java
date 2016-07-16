package com.expressway.billmanagement.service;

import java.util.List;

import com.expressway.billmanagement.data.models.SystemMenuMenuitem;
import com.expressway.billmanagement.service.messages.FeedBackMessage;

/**
 * 维护部门菜单对照关系
 * 
 * @author FXStudio.Ajaxfan
 */
public interface ISystemMenuToMenuItemService {
    /**
     * 变更部门菜单关系
     * 
     * @param sysid
     * @param menuIds
     * @return
     */
    public FeedBackMessage addOrUpdate(String sysid, String[] itemids);
    
    /**
     * 查询某个菜单下的所有项目
     * 
     * @param sysid
     * @return
     */
    public List<SystemMenuMenuitem> getList(String sysid);

    /**
     * 删除指定用户组的对照关系
     * 
     * @param sysid
     * @return
     */
    public FeedBackMessage del(String sysid);
}
