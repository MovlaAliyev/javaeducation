<%-- 
    Document   : index
    Created on : Dec 23, 2017, 8:43:06 PM
    Author     : Javatarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="src/css/style.css" /> 
    </head>
    <body>

        <input id="searchvalue" type="text" name="search" placeholder="Search.." >
        <input type="submit" value="Search" onclick="searchCity()"/>


        <div id="table">

        </div>
        <div id="load_message">
            <input id="t" type="submit" value="load" onclick="doPagination()"/>
        </div>
        <button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>

        <script type="text/javascript" src="src/js/script.js"></script>

    </body>
</html>


