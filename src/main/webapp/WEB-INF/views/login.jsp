<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- for using  Spring framework tags  -->
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="row">
		<div class="col-md-offset-2 col-md-8">
			<div class="panel">
				<div class="panel-heading">
					<h3>Login</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-md-offset-2 col-md-8">
				<c:if test="${not empty message}">
					<div class="panel">
						<div class="panel-heading">
							<h3>${message}</h3>
						</div>
					</div>
					</c:if>
					<form class="form-horizontal" method="POST"
						action="${contextRoot}/login">
						<div class="form-group">
							<label class="control-label col-md-4" for="emailId">Enter email address :</label>
							<div class="col-md-8">
								<input type="email" name="username" id="emailId" placeholder="Enter email address" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="user_password">Enter
								your password :</label>
							<div class="col-md-8">
								<input type="password" name="password" id="user_password" placeholder="Enter password" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-2 col-md-4">
								<input type="submit" name="submit" class="btn btn-primary"
									value="Login"> <input type="hidden"name="${_csrf.parameterName}" value="${_csrf.token}" />
							</div>
						</div>
					</form>
				</div>
			</div>
</body>
</html>