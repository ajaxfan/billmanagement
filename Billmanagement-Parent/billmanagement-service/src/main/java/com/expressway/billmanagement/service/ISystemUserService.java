package com.expressway.billmanagement.service;

import java.util.List;

import com.expressway.billmanagement.data.models.SystemGroup;
import com.expressway.billmanagement.data.models.SystemUser;
import com.expressway.billmanagement.data.protocal.ConditionFiled;
import com.expressway.billmanagement.service.messages.FeedBackMessage;

/**
 * 系统用户
 * 
 * @author FXStudio.Ajaxfan
 */
public interface ISystemUserService {
    /**
     * @param user
     * @return
     */
    public FeedBackMessage addOrUpdate(SystemUser user);

    /**
     * 获得用户对象
     * 
     * @param sysid
     * @return
     */
    public SystemUser findUser(String sysid);

    /**
     * 待选用户组
     *
     * @param userID
     * @return
     */
    public List<SystemGroup> getUserGroups(String userId);

    /**
     * 删除用户信息
     * 
     * @param sysid
     * @return
     */
    public FeedBackMessage del(String sysid);

    /**
     * 查询用户信息
     * 
     * @param cf
     * @return
     */
    public List<SystemUser> findRecords(ConditionFiled cf);
}
