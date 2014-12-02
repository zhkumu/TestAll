package test.aop.advice;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		MyServiceImpl service=new MyServiceImpl();
//		ProxyFactory factory=new ProxyFactory();
//		factory.addAdvice(new MyBeforeAdvice());
//		factory.setTarget(service);
//		MyServiceImpl impl=(MyServiceImpl)factory.getProxy();
//		impl.doSomething();
		
		ApplicationContext context=new ClassPathXmlApplicationContext("/test/aop/spring.xml");
		MyServiceImpl serviceImpl=(MyServiceImpl)context.getBean("impl");
		serviceImpl.doSomething();
	}

}
