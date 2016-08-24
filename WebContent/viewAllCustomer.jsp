<%@page import = "java.io.*" %>
<%@page import = "java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>list of customers </title><link href="css/screen.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>
<body>
<div><%@ include file="header1.jsp" %></div>
<div>
 <form name="myForm1" method="post" action="controller.do">
      <input type="hidden" name="pagecommand" value="customer" /> 
        <input type="hidden" name="action" value="delete" /> 

<center> <h1>All Customer Details</h1> 
<table>
<%=request.getAttribute("wrong")!=null?request.getAttribute("wrong"):"" %>
    
<tr>
<th> customerName</th>
<th> ceo</th>
<th> mission</th>
<th> phoneNo</th>
<th> address</th>
<th> startDate</th>
<th> customerId</th>
<th> Update</th>
<th> delete</th>

</tr>
<%
    Collection<com.ts.beans.CustomerBean> cBean = (ArrayList)request.getAttribute("viewAllCustomer");
    Iterator i = cBean.iterator();
    while(i.hasNext())
    {
        com.ts.beans.CustomerBean item = (com.ts.beans.CustomerBean)i.next();
%>
<tr>
    <td>    <%=item.getCustomerName()%></td>
     <td>    <%=item.getCeo()%></td>
   <td>    <%=item.getMission()%></td>
    <td>    <%=item.getPhoneNo()%></td>
    <td>    <%=item.getAddress()%></td>
     <td>    <%=item.getStartDate()%></td>
        <td>    <%=item.getCustomerId()%></td>
         <td> <a href="updateCustomer.jsp?customerName=<%=item.getCustomerName()%>&&ceo=<%=item.getCeo()%>&&mission=<%=item.getMission()%>&&phoneNo=<%=item.getPhoneNo()%>&&address=<%=item.getAddress()%>&&customerId=<%=item.getCustomerId()%>&&startDate=<%=item.getStartDate()%>">
	 		update</a></td>
        <td>    <input type="radio" name="notify" value="<%=item.getCustomerName()%>" /> </td>
<%}%>
</tr>
</table>
<br><input type="submit" name="enter_button" value="delete" />        
</center> </form>
</div>
  <div>
           		<%@ include file="footer.jsp" %>
           </div>   
</body>
</html>