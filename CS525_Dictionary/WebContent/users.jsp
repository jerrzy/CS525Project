<%-- 
    Document   : index
    Created on : Dec 19, 2017, 2:47:06 PM
    Author     : feifei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/user.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="style/index.css">
<link rel="stylesheet" type="text/css" href="style/users.css">
<title>Dictionary</title>
</head>
<body>
	<div id="header">
		<div id="headerTitle">News hub</div>
		<div id="header_right">
			<a href="register.jsp"><img src="icons/add-user.png" width="16px" height="16px">Sign up</a>
		 	<a href="login.jsp"><img src="icons/add-user.png" width="16px" height="16px">Sign in</a>
		 	<a href="users.jsp"><img src="icons/add-user.png" width="16px" height="16px">View users</a>
		 	<a href="index.jsp"><img src="icons/add-user.png" width="16px" height="16px">Home</a>
		</div>
	</div>
	<div id="content">
		<p id="inputParams" style="display: none" userId="${param.userId}"></p>
		<div id="usercontent">
			<div id="userUserName">Username</div>
			<div id="userFirstName">First Name</div>
			<div id="userLastName">Last Name</div>
		</div>
	</div>
	<div id="footer">Copyright @2018</div>
</body>
</html>
