package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dao.SearchDao;
import com.dao.UserDao;
import com.model.SearchResult;
import com.model.StopsDetails;
import com.model.User;
import com.service.InterfaceTraxService;
 


@Controller
@SessionAttributes({"MyProfile","Search"})
public class TraxController {
	
	
	 @Autowired
		private InterfaceTraxService userservice;
	 
	 @PostMapping("/bookSeat")
	   public  ModelAndView addMoreStopsDetails(@SessionAttribute("MyProfile") User r,@SessionAttribute("Search") SearchResult sr) {
		
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("MyProfile",r);
		 mv.addObject("Search",sr);
		return new ModelAndView("booking"); 
	   }
	
	
	

}
