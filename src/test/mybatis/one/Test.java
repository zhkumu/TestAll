package test.mybatis.one;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import test.mybatis.one.bean.Student;
import test.mybatis.one.mapper.StudentMapper;

public class Test {

	/**
	 * @throws IOException 
	 * @param args
	 * @throws  
	 */
	public static void main(String[] args) throws IOException   {
		InputStream stream=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(stream);
		SqlSession session=factory.openSession();
		
		StudentMapper mapper=session.getMapper(StudentMapper.class);
		
		Student student=mapper.getStudent(1);
		
		System.out.println(student);
		
		session.close();

	}

}