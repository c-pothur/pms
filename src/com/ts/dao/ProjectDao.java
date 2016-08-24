package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.ts.beans.ProjectBean;

public class ProjectDao {
	static Logger logger = Logger.getLogger("myconsole");
	static Logger log = Logger.getLogger("com.a");
		public String insertProject(ProjectBean projectBean) {
			
			PreparedStatement pst = null;
			String result = "success";
			
		
					Connection con = DBConnection.getSimpleConnection();
					logger.info("got connection");
					try{
						//con.setAutoCommit(false);
						
						String sql = ("insert into project(projectName,startDate,endDate,projectId,cost,employeeId) values(?,?,?,?,?,?)");
						
						
						//System.out.println(userBean.getPassword()+"in userdao class");
							System.out.println("before sql");
						pst = con.prepareStatement(sql);
						System.out.println("after sql");
						pst.setString(1, projectBean.getProjectName());
						pst.setString(2, projectBean.getStartDate());
						pst.setString(3, projectBean.getEndDate());
						pst.setInt(4, projectBean.getProjectId());
						pst.setFloat(5, projectBean.getCost());
						pst.setInt(6, projectBean.getEmployeeId());
						int rows = pst.executeUpdate();
						
						if(rows != 1 )
							result = "failure";	
					}
					catch(SQLException e)
					{
						log.error("SQL Exception");
						result = "failure";
						
					}
					

					return result;		
		}

public String updateProject(ProjectBean projectBean) {
	// TODO Auto-generated method stub
	
	PreparedStatement pst = null;
	String result = null;
	// getting database connection 
			Connection con = DBConnection.getSimpleConnection();
			logger.info("got connection");
			try{
				//con.setAutoCommit(false);
System.out.println(projectBean.getProjectId()+"?");
				StringBuffer updateSql = new StringBuffer();
				updateSql.append("UPDATE project SET ");
				updateSql.append("projectName='"+projectBean.getProjectName()+"' ,  startDate='"+projectBean.getStartDate()+"' , endDate = '"+projectBean.getEndDate()+"',cost="+projectBean.getCost() +",employeeId="+projectBean.getEmployeeId()+" where projectId="+projectBean.getProjectId()+"");
				
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


			return result;
			
}

			

public Collection<ProjectBean> selectProject() {
	// TODO Auto-generated method stub
	
	Collection<ProjectBean> pbset = new ArrayList<ProjectBean>();
	
	//getting database connection
	Connection con = DBConnection.getSimpleConnection();
	logger.info("got connection");
	Statement pst = null;
	ResultSet rs = null;
	
	try{
		
		con.setAutoCommit(false);
		pst = (Statement) con.createStatement();
		rs = ((java.sql.Statement) pst).executeQuery("select * from project");
		log.info("reading values");
		while (rs.next())
		{
			ProjectBean pb = new ProjectBean();
			pb.setProjectName(rs.getString("projectName"));
			System.out.println("in selectproject()");
			
			pb.setStartDate(rs.getString("startDate"));
			pb.setEndDate(rs.getString("endDate"));
			pb.setProjectId(rs.getInt("projectId"));
			pb.setCost(rs.getFloat("cost"));
			pb.setEmployeeId(rs.getInt("employeeId"));
			pbset.add(pb);
		System.out.println(pb.getProjectId()+"?");
		}
		
	}catch(Exception e)
	{
		log.error("SQL Exception");
		System.out.println(e);
	}	
			
	return pbset;
}

public String deleteProject(String projectName) {
	String result= "false";
	Statement st= null;
	Connection con = DBConnection.getSimpleConnection();
	logger.info("got connection");
	String sql="delete from project where projectName='"+projectName+"'";
	System.out.println(projectName);
	try {
		st = con.createStatement();
		st.executeUpdate(sql);
		result="success";
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		log.error("SQL Exception");
		e.printStackTrace();
		result="failure";
	}
	

	return result;
}

public Collection<ProjectBean> selectProjectList() {

Collection<ProjectBean> pbset = new ArrayList<ProjectBean>();
	
	//getting database connection
	Connection con = DBConnection.getSimpleConnection();
	logger.info("got connection");
	Statement pst = null;
	ResultSet rs = null;
	
	try{
		
		con.setAutoCommit(false);
		pst = (Statement) con.createStatement();
		rs = ((java.sql.Statement) pst).executeQuery("select * from project");
		log.info("reading values");
		while (rs.next())
		{
			ProjectBean pb = new ProjectBean();
			pb.setProjectName(rs.getString("projectName"));
			System.out.println("in selectpro");
			
			pb.setStartDate(rs.getString("startDate"));
			pb.setEndDate(rs.getString("endDate"));
			pb.setProjectId(rs.getInt("projectId"));
			pb.setCost(rs.getFloat("cost"));
			pb.setEmployeeId(rs.getInt("employeeId"));
			pbset.add(pb);
		}
		
	}catch(Exception e)
	{
		log.error("SQL Exception");
		System.out.println(e);
	}	
			
	return pbset;
}
}
