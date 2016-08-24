<%@page import = "java.io.*" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<title>select employee</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/screen.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>


<body>
	<div><%@ include file="header.jsp" %></div>
    <form action="controller.do" method="post">
      <input type="hidden" name="pagecommand" value="employee" /> 
        <input type="hidden" name="action" value="update" /> 
        <select name="employeeId">
	<%
	Collection<com.ts.beans.EmployeeBean> eb = (ArrayList)request.getAttribute("employees");
	Iterator i = eb.iterator();
	while(i.hasNext())
	{
		com.ts.beans.EmployeeBean item = (com.ts.beans.EmployeeBean)i.next();
	%>
	
	<option value="<%=item.getEmployeeId()%>"> <%=item.getEmployeeId()+","+item.getEmployeeName()%> </option>
<%}%>
</select>
<input type="submit" value="Search">
</form>
<div><%@ include file="footer.jsp" %></div> 
</body>
</html>
