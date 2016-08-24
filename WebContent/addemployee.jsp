<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add employee</title><link href="css/screen.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>
<body>
<div><%@ include file="header1.jsp" %></div> 
<center>
<h1>Add Employee Details</h1>
<form action="addEmployee.do" method="post">
<input type="hidden" name="pagecommand" value="employee">
<input type="hidden" name="action" value="signup">
<table>
<tr class="table-top"></tr>
<tr><th>Employee Name</th><td><input type="text" name="employeeName" ></td></tr>
<tr><th>Date of joining</th><td><input type="text" name="dateOfJoining" placeholder="DD/MM/YYYY" ></td></tr>
<tr><th>Designation</th><td><input type="text" name="designation" ></td></tr>
<tr><th>Role</th><td>
<select name="roleId">
<option value="1">Admin</option>
<option value="2">Manager</option>
<option value="3">Team Member</option>
</select>
</td></tr>
<tr><th>Email</th><td><input type="text" name="email" ></td></tr>
<tr><th>Username</th><td><input type="text" name="username" ></td></tr>
<tr><th>Password</th><td><input type="password" name="password" ></td></tr>
<tr><th></th><td><input type="submit" value="Add" ><input type="reset" ></td></tr>
</table>
</form></center>
 <div><%@ include file="footer.jsp" %></div>   

</body>
</html>