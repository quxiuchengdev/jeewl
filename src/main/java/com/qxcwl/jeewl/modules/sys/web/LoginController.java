package com.qxcwl.jeewl.modules.sys.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qxcwl.jeewl.common.controller.BaseController;

@Controller
public class LoginController extends BaseController{

	@RequestMapping(value = "${adminPath}/login")
	public String login(HttpServletRequest request, HttpServletResponse response){
		return "modules/sys/login";
	}
	
	@RequestMapping(value = "${adminPath}/doLogin")
	public String doLogin(HttpServletRequest request, HttpServletResponse response){
		return "modules/sys/index";
	}
	
	@RequestMapping(value = "${adminPath}/index")
	public String index(HttpServletRequest request, HttpServletResponse response){
		return "modules/sys/index";
	}
	
	@RequestMapping(value = "${adminPath}/menuList")
	public String logout(HttpServletRequest request, HttpServletResponse response){
		return "modules/sys/menuList";
	}
	
	@RequestMapping(value = "${adminPath}/page404")
	public String page404(HttpServletRequest request, HttpServletResponse response){
		return "modules/error/404";
	}
	
	@RequestMapping(value = "${adminPath}/page500")
	public String page500(HttpServletRequest request, HttpServletResponse response){
		return "modules/error/500";
	}
	
}
