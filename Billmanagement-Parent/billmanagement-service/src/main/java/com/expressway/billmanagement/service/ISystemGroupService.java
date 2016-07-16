package com.expressway.billmanagement.service;

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
    public FeedBackMessage add(SystemGroup group, String[] menuIds);

    /**
     * 修改用户组
     * 
     * @param menuItem
     * @return
     */
    public FeedBackMessage update(SystemGroup group, String[] menuIds);

    /**
     * 删除用户组
     * 
     * @param sysid
     * @return
     */
    public FeedBackMessage del(String sysid);
}
