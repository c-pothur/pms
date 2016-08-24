<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> welcome</title>
<link href="css/screen.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>
<body bgcolor="silver">
<div><%@ include file="header.jsp" %></div>   
        <div id="boxcenter">
        <div class="rbroundbox">
	         <div class="rbtop"><div></div></div>
		          <div class="rbcontent">
          			
          		<div class="content">
              <h2>Project Management System</h2>
              <p>Project management software has the capacity to help plan, organize, and manage resource pools and develop resource estimates. Depending on the sophistication of the software, it can manage estimation and planning, scheduling, cost control and budget management, resource allocation, collaboration software, communication, decision-making, quality management and documentation or administration systems. Today, numerous PC-based project management software packages exist, and they are finding their way into almost every type of business. In the early days, however, project management software ran on big mainframe computers and was used only in the large projects. These early systems were limited in their capabilities and, by today's standards, were difficult to use.</p>
            
              </div>
              <div id="panel-right"><div id="panel-right-inside"><br><br><span style="font-size:18px"><b>LOGIN HERE</b></span><br>
             <form action="Controller.do" method="post">
             <input type="hidden" name="pagecommand" value="login">
              <p><span style="font-size:16px">Username</span><br /><input type="text" name="username"></p>
              <p><span style="font-size:16px">password</span><br /><input type="password" name="password"></p>
			  <center><input type="submit" value="Login"> </form>
			  <a style="text-decoration: none;" href="javascript:document.viewall.submit();"><span style="font-size:11px">View Users</span></a>
	  			<form name="viewall" action="controller.do" method="post">
				<input type=hidden name="pagecommand" value="employee">
				<input type=hidden name="action" value="viewusers"></form>
			  </center><br><br>
			 
              </div></div>	
          			
        		  </div>
	         <div class="rbbot"><div></div></div>
        </div>
          <div id="main">
		  
		  </div>
        
        </div>
        </div>
           <div><%@ include file="footer.jsp" %></div>   

</body>
</html>