<%@page import = "java.io.*" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/screen.css" type="text/css" rel="stylesheet" media="screen,projection" />
<title>list of employee </title>
</head>


<body>
	<div><%@ include file="header1.jsp" %></div>  
    <form action="controller.do" method="post">
      <input type="hidden" name="pagecommand" value="employee" /> 
        <input type="hidden" name="action" value="delete" /> 
<center><h1>All Employee Details</h1></center>
<table>	
<tr class="table-top">
<th>Employee ID</th>
<th>Employee Name</th>
<th>Designation</th>
<th> Role</th>
<th>Date Of Joining</th>
<th>Username</th>
<th>Password</th>
<th>Email</th>
<th>Update</th>
<th>Delete</th>
</tr>
<%
	Collection<com.ts.beans.EmployeeBean> eb = (ArrayList)request.getAttribute("employees");
	Iterator i = eb.iterator();
	while(i.hasNext())
	{
		com.ts.beans.EmployeeBean item = (com.ts.beans.EmployeeBean)i.next();
%>
<tr>
	<td>    <%=item.getEmployeeId() %></td>
	<td>	<%=item.getEmployeeName()%></td>
	<td>	<%=item.getDesignation()%></td>
			<% if(item.getRoleId()==1){ %>
				<%="<td>Admin</td>" %>
			<%}else if(item.getRoleId()==2){ %>
				<%="<td>Manager</td>" %>
			<%}else if(item.getRoleId()==3){ %>
				<%="<td>Team Member</td>" %>
		<%	} %>
	<td>	<%=item.getDateOfJoining()%></td>
	<td>	<%=item.getUserName()%></td>
	<td>	<%=item.getPassword()%></td>
	<td>	<%=item.getEmail()%></td>
	 <td> <a href="updateEmployee.jsp?employeeName=<%=item.getEmployeeName()%>
	 								&&dateOfJoining=<%=item.getDateOfJoining()%>
	 								&&designation=<%=item.getDesignation()%>
	 								&&roleId=<%=item.getRoleId()%>
	 								&&email=<%=item.getEmail()%>
	 								&&username=<%=item.getUserName()%>
	 								&&password=<%=item.getPassword()%>">
	 		update</a></td>
	<td>	<input type="radio" name="notify" value="<%=item.getEmail()%>"></td>
<%}%>
</tr>
</table>
<center><input type="submit" value="Delete"></center>	
</form>
 <div><%@ include file="footer.jsp" %></div>  
</body>
</html>
