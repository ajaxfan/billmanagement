package com.expressway.billmanagement.web.controllers.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expressway.billmanagement.data.models.SystemUser;
import com.expressway.billmanagement.service.ISystemUserService;
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
		List<SystemUser> users = systemUserService.findRecords(cf);

		if (users.size() == 0) {// 如果用户信息不存在，则提示用户错误原因
			return new FeedBackMessage(false, "用户名或密码不正确");
		}
		// 用户信息存在Session中
		request.getSession().setAttribute("freeWayUser", users.get(0));
		
		return new FeedBackMessage(true);
	}
}
