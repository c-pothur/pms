<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title><link href="css/screen.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>
<body bgcolor="pink">
<div><%@ include file="header.jsp" %></div>  

<a href="newCustomer.jsp">new Customer</a><br>



<a style="text-decoration: none;" href="javascript:document.myForm1.submit();">view All Customer</a>
	  			
<form name="myForm1" method="post" action="controller.do">
      <input type="hidden" name="pagecommand" value="customer" /> 
        <input type="hidden" name="action" value="viewAllCustomer" /> 
		</form>
<div>
           		<%@ include file="footer.jsp" %>
           </div> 
</body>
</html>