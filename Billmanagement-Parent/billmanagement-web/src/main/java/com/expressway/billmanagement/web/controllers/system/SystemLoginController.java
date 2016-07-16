package com.expressway.billmanagement.web.controllers.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expressway.billmanagement.data.models.SystemUser;
import com.expressway.billmanagement.service.ISystemUserService;
import com.expressway.billmanagement.service.helper.MD5Converter;
import com.expressway.billmanagement.service.messages.FeedBackMessage;
import com.expressway.billmanagement.service.protocal.ConditionFiled;

/**
 * 计重设备异常异常
 *
 * @author Ajaxfan
 */
@RestController
@RequestMapping(value = "services", method = RequestMethod.POST)
public class SystemLoginController {
	/** 用户服务接口类 */
	private @Autowired ISystemUserService systemUserService;

	/**
	 * @return 系统登录
	 */
	@RequestMapping("systemLogin")
	public Object systemLogin(HttpServletRequest request, ConditionFiled cf) {
		// 从Session重获取用户信息
		SystemUser user = (SystemUser) request.getSession().getAttribute("freeWayUser");

		// 先通过session信息来判断当前用户是否已经登录，如果已经登录则不需要记录日志和访问数据库
		if (user != null) {
			if (cf.getUsername().equals(user.getUsername())
					&& MD5Converter.string2MD5(cf.getPassword()).equals(user.getPassword())) {
				return new FeedBackMessage(true);
			}
		}
		// 通过数据库的方式查看用户登陆信息是否正确
		List<SystemUser> users = systemUserService.findRecords(cf);

		// 如果用户信息不存在，则提示用户错误原因
		if (users.size() == 0) {
			return new FeedBackMessage(false, "用户名或密码不正确");
		}
		// 用户信息存在Session中
		request.getSession().setAttribute("freeWayUser", users.get(0));
		
		return new FeedBackMessage(true);
	}
}
