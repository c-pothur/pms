package com.ts.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

public class DBConnection {
	static Logger logger = Logger.getLogger("com.a");
	public static Connection getSimpleConnection()
	{
	
		String dbUrl = "jdbc:mysql://10.1.0.5:3306/h15j02p4db";
        Connection con = null;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection (dbUrl, "h15j02p4", "pms123$");
        }catch(Exception ex){
        	ex.printStackTrace();
        }
        return con;
	}
}
