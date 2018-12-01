package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.AdminBusDetails;
import com.model.BusDetail;
import com.model.Login;
import com.model.SearchResult;
import com.model.StopsDetails;
import com.service.InterfaceUserService;
import com.service.UserService;



@Controller
public class AdminController {
	
	
	
	 @Autowired
		private InterfaceUserService userservice;

		@RequestMapping(value = "/first1")
		 public ModelAndView welcome1() {
		        return new ModelAndView("adminlogin-signup");
	 }
	 
/*	 
	 @RequestMapping(value = "/UpdateBus")
	 public ModelAndView welcome() {
	        return new ModelAndView("UpdateBus");
 }
	 @RequestMapping(value = "/UpdateStops")
	 public ModelAndView welcome2() {
	        return new ModelAndView("UpdateStops");
 }*/
	
	 @PostMapping("/dologin")
	   public ModelAndView doLogin(@ModelAttribute("admin") Login admin, Model model) {

	      // Implement your business logic
	      if (admin.getEmailId().equals("admin@gmail.com") && admin.getPassword().equals("Admin@123")) {
	    	  return new ModelAndView("adminhome");
	      } else {
	         model.addAttribute("message", "Login failed. Try again.");
	        
	      }
		return null;
		
	      
	   }
	 
	/* @PostMapping("/addDetails")
	   public  ModelAndView addDetails(@ModelAttribute AdminBusDetails br, Model model) {

	      // Implement your business logic
		 int i = userservice.UpdateBus(br);
		 if(br.getBusNumber() == i) {
			 return new ModelAndView("UpdateBus");
		 }
		return new ModelAndView("UpdateBus"); 
	   }*/
	 
	 @GetMapping("/viewDetails")
		 public ModelAndView viewDetails() {
		
		 List<AdminBusDetails> viewList = userservice.viewBusDetails();
		 System.out.println(viewList.get(0).getBusNumber());
		 ModelAndView mv= new ModelAndView("viewAllDetail");
		 mv.addObject("list", viewList);
		 
		 
		 
			return mv;
			 
		 }
	
	
	 @PostMapping("/insertBus")
	   public  ModelAndView addMoreDetails(@ModelAttribute AdminBusDetails br, Model model) {
		 int i=userservice.UpdateBus(br);
		 if(i==0) {
		 int i1=userservice.insertNewBus(br);
		 if(i1 == 0) {
			 return new ModelAndView("unsuccessfull"); 
	   }
		 else {
			 return new ModelAndView("successfull");
		 }
	 }
		 return new ModelAndView("not");
	 }
	 @PostMapping("/insertStop")
	   public  ModelAndView addMoreStopsDetails(@ModelAttribute StopsDetails sd, Model model) {
		 	
		 		userservice.AddNewStops(sd);
			 return new ModelAndView("successfull"); 
	   }
	 @PostMapping("/insertStop")
	   public  ModelAndView status(@ModelAttribute  Model model) {
		 	
		 		userservice.StatusView();
			 return new ModelAndView("successfull"); 
	   }
	 

}
