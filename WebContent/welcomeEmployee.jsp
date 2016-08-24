<jsp:useBean id="employeeBean" class="com.ts.beans.EmployeeBean" scope="session"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome <%=employeeBean.getEmployeeName() %></title>
<link href="css/screen.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>
<body>
<div><%@ include file="header2.jsp" %></div> 
<center>
<br><br><br><br><h1 style="font-size:58px;text-transform:capitalize;">Welcome <%=employeeBean.getEmployeeName() %></h1>
<span style="font-size:28px">find the options in menubar to manage Profile and projects details.</span>
</center>
 <div><%@ include file="footer.jsp" %></div>  
</body>
</html>