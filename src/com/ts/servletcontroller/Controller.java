package com.ts.servletcontroller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ts.command.AssignCommand;
import com.ts.command.Command;
import com.ts.command.CompanyCommand;
import com.ts.command.CustomerCommand;
import com.ts.command.EmployeeCommand;
import com.ts.command.LoginCommand;
import com.ts.command.PdfCommand;
import com.ts.command.ProjectCommand;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

    private Map cmap = new HashMap();
    static Logger logger = Logger.getLogger("myconsole");
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		logger.info("storing values into map associated with objects");
		cmap.put("employee", new EmployeeCommand());
		cmap.put("customer", new CustomerCommand());
		cmap.put("project", new ProjectCommand());
		cmap.put("login", new LoginCommand());
		cmap.put("pdf", new PdfCommand());
		cmap.put("assign", new AssignCommand());
		cmap.put("company", new CompanyCommand());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processCommand(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processCommand(request,response);
	}

	private void processCommand(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String pageCommand =request.getParameter("pagecommand");
		logger.info("read the value from request object"+pageCommand);
		
		Command cmd = (Command) cmap.get(pageCommand);
		cmd.execute(request, response);
	}

}
