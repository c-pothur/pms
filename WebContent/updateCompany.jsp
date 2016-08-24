<jsp:useBean id="userbean" class="com.ts.beans.CompanyBean" scope="session"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update company</title>
</head>
<body>
<div><%@ include file="header1.jsp" %></div>  
      <center>
      <h1>Update Company</h1>
    <form action="Controller.do" name="updateform" method="post">
    <input type="hidden" name="pagecommand" value="company"/>
    <input type="hidden" name="action" value="updateCompany"/>
    <table>
    <tr><th>Name</th><td><input type="text" name="companyName" value='<%=request.getParameter("companyName") %>'>
    </td></tr>
	 <tr><th>
	    CEO </th><td><input type="text"  name="ceoName" value='<%=request.getParameter("ceoName") %>'>
	 </td></tr>
	 <tr><th>
	    Mission </th><td><input type="text"  name="mission" value='<%=request.getParameter("mission") %>'>
	 </td></tr>
	 <tr><th>
	    Phone</th><td><input type="text"  name="phoneNo"  value='<%=request.getParameter("phoneNo") %>'>
	 </td></tr>
	 <tr><th>
                 Address</th><td><input type="text"  name="address"  value='<%=request.getParameter("address") %>'>
	 </td></tr>
	 
	 <tr><th>
	 
	 			companyId</th><td><input type="text" name="companyId" value=<%=request.getParameter("companyId")%> readonly="readonly">
    </td></tr>
	 <tr><td>
	    </td><td><input type="submit" value="Update"/>
	 </td></tr>
	</table>
</form>
   </center>
  

</body>
</html>