/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ts.dao;
import java.sql.*;
import com.ts.beans.CompanyBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;



/**
 *
 * @author sss
 */
public class CompanyDao {

	
    public String createCompany(CompanyBean beans){
        
        PreparedStatement pst=null;
        String result="success";
        Connection con =DBConnection.getSimpleConnection();
        
        try {
            String sql=("insert into company(companyName ,ceoName,mission,phoneNo,address)values(?,?,?,?,?)");
            pst=con.prepareStatement(sql);
            pst.setString(1, beans.getCompanyName());
            pst.setString(2, beans.getCeoName());
            pst.setString(3, beans.getMission());
            pst.setString(4, beans.getPhoneNo());
            pst.setString(5, beans.getAddress());
            
            int rows=pst.executeUpdate();
            if(rows!=1)
                result = "failure";
        } catch (Exception e) {
        	
            result = "failure";
        }
        
        
        return result;
    }
    public Collection<CompanyBean> selectCompany(){
        
        Collection<CompanyBean> coll = new ArrayList<CompanyBean>();
        //getting the Database connection
       
        Connection con =DBConnection.getSimpleConnection();
       
        Statement st=null;
        ResultSet rs=null;
        try{
            con.setAutoCommit(false);
            st=con.createStatement();
          rs = st.executeQuery("select * from company");
          
          while(rs.next()){
              CompanyBean beans = new CompanyBean();
              beans.setCompanyName(rs.getString(1));
              beans.setCeoName(rs.getString(2));
              beans.setMission(rs.getString(3));
              beans.setPhoneNo(rs.getString(4));
              beans.setAddress(rs.getString(5));
              beans.setCompanyId(rs.getInt(6));
              System.out.println(beans);
              coll.add(beans);
              
             
          }
        }catch(Exception e){
        	
        }
        return coll;
        
     }
     
    public String updateCompany(CompanyBean beans) {
		// TODO Auto-generated method stub
		
		PreparedStatement pst = null;
		String result = null;
		// getting database connection 
				Connection con = DBConnection.getSimpleConnection();
				
				try{
					con.setAutoCommit(false);

					StringBuffer updateSql = new StringBuffer();
					updateSql.append("UPDATE company SET ");
					updateSql.append("companyName='"+beans.getCompanyName()+"' , ceoName = '"+beans.getCeoName() +"', mission= '"+beans.getMission()+"', phoneNo="+beans.getPhoneNo()+",address='"+beans.getAddress()+"' where companyId='"+beans.getCompanyId()+"'");
					
					pst = con.prepareStatement(updateSql.toString());
					int rows = pst.executeUpdate();
					
					if(rows != 1 )
						result = "failure";
					else {
					result = "success";
					}
				}
				catch(SQLException e)
				{
					
					result = "failure";
					
				}
				


				return result;
				
	}
    
 
    public String deleteCompany(int   companyId) {

		
  		// TODO Auto-generated method stub
  				String result= "success";
  				Statement st = null;
  				// getting database connection 
  				Connection con = DBConnection.getSimpleConnection();

  				String sql="delete from company where companyId='"+companyId+"'";
  				
  				System.out.println(companyId);

  				try {
  					st = con.createStatement();
  					st.executeUpdate(sql);
  					result="success";
  				} catch (SQLException e) {
  					// TODO Auto-generated catch block
  					
  					e.printStackTrace();
  					result="failure";
  				}
  				

  				return result;
  			}
  			
	
	
}