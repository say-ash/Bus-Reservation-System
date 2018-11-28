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
	
		System.out.println(b.getSource()+"\n"+b.getDestination()+"\n"+b.getDoj()+"\n"+b.getDor());
		ModelAndView mv = new ModelAndView("bus");
		List<SearchResult> list = (List<SearchResult>) searchService.searchBus(b);
		System.out.println(list.get(0).getSource());
		mv.addObject("msg",list);
		mv.addObject("msg1",list.get(0).getSource());
		mv.addObject("msg2",list.get(0).getDestination());
		return mv;
		
	}
	
	
	@RequestMapping("/check")
	public ModelAndView rediret()
	{
		return new ModelAndView("about");
	}
	
}
