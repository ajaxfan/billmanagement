package com.expressway.billmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expressway.billmanagement.data.mappers.SystemMenuItemMapper;
import com.expressway.billmanagement.data.models.SystemMenuItem;
import com.expressway.billmanagement.service.ISystemMenuItemService;
import com.expressway.billmanagement.service.messages.FeedBackMessage;

/**
 * 系统菜单项
 *
 * @author FXStudio.Ajaxfan
 */
@Service
final class SystemMenuItemService implements ISystemMenuItemService {
    /** 菜单项Dao */
    private @Autowired SystemMenuItemMapper systemMenuItemMapper;

    /**
     * 通过主键来删除数据
     *
     * @param sysid
     *            系统逐渐
     * @return 消息
     */
    @Override
    @Transactional
    public FeedBackMessage del(String sysid) {
        // 删除菜单项对象
        systemMenuItemMapper.deleteByPrimaryKey(sysid);

        return new FeedBackMessage(true);
    }

    /**
     * 数据的添加或删除
     *
     * @param menu_item
     * @return
     */
    @Override
    @Transactional
    public FeedBackMessage addOrUpdate(SystemMenuItem item) {
        // 删除菜单项对象
        del(item.getSysid());

        // 新增菜单项
        systemMenuItemMapper.insert(item);

        return new FeedBackMessage(true);
    }

    /**
     * 查询所有的菜单项
     * 
     * @return
     */
    @Override
    public List<SystemMenuItem> getAll() {
        return systemMenuItemMapper.selectAll();
    }
}
