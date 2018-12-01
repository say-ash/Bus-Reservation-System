package com.service;

import java.util.List;

import com.model.AdminBusDetails;
import com.model.BusStatus;
import com.model.Login;
import com.model.StopsDetails;
import com.model.User;


public interface InterfaceUserService {

	
	public int saveUser(User r);
	public boolean validateUser(Login l);
	public int AddBusDetails(AdminBusDetails br);
	public int UpdateBus(AdminBusDetails br);
	public int UpdateMoreDetails(AdminBusDetails br );
	public int insertNewBus(AdminBusDetails br) ;
	public int UpdateStops(StopsDetails sd);
	public int UpdateNewStops(StopsDetails sd);
	public int AddNewStops(StopsDetails sd);
	public List<AdminBusDetails> viewBusDetails();
	public List<BusStatus> StatusView();
	
}
