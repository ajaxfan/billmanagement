package com.expressway.billmanagement.service;

import java.util.List;

import com.expressway.billmanagement.data.models.SystemMenuItem;
import com.expressway.billmanagement.service.messages.FeedBackMessage;
import com.expressway.billmanagement.service.protocal.ConditionFiled;

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

    public FeedBackMessage del(String sysid);

    /**
     * @param cf
     * @return
     */
    public List<SystemMenuItem> findRecords(ConditionFiled cf);
    
    /**
     * @param cf
     * @return
     */
    public Integer getSize(ConditionFiled cf);
}
