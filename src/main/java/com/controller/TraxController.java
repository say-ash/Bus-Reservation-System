package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.StopsDetails;
import com.service.InterfaceBookService;



@Controller
public class TraxController {
	
	
	 @Autowired
		private InterfaceBookService userservice;
	 
	 @PostMapping("/bookSeat")
	   public  ModelAndView addMoreStopsDetails(@ModelAttribute StopsDetails sd, Model model) {

	      // Implement your business logic
		 int i = userservice.UpdateStops(sd);
		 if(sd.getBusNumber()==i) {
			 userservice.UpdateNewStops(sd);
		 }
		 else {
			 userservice.AddNewStops(sd);
		 }
		 
		return new ModelAndView("AdminIndex"); 
	   }
	
	
	

}
