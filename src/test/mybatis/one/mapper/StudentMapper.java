package test.mybatis.one.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import test.mybatis.one.bean.Student;

public interface StudentMapper {
	Student getStudent(int id);
	
	int addStudent(Student student);
	
	Student selectStudent(@Param("id") int id ,@Param("name") String name);
	
	int updateStudent(@Param("name") String name,@Param("remark") String remark);

	Student selStudent(@Param("id") int id,@Param("name") String name,@Param("remark") String remark);
	
	Student selStudentByName(@Param("name")String name,@Param("remark") String remark);
	
	List<Student> getStudents(@Param("ids") List<Integer> ids);
	
	void getStudentId(Map map);
	
	String getStudnentName(Map map);
}
