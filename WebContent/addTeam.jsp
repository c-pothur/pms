<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="controller.do" method="post">
<input type="hidden" name="pagecommand" value="teams">
<input type="hidden" name="action" value="minsert">
<table>
<tr><td>Team Name</td><td><input type="text" name="teamName"></td></tr>
<tr><td>Employee Name</td><td>
<select name="employeeId">
<option value="<%= eb.getEmployeeId%>"><%=eb.getEmployeeName %></option>
</select>
</td></tr>
<tr><td></td><td><input type="submit" value="add"></td></tr>
</table>
</form>

</body>
</html>