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
<script src="article.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="style/article.css">
<title>Dictionary</title>
</head>
<body>
	<div id="header">
		Word Lookup <a href="login.jsp" class="button">Login</a>
	</div>
	<div id="content">
		<div id="article">
			<div id="articletitle">News Hub</div>
			<div id="articlecontent">article list</div>
		</div>
		<div id="tool">
			this is tool
			<div id="search">
				<input id="inputWord" type="text" />
				<input id="searchButton" type="button" value="Go">
			</div>
			<div id="searchcontent"></div>
			<div id="searchsimilar"></div>
		</div>
	</div>
	<div id="footer">Copyright @2018</div>
</body>
</html>
