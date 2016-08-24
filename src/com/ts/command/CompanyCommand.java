/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ts.command;


import com.ts.dao.CompanyDao;
import com.ts.dao.EmployeeDao;
import com.ts.beans.CompanyBean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


/**
 *
 *
 * @author sss
 */
public class CompanyCommand implements Command { 
	static Logger logger = Logger.getLogger("com.a");
	@Override
public void execute(HttpServletRequest request,HttpServletResponse response)
{
    if("insert".equalsIgnoreCase(request.getParameter("action")))
    {
    this.insertCompany(request,response);
    }
    else if("updateCompany".equalsIgnoreCase(request.getParameter("action")))
    {
    this.updateCompany(request,response);												
    }
    else if("viewAllCompanies".equalsIgnoreCase(request.getParameter("action")))
    {
	this.viewAllCompany(request,response);												
    }
    else if("delete".equalsIgnoreCase(request.getParameter("action")))
    {
    this.deleteCompany(request,response);																					
    }
}

    private void insertCompany(HttpServletRequest request, HttpServletResponse response) {
        CompanyBean beans = new CompanyBean();
        mapToUserBean(request,beans); 
        String result = new CompanyDao().createCompany(beans);
        try {
            if("success".equalsIgnoreCase(result))
            {
            	logger.info("inserted new Companies");
               response.sendRedirect(request.getContextPath()+"/welcomeAdmin.jsp");
            }
        } catch (Exception e) {
        	
            e.printStackTrace();
            logger.error("not insertion failed");
        }
   }

    private void mapToUserBean(HttpServletRequest request, CompanyBean beans) {
            beans.setCompanyName(request.getParameter("companyName"));
            beans.setCeoName(request.getParameter("ceoName"));
            beans.setMission(request.getParameter("mission"));
            beans.setPhoneNo(request.getParameter("phoneNo"));
            beans.setAddress(request.getParameter("address"));
            if(request.getParameter("companyId") != null)
           beans.setCompanyId(Integer.parseInt(request.getParameter("companyId")));
    }

    private void updateCompany(HttpServletRequest request, HttpServletResponse response) {
        CompanyBean beans =new CompanyBean();
        mapToUserBean(request,beans);
        
        try{
			String result = new CompanyDao().updateCompany(beans); 
		
			  if ("success".equalsIgnoreCase(result))
			  {
				  HttpSession session = request.getSession();
				  session.setAttribute("userbean", beans);
				  ServletContext context = request.getSession().getServletContext();
				  context.getRequestDispatcher("/welcomeAdmin.jsp").include(request, response);
			  }
			  else
			  {
				  this.viewAllCompany(request, response);
			  }    
		 }	
		
		catch(Exception ex){
			logger.error("not updated successfully");
			
			}
	}
private void viewAllCompany(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("company  cmd viewallcomp");
		Collection<CompanyBean> colbean = new ArrayList<CompanyBean>();
	try{
		colbean = new CompanyDao().selectCompany();
		if(!colbean.isEmpty())
			{
				request.setAttribute("Company", colbean);
				ServletContext context = request.getSession().getServletContext();
				context.getRequestDispatcher("/viewAllCompanies.jsp").forward(request,response);
			}
		else
		{
			ServletContext context = request.getSession().getServletContext();
			context.getRequestDispatcher("/AddCompany.jsp").forward(request,response);
		}
		}
	catch(Exception e){
		logger.error("exception");
		}
	}        

    private void deleteCompany(HttpServletRequest request, HttpServletResponse response) {

		// TODO Auto-generated method stub
		
		CompanyBean userBean = new CompanyBean();
		mapToUserBean(request,userBean);
		userBean.setCompanyId(Integer.parseInt(request.getParameter("notify")));
		
		try{
			String result = new CompanyDao().deleteCompany(userBean.getCompanyId()); 
		
			  if ("success".equalsIgnoreCase(result))
			  {
				  logger.info("View All Companies");
				  viewAllCompany(request, response);
			  }
			  else
			  {
				  logger.info("No Companies selected to delete");
				  request.setAttribute("wrong","Please select atleast one record");
					viewAllCompany(request, response);	
			  }    
		 }	
		
		catch(Exception ex){
			logger.error("exception");
			}
	}        
    }