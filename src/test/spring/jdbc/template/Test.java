package test.spring.jdbc.template;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.spring.jdbc.template.dao.TeacherDao;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("/test/spring/jdbc/template/spring.xml");
		TeacherDao dao= context.getBean(TeacherDao.class);
		System.out.println(dao.getStudentId());
	}

}
