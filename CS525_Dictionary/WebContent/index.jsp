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
<script src="js/index.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="style/index.css">
<link rel="stylesheet" type="text/css" href="style/indexcontent.css">
<title>News Press</title>
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
		<p id="inputParams" style="display: none" userId="${param.userId}"
			articleId="${param.articleId}"></p>
		<div id="article">
			<div id="articletitle">Top News</div>
			<div id="articlecontent">article list</div>
		</div>
		<c:if test="${currentUser!=null}">
			<div id="tool">
				<div id="search">
					<input id="inputWord" type="text" /> <input id="searchButton"
						type="button" value="Go"><br> <input id="searchWord"
						checked type="radio" value="word" name="searchOption">Word</input>
					<input id="searchArticle" type="radio" value="article"
						name="searchOption">Article</input> <input
						id="searchArticleByUser" type="radio" value="user"
						name="searchOption">Author</input>
				</div>
				<div id="searchcontent"></div>
				<div id="searchsimilar"></div>
			</div>
		</c:if>
	</div>
	<div id="footer">Copyright @2018</div>
</body>
</html>
