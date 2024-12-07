package com.klu.springmvc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DAO {
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int insert(Student s) {
		String sql = "insert into studentmvc values (" + s.getId() + ", '" + s.getName() + "')";
		return jdbcTemplate.update(sql);
	}
	
	public List<Student> getAllStudents() {
		String sql = "select * from studentmvc";
		return jdbcTemplate.query(sql, new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int row) throws SQLException {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				return s;
			}
		});
	}
	
}
