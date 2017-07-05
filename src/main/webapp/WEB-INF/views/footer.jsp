<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- spring tag library -->
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <!-- three vriabels using spring url -->
    <!-- css variable using spring url element -->
    <spring:url var="css" value="/resources/css"></spring:url>
    <!-- js variable using spring url element -->
    <spring:url var="js" value="/resources/js"/>
    <!-- images variable using spring url element -->
    <spring:url var="images" value="/resources/images"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<!-- Bootstrap library -->
<link rel="stylesheet" href="${css}/bootstrap.min.css">

<!-- jQuery library -->
<script src="${js}/JQuery.js"></script>

<!-- Latest compiled JavaScript -->
<script src="${js}/bootstrap.min.js"></script>
<!-- Custom java script file  -->
<script src="${js}/myApp.js"></script>
</head>
<body>
<div class="conteiner">
<h4>All  right recieved @2017</h4>
</div>
</body>
</html>

