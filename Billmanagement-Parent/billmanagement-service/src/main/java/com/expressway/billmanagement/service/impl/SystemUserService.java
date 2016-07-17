package com.expressway.billmanagement.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expressway.billmanagement.data.Condition;
import com.expressway.billmanagement.data.helpers.StringHelper;
import com.expressway.billmanagement.data.helpers.UUIDGenerator;
import com.expressway.billmanagement.data.mappers.SystemUserMapper;
import com.expressway.billmanagement.data.models.SystemGroup;
import com.expressway.billmanagement.data.models.SystemUser;
import com.expressway.billmanagement.data.protocal.ConditionFiled;
import com.expressway.billmanagement.service.ISystemGroupService;
import com.expressway.billmanagement.service.ISystemUserService;
import com.expressway.billmanagement.service.helper.MD5Converter;
import com.expressway.billmanagement.service.messages.FeedBackMessage;

import tk.mybatis.mapper.entity.Example.Criteria;

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
     * 待选用户组
     *
     * @param userID
     * @return
     */
    @Override
    public List<SystemGroup> getUserGroups(String userId) {
        SystemUser user = findUser(userId);

        // 获得全部的用户组信息
        List<SystemGroup> list = systemGroupService.getAll();

        // 判断用户组是否被选中
        if (user != null) {
            for (SystemGroup group : list) {
                if (group.getSysid().equals(user.getGroupid())) {
                    group.setRemark("true");
                }
            }
        }
        return list;
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
     * 查询用户登录信息
     * 
     * @param fields
     * @return
     */
    @Override
    public List<SystemUser> findRecords(ConditionFiled cf) {
        Condition condition = new Condition(SystemUser.class);
        condition.setOrderByClause("createtime");
        Criteria criteria = condition.createCriteria();

        // 按组搜索用户
        if (!StringHelper.isNullOrEmpty(cf.getSysid())) {
            criteria.andEqualTo("groupid", cf.getSysid());
            return systemUserMapper.selectByExampleAndRowBounds(condition,
                    new RowBounds(cf.getStart(), cf.getLimit() - cf.getStart()));
        }
        // 查找全部的用户
        else if (StringHelper.isNullOrEmpty(cf.getUsername()) && StringHelper.isNullOrEmpty((cf.getPassword()))) {
            criteria.andNotEqualTo("visible", "1");// 超级管理员账户不可见
            return systemUserMapper.selectByExampleAndRowBounds(condition,
                    new RowBounds(cf.getStart(), cf.getLimit() - cf.getStart()));
        }
        // 查找特定的用户信息
        criteria.andEqualTo("username", cf.getUsername());
        criteria.andEqualTo("password", MD5Converter.string2MD5(cf.getPassword()));

        return systemUserMapper.selectByExample(condition);
    }

    /**
     * @param sysid
     * @return
     */
    @Override
    public SystemUser findUser(String sysid) {
        return systemUserMapper.selectByPrimaryKey(sysid);
    }
}
