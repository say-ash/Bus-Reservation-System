package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.model.AdminBusDetails;
import com.model.BusStatus;
import com.model.StopsDetails;




public class AddBusDetailsDao implements InterfaceBusDetailsDao {
	private JdbcTemplate jdbcTemplate;  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}
	
	public int AddBusDetails(AdminBusDetails br) {
		String query1 = "select GROUP9_BUS_DETAILS_SEQ.nextval from dual";
		int query2 = getSeq(query1);
	 String query="insert into GROUP9_BUS_DETAILS values("+query2+",'"+br.getBusName()+"',"+br.getNumberSeats()+")";  
	 String query4="select GROUP9_BUS_TYPES_SEQ.nextval from dual";
	 int query5=getSeq1(query4);
	 String query3="insert into GROUP9_BUS_TYPES values("+query5+","+query2+",'"+br.getBusType()+"')";
	    return jdbcTemplate.update(query,query3);  
}

	/*private int getSeq(String query1) {
		int res = jdbcTemplate.queryForObject(query1, Integer.class);
		return res;
	}
	private int getSeq1(String query4) {
		int res = jdbcTemplate.queryForObject(query4, Integer.class);
		return res;
	}
	*/
	
	public int UpdateBus(AdminBusDetails br) {
		
		
			try {
				String query = "select GBD_ID from GROUP9_BUS_details where GBD_ID= " + br.getBusNumber();
				int busNumber = jdbcTemplate.queryForObject(query, Integer.class);
				return busNumber;
			} catch (Exception e) {
				int bus;
				return bus=0;
			}
	}
	

	public int UpdateMoreDetails(AdminBusDetails br ) {
		
		String query1="UPDATE GROUP9_BUS_details SET  GBD_NAME='"+br.getBusName()+"' GBD_NUMBER_OF_SEATS ="+br.getNumberSeats()+ " WHERE GBD_ID=" + br.getBusNumber()+" ";
		
		String query2= "UPDATE GROUP9_BUS_TYPES SET  GBT_TYPE= '"+br.getBusType()+"'  WHERE GBT_BD_ID= "+br.getBusNumber();
		return jdbcTemplate.update(query1 , query2);
		
		
	}
	
		public int insertNewBus(AdminBusDetails br) {
			String query1 = "select GROUP9_BUS_DETAILS_SEQ.nextval from dual";
			int query2 = getSeq(query1);
		 String query3="insert into GROUP9_BUS_DETAILS values("+query2+",'"+br.getBusName()+"',"+br.getNumberSeats()+")"; 
		 String query4 = "select GROUP9_BUS_TYPES_SEQ.nextval from dual";
			int query5 = getSeq1(query4);
		 String query6="insert into GROUP9_BUS_TYPES values("+query5+","+query2+",'"+br.getBusType()+")";
		    return jdbcTemplate.update(query3,query6); 
		}
		private int getSeq(String query1) {
			int res = jdbcTemplate.queryForObject(query1, Integer.class);
			return res;
		}
		private int getSeq1(String query4) {
			int res = jdbcTemplate.queryForObject(query4, Integer.class);
			return res;
		}
			
		
		public int UpdateStops(StopsDetails sd) {
			try {
				String query = "select GBS_ID from GROUP9_BUS_STOPS where GBS_ID= " + sd.getBusNumber();
				int busNumber = jdbcTemplate.queryForObject(query, Integer.class);
				return busNumber;
			} catch (Exception e) {
				int bus;
				return bus=0;
			}
			
		}

		public int UpdateNewStops(StopsDetails sd) {
		
				String query1="UPDATE GROUP9_BUS_STOPS SET  GBS_STOP_NAME= ?  GBS_STOP_ORDER = ?  GBS_ARRIVAL_TIME = ? GBS_DEPARTURE_TIME = ? GBS_DISTANCE= ? GBS_PRICE= ? WHERE GBD_ID= ?";
				
				
				return jdbcTemplate.update(query1, sd.getBusNumber(),sd.getStopOrder(),sd.getArivalTime(),sd.getDepartureTime(),sd.getDistance(),sd.getPrice(),sd.getBusNumber());
			}
			
		public int AddNewStops(StopsDetails sd) {
			String query1 = "select GROUP9_BUS_STOPS_SEQ.nextval from dual";
			int query2 = getSeq3(query1);
			
			
			String query3="insert into GROUP9_BUS_STOPS values ("+query2+","+sd.getBusNumber()+",'"+sd.getStopName()+"',"+sd.getStopOrder()+",'"+sd.getArivalTime()+"','"+sd.getDepartureTime()+"',"+sd.getDistance()+","+sd.getPrice()+")";
		
			return jdbcTemplate.update(query3 );
		}
		private int getSeq3(String query1) {
			int res = jdbcTemplate.queryForObject(query1, Integer.class);
			return res;
		}
		
		
		
		
		
		public List<AdminBusDetails> viewBusDetails() {
			String q="select d.GBD_ID,  d.GBD_NAME , d.GBD_NUMBER_OF_SEATS , t.GBT_TYPE from  GROUP9_BUS_DETAILS d join GROUP9_BUS_TYPES t on (d.GBD_ID=t.GBT_BD_ID)";
			return jdbcTemplate.query(q,new RowMapper<AdminBusDetails>(){

				public AdminBusDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
					AdminBusDetails ad =new AdminBusDetails(); 
	                ad.setBusNumber(rs.getInt(1));
	                ad.setBusName(rs.getString(2));
	                ad.setNumberSeats(rs.getInt(3));
	                ad.setBusType(rs.getString(3));
	               
				       
				       
				        return ad;
			
			
			
			
		}
			});
		}

		public List<BusStatus> StatusView() {
			String query1="select gbd.GBD_ID, gbsc.GBSC_DATE , gbsc.GBSC_STATUS, gbd.GBD_NAME  from GROUP9_BUS_STATUS_CHECK gbsc inner join GROUP9_BUS_DETAILS gbd on gbsc.GBSC_GBD_ID= gbd.GBD_ID";
			return jdbcTemplate.query(query1, new RowMapper<BusStatus>() {

				public BusStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
					BusStatus bs= new BusStatus();
					bs.setBusNumber(rs.getInt(1));
					bs.setBusDate(rs.getString(2));
					bs.setBusStatus(rs.getString(3));
					bs.setBusName(rs.getString(4));
					
					return bs;
				}
				
			});
		}
				
			
				
		
			
	
			
		
}
	



	
	
	


