package test.spring.iocbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		ApplicationContext context=new ClassPathXmlApplicationContext("test/spring/iocbean/spring.xml");
//		Cat cat=context.getBean("cat",Cat.class);
//		System.out.println(cat);
		
		
//		ApplicationContext fcontext=new ClassPathXmlApplicationContext("test/spring/iocbean/father.xml");
//		
//		ConfigurableApplicationContext ccontext=new ClassPathXmlApplicationContext("test/spring/iocbean/father.xml");
//		ccontext.setParent(fcontext);
//		
//		Dog dog= ccontext.getBean("dog",Dog.class);
//		System.out.println(dog);
		
		//父容器不能使用子容器注册的bean
//		Cat cat=fcontext.getBean("cat",Cat.class);
//		System.out.println(cat);
		
		
//		ApplicationContext context=new ClassPathXmlApplicationContext("test/spring/iocbean/spring.xml");
//		Single single=context.getBean("single",Single.class);
//		System.out.println(single);
//		Single single2=context.getBean("single",Single.class);
//		System.out.println(single2);
		
	//	ApplicationContext context=new ClassPathXmlApplicationContext("test/spring/iocbean/spring.xml");
		String tmp=null;
		System.out.println(tmp.equals("wap"));
	}

}
