<%@page import = "java.io.*" %>
<%@page import = "java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>assign project</title>
</head>
<body>
<div><%@ include file="header2.jsp" %></div> 
<center> 
<h1>Assign Project</h1>
<form action="controller.do" method="post" name="assignprj">
<input type=hidden name="pagecommand" value="assign">
<input type=hidden name="action" value="assign">
<table>
<input type="hidden" name="projectId" value="<%= request.getParameter("projectId")%>">
<input type="hidden" name="managerId" value="<%= request.getParameter("employeeId")%>">
<tr class="table-top"><td></td><td></td></tr>
<tr><th>Project Name</th><td><%=request.getParameter("projectName") %></td></tr>
<tr><th>select team to assign project</th><td>
<select name="teamId">
<option value="1">Team 1</option>
<option value="2">Team 2</option>
<option value="3">Team 3</option>
</select>
</td></tr>
<tr><td></td><td><input type="submit" value="assign"></td></tr>
</table>
</form>
</center>
 <div><%@ include file="footer.jsp" %></div>   

</body>
</html>