package com.common.filter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.facade.entity.User;

/**
 * 登入拦截
 * @author huangzhi
 * 2018年9月14日
 */
public class LoginInterceptor implements HandlerInterceptor{
	
	// 配置系统级别无需校验的URI列表
	static List<String> excludeUri = null;
	static String loginRUI = "/user/login";
	static String notLoginRUI = "/user/not-login";
	static{
		excludeUri=new ArrayList<>();
		excludeUri.add(loginRUI);
		excludeUri.add(notLoginRUI);
	}
	

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		/**
		 *整个请求处理完毕回调方法，即在视图渲染完毕时回调，如性能监控中我们可以在此记录结束时
		 *间并输出消耗时间，还可以进行一些资源清理，类似于try-catch-finally中的finally，但仅调用处理器执行链中
		 */
		System.out.println("=======销毁过滤器=========");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		/**
		 * 后处理回调方法，实现处理器的后处理（但在渲染视图之前），此时我们可以通过modelAndView（模型和视图对象）对模型数据进行处理或对视图进行处理，modelAndView也可能为null。
		 */
		System.out.println("=======化过滤器执行?=========");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		/**
		 * 预处理回调方法，实现处理器的预处理（如登录检查），第三个参数为响应的处理器（如我们上一章的Controller实现）；
		 *   返回值：true表示继续流程（如调用下一个拦截器或处理器）；
		 *   false表示流程中断（如登录检查失败），不会继续调用其他的拦截器或处理器，此时我们需要通过response来产生响应；
		 */
		System.out.println("=======初始化过滤器=========");
		Object user=getSession(request);
		String url = request.getRequestURI(); // 当前请求的url
		if(checkIgnore(url)){
			return true;
		}
		
		if(user==null){
			//这里填写你允许进行跨域的主机ip
			response.setHeader("Access-Control-Allow-Origin", "*");
			//允许的访问方法
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
			//Access-Control-Max-Age 用于 CORS 相关配置的缓存
			//resp.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

			String notLogin = "/user/not-login";
			//resp.setStatus(700);
			request.getRequestDispatcher(notLogin).forward(request, response);

			return false;
		}
		return true;
	}
	
	Boolean checkIgnore(String url) {
		boolean flag = false;
		for (String exclude : excludeUri) {
			if (url.contains(exclude)) {
				flag = true;
				break;
			}
		}
		System.out.println(flag);
		return flag;
	}
	
	Object getSession(HttpServletRequest request){
		System.out.println("sessionID:"+request.getSession().getId());
		User user=(User) request.getSession().getAttribute("user");
		if(user!=null){
			return user;
		}
		return null;
	}

}
