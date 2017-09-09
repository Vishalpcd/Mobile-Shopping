<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- spring tag library -->
    <!-- using this tag library we can use spring tags in our project -->
    <!-- to fetch bootstrap files add below uri -->
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <!-- if you dont add this then you can't add conextRoot  -->
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    <!-- three vriabels using spring url -->
    <!-- css variable using spring url element -->
    <spring:url var="css" value="/resources/css"></spring:url>
    <!-- js variable using spring url element -->
    <spring:url var="js" value="/resources/js"/>
    <!-- images variable using spring url element -->
    <spring:url var="images" value="/resources/images"/>
    <spring:url var="image" value=""/>

    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<!-- Bootstrap library -->
<link rel="stylesheet" href="${css}/bootstrap.min.css">
<!-- Darkly theme -->
<link rel="stylesheet" href="${css}/Darkly.css">
<!-- Data table css file -->
<link rel="stylesheet" href="${css}/dataTables.bootstrap.css">
<!-- Customcss file -->
<link rel="stylesheet" href="${css}/customCss.css">
<!-- Custom java script file  -->
<!-- jQuery library -->
<script src="${js}/JQuery.js"></script>
<!-- Latest compiled JavaScript -->
<script src="${js}/bootstrap.min.js"></script>
<!-- jquery data table plugin -->
<script src="${js}/jquery.dataTables.js"></script>
<!-- data table bootstrap javascript file -->
<script src="${js}/dataTables.bootstrap.js"></script>
<!-- adding custom java script file -->
<script src="${js}/myApp.js"></script>
</head>
<body>
<div class="container-fluid">
<nav class="navbar navbar-inverse navbar-fixed-top">
<div class="navbar-header">
<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#tog" aria-expanded="false">
<span class="sr-only">toggle navigation</span>
<span class="sr-only"></span>
<span class="sr-only"></span>
<span class="sr-only"></span>
<span class="sr-only"></span>
<span class="sr-only"></span>
<span class="sr-only"></span>
</button>
<a class="navbar-brand" id="brand" href="${contextRoot}/home"><img alt="Mobile Shopping" src="${images}/title.jpg" heght="30" width="30">
</a>
</div>
<div class="collapse navbar-collapse" id="tog">
<ul class="nav navbar-nav">
<li id="home"><a href="${contextRoot}/home"><span class="glyphicon glyphicon-home"></span></a></li>
<li class="dropdown" id="brand">
<%@include file="BrandNavbar.jsp" %>
</li>
<li class="dropdown" id="type">
<%@include file="TypeNavbar.jsp" %>
</li>
<li class="dropdown" id="category">
<%@include file="CategoryNavbar.jsp"%>
</li>
<li><a href="${contextRoot}/about">about us</a></li>
<li><a href="${contextRoot}/show/all/products">Show all Products</a></li>
<li><a href="${contextRoot}/login">Login</a></li>
<li><a href="${contextRoot}/signup">signup</a></li>
</ul>
</div>
</nav>
</div>
</body>
</html>