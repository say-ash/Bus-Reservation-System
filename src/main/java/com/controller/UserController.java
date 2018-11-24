package com.controller;
import javax.servlet.Registration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserDao;
import com.model.Login;
import com.model.User;
import com.service.InterfaceUserService;



@Controller
public class UserController {
	

	@RequestMapping(value = "/first")
	 public ModelAndView welcome() {
	        return new ModelAndView("login-signup");
 }

	
	@Autowired
	private InterfaceUserService userService;
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute User r,@ModelAttribute Login l) {
	
		int i = userService.saveUser(r);
		if(i>0)
			return new ModelAndView("thankyou");
		else
			return new ModelAndView("thankyou");
			
		
		}
	
	@Autowired
	private InterfaceUserService userService1;
	@RequestMapping("/register1")
	public void validate(@ModelAttribute Login l) {
	
		userService1.validateUser(l);
		
		
		}
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("login", new Login());
	    return mav;
	  }
	

}
		
	


