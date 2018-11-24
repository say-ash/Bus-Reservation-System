package com.dao;

import java.util.List;
import java.util.Map;

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
			String query1 = "select group9_bus_users_seq.nextval from dual";
			int query2 = getSeq(query1);
		 String query="insert into GROUP9_BUS_USERS values("+query2+",'"+r.getFirstName()+"','"+r.getLastName()+"','"+r.getEmailId()+"','"+r.getPassword()+"',"+r.getContactNumber()+")";  
		    return jdbcTemplate.update(query);  
	}

	private int getSeq(String query1) {
		
		int res = jdbcTemplate.queryForObject(query1, Integer.class);
		return res;
	}

	public boolean validateUser(Login l) {
		
		String email= "select GBU_EMAIL_ID from GROUP9_BUS_USERS where GBU_EMAIL_ID='" + l.getEmailId() + "'";
		String password= "select GBU_PASSWORD from GROUP9_BUS_USERS where GBU_PASSWORD='" + l.getPassword() + "'";
		String e = jdbcTemplate.queryForObject(email, String.class);
		System.out.println(e);
	
		String p = jdbcTemplate.queryForObject(password, String.class);
		System.out.println(p);
		
		if(l.getEmailId().equals(e) && l.getPassword().equals(p)) { 
		return true;
		
	}	
		else
			return false;
	
	}
}
