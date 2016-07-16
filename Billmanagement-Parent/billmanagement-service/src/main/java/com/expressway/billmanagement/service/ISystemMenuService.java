package com.expressway.billmanagement.service;

import java.util.List;

import com.expressway.billmanagement.data.models.SystemMenu;
import com.expressway.billmanagement.service.messages.FeedBackMessage;
import com.expressway.billmanagement.service.tree.inters.INode;

/**
 * 系统菜单维护
 * 
 * @author FXStudio.Ajaxfan
 */
public interface ISystemMenuService {
	/**
	 * 添加新的菜单及维护与菜单项的关系
	 * 
	 * @param menu
	 * @return
	 */
	public FeedBackMessage addOrUpdate(SystemMenu menu, String[] itemIds);

	/**
	 * 展开菜单
	 * 
	 * @param sysid
	 * @return
	 */
	public List<INode> extratMenus(String sysid);
	

    public FeedBackMessage del(String sysid);

}
