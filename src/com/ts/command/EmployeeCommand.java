package com.ts.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ts.beans.EmployeeBean;
import com.ts.dao.EmployeeDao;

public class EmployeeCommand implements Command {
	static Logger logger = Logger.getLogger("com.a");
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("signup")){
			this.insertEmployee(request,response);
		}else if(action.equalsIgnoreCase("update")){
			this.updateEmployee(request,response);
		}else if(action.equalsIgnoreCase("viewall")){
			this.viewAllEmployee(request,response);
		}else if(action.equalsIgnoreCase("delete")){
			this.deleteEmployee(request,response);
		}else if(action.equalsIgnoreCase("select")){
			this.selectEmployees(request,response);
		}else if(action.equalsIgnoreCase("viewusers")){
			this.viewusers(request,response);
		}else if(action.equalsIgnoreCase("updateprofile")){
			this.updateProfile(request,response);
		}


	
	}
	private void updateProfile(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		EmployeeBean eb = new EmployeeBean();
		mapToBean(request,eb);
		System.out.println("hi....");

		String result = new EmployeeDao().updateUser(eb);
		System.out.println(result);
		try {
			if("success".equalsIgnoreCase(result))
					{
					  HttpSession session = request.getSession();
					  session.setAttribute("employeeBean", eb);
					  ServletContext context = request.getSession().getServletContext();
					  context.getRequestDispatcher("/welcomeEmployee.jsp").include(request, response);
					}
			else {				
				 ServletContext context = request.getSession().getServletContext();
			      context.getRequestDispatcher("/updateProfile.jsp").forward(request, response);
			}
			} 
		
			catch (Exception e) {
				logger.error("not updated successfully");
				e.printStackTrace();
			}
	}
	private void viewusers(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		Collection<EmployeeBean> colbean = new ArrayList<EmployeeBean>();
		try{
			colbean = new EmployeeDao().selectEmployees();
			if(!colbean.isEmpty())
				{
					request.setAttribute("employees", colbean);
					ServletContext context = request.getSession().getServletContext();
					context.getRequestDispatcher("/viewusers.jsp").forward(request,response);
				}
			else
			{
				ServletContext context = request.getSession().getServletContext();
				context.getRequestDispatcher("/login.jsp").forward(request,response);
			}
			}
		catch(Exception e){
			logger.error("exception");
			}
	}
	private void selectEmployees(HttpServletRequest request,HttpServletResponse response) {
		EmployeeBean eb = new EmployeeBean();
			Collection<EmployeeBean> colbean = new ArrayList<EmployeeBean>();
			try{
		//		colbean = new EmployeeDao().listEmployee(eb);

				if(!colbean.isEmpty())
				{
					request.setAttribute("employees", colbean);
					ServletContext context = request.getSession().getServletContext();
					context.getRequestDispatcher("/selectEmployees.jsp").forward(request,response);
				}
				else
				{
					ServletContext context = request.getSession().getServletContext();
					context.getRequestDispatcher("/login.jsp").forward(request,response);
				}
			}
			catch(Exception e){
				e.printStackTrace();
				logger.error("exception");
			}
		}
		
	private void deleteEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		EmployeeBean eb =new EmployeeBean();
		eb.setEmail(request.getParameter("notify"));
		String result = new EmployeeDao().deleteEmployee(eb.getEmail());
		if("success".equalsIgnoreCase(result))
		{
			logger.info("View All employees");
			 viewAllEmployee(request,response);
		}
		else
		{
			logger.info("No employee selected to delete");
			request.setAttribute("wrong","Please select atleast one record");
			viewAllEmployee(request, response);
		}
		
	}
	private void viewAllEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		Collection<EmployeeBean> colbean = new ArrayList<EmployeeBean>();
		try{
			colbean = new EmployeeDao().selectEmployees();
			if(!colbean.isEmpty())
				{
					request.setAttribute("employees", colbean);
					ServletContext context = request.getSession().getServletContext();
					context.getRequestDispatcher("/viewAllEmployee.jsp").forward(request,response);
				}
			else
			{
				ServletContext context = request.getSession().getServletContext();
				context.getRequestDispatcher("/login.jsp").forward(request,response);
			}
			}
		catch(Exception e){
			logger.error("exception");
			}
	}
	private void updateEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		EmployeeBean eb = new EmployeeBean();
		mapToBean(request,eb);
		System.out.println("hi....");

		String result = new EmployeeDao().updateUser(eb);
		System.out.println(result);
		try {
			if("success".equalsIgnoreCase(result))
					{
					  HttpSession session = request.getSession();
					  session.setAttribute("employeeBean", eb);
					  ServletContext context = request.getSession().getServletContext();
					  context.getRequestDispatcher("/welcomeAdmin.jsp").include(request, response);
					}
			else {				
				 ServletContext context = request.getSession().getServletContext();
			      context.getRequestDispatcher("/updateEmployee.jsp").forward(request, response);
			}
			} 
		
			catch (Exception e) {
				logger.error("not updated successfully");
				e.printStackTrace();
			}
	}
	private void insertEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		EmployeeBean eb = new EmployeeBean();
		mapToBean(request, eb);
		String result = new EmployeeDao().insertEmployee(eb);
		try {
			if("success".equalsIgnoreCase(result))
					{
				logger.info("inserted new employee");
					response.sendRedirect(request.getContextPath()+"/welcomeAdmin.jsp");
					
					}
			} 
			catch (Exception e) {
				e.printStackTrace();
				logger.error("not insertion failed");
			}
	}
	private void mapToBean(HttpServletRequest request, EmployeeBean eb) {
		// TODO Auto-generated method stub
		eb.setUserName(request.getParameter("username"));
		eb.setPassword(request.getParameter("password"));
		eb.setEmployeeName(request.getParameter("employeeName"));
		eb.setDesignation(request.getParameter("designation"));
		eb.setRoleId(Integer.parseInt(request.getParameter("roleId")));
		eb.setDateOfJoining(request.getParameter("dateOfJoining"));
		eb.setEmail(request.getParameter("email"));
		System.out.println("in maaptobean "+eb.getUserName());
	}

}
