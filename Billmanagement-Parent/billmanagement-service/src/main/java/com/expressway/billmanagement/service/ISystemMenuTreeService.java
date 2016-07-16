package com.expressway.billmanagement.service;

import java.util.List;

import com.expressway.billmanagement.service.tree.inters.INode;


/**
 * 系统导航树服务接口
 * 
 * @author FXStudio.Ajaxfan
 */
public interface ISystemMenuTreeService {

	/**
	 * 生成系统功能树结构
	 * 
	 * @param depid 用户组ID
	 * @return
	 */
	public List<INode> getSystemMenu(String depid);
}
