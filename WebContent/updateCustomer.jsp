<jsp:useBean id="customerBean" class="com.ts.beans.CustomerBean" scope="session"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update customer</title><link href="css/screen.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>
<body bgcolor="skyblue">
<div><%@ include file="header1.jsp" %></div>  

<center>
 <h1>Update Details</h1>
    <form action="controller.do" name=updateform method="post">
    <input type="hidden" name="pagecommand" value="customer"/>
    <input type="hidden" name="action" value="updateCustomer"/>
    <table>
	 <tr>
	   <th>
		CustomerName</th><td> <input type="text" name="customerName" value="<%=request.getParameter("customerName") %>" />
   	   </td>
	 </tr>
	 
	
	 <tr><th>
	    ceo</th><td><input type="text"  name="ceo"  value="<%=request.getParameter("ceo") %>" />
	  </td></tr>
	  <tr><th>
	    mission </th><td><input type="text"  name="mission"  value="<%=request.getParameter("mission") %>" />
	 </td></tr>
	<tr><th>
	    phoneNo</th><td><input type="text"  name="phoneNo"  value="<%=request.getParameter("phoneNo") %>" />
	 </td></tr>
	    <tr><th>
	    address</th><td><input type="text"  name="address"  value="<%=request.getParameter("address") %>" />
	  </td></tr>
	  <tr><th>
	    customerId </th><td><input type="text"  name="customerId" value="<%=request.getParameter("customerId") %>" />
	 </td></tr>
	 <tr><th>
	    StartDate</th><td><input type="text"  name="startDate"  value="<%=request.getParameter("startDate") %>" />
	 </td></tr>
	 
	
	 <tr><td>
	    </td><td><input type="submit" value="updateCustomer"/>
	 </td></tr>
	</table>
</form>
   </center>
     <div>
           		<%@ include file="footer.jsp" %>
           </div>   
</body>
</html>