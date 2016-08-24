package com.ts.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ts.beans.AssignBean;
import com.ts.beans.EmployeeBean;
import com.ts.beans.ProjectBean;
import com.ts.dao.EmployeeDao;
import com.ts.dao.ProjectDao;

public class ProjectCommand implements Command {
	static Logger logger = Logger.getLogger("com.a");
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		if("insertProject".equalsIgnoreCase(request.getParameter("action")))
		{
			this.insertProject(request,response);
		}
		if("updateProject".equalsIgnoreCase(request.getParameter("action")))
		{
			this.updateProject(request,response);
		}
		if("deleteProject".equalsIgnoreCase(request.getParameter("action")))
		{
			this.deleteProject(request,response);
		}
			
		if("viewAllProject".equalsIgnoreCase(request.getParameter("action")))
		{
			this.viewAllProject(request,response);
		}
		if("viewPrjNames".equalsIgnoreCase(request.getParameter("action")))
		{
			this.viewPrjNames(request,response);
		}if("updateaproject".equalsIgnoreCase(request.getParameter("action"))){
			this.updateaproject(request,response);
		}
	
	}


	private void updateaproject(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		ProjectBean projectBean = new ProjectBean();
		mapToProjectBean(request,projectBean);
 
		try{
			String result = new ProjectDao().updateProject(projectBean); 
		
			  if ("success".equalsIgnoreCase(result))
			  {
				  HttpSession session = request.getSession();
				  session.setAttribute("projectBean", projectBean);
				  ServletContext context = request.getSession().getServletContext();
				  context.getRequestDispatcher("/welcomeEmployee.jsp").include(request, response);
			  }
			  else
			  {
				  ServletContext context = request.getSession().getServletContext();
			      context.getRequestDispatcher("/updateaProject.jsp").forward(request, response);	
			  }    
		 }		
		
		catch(Exception e){
			e.printStackTrace();
			logger.error("not updated successfully");

			}
	}


	private void viewPrjNames(HttpServletRequest request,
			HttpServletResponse response) {
		Collection<ProjectBean> colbean = new ArrayList<ProjectBean>();
		try{
			colbean = new ProjectDao().selectProjectList();
			
			if(!colbean.isEmpty())
				{
					request.setAttribute("viewPrjNames", colbean);
					ServletContext context = request.getSession().getServletContext();
					System.out.println("after dao in comma");
					context.getRequestDispatcher("/selectProject.jsp").forward(request,response);
				}
			else
			{
				ServletContext context = request.getSession().getServletContext();
				context.getRequestDispatcher("login.jsp").forward(request,response);
			}
			}
		catch(Exception e){
			logger.error("exception");		
			}
		
	}


	private void insertProject(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		ProjectBean projectBean = new ProjectBean();
		mapToProjectBean(request,projectBean);

		String result = new ProjectDao().insertProject(projectBean);
		
		try {
		if("success".equalsIgnoreCase(result))
				{
			logger.info("inserted new project");
				response.sendRedirect(request.getContextPath()+"/welcomeAdmin.jsp");
				
				}
		} 
		catch (Exception e) {
			logger.error("not insertion failed");
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
		private void updateProject(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		ProjectBean projectBean = new ProjectBean();
		mapToProjectBean(request,projectBean);
 
		try{
			String result = new ProjectDao().updateProject(projectBean); 
		
			  if ("success".equalsIgnoreCase(result))
			  {
				  HttpSession session = request.getSession();
				  session.setAttribute("projectBean", projectBean);
				  ServletContext context = request.getSession().getServletContext();
				  context.getRequestDispatcher("/welcomeAdmin.jsp").include(request, response);
			  }
			  else
			  {
				  ServletContext context = request.getSession().getServletContext();
			      context.getRequestDispatcher("/updateProject.jsp").forward(request, response);	
			  }    
		 }		
		
		catch(Exception e){
			e.printStackTrace();
			logger.error("not updated successfully");

			}
	}
		private void deleteProject(HttpServletRequest request,
				HttpServletResponse response) {
			// TODO Auto-generated method stub
			ProjectBean pb =new ProjectBean();
			pb.setProjectName(request.getParameter("notify"));
			String result = new ProjectDao().deleteProject(pb.getProjectName());
			if("success".equalsIgnoreCase(result))
			{
				logger.info("View All projects");
				 viewAllProject(request,response);
			}
			else
			{
				logger.info("No project selected to delete");
				request.setAttribute("wrong","Please select atleast one record");
				viewAllProject(request, response);
			}
			
		}
		
		private void viewAllProject(HttpServletRequest request,
				HttpServletResponse response) {
			// TODO Auto-generated method stub
			
			Collection<ProjectBean> colbean = new ArrayList<ProjectBean>();
		try{
			colbean = new ProjectDao().selectProject();
			if(!colbean.isEmpty())
				{
					request.setAttribute("viewAllProject", colbean);
					ServletContext context = request.getSession().getServletContext();
					context.getRequestDispatcher("/viewAllProject.jsp").forward(request,response);
				}
			else
			{
				ServletContext context = request.getSession().getServletContext();
				context.getRequestDispatcher("login.jsp").forward(request,response);
			}
			}
		catch(Exception e){
			logger.error("exception");	
			}
		}
	
	
		private void mapToProjectBean(HttpServletRequest request, ProjectBean projectbean) {
		// TODO Auto-generated method stub
			System.out.println(request.getParameter("projectId")+"?");
		projectbean.setProjectName(request.getParameter("projectName"));
		
		projectbean.setStartDate(request.getParameter("startDate"));
		projectbean.setEndDate(request.getParameter("endDate"));
		
		projectbean.setProjectId(Integer.parseInt(request.getParameter("projectId")));
		
		projectbean.setCost (Float.parseFloat(request.getParameter("cost")));
		projectbean.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
	
		
	}


	
	


}

