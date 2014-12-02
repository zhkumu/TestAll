package test.aop.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


public class Monitor implements MethodInterceptor{
	private Enhancer enhancer=new Enhancer();
	public Object getProxy(Class cla){
		//生成这个类的子类
		enhancer.setSuperclass(cla);
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	/*
	 * object 即被代理的对象，method要调用的方法，args方法的参数，proxy代理对象
	 */
	public Object intercept(Object object, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("start");
		//调用基类的方法
		Object result= proxy.invokeSuper(object, args);
		System.out.println("end");
		return result;
	}
	
}
