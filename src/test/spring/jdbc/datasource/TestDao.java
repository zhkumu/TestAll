package test.spring.jdbc.datasource;

import org.springframework.jdbc.core.JdbcTemplate;

public class TestDao {
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int getStudent(String  name){
		int id = jdbcTemplate.queryForInt("select id from student where name=? ", name );
		return id;
	}
}
