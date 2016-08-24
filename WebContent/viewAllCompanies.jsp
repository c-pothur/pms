<%@page  import="java.io.*" %>
<%@page  import=" java.util.*" %>
<%@page import="com.mysql.jdbc.IterateBlock" %>
<%@page import="java.util.Collection" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Iterator" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>list of companies</title><link href="css/screen.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>
<body>
<div><%@ include file="header1.jsp" %></div>  

 <center>
        <form name="myFormA" method="post" action="Controller.do">
      <input type="hidden" name="pagecommand" value="company" /> 
        <input type="hidden" name="action" value="delete" /> 
            <center> <h1>All Companies Details</h1> 
<table>
<%=request.getAttribute("wrong")!=null?request.getAttribute("wrong"):"" %>

<tr class="table-top">
<th> Name</th>
<th> CEO</th>
<th> Mission</th>
<th> Phone</th>
<th> Address</th>
<th>companyId</th>
<th>Delete</th>
<th>Update</th>
</tr>
 
 <%
	Collection<com.ts.beans.CompanyBean> customerbean = (ArrayList)request.getAttribute("Company");
	Iterator i = customerbean.iterator();
	while(i.hasNext())
	{
		com.ts.beans.CompanyBean item = (com.ts.beans.CompanyBean)i.next();
%> 

<tr>
	<td>	<%=item.getCompanyName()%></td>
	<td>	<%=item.getCeoName()%></td>
	<td>	<%=item.getMission()%></td>
	<td>	<%=item.getPhoneNo()%></td>
     	<td><%=item.getAddress()%>  </td>
     	<td>	<%=item.getCompanyId()%></td>
     	<td>	<input type="radio" name="notify" value="<%=item.getCompanyId()%>" /> </td>
     	<td> <a href="updateCompany.jsp?&&companyId=<%=item.getCompanyId() %>
     								&&companyName=<%=item.getCompanyName()%>
	 								&&ceoName=<%=item.getCeoName()%>
	 								&&mission=<%=item.getMission()%>
	 								&&phoneNo=<%=item.getPhoneNo()%>
	 								&&address=<%=item.getAddress()%>">
	 		update</a></td>
	
<%}
%>
</tr>
   </table>
  </center><br><input type="submit" name="delete" value="delete" />  
   </form> 
    <div>
           		<%@ include file="footer.jsp" %>
           </div>  
</body>
</html>