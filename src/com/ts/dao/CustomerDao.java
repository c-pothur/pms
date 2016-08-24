package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.ts.beans.CustomerBean;

public class CustomerDao {

	static Logger logger = Logger.getLogger("myconsole");
	static Logger log = Logger.getLogger("com.a");
	private static final String customerName = null;
	private static final String cb = null;

	public String insertCustomer(CustomerBean customerBean) {
		
		PreparedStatement pst = null;
		String result = "success";
		
	
				Connection con = DBConnection.getSimpleConnection();
				logger.info("got connection");
				try{
					//con.setAutoCommit(false);
					
					String sql = ("insert into customer(customerName,ceo,mission,phoneNo,address,startDate) values(?,?,?,?,?,?)");
					
					
						System.out.println("before sql");
						System.out.println(customerBean.getCustomerName()+","+customerBean.getCeo()+","+customerBean.getMission()+","+customerBean.getPhoneNo()+","+customerBean.getStartDate()+","+customerBean.getAddress());
					pst = con.prepareStatement(sql);
					pst.setString(1, customerBean.getCustomerName());
					pst.setString(2, customerBean.getCeo());
					
					pst.setString(3, customerBean.getMission());
					pst.setString(4, customerBean.getPhoneNo());
					pst.setString(5, customerBean.getAddress());
					
					pst.setString(6, customerBean.getStartDate());
					int rows = pst.executeUpdate();
					
					if(rows != 1 )
						result = "failure";	
				}
				catch(SQLException e)
				{
					log.error("SQL Exception");
					result = "failure";
					
				}
				
System.out.println(result);
				return result;		
	}

public String updateCustomer(CustomerBean customerBean) {
	// TODO Auto-generated method stub
	
	PreparedStatement pst = null;
	String result = null;
	// getting database connection 
			Connection con = DBConnection.getSimpleConnection();
			//con.setAutoCommit(false);
			logger.info("got connection");
			try{
			StringBuffer updateSql = new StringBuffer();
			System.out.println("update customer");
			String str ="customerName='"+customerBean.getCustomerName()+"',ceo='"+customerBean.getCeo()+"',mission='"+customerBean.getMission()+"',phoneNo='"+customerBean.getPhoneNo()+"',address='"+customerBean.getAddress()+"',startDate='"+customerBean.getStartDate()+"' where customerId="+customerBean.getCustomerId();
			updateSql.append("UPDATE customer SET ");
			updateSql.append(str);
			//updateSql.append("customerName='"+customerBean.getCustomerName()+"',ceo='"+customerBean.getCeo()+"',mission='"+customerBean.getMission()+"',phoneNo='"+customerBean.getPhoneNo()+"' ,address='"+customerBean.getAddress()+"' startDate='"+customerBean.getStartDate()+"' ,where customerId="+customerBean.getCustomerId());
			
				
				pst = con.prepareStatement(updateSql.toString());
				int rows = pst.executeUpdate();
				
				if(rows != 1 )
					result = "failure";
				result = "success";
			
			}
			catch(SQLException e)
			{
				log.error("SQL Exception");
				result = "failure";
				
			}
			
			

System.out.println(result);
			return result;
}	

public Collection<CustomerBean> selectcustomer() {
	// TODO Auto-generated method stub
	
	Collection<CustomerBean> customerbean = new ArrayList<CustomerBean>();
	System.out.println("customer");
	//getting database connection
	Connection con = DBConnection.getSimpleConnection();
	logger.info("got connection");
		
		try {
			//con.setAutoCommit(false);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from customer");
			log.info("reading values");
			while (rs.next())
			{ 
				CustomerBean cb = new CustomerBean();
				cb.setCustomerName(rs.getString(1));
				cb.setCeo(rs.getString(2));
				cb.setMission(rs.getString(3));
				cb.setPhoneNo(rs.getString(4));
				cb.setAddress(rs.getString(5));
				cb.setCustomerId(rs.getInt(6));
				cb.setStartDate(rs.getString(7));
			
				
				customerbean.add(cb);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	

			
	return customerbean;
}

public String deleteCustomer(String customerName) {
	// TODO Auto-generated method stub
	String result= "false";
	Statement st= null;
	Connection con = DBConnection.getSimpleConnection();
	logger.info("got connection");
	String sql="delete from customer where customerName='"+customerName+"'";
	System.out.println("customer");
	try {
		st = con.createStatement();
		st.executeUpdate(sql);
		result="success";
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		log.error("SQL Exception");
		result="failure";
	}
	

	return result;
}
}