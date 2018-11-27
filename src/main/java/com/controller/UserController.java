package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.model.Login;
import com.model.User;
import com.service.InterfaceUserService;

/**
 * This is to mention it is the Controller 
 *
 */

@Controller
public class UserController {
	

	@RequestMapping(value = "/first")
	 public ModelAndView welcome() {
	        return new ModelAndView("login-signup");
 }

	@Autowired
	private InterfaceUserService userService;
	
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User r) {
	
		int i = userService.saveUser(r);
		if(i>0)
			return new ModelAndView("login-signup");
		else 
			return null;
		}
	
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	  public ModelAndView checkLogin(@ModelAttribute Login l) {
		
		 Boolean check = userService.validateUser(l);
		 if(check)
			 return new ModelAndView("home");
		 else
		 return new ModelAndView("not");

		 
	    
	  }
	
}
		
	


