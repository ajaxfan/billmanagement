package com.expressway.billmanagement.web.controllers.tree;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expressway.billmanagement.data.models.SystemUser;
import com.expressway.billmanagement.service.ISystemMenuTreeService;

/**
 * 系统所有树菜单的控制器
 *
 * @author Ajaxfan
 */
@RestController
@RequestMapping(value = "services", method = RequestMethod.POST)
public class TreeController {
	private @Autowired ISystemMenuTreeService systemMenuTreeService;

	/**
	 * 楼栋列表
	 *
	 * @param limit
	 *            开始索引
	 * @param start
	 *            结束索引
	 * @return
	 */
	@RequestMapping(value = "systemMenuList")
	public Object systemMenuList(HttpServletRequest request) {
		// 系统登录用户信息
		SystemUser userVo = (SystemUser) request.getSession().getAttribute("freeWayUser");

		if (userVo == null) {
			return null;
		}
		return systemMenuTreeService.getSystemMenu(userVo.getGroupid());
	}
}
