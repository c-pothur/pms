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

import com.ts.beans.CustomerBean;
import com.ts.beans.EmployeeBean;
import com.ts.dao.CustomerDao;
import com.ts.dao.EmployeeDao;


public class CustomerCommand implements Command {
	
	static Logger logger = Logger.getLogger("com.a");
public void execute(HttpServletRequest request,  HttpServletResponse response)
    {
		if("insert".equalsIgnoreCase(request.getParameter("action")))
		{
			this.insertcustomer(request,response);
		}
		
		
		 if("updateCustomer".equalsIgnoreCase(request.getParameter("action")))
			{
				this.updateCustomer(request,response);												
			}
		 
     if("delete".equalsIgnoreCase(request.getParameter("action"))){
		this.deleteCustomer(request,response);
     }
     
	if("viewAllCustomer".equalsIgnoreCase(request.getParameter("action")))
   {		System.out.println("ccmd view all");
			this.viewAllCustomer(request,response);
    
    }   
    }
	private void updateCustomer(HttpServletRequest request,
			HttpServletResponse response) {
		CustomerBean customerBean = new CustomerBean();
		mapToCustomerBean(request,customerBean);
 
		try{
			String result = new CustomerDao().updateCustomer(customerBean); 
		
			  if ("success".equalsIgnoreCase(result))
			  {
				  System.out.println(result);
				  HttpSession session = request.getSession();
				  session.setAttribute("customerBean", customerBean);
				 ServletContext context = request.getSession().getServletContext();
		          context.getRequestDispatcher("/welcomeAdmin.jsp").forward(request, response);	
			  }
			  else
			  {
				  ServletContext context = request.getSession().getServletContext();
			      context.getRequestDispatcher("/updateCustomer.jsp").forward(request, response);	
			  }    
		 }	
		
		catch(Exception ex){

			logger.error("not updated successfully");

		  	}
	}
		
	

	


	private void insertcustomer(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		CustomerBean customerBean = new CustomerBean();
		mapToCustomerBean(request,customerBean);

		String result = new CustomerDao().insertCustomer(customerBean);
		
		try {
			if("success".equalsIgnoreCase(result)){
				logger.info("inserted new customer");
				response.sendRedirect(request.getContextPath()+"/welcomeAdmin.jsp");
			}else
				response.sendRedirect(request.getContextPath()+"/newCustomer.jsp");
		} 
		catch (Exception e) {
			logger.error("not insertion failed");
			e.printStackTrace();
		}
	}
	private void deleteCustomer(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		CustomerBean cb =new CustomerBean();
		cb.setCustomerName(request.getParameter("notify"));
		String result = new CustomerDao().deleteCustomer(cb.getCustomerName());
		if("success".equalsIgnoreCase(result))
		{
			logger.info("View All customers");
			 viewAllCustomer(request,response);
			 System.out.println("delete");
		}
		else
		{
			logger.info("No customer selected to delete");
			request.setAttribute("wrong","Please select atleast one record");
			 viewAllCustomer(request, response);
		}
		
	}
private void viewAllCustomer(HttpServletRequest request,
		HttpServletResponse response) {
	// TODO Auto-generated method stub
	
	Collection<CustomerBean> colbean = new ArrayList<CustomerBean>();
try{
	colbean = new CustomerDao().selectcustomer();
	if(!colbean.isEmpty())
		{
			request.setAttribute("viewAllCustomer", colbean);
			ServletContext context = request.getSession().getServletContext();
			context.getRequestDispatcher("/viewAllCustomer.jsp").forward(request,response);
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
	
	
private void mapToCustomerBean(HttpServletRequest request,
		CustomerBean customerBean) {
	// TODO Auto-generated method stub
	//customerBean.setCustomerid(0);
	customerBean.setCustomerName(request.getParameter("customerName"));
	customerBean.setCeo(request.getParameter("ceo"));
	customerBean.setMission(request.getParameter("mission"));
	customerBean.setPhoneNo (request.getParameter("phoneNo"));
	customerBean.setAddress(request.getParameter("address"));
	//customerBean.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
    customerBean.setStartDate(request.getParameter("startDate"));
	if(request.getParameter("customerId") != null)
	customerBean.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
}
}