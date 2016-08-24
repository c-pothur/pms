package com.ts.beans;

import java.util.Collection;

public class CustomerBean {
	String customerName;
	String ceo;
	String mission;
	String phoneNo;
	String address;
	int customerId;
	String startDate;
	
	
	
	
	public String getPhoneNo() {
		return phoneNo;
	}




	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}




	public String getCustomerName() {
		return customerName;
	}




	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}




	public String getCeo() {
		return ceo;
	}




	public void setCeo(String ceo) {
		this.ceo = ceo;
	}




	public String getMission() {
		return mission;
	}




	public void setMission(String mission) {
		this.mission = mission;
	}





	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public int getCustomerId() {
		return customerId;
	}




	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}




	public String getStartDate() {
		return startDate;
	}




	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}




	public CustomerBean() {
		super();
		this.customerName = customerName;
		this.customerId = customerId;
		this.ceo = ceo;
		
		this.startDate = startDate;
		this.mission = mission;
		this.phoneNo = phoneNo;
		this.address = address;
	}



	

	


}
