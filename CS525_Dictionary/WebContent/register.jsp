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
<link rel="stylesheet" type="text/css" href="style/index.css">
<link rel="stylesheet" type="text/css" href="style/loginregistor.css">
<title>Dictionary</title>
</head>
<body>
	<div id="header">Word Lookup</div>
	<div id="content">
		<div class='contentcenter'>
		
		<form method="post" action="register.do">
		<h4 class='titlecenter'>Register to Word Lookup</h4>
			<table>
				<tr>
				    <td class='titleright'><img src='icons/user.png' width='16px' height='16px'></td>
				    <td><h4>User Info</h4></td>
				    <td></td>
				    <td></td>
				</tr>
				<tr>
				    <td>First Name:</td>
				    <td><input type="text" name="firstname" id="firstname" /></td>
				    <td>Last Name:</td>
				    <td><input type="text" name="lastname" id="lastname" /></td>
				</tr>
				<tr>
				    <td>Username:</td>
				    <td><input type="text" name="username" id="username" /></td>
				    <td>Password:</td>
				    <td><input type="password" name="password" id="password" /></td>
				</tr>
				<tr>
				    <td>Email:</td>
				    <td><input type="text" name="email" id="email" /></td>
				    <td>Role:</td>
				    <td><input type="text" name="role" id="role" /></td>
				</tr>
				<tr>
				    <td class='titleright'><img src='icons/address.png' width='16px' height='16px'></td>
				    <td><h4>User Address</h4></td>
				    <td></td>
				    <td></td>
				</tr>
				<tr>
				    <td>Street:</td>
				    <td><input type="text" name="street" id="street" /></td>
				    <td>City:</td>
				    <td><input type="text" name="city" id="city" /></td>
				</tr>
				<tr>
				    <td>State:</td>
				    <td><input type="text" name="state" id="state" /></td>
				    <td>Zipcode:</td>
				    <td><input type="text" name="zipcode" id="zipcode" /></td>
				</tr>
				<tr>
				    <td></td>
				    <td><input type="submit" id="register" value="register" class="buttonsize" /></td>
				    <td></td>
				    <td></td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div id="footer">Copyright @2018</div>
</body>
</html>
