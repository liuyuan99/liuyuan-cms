package com.liuyuan.cms.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/**
 * 
 * @ClassName: AdminMyInteceptor 
 * @Description: 管理员中心拦截器
 * @author: 刘媛
 * @date: 2020年3月13日 下午8:36:32
 */
public class AdminMyInteceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//如果用户已经注册登录,不拦截
		HttpSession session = request.getSession();
		Object object = session.getAttribute("admin");
		if(object!=null) {
			return true;  //不拦截
		}
		//response.sendRedirect("/passport/login");
		request.setAttribute("msg", "请登录后重试");
		request.getRequestDispatcher("/WEB-INF/view/passport/adminLogin.jsp").forward(request, response);
		return false;
	}
}
