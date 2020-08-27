package com.yc.springboot.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

//定义登录拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		//登录成功之后，应该有用户的session
		Object loginedUser=request.getAttribute("loginedUser");
		
		if(loginedUser==null) { //没有登录 
			request.setAttribute("msg", "没有权限，请先登录");
			request.getRequestDispatcher("/login.html").forward(request, response);
			return false;
		}else {
			return true;
		}
		
	
	}

	
	
}
