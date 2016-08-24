<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/screen.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>
<body>
<div id="layout">
      
      <div id="header">
        
        <h1 id="logo"><a href="welcomeAdmin.jsp" title="Admin Home"><span>P M S</span></a></h1>
        <hr class="noscreen" />   
         
              
        <div id="nav1">
        <ul id="menu">

    <li>
        <a href="#">Manage Employees</a>
		 <ul class="sub-menu">
            <li>
                <a href="addemployee.jsp">Add Employee</a>
            </li>
           
            <li>
                <a href="javascript:document.viewall.submit();">View All Employees</a>
                <form name="viewall" action="controller.do">
				<input type=hidden name="pagecommand" value="employee">
				<input type=hidden name="action" value="viewall"></form>
            </li>
             <li>
                <a href="javascript:document.pdf.submit();">Pdf   Reports  </a>
                <form name="pdf" action="controller.do">
				<input type=hidden name="pagecommand" value=pdf>
				<input type=hidden name="action" value="pdf"></form>
            </li>
        </ul>
    </li>

    <li><a href="#">Manage Companies</a>

        <ul class="sub-menu">
            <li>
                <a href="AddCompany.jsp">Add company</a>
            </li>
            <li>
                <a href="javascript:document.comp.submit();">View All Companies</a>
                <form name="comp" action="controller.do">
	  			<input type="hidden" name="pagecommand" value="company">
				<input type=hidden name="action" value="viewAllCompanies"></form>
            </li>
        </ul>
    </li>

    <li><a href="#">Manage Customers</a>
		 <ul class="sub-menu">
            <li>
                <a href="newCustomer.jsp">Add customer</a>
            </li>
            
            <li>
                <a href="javascript:document.customer.submit();">View All Customers</a>
                <form name="customer" method="post" action="controller.do">
					<input type="hidden" name="pagecommand" value="customer" /> 
 			    	<input type="hidden" name="action" value="viewAllCustomer" /> 
				</form>
            </li>
        </ul>
    </li>

    <li><a href="#">Manage Projects</a>

        <ul class="sub-menu">
            <li>
                <a href="newProject.jsp">Add project</a>
            </li>
            <li>
                <a href="javascript:document.prj.submit();">View All projects</a>
                <form name="prj" action="controller.do">
				<input type=hidden name="pagecommand" value="project">
				<input type=hidden name="action" value="viewAllProject"></form>
            </li>
        </ul>
    </li>
    <li>
         <a href="logout.jsp">logout</a>
    </li>
</ul>
        </div>
        <hr class="noscreen" />  
    
      </div>
</body>
</html>