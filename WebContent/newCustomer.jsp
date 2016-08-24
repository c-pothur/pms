<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add customer</title><link href="css/screen.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>
<body bgcolor="wheat">
<div><%@ include file="header1.jsp" %></div> <center> 
<h1>New Customer Details</h1>
<table>
<form name="loginform" action="controller.do" method="post"> 
       <input type="hidden" name="pagecommand" value="customer"/> 
 	   <input type="hidden" name="action" value="insert"/> 
<tr class="table-top"><td></td><td></td></tr>
<tr><th>customerName:</th><td><input type="text" name="customerName"></td></tr>
		<tr><th>ceo:</th><td><input type="text" name="ceo"></td></tr>
		<tr><th>mission:</th><td><input type="text" name="mission"></td></tr>
		<tr><th>phoneNo:</th><td><input type="text" name="phoneNo"></td></tr>
		<tr><th>address:</th><td><input type="text" name="address"></td></tr>
			
				<tr><th>start Date:</th><td><input type="text" name="startDate" placeholder="DD/MM/YYYY"></td></tr>
		
<tr>	<td></td><td><input type="submit" value="Register"/>   <input type="reset" value="clear"/> </td></tr>
	
	</form>	
	</table></center>
	  <div>
           		<%@ include file="footer.jsp" %>
           </div>   
</body>
</html>