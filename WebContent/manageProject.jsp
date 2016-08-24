<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title><link href="css/screen.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>
<body>
<div><%@ include file="header.jsp" %></div>  
<a href="newProject.jsp">add project</a><br><br>

<a href="updateProject.jsp">update project</a><br><br>
<a href="addModules.jsp">add Modules</a><br><br>
<a style="text-decoration: none;" href="javascript:document.myForm1.submit();">viewAllProject</a>
			  	<form name="myForm1" action="controller.do">
				<input type=hidden name="pagecommand" value="project">
				<input type=hidden name="action" value="viewAllProject">
				 <div><%@ include file="footer.jsp" %></div>   
		</body>
</html>