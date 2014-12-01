package test.spring.jdbc.template.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import test.spring.jdbc.bean.Teacher;


public class TeacherDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int addTeacher(){
		Object[] objects=new Object[]{"smell3",null};
		int result= jdbcTemplate.update("insert into teacher(`name`,`remark`)values(?,?)", objects);
		return result;
	}
	
	public int getStudentId(){
		//CallableStatementCallback参数下标从1开始
		return jdbcTemplate.execute("{call pro_selStudentId(?,?)}", new CallableStatementCallback<Integer>() {
			@Override
			public Integer doInCallableStatement(
					CallableStatement callablestatement) throws SQLException,
					DataAccessException {
				callablestatement.setString(1,"mu");
				callablestatement.registerOutParameter(2, java.sql.Types.INTEGER);
				callablestatement.execute();
				return callablestatement.getInt(2);
			}
		});
	}
	
	public Teacher getTeacher(){
		//返回多列必须使用RowMapper
		Teacher teacher=jdbcTemplate.queryForObject
				("select * from teacher where id=?",
			     new RowMapper<Teacher>(){
					@Override
					public Teacher mapRow(ResultSet resultset, int i)
							throws SQLException {
						Teacher teacher=new Teacher();
						teacher.setId(resultset.getInt("id"));
						teacher.setName(resultset.getString("name"));
						teacher.setRemark(resultset.getString("remark"));
						return teacher;
					}
					
				} ,  new Object[]{new Integer(1)});
		return teacher;
	}
	
	public List<Teacher> getTeachers(){
		/* final List<Teacher> list=new ArrayList<Teacher>();
		 //RowCallbackHandler 可以方法中在针对单个元素进行业务处理
		 jdbcTemplate.query(
				 "select * from teacher where id>?", 
				 new Object[]{new Integer(1)}, 
				 new RowCallbackHandler() {
					
					@Override
					public void processRow(ResultSet resultset) throws SQLException {
						Teacher teacher=new Teacher();
						teacher.setId(resultset.getInt("id"));
						teacher.setName(resultset.getString("name"));
						teacher.setRemark(resultset.getString("remark"));
						list.add(teacher);
						
					}
				});
		 return list;*/
		
		//RowMapper 不能在方法中对该方法进行业务处理
		List<Teacher> list= jdbcTemplate.query(
				 "select * from teacher where id>?", 
				 new Object[]{new Integer(1)}, 
				 new RowMapper<Teacher>(){
					@Override
					public Teacher mapRow(ResultSet resultset, int i)
							throws SQLException {
						Teacher teacher =new Teacher();
						teacher.setId(resultset.getInt("id"));
						teacher.setName(resultset.getString("name"));
						teacher.setRemark(resultset.getString("remark"));
						return teacher;
					}
				 });
		return list;
	}
}


