package com.ts.command;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ts.beans.EmployeeBean;
import com.ts.beans.TeamBean;
import com.ts.dao.EmployeeDao;

public class TeamCommand implements Command {
	static Logger logger = Logger.getLogger("com.a");
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	if("set".equalsIgnoreCase(request.getParameter("action"))){
		this.addteam(request,response);
	}if("get".equalsIgnoreCase(request.getParameter("action"))){
		this.getTeams(request,response);
	}
	
	}

	private void addteam(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		TeamBean tb = new TeamBean();
		maptobean(request,tb);
	}

	

	private void getTeams(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		Collection<TeamBean> colbean = new ArrayList<TeamBean>();
		try{
		//	colbean = new TeamDao().getTeams();
			if(!colbean.isEmpty())
				{
					request.setAttribute("teams", colbean);
					ServletContext context = request.getSession().getServletContext();
					context.getRequestDispatcher("/welcomeEmployee.jsp").forward(request,response);
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
	private void maptobean(HttpServletRequest request, TeamBean tb) {
		// TODO Auto-generated method stub
		tb.setTeamname(request.getParameter("teamname"));
	}
}
