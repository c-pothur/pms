/**
 * 
 */
package com.ts.command;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.ts.beans.EmployeeBean;
import com.ts.command.Command;

/**
 * @author SUMITH
 *
 */
public class PdfCommand implements Command {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	
		try {
            // Get the text that will be added to the PDF
            String text = request.getParameter("text");
            if (text == null || text.trim().length() == 0) {
                 text = "";
            }
            // step 1
            Document document = new Document();
            // step 2
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);
            // step 3
            document.open();
            // step 4
            EmployeeBean eBean = new EmployeeBean();
            String dburl="jdbc:mysql://10.1.0.5:3306/h15j02p4db";
            Statement st= null;
    		Connection con= null;
    		Class.forName("com.mysql.jdbc.Driver");
    		con =DriverManager.getConnection(dburl,"h15j02p4","pms123$");
    		ResultSet rs=null;
    		String sql = ("select * from employee");
    		st = con.createStatement();
			rs = st.executeQuery(sql);
			document.add(new Paragraph("EmployeeName  |  dateOfJoining  |  designation  |  username  | roleId  |  employeeId  |  email"));	
    		while(rs.next())
    		{
    			
    			
  			
    			String output = rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | " +rs.getString(4)+" | "+rs.getString(5)+" | "+rs.getInt(6)+" | "+rs.getInt(7)+" | "+rs.getString(8);
            document.add(new Paragraph(output)); 
            
            
          
    		}
    		  document.add(new Paragraph(text));
            // step 5
            document.close();
 
            // setting some response headers
            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control",
                "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            // setting the content type
            response.setContentType("application/pdf");
            // the content length
            response.setContentLength(baos.size());
            // write ByteArrayOutputStream to the ServletOutputStream
            OutputStream os = response.getOutputStream();
            baos.writeTo(os);
            os.flush();
            os.close();
        }
        catch(Exception e) {
            try {
				throw new IOException(e.getMessage());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }

	}
	
			}
       


	

