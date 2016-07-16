package com.expressway.billmanagement.service;

import java.util.List;

import com.expressway.billmanagement.data.models.SystemGroup;
import com.expressway.billmanagement.data.models.SystemUser;
import com.expressway.billmanagement.service.messages.FeedBackMessage;
import com.expressway.billmanagement.service.protocal.ConditionFiled;

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
	 * 待选用户组
	 * 
	 * @param userID
	 * @return
	 */
	public List<SystemGroup> getUserGroups(String userId);
	

    

    public FeedBackMessage del(String sysid);

    /**
     * @param cf
     * @return
     */
    public List<SystemUser> findRecords(ConditionFiled cf);
    
    /**
     * @param cf
     * @return
     */
    public Integer getSize(ConditionFiled cf);
}
