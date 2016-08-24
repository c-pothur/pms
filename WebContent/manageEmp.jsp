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
<a href="addemployee.jsp">add employee</a><br>
<a href="updateProfile.jsp">update profile</a><br>
<a style="text-decoration: none;" href="javascript:document.select.submit();">update employees</a><br><br>
	  			<form name="select" action="controller.do">
				<input type=hidden name="pagecommand" value="employee">
				<input type=hidden name="action" value="select">
		</form><br>

<a style="text-decoration: none;" href="javascript:document.viewall.submit();">view all employees</a><br><br>
	  			<form name="viewall" action="controller.do">
				<input type=hidden name="pagecommand" value="employee">
				<input type=hidden name="action" value="viewall"></form><br>

<a style="text-decoration: none;" href="javascript:document.pdf.submit();">reports</a><br><br>
	  			<form name="pdf" action="controller.do">
				<input type=hidden name="pagecommand" value=pdf>
				<input type=hidden name="action" value="pdf"></form><br>


				<div><%@ include file="footer.jsp" %></div> 
</body>
</html>