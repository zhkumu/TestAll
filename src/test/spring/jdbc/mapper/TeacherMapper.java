package test.spring.jdbc.mapper;


import test.spring.jdbc.bean.Teacher;

public interface TeacherMapper {
	
	Teacher getTeacher(String name);
}
