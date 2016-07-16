package com.expressway.billmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expressway.billmanagement.data.mappers.SystemGroupMapper;
import com.expressway.billmanagement.data.models.SystemGroup;
import com.expressway.billmanagement.service.ISystemGroupMenuService;
import com.expressway.billmanagement.service.ISystemGroupService;
import com.expressway.billmanagement.service.messages.FeedBackMessage;

/**
 * 用户组相关的服务
 *
 * @author FXStudio.Ajaxfan
 */
@Service
final class SystemGroupService implements ISystemGroupService {
    /** 用户组Dao */
	private @Autowired SystemGroupMapper systemGroupMapper;
	/** 维护用户组菜单相关的服务 */
	private @Autowired ISystemGroupMenuService systemGroupMenuService;

	/**
	 * 新增用户组
	 * 
	 * @param group
	 * @param menuIds
	 * @return
	 */
	@Override
	@Transactional
	public FeedBackMessage add(SystemGroup group, String[] menuIds) {
	    // 新增用户组对象
		systemGroupMapper.insert(group);
		
		// 维护用户组、菜单关系
		systemGroupMenuService.update(group.getSysid(), menuIds);
		
		return new FeedBackMessage(true);
	}

	/**
	 * 删除用户组
	 * 
	 * @param sysid
	 * @return
	 */
	@Override
	@Transactional
	public FeedBackMessage del(String sysid) {
	    // 删除用户组信息
		systemGroupMapper.deleteByPrimaryKey(sysid);
		
		// 删除用户组和菜单的关系记录
		systemGroupMenuService.del(sysid);

		return new FeedBackMessage(true);
	}

	/**
	 * 修改用户组信息
	 * 
	 * @param group
	 * @param menuIds
	 * @return
	 */
	@Override
	@Transactional
	public FeedBackMessage update(SystemGroup group, String[] menuIds) {
	    // 修改用户组信息
		systemGroupMapper.updateByPrimaryKey(group);
		
        // 维护用户组、菜单关系
        systemGroupMenuService.update(group.getSysid(), menuIds);

		return new FeedBackMessage(true);
	}
}
