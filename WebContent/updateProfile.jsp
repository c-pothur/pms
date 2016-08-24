<jsp:useBean id="employeeBean" class="com.ts.beans.EmployeeBean" scope="session"/>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta content="text/html; charset=utf-8" http-equiv="Content-Type"><link href="css/screen.css" type="text/css" rel="stylesheet" media="screen,projection" />
<title>update profile</title>
</head>

<body>

	<div><%@ include file="header2.jsp" %></div>  
<center>
<h1>Update Profile</h1>
<form   action="Controller.do" method="post" id="register-form">

    <input type="hidden" name="pagecommand" value="employee">
    <input type="hidden" name="action" value="updateprofile">
               
	<table>
	<tr class="table-top"><th></th><td></td></tr>
<tr><th>Employee Name</th><td><input type="text" name="employeeName" value='<jsp:getProperty property="employeeName" name="employeeBean"/>'></td></tr>
<tr><th>Date of joining</th><td><input type="text" name="dateOfJoining" value='<jsp:getProperty property="dateOfJoining" name="employeeBean"/>'></td></tr>
<tr><th>Designation</th><td><input type="text" name="designation" value='<jsp:getProperty property="designation" name="employeeBean"/>'></td></tr>
<tr><th>Role</th><td>
<select name="roleId" value='<jsp:getProperty property="roleId" name="employeeBean"/>'>
<option value="1">Admin</option>
<option value="2">Manager</option>
<option value="3">Team Member</option>
</select>
</td></tr>
<tr><th>Email</th><td><input type="text" name="email" value='<jsp:getProperty property="email" name="employeeBean"/>'></td></tr>
<tr><th>Username</th><td><input type="text" name="username" value='<jsp:getProperty property="userName" name="employeeBean"/>'></td></tr>
<tr><th>Password</th><td><input type="text" name="password" value='<jsp:getProperty property="password" name="employeeBean"/>'></td></tr>
<tr><th></th><td><input type="submit" value="Update" ><input type="reset" ></td></tr>
</table>
	</form>  
</center>
	<div>
           		<%@ include file="footer.jsp" %>
           </div>  

</body>
</html>