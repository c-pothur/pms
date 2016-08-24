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

<a href="AddCompany.jsp">Add Company</a>
<a href="updateCompany.jsp">Update Company</a>


<a style="text-decoration: none;" href="javascript:document.myForm2.submit();">View all Company</a>
	  			<form name="myForm2" action="controller.do">
	  		<input type="hidden" name="pagecommand" value="company">
				<input type=hidden name="action" value="viewAllCompanies">
		</form>

		<div>
           		<%@ include file="footer.jsp" %>
           </div>  
</body>
</html>