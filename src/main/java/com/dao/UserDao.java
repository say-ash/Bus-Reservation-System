package com.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.web.servlet.ModelAndView;

import com.model.Login;
import com.model.User;

public class UserDao implements InterfaceUserDao {
	
	private JdbcTemplate jdbcTemplate;  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	  
	public int saveUser(User r) {
		 String query="insert into GROUP9_BUS_USER values('"+r.getFirstName()+"','"+r.getLastName()+"','"+r.getEmailId()+"',"+r.getPassword()+"'"+r.getContactNumber()+")";  
		    return jdbcTemplate.update(query);  
	}

	public int validateUser(Login l) {
		String username=l.getEmailId();
		String password=l.getPassword();
		String sql= "select * from GROUP9_BUS_USER where GBU_EMAIL_ID='" + l.getEmailId() + "' and password='" + l.getPassword()+ "'";
		jdbcTemplate.execute(sql);
		
		return 0;
	}

	
	
	
}
