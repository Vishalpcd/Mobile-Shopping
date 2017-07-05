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
<!-- Darkly theme -->
<link rel="stylesheet" href="${css}/Darkly.css">

<!-- jQuery library -->
<script src="${js}/JQuery.js"></script>

<!-- Latest compiled JavaScript -->
<script src="${js}/bootstrap.min.js"></script>
<!-- Custom java script file  -->
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
</button>
<a class="navbar-brand" id="brand" href="/MobileShopping/home"><img alt="Mobile Shopping" src="${images}/title.jpg" heght="30" width="30">
</a>
</div>
<div class="collapse navbar-collapse" id="tog">
<ul class="nav navbar-nav">
<li id="home"><a href="/MobileShopping/home"><span class="glyphicon glyphicon-home"></span></a></li>
<li class="dropdown">
<a href= "#" role="button" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Brands<span class="caret"></span></a>
<ul class="dropdown-menu">
<li><a href="#">Samsung</a></li>
<li><a href="#">Nokia</a></li>
<li><a href="#">One Plus One</a></li>
</ul>
</li>
<li class="dropdown">
<a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Types<span class="caret"></span></a>
<ul class="dropdown-menu">
<li><a href="#">Smart Phones</a></li>
<li><a href="#">Featured Phones</a></li>
</ul>
</li>
<li id="about"><a href="/MobileShopping/about">About us</a></li>
<li id="login"><a href="/MobileShopping/login">Login</a></li>
<li id="signup"><a href="/MobileShopping/signup">Sign-up</a></li>
</ul>
</div>
<div>

</div> 
</nav>
</div>
</body>
</html>