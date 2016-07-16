package com.expressway.billmanagement.service;

import java.util.List;

import com.expressway.billmanagement.data.models.SystemGroup;
import com.expressway.billmanagement.service.messages.FeedBackMessage;

/**
 * 系统用户组
 * 
 * @author FXStudio.Ajaxfan
 */
public interface ISystemGroupService {
    /**
     * 添加用户组
     * 
     * @param menuItem
     * @return
     */
    public FeedBackMessage addOrUpdate(SystemGroup group, String[] menuIds);

    /**
     * 删除用户组
     * 
     * @param sysid
     * @return
     */
    public FeedBackMessage del(String sysid);
    
    /**
     * 查询全部的用户组信息
     * 
     * @return
     */
    public List<SystemGroup> getAll();
}
