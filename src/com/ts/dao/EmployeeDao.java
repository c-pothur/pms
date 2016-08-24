package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.ts.beans.EmployeeBean;
import com.ts.dao.DBConnection;

public class EmployeeDao {
	static Logger logger = Logger.getLogger("myconsole");
	static Logger log = Logger.getLogger("com.a");
	public String insertEmployee(EmployeeBean eb) {
		String result= "success";
		PreparedStatement pst = null;
		Connection con = DBConnection.getSimpleConnection();
		logger.info("got connection");
		ResultSet rs=null;
		System.out.println("before sql the elements in eb are"+eb.getRoleId());
		String sql = ("insert into employee(employeeName,dateOfJoining,designation,username,password,email,roleId) values(?,?,?,?,?,?,?)");
		try {
			pst =  con.prepareStatement(sql);
					
				
				pst.setString(1,eb.getEmployeeName());
				pst.setString(2,eb.getDateOfJoining());
				pst.setString(3,eb.getDesignation());
				pst.setString(4,eb.getUserName());
				pst.setString(5,eb.getPassword());
				pst.setString(6,eb.getEmail());
				pst.setInt(7,eb.getRoleId());

				int rows = pst.executeUpdate();
			
				
				if(rows != 1 )
					result = "failure";
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				log.error("SQL Exception");
				e.printStackTrace();
			}
		}

		return result;
	}

	public String updateUser(EmployeeBean eb) {
		// TODO Auto-generated method stub
		String result= "failure";
		PreparedStatement pst= null;
		System.out.println("dao1");
		
		
		
		Connection con = DBConnection.getSimpleConnection();
		logger.info("got connection");
		//con.setAutoCommit(false);
		StringBuffer updatesql = new StringBuffer();
		System.out.println("dao2");
		
		updatesql.append("update employee set ");
		updatesql.append("employeeName='"+eb.getEmployeeName()+"' ,");
		updatesql.append("roleId='"+eb.getRoleId()+"' ,");
		updatesql.append("password='"+eb.getPassword()+"',");
		updatesql.append("username='"+eb.getUserName()+"',");
		updatesql.append("dateOfJoining='"+eb.getDateOfJoining()+"',");
		updatesql.append("designation='"+eb.getDesignation()+"' ");
		updatesql.append("where email='"+eb.getEmail()+"'");
		
		try {
			pst = con.prepareStatement(updatesql.toString());
			
			int rows = pst.executeUpdate();
			

			if(rows != 1){
				result = "failure";
			}
			else {
				result="success";
			}
		}
		catch (SQLException e) {
			log.error("SQL Exception");
			e.printStackTrace();
			return result;
		}
		
		return result;
	}

	public Collection<EmployeeBean> selectEmployees() {
		// TODO Auto-generated method stub
		Collection<EmployeeBean> employeebean = new ArrayList<EmployeeBean>();
		Connection con = DBConnection.getSimpleConnection();
		logger.info("got connection");
		Statement st = null;
		ResultSet rs = null;
		try{			
			con.setAutoCommit(false);
			st = con.createStatement();
			rs = st.executeQuery("select * from employee");
			log.info("reading values");
			while (rs.next())
			{
				EmployeeBean eb = new EmployeeBean();
                eb.setEmployeeName(rs.getString("employeeName"));
				eb.setDateOfJoining(rs.getString("dateOfJoining"));
				eb.setDesignation(rs.getString("designation"));
				eb.setEmail(rs.getString("email"));
				eb.setUserName(rs.getString("username"));
				eb.setPassword(rs.getString("password"));
				eb.setRoleId(rs.getInt("roleId"));
				eb.setEmployeeId(rs.getInt("employeeId"));
				employeebean.add(eb);
			}
			
		}catch(Exception e)
		{
			log.error("SQL Exception");
			System.out.println(e);
		}
				
		return employeebean;
	}

	public String checkuser(EmployeeBean eb) {
		// TODO Auto-generated method stub
		String result= "false";
		Statement st= null;
		Connection con = DBConnection.getSimpleConnection();
		ResultSet rs=null;
		String sql = ("select * from employee where username='"+eb.getUserName()+"' and password='"+eb.getPassword()+"'");

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			log.info("reading values");
			while(rs.next()){
				eb.setEmployeeName(rs.getString("employeeName"));
				eb.setDateOfJoining(rs.getString("dateOfJoining"));
				eb.setDesignation(rs.getString("designation"));
				eb.setEmail(rs.getString("email"));
				eb.setUserName(rs.getString("username"));
				eb.setPassword(rs.getString("password"));
				eb.setRoleId(rs.getInt("roleId"));
				eb.setEmployeeId(rs.getInt("employeeId"));
				
				result = "success";
				
			}
			
		}
		catch (SQLException e) {
			log.error("SQL Exception");
			e.printStackTrace();
		}
		return result;
	}

	public String deleteEmployee(String email) {
		// TODO Auto-generated method stub
		String result= "false";
		Statement st= null;
		Connection con = DBConnection.getSimpleConnection();
		logger.info("got connection");
		String sql="delete from employee where email='"+email+"'";
		System.out.println(email);
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

	
}
