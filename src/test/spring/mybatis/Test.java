package test.spring.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.spring.mybatis.service.StudentService;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("test/spring/mybatis/spring.xml");
		StudentService service=context.getBean(StudentService.class);
		System.out.println(service.getStudent(1));
	}

}
