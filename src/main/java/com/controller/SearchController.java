package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.BusSearch;
import com.model.SearchResult;
import com.service.InterfaceSearchService;


@Controller
public class SearchController {


	@Autowired
	private InterfaceSearchService searchService;
	
	@RequestMapping(value = "/search")
	public ModelAndView search(@ModelAttribute BusSearch b) {
	
		System.out.println(b.getDestination()+"\n"+b.getDoj()+"\n"+b.getDor());
		ModelAndView mv = new ModelAndView("search-result");
		List<SearchResult> list = (List<SearchResult>) searchService.searchBus(b);
		System.out.println("t1");
		mv.addObject("msg",list);
		System.out.println("t2");
		return mv;
		
	}
	
	
}
