package com.expressway.billmanagement.service;

import java.util.List;

import com.expressway.billmanagement.data.models.SystemMenuItem;
import com.expressway.billmanagement.data.protocal.ConditionFiled;
import com.expressway.billmanagement.service.messages.FeedBackMessage;

/**
 * 系统菜单项管理
 * 
 * @author FXStudio.Ajaxfan
 */
public interface ISystemMenuItemService {

    /**
     * 数据新增或修改
     * 
     * @param menu_item
     *            数据对象
     * @return 处理的结果
     */
    public FeedBackMessage addOrUpdate(SystemMenuItem menu_item);

    /**
     * 删除菜单项对象
     * 
     * @param sysid
     * @return
     */
    public FeedBackMessage del(String sysid);

    /**
     * 查询所有的菜单项
     * 
     * @return
     */
    public List<SystemMenuItem> getAll();
    
    /**
     * 获取菜单项信息
     * 
     * @param itemid
     * @return
     */
    public SystemMenuItem findMenuItem(String itemid);

    /**
     * 查询菜单项记录
     * 
     * @param cf
     * @return
     */
    public List<SystemMenuItem> findRecords(ConditionFiled cf);
}
