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
		//���� ��ü�� �����ͼ� �α��� ó���� ����������� ����ִ� ��ü�� �����´�.
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user_id");
		
		if(obj == null) {//��α��� -> �α���������
			response.sendRedirect("/login/login");
			return false; 
			//��Ʈ�ѷ��� �Ȱ����� false��ȯ
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
}
