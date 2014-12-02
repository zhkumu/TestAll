package test.aop.jdk;

import java.lang.reflect.Proxy;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyServiceImpl service=new MyServiceImpl();
		
		Monitor monitor=new Monitor(service);
		
		//只能通过接口来做代理
		MyService impl=(MyService)Proxy.newProxyInstance(Test.class.getClassLoader(), service.getClass().getInterfaces(), monitor);
		impl.doSomething();
	}
}
