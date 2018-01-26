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
        <script src="dictionary.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="dictionary.css">
        <title>Dictionary</title>
    </head>
    <body>
        <div id="title">Online Dictionary</div>
        <div id="search"><input id="inputWord" type="text"/><input id="searchButton" type="button" value="Go"></div>
        <div id="content"></div>
        <div id="similar"></div>
    </body>
</html>
