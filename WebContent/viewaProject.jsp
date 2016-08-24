<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>project details</title>
<link href="css/screen.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>
<body>
<div><%@ include file="header2.jsp" %></div>  
<center>
<h1>Project Details</h1>
<table>
<tr class="table-top"><td></td><td></td></tr>
<tr><th>Project ID</th><td><%=request.getParameter("projectId") %></td></tr>
<tr><th>Project Name</th><td><%=request.getParameter("projectName") %></td></tr>
<tr><th>Start Date</th><td><%=request.getParameter("startDate") %></td></tr>
<tr><th>End Date</th><td><%=request.getParameter("endDate") %></td></tr>
<tr><th>Cost</th><td><%=request.getParameter("cost") %></td></tr>

</table>
</center>
<div><%@ include file="footer.jsp" %></div> 
</body>
</html>