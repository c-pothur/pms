<%@page import = "java.io.*" %>
<%@page import = "java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>select project</title>
<link href="css/screen.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>
<body>
<div><%@ include file="header2.jsp" %></div>
<center>
<h1>Update/View/Assign Projects</h1>
<table>
<tr class="table-top"><th colspan="4">Project Names</th></tr>
<%
	Collection<com.ts.beans.ProjectBean> pb = (ArrayList)request.getAttribute("viewPrjNames");
	Iterator i = pb.iterator();
	while(i.hasNext())
	{
		com.ts.beans.ProjectBean item = (com.ts.beans.ProjectBean)i.next();
%>

<tr><td> <b>	<%=item.getProjectName()%></b></td>
 <th> <a href="updateaproject.jsp?projectName=<%=item.getProjectName()%>
	 								&&startDate=<%=item.getStartDate()%>
	 								&&endDate=<%=item.getEndDate()%>
	 								&&projectId=<%=item.getProjectId()%>
	 								&&cost=<%=item.getCost()%>
	 								&&employeeId=<%=item.getEmployeeId()%>">
	 	update</a></th>
	 		<th ><a href="viewaProject.jsp?projectName=<%=item.getProjectName()%>
	 								&&startDate=<%=item.getStartDate()%>
	 								&&endDate=<%=item.getEndDate()%>
	 								&&projectId=<%=item.getProjectId()%>
	 								&&cost=<%=item.getCost()%>
	 								&&employeeId=<%=item.getEmployeeId()%>">
	 		
	 		view</a></th>
	 		<th> <a href="assignProject.jsp?projectName=<%=item.getProjectName()%>
	 								&&startDate=<%=item.getStartDate()%>
	 								&&endDate=<%=item.getEndDate()%>
	 								&&projectId=<%=item.getProjectId()%>
	 								&&cost=<%=item.getCost()%>
	 								&&employeeId=<%=item.getEmployeeId()%>">
	 		Assign</a></th>
	 		</tr>

<%}%>
</table>
Click on <b>update </b> to update project <b>view</b> to view the project details and on <b>Assign</b> to assign Project
</center>
 <div><%@ include file="footer.jsp" %></div>  
</body>
</html>