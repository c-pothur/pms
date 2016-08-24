<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add project</title><link href="css/screen.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>
<body bgcolor="wheat">
<div><%@ include file="header1.jsp" %></div> 
<center>
<h1>Add Project Details</h1>	
  	   <form name="loginform" action="Controller.do" method="post">
       <input type="hidden" name="pagecommand" value="project"/>
	   <input type="hidden" name="action" value="insertProject"/>
	   <table>
	   <tr class="table-top"><td></td><td></td></tr>
<tr><th>Project Name</th>
<td> <input type="text" name="projectName"></td></tr>
<tr><th>Start Date </th>
<td><input type="text" name="startDate" placeholder="DD/MM/YYYY"></td></tr>
<tr><th>End Date</th>
<td><input type="text" name="endDate" placeholder="DD/MM/YYYY"></td></tr>
<tr><th>Project ID</th>
<td><input type="text" name="projectId"></td></tr>
<tr><th>Cost</th>
<td><input type="text" name="cost"></td></tr>
<tr><th>Employee ID</th>
<td><input type="text" name="employeeId"></td></tr> 
<tr><th></th>
<td><input type="submit" value="AddProject"><input type="reset" value="clear"></td></tr>
</table>
</form>
   	 
  	  </center>
 <div><%@ include file="footer.jsp" %></div>   
</body>
</html>