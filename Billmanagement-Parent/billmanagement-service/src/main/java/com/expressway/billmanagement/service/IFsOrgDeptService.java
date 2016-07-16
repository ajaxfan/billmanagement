package com.expressway.billmanagement.service;

import java.util.List;

import com.expressway.billmanagement.service.tree.inters.INode;

/**
 * 部门信息统计
 * 
 * @author FXStudio.Ajaxfan
 */
public interface IFsOrgDeptService {
	/**
	 * @return
	 */
	public List<INode> findAll(String deptid);

	/**
	 * @return
	 */
	public List<INode> deptTree(String userid);
}
