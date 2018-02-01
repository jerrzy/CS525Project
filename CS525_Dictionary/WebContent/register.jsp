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
<script src="jquery.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="index.css">
<title>Dictionary</title>
</head>
<body>
	<div id="header">Word Lookup</div>
	<div id="content">
		<h6>Register to Word Lookup</h6>
		<form method="post" action="register.do">
			<h1>User Info</h1>
			First Name:<input type="text" name="firstname" id="firstname" />
			Last Name:<input type="text" name="lastname" id="lastname" /><br /> <br />
			User Name:<input type="text" name="username" id="username" />
			Password:<input type="password" name="password" id="password" /><br /> <br />
			Email:<input type="text" name="email" id="email" /><br /> <br />
			<h1>User Address</h1>
			Street:<input type="text" name="street" id="street" />
			City:<input type="text" name="city" id="city" /><br /> <br />
			State:<input type="text" name="state" id="state" />
			Zipcode:<input type="text" name="zipcode" id="zipcode" /><br /> <br />
			
			<input type="submit" id="register" value="register" class="" />
		</form>
	</div>
	<div id="footer">Copyright @2018</div>
</body>
</html>
