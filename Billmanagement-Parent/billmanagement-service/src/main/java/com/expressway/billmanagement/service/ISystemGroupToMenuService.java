package com.expressway.billmanagement.service;

import java.util.List;

import com.expressway.billmanagement.service.messages.FeedBackMessage;
import com.expressway.billmanagement.service.tree.inters.INode;

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
    
    /**
     * 获取用户组下的所有菜单
     * 
     * @param groupId
     * @return
     */
    public List<INode> getSystemMenu(String groupId);
}
