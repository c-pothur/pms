<jsp:useBean id="projectBean" class="com.ts.beans.ProjectBean" scope="session"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update project</title>
<link href="css/screen.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>
<body>
<div><%@ include file="header2.jsp" %></div>
 <center>
 <h1>Update Project Details</h1>
    <form action="Controller.do" name="updateform" method="post">
    <input type="hidden" name="pagecommand" value="project"/>
    <input type="hidden" name="action" value="updateaProject"/>
    <table>
	 <tr>
	   <th>
		ProjectName</th><td> <input type="text" name="projectName" value="<%=request.getParameter("projectName") %>" />
   	   </td>
	 </tr>
	  <tr><th>
	    StartDate</th><td><input type="text"  name="startDate"  value="<%=request.getParameter("startDate") %>"/>
	  </td></tr>
	  <tr><th>
	    EndDate </th><td><input type="text"  name="endDate"  value="<%=request.getParameter("endDate") %>"/>
	 </td></tr>
	
	  <tr><th>
	    ProjectID </th><td><%=request.getParameter("projectId")%>
	 </td></tr>
	
	  <tr><th>
	  Cost </th><td><input type="text"  name="cost"  value="<%=request.getParameter("cost") %>"/>
	 </td></tr>
	  <tr><th>
	    EmployeeID </th><td><input type="text"  name="employeeId" value="<%=request.getParameter("employeeId") %>" />
	 </td></tr>
	 
	 <tr><td>
	    </td><td><input type="submit" value="updateProject"/>
	 </td></tr>
	</table>
</form>
  </center>
    <div><%@ include file="footer.jsp" %></div>   
</body>
</html>