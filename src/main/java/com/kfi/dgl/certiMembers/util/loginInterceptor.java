package com.kfi.dgl.certiMembers.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class loginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//세션 객체를 가져와서 로그인 처리의 사용자정보를 담고있는 객체를 가져온다.
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user_id");
		
		if(obj == null) {//비로그인 -> 로그인폼으로
			response.sendRedirect("/login/login");
			return false; 
			//컨트롤러로 안가도록 false반환
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
}
