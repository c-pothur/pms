package com.ts.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ts.beans.AssignBean;
import com.ts.dao.AssignDao;
import com.ts.dao.ProjectDao;

public class AssignCommand implements Command {
	static Logger logger = Logger.getLogger("com.a");
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			AssignBean ab = new AssignBean();
			mapToBean(request, ab);
			
			String result = new AssignDao().assignPrj(ab);
			
			try {
			if("success".equalsIgnoreCase(result))
					{
				logger.info("project assigned");
					response.sendRedirect(request.getContextPath()+"/welcomeEmployee.jsp");
					
					}
			} 
			catch (Exception e) {
				logger.error("project assigning failed");
				e.printStackTrace();
			}
	}

	private void mapToBean(HttpServletRequest request, AssignBean ab) {
		// TODO Auto-generated method stub
		char c =(request.getParameter("projectId")).charAt(0);
		String d=""+c;
		ab.setProjectId(Integer.parseInt(d));
		ab.setManagerId(Integer.parseInt(request.getParameter("managerId")));
		ab.setTeamId(Integer.parseInt(request.getParameter("teamId")));
	}
}
