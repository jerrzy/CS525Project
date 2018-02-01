<%-- 
    Document   : index
    Created on : Dec 19, 2017, 2:47:06 PM
    Author     : feifei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.dictionary.domain.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String displayValue = "Sign in";
	User currentUser = (User) session.getAttribute("currentUser");
%>
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
	<div id="header">
		<div id="headerTitle">News hub</div>
			<div id="header_right">
				<c:if test="${currentUser==null}">
					<a href="register.jsp"><img src="icons/add-user.png"
						width="16px" height="16px">Sign up</a>
					<a href="login.jsp"><img src="icons/add-user.png" width="16px"
						height="16px"><%=displayValue%></a>
				</c:if>
				<c:if test="${currentUser!=null}">
					<a href="logout.jsp"><img src="icons/add-user.png"
						width="16px" height="16px">Logout</a>
				</c:if>
				<a href="users.jsp"><img src="icons/add-user.png" width="16px"
					height="16px">View users</a> 
				<a href="index.jsp"><img
					src="icons/add-user.png" width="16px" height="16px">Home</a> 
				<a href="addarticle.jsp"><img src="icons/add-user.png" width="16px"
					height="16px">+</a>
			</div>
		</div>
	<div id="content">
		<div class='contentcenter'>
			<h4>Login to Word Lookup</h4>
			<form method="post" action="login.do">
				<table>
					<tr>
					    <td>Name:</td>
					    <td><input type="text" name="username" id="username" /></td>
					</tr>
					<tr>
					    <td>Password:</td>
					    <td><input type="password" name="userpass" id="userpass" /></td>
					</tr>
					<tr>
					    <td></td>
					    <td><input type="submit" id="login" value="login" class="buttonsize" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div id="footer">Copyright @2018</div>
</body>
</html>
