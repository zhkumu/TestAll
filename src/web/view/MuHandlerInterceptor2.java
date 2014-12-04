package web.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

//也可以实现这个接口HandlerInterceptor
public class MuHandlerInterceptor2 extends HandlerInterceptorAdapter {

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
		if(handler instanceof ResourceHttpRequestHandler){
			System.out.println("静态资源3");
			return ;
		}
		System.out.println("视图渲染后");
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelandview) throws Exception {
		if(handler instanceof ResourceHttpRequestHandler){
			System.out.println("静态资源2");
			return ;
		}
		System.out.println("controller方法处理完成");
	}

	//如果这里不返回true，则后面的拦截器就不会执行了
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if(handler instanceof ResourceHttpRequestHandler){
			System.out.println("静态资源1");
			return false;
		}
		System.out.println("进入controller方法前");
		return false;
	}

	

	
}
