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
        
        <h1 id="logo"><a href="welcomeEmployee.jsp" title="Employee Home"><span>P M S</span></a></h1>
        <hr class="noscreen" />   
         
              
        <div id="nav1">
        <ul id="menu">

    <li>
        <a href="updateProfile.jsp">Manage Profile</a>
		 
    </li>

	<li>
	<a style="text-decoration: none;" href="javascript:document.myForm1.submit();"> Manage Projects</a>
			  	<form name="myForm1" action="controller.do">
				<input type=hidden name="pagecommand" value="project">
				<input type=hidden name="action" value="viewPrjNames"></form>
	
	</li>
   
    <li>
        <a href="logout.jsp">logout</a>
        
    </li>
    <li></li>
</ul>
        </div>
        <hr class="noscreen" />  
    
      </div>
</body>
</html>