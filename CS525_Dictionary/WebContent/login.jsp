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
<script src="login.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="dictionary.css">
<title>Dictionary</title>
</head>
<body>
	<div id="header">Word Lookup</div>
	<div id="content">
		<h6>Login to Word Lookup</h6>
		<div>
			Name:<input type="text" name="username" id="username" /><br /> <br />
			Password:<input type="password" name="userpass" id="userpass" /><br />
			<br /> <input type="submit" id="login" value="login" class="" />
		</div>
	</div>
	<div id="footer">Copyright @2018</div>
</body>
</html>
