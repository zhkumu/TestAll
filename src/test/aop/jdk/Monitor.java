package test.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Monitor implements InvocationHandler {

	private Object target;
	
	public Monitor(Object target){
		this.target=target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("start");
		Object result= method.invoke(target, args);
		System.out.println("end");
		return result;
	}

}
