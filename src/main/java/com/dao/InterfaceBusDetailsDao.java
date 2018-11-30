package com.dao;

import java.util.List;

import com.model.AdminBusDetails;
import com.model.StopsDetails;
import com.model.User;

public interface InterfaceBusDetailsDao {

	public int AddBusDetails(AdminBusDetails br);
	public int UpdateBus(AdminBusDetails br);
	/*public int UpdateOldBus(AdminBusDetails br, int busNumber);*/
	public int UpdateMoreDetails(AdminBusDetails br );
	public int insertNewBus(AdminBusDetails br) ;
	public int UpdateStops(StopsDetails sd);
	public int UpdateNewStops(StopsDetails sd);
	public int AddNewStops(StopsDetails sd);
	public List<AdminBusDetails> viewBusDetails();
	
}
