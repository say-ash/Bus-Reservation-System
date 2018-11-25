package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.BusSearch;
import com.service.InterfaceSearchService;


@Controller
public class SearchController {


	@Autowired
	private InterfaceSearchService searchService;
	
	@RequestMapping(value = "/search")
	public void search(@ModelAttribute BusSearch b) {
	
		@SuppressWarnings("unchecked")
		List<Object> list = (List<Object>) searchService.searchBus(b);
	}
	
	
}
