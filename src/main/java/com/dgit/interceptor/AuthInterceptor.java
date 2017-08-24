package com.dgit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AUTH interceptor PreHandle -----------------------");
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("login");
		System.out.println("session mid : " +mid);
		if(mid == null){
			saveDest(request);
			//http://localhost:8080/ex01/sboard/user/login sboard 없애야 경로가 맞음.
			String url = request.getContextPath() + "/user/login";
			response.sendRedirect(url);
			return false;
		}
		return true;
	}
	
	//login화면으로 이동전의 command와 query를 기억해 둔다.
	private void saveDest(HttpServletRequest request){
		String uri = request.getRequestURI();
		String query = request.getQueryString();// 주소창에 ? 담에 있는  key = value 다 가져옴
		
		if(query == null || query.equals("null")){
			query = "";
		}else{
			query = "?" + query;
		}
		if(request.getMethod().equals("GET")){
			System.out.println(uri + query);
			request.getSession().setAttribute("dest", uri + query);
		}
	}
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AUTH interceptor PostHandle -----------------------");
	}

}
