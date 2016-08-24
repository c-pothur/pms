package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ts.beans.AssignBean;

public class AssignDao {
	static Logger logger = Logger.getLogger("myconsole");
	static Logger log = Logger.getLogger("com.a");
	
	public String assignPrj(AssignBean ab) {
		String result = "success";
		PreparedStatement pst = null;
		Connection con = DBConnection.getSimpleConnection();
		logger.info("got connection");
		try{
			String sql = ("insert into assign(projectId,managerId,teamId) values(?,?,?)");
			pst = con.prepareStatement(sql);
			pst.setInt(1, ab.getProjectId());
			pst.setInt(2, ab.getManagerId());
			pst.setInt(3, ab.getTeamId());
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
	
}
