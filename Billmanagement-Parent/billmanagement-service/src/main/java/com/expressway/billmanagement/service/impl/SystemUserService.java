package com.expressway.billmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expressway.billmanagement.data.mappers.SystemUserMapper;
import com.expressway.billmanagement.data.models.SystemGroup;
import com.expressway.billmanagement.data.models.SystemUser;
import com.expressway.billmanagement.service.ISystemGroupService;
import com.expressway.billmanagement.service.ISystemUserService;
import com.expressway.billmanagement.service.helper.MD5Converter;
import com.expressway.billmanagement.service.helper.UUIDGenerator;
import com.expressway.billmanagement.service.messages.FeedBackMessage;

/**
 * 系统用户
 *
 * @author FXStudio.Ajaxfan
 */
@Service
final class SystemUserService implements ISystemUserService {
    /** 用户信息Dao */
    private @Autowired SystemUserMapper systemUserMapper;
    /** 用户组信息服务 */
    private @Autowired ISystemGroupService systemGroupService;

    /**
     * @param user
     * @return
     */
    @Override
    public FeedBackMessage addOrUpdate(SystemUser user) {
        // 删除现有的用户信息
        del(user.getSysid());
        
        // 新增用户信息
        user.setSysid(UUIDGenerator.random());
        user.setPassword(MD5Converter.string2MD5(user.getPassword()));
        systemUserMapper.insert(user);
        
        return new FeedBackMessage(true);
    }

    /**
     * 删除用户信息
     *
     * @param sysid
     *            用户Id
     * @return 消息
     */
    @Override
    @Transactional
    public FeedBackMessage del(String sysid) {
        return new FeedBackMessage(systemUserMapper.deleteByPrimaryKey(sysid) > 0);
    }

    /**
     * 待选用户组
     *
     * @param userID
     * @return
     */
    @Override
    public List<SystemGroup> getUserGroups(String userId) {
        // 用户信息
        SystemUser user = systemUserMapper.selectByPrimaryKey(userId);

        // 获得全部的用户组信息
        List<SystemGroup> list = systemGroupService.getAll();

        // 判断用户组是否被选中
        if (user != null) {
            for (SystemGroup group : systemGroupService.getAll()) {
                if (group.getSysid().equals(user.getGroupid())) {
                    group.setRemark("true");
                }
            }
        }
        return list;
    }
}
