package test.mybatis.one;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.EnumTypeHandler;

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
		
		//打开一个不自动提交事务的会话，如果没有插入、更新、删除操作，需要调用session.commit(true)方法才会提交事务，否则在会话关闭前事务不会释放
		SqlSession session=factory.openSession(true);
		
		StudentMapper mapper=session.getMapper(StudentMapper.class);
		
//		Student student=mapper.selStudentByName("mu","hehe");
//		
//		System.out.println(student);
		
		Map map=new HashMap();
//		map.put("name", "mu");
//		mapper.getStudentId(map);
//		System.out.println(map.get("id"));

		map.put("id", 1);
		mapper.getStudnentName(map);
		System.out.println(map);
		
//		List<Integer> ids=new ArrayList<Integer>();
//		ids.add(1);
////		ids.add(2);
//		List<Student> list=mapper.getStudents(ids);
//		System.out.println(list);
		
//		Student addStudent=new Student();
//		addStudent.setName("wang1");
//		addStudent.setRemark("test1");
//		addStudent.setBirthday(new Date());
//		
//		System.out.println(mapper.addStudent(addStudent));
//		
//		session.commit();
		InputStream in=System.in;
		in.read();
 
		//session.close();

	}

}
