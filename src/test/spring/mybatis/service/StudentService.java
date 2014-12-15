package test.spring.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.spring.mybatis.bean.Student;
import test.spring.mybatis.dao.StudentDao;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	
	public Student getStudent(int id){
		return studentDao.getStudent(id);
	}
}
