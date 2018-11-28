package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.InterfaceSearchDao;
import com.model.BusSearch;

@Service
public class SearchService implements InterfaceSearchService{

	@Autowired
	private InterfaceSearchDao searchDao;
	
	public Object searchBus(BusSearch b) {
		return searchDao.searchBus(b);
	
	}
	
	
}
