package com.ts.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ts.beans.EmployeeBean;
import com.ts.dao.EmployeeDao;

public class LoginCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		EmployeeBean eb = new EmployeeBean();
		mapToBean(request,eb);
		String result = new EmployeeDao().checkuser(eb);
		System.out.println(result);
		if("success".equalsIgnoreCase(result)){

			if(eb.getRoleId()==1){
				HttpSession session = request.getSession();
				session.setAttribute("employeeBean", eb);
				session.setAttribute("employeeName", eb.getEmployeeName());
				ServletContext context = request.getSession().getServletContext();
				try {
					context.getRequestDispatcher("/welcomeAdmin.jsp").include(request, response);
				} 
				catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(eb.getRoleId()==2 || eb.getRoleId()==3){
				HttpSession session = request.getSession();
				session.setAttribute("employeeBean", eb);
				ServletContext context = request.getSession().getServletContext();
				try {
					context.getRequestDispatcher("/welcomeEmployee.jsp").include(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("invalid details");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			try {
				rd.include(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}



		

	public void mapToBean(HttpServletRequest request,EmployeeBean eb) {
		eb.setUserName(request.getParameter("username"));
		eb.setPassword(request.getParameter("password"));	
	}


}
