<%@page import = "java.io.*" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/screen.css" type="text/css" rel="stylesheet" media="screen,projection" />
<title>users</title>
</head>


<body>
	<div><%@ include file="header.jsp" %></div>  
    
<center><h1>Users List</h1>
<table>	
<tr class="table-top">
<th>Username</th>
<th>Password</th>
<th> Role</th></tr>
<%
	Collection<com.ts.beans.EmployeeBean> eb = (ArrayList)request.getAttribute("employees");
	Iterator i = eb.iterator();
	while(i.hasNext())
	{
		com.ts.beans.EmployeeBean item = (com.ts.beans.EmployeeBean)i.next();
%>
<tr>
	
	<td>	<%=item.getUserName()%></td>
	<td>	<%=item.getPassword()%></td>

			<% if(item.getRoleId()==1){ %>
				<%="<td>Admin</td>" %>
			<%}else if(item.getRoleId()==2){ %>
				<%="<td>Manager</td>" %>
			<%}else if(item.getRoleId()==3){ %>
				<%="<td>Team Member</td>" %>
		<%	} %>
<%}%>
</tr>
</table>
</center>
 <div><%@ include file="footer.jsp" %></div>  
</body>
</html>
