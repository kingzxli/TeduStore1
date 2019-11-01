package cn.tedu.store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginInterceptor implements HandlerInterceptor{
	//响应页面之后执行
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
		
	}
	
	//控制器方法之后，响应页面之前执行
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
		
	}
	
	//控制器方法之前执行
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
			Object obj=request.getSession().getAttribute("user");
			if(obj==null) {
				response.sendRedirect(request.getContextPath()+"/user/showLogin.do");
				return false;
			}
		return true;
	}
}













