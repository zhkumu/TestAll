package test.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.spring.jdbc.bean.Teacher;
import test.spring.jdbc.mapper.TeacherMapper;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		
		TeacherMapper mapper= context.getBean(TeacherMapper.class);

		Teacher teacher=mapper.getTeacher("mu");
		
		System.out.println(teacher);
	}

}
