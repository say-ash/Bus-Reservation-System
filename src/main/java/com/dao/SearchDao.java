package com.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.BusSearch;

public class SearchDao implements InterfaceSearchDao{

	private JdbcTemplate jdbcTemplate;  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	
	public Object searchBus(BusSearch b) {
		
		
		return b;
		
	}

}
