package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import com.model.Login;
import com.model.User;
import com.service.InterfaceUserService;

/**
 * This is to mention it is the Controller 
 *
 */

@Controller
@SessionAttributes("login")
public class UserController {
	
	
	
	
	@RequestMapping(value = "/first")
	 public ModelAndView welcome() {
	        return new ModelAndView("login-signup");
 }

	@Autowired
	private InterfaceUserService userService;
	
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User r) {
	
		ModelAndView mv= new ModelAndView("login-signup");
		int i = userService.saveUser(r);
		
		if(i>0)
			return mv;
		else 
			return null;
		}
	
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	  public ModelAndView checkLogin(@ModelAttribute("login") Login l) {
		
		 Boolean check = userService.validateUser(l);
		 if(check) {
		 ModelAndView mv = new ModelAndView("userhome");
		 mv.addObject("login",l);
			 return  mv;
		 }
		 else
		 return new ModelAndView("not");  
	  }
	
	 @RequestMapping(value = "/last", method = RequestMethod.POST)
	  public ModelAndView logoutUser(@ModelAttribute Login l) {
		
		 Boolean check = userService.validateUser(l);
		 if(check)
			 return new ModelAndView("home");
		 else
		 return new ModelAndView("not");  
	  }
	 
}
		
	


