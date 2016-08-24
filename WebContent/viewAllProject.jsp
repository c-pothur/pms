<%@page import = "java.io.*" %>
<%@page import = "java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>projects list</title><link href="css/screen.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>
<body>
<div><%@ include file="header1.jsp" %></div> 
 <form name="myForm1" method="post" action="controller.do">
      <input type="hidden" name="pagecommand" value="project" /> 
        <input type="hidden" name="action" value="deleteProject" /> 

<center> <h1> All Project Details</h1> 
<table border=1>
<%=request.getAttribute("wrong")!=null?request.getAttribute("wrong"):"" %>
	
<tr class="table-top">
<th> projectName</th>
<th> startDate</th>
<th> endDate</th>
<th> projectId</th>
<th> cost</th>
<th>employeeId</th>
<th>update</th>
<th>delete</th>
</tr>
<%
	Collection<com.ts.beans.ProjectBean> pBean = (ArrayList)request.getAttribute("viewAllProject");
	Iterator i = pBean.iterator();
	while(i.hasNext())
	{
		com.ts.beans.ProjectBean item = (com.ts.beans.ProjectBean)i.next();
%>
<tr>
	<td>	<%=item.getProjectName()%></td>
	<td>	<%=item.getStartDate()%></td>
	<td>	<%=item.getEndDate()%></td>
	<td>	<%=item.getProjectId()%></td>
	<td>	<%=item.getCost()%></td>
		<td>	<%=item.getEmployeeId()%></td>
		 <td> <a href="updateProject.jsp?projectName=<%=item.getProjectName()%>&&startDate=<%=item.getStartDate()%>&&endDate=<%=item.getEndDate()%>&&projectId=<%=item.getProjectId()%>&&cost=<%=item.getCost()%>&&employeeId=<%=item.getEmployeeId()%>">
	 		update</a></td>
		<td>	<input type="radio" name="notify" value="<%=item.getProjectName()%>" /> </td></tr>
<%}
%>

</table>
<br><input type="submit" name="enter_button" value="delete" />		
</center> </form>
<div><%@ include file="footer.jsp" %></div>  
</body>
</html>