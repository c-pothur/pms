/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ts.beans;

import java.util.Collection;

/**
 *
 * @author sss
 */
public class CompanyBean {

   
    String companyName;
    String ceoName;
    String mission;
     String phoneNo;
     String address;
     int companyId;

    

    public int getCompanyId() {
		return companyId;
	}



	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}



	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public String getCeoName() {
		return ceoName;
	}



	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}



	public String getMission() {
		return mission;
	}



	public void setMission(String mission) {
		this.mission = mission;
	}







	public String getPhoneNo() {
		return phoneNo;
	}



	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public void getName(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    public void add(Collection<CompanyBean> coll) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}
	
	
	
	
	
	
	


