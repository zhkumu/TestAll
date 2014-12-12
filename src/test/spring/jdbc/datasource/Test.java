package test.spring.jdbc.datasource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("test/spring/jdbc/datasource/spring.xml");
		TestDao dao=context.getBean(TestDao.class);
		int id= dao.getStudent("mu");
		System.out.println(id);
	}

}
