package test.spring.jdbc.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.AccessException;

public class Test {

	/**
	 * @param args
	 * @throws AccessException 
	 */
	public static void main(String[] args)  {
		ApplicationContext context=new ClassPathXmlApplicationContext("test/spring/jdbc/transaction/spring.xml");
		TestService service=context.getBean(TestService.class);
		int id=0;
		try {
			id = service.getStudent("mu");
		} catch (AccessException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(id);
	}
	

}
