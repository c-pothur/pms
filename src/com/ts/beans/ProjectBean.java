package com.ts.beans;

import java.sql.Date;

public class ProjectBean {
	
	String projectName;
	
	String startDate;
	String endDate;
	int projectId;
	float cost;
	int employeeId;
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectID) {
		this.projectId = projectID;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeID) {
		this.employeeId = employeeID;
	}
	
	public ProjectBean() {
		super();
		this.projectName = projectName;
		
		this.startDate = startDate;
		this.endDate = endDate;
		this.projectId = projectId;
		this.cost = cost;
		this.employeeId=employeeId;
	}
	

}
