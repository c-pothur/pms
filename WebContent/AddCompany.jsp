<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add company</title><link href="css/screen.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>
<body >
<div><%@ include file="header1.jsp" %></div>  
<center>
<h1>Add Company Details</h1>
<div class="centertable">
<form action="Controller.do" method="post" name="add_Company">
<input type="hidden" name="pagecommand" value="company"> 
<input type="hidden" name="action" value="insert">
<table>
<tr class="table-top"><th></th><td></td></tr>
<tr ><th>Name</th><td><input type="text" name="companyName"></td></tr>
<tr><th>CEO</th><td><input type="text" name="ceoName"></td></tr>
<tr><th>Mission</th><td><textarea rows="5" cols="15" name="mission"></textarea></td></tr>
			
				<tr>
						<th>Phone</th><td><input type="text" name="phoneNo" ></td>
					</tr>
					<tr>
						<th>Address</th><td><input type="text" name="address" ></td>
						</tr>
					<tr>
					<td></td><td><input type="submit" value="Add"><input type="reset" value="Reset"></td>
						</tr>
							
	</table>
</form>
</div></center>
<div>
           		<%@ include file="footer.jsp" %>
           </div>  
</body>
</html>