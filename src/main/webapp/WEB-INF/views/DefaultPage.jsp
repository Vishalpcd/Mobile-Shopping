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
window.menu='${title}';
//adding contextRoot 
window.contextRoot='${contextRoot}'
</script>
</head>
<body>
<!-- header -->
<%@include file="header.jsp" %>
<!-- home  -->
<c:if test="${userClicksHome==true}">
<%@include file="home.jsp" %>
</c:if>
<!-- user seccessfully logged in -->
<c:if test="${userClicksSuccessLogin==true}">
<%@include file="home.jsp" %>
</c:if>
<!-- Address page   -->
<c:if test="${UserClicksCheckOut==true}">
<%@include file="Address.jsp" %>
</c:if>
<!-- Reciept page  -->
<c:if test="${UserClicksReceipt==true}">
<%@include file="Receipt.jsp" %>
</c:if>
<!-- about us -->
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
<script>

window.categoryId='';
</script>
<%@include file="allProducts.jsp" %>
</c:if>


<c:if test="${userClickscategoryProducts==true}">
<script>
<!--test("%{category.id}%");-->
window.categoryId='${category.id}';
</script>
<%@include file="allProducts.jsp" %>
</c:if>

<c:if test="${userClicksbrandProducts==true}">
<script>
window.brandId='${brand.id}';
</script>
<%@include file="allProducts.jsp" %>
</c:if>
<c:if test="${userClickstypeProducts==true}">
<script>
window.typeId='${type.id}';
</script>
<%@include file="allProducts.jsp" %>
</c:if>


<!-- single product.jsp -->

<c:if test="${UserClickProduct==true}">
<%@include file="singleProduct.jsp" %>
</c:if>
<c:if test="${userClicksManageProducts==true}">
<%@include file="ManageProducts.jsp" %>
</c:if>
<!-- Edit product -->
<c:if test="${userClickseditProducts==true}">
<%@include file="EditProducts.jsp" %>
</c:if>
<!-- Manage brand -->
<c:if test="${userClicksManageBrands==true}">
<%@include file="ManageBrand.jsp" %>
</c:if>
<!-- error while login -->
<c:if test="${userClicksLoginError==true}">
<%@ include file="login.jsp" %>
</c:if>
<c:if test="${userClicksCart==true}">
<%@include file="cart.jsp" %>
</c:if>
</body>
</html>
