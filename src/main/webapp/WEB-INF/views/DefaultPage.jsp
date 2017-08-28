<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="icon" type="jpg,png,jpeg,gif" href="${images}/title.jpg"></link>
<title>Mobile Shopping -${title}</title>
<script>
window.menu="${title}";
</script>
</head>
<body>
<!-- header -->
<%@include file="header.jsp" %>
<!-- home  -->
<c:if test="${userClicksHome==true}">
<%@include file="home.jsp" %>
</c:if>
<!-- abou us -->
<c:if test="${userClicksAbout==true}">
<%@include file="about.jsp" %>
</c:if>
<!-- login -->
<c:if test="${userClicksLogin==true}">
<%@include file="login.jsp" %>
</c:if>
<!-- signup -->
<c:if test="${userClicksSignup==true}">
<%@include file="signup.jsp" %>
</c:if>
<!-- allproducts -->
<c:if test="${userClicksallProducts==true}">
<%@include file="allProducts.jsp" %>
</c:if>
<c:if test="${userClicksallProducts==true or userClickscategoryProducts==true}">
<%@include file="listProducts.jsp" %>

</c:if>
</body>
</html>
