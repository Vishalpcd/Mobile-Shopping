<!-- for using  Spring framework tags  -->
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

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
<div class="panel">
<div class="panel-heading">
<h3>${message}</h3>
</div>
</div>
<form class="form-horizontal" method="POST" action="${contextRoot}/user/login">
<div class="form-group">
<label class="control-label col-md-4" for="emailId">Enter brand email address :</label>
<div class="col-md-8">
<input type="email" name="email" id="emailId" placeholder="Enter email address" class="form-control">
<em class="help-block">Please enter your email address</em>
</div>
</div>
<div class="form-group">
<label class="control-label col-md-4" for="user_password">Enter your password :</label>
<div class="col-md-8">
<input type="password" name="password" id="user_password" placeholder="Enter password" class="form-control">
<em class="help-block">Please enter your password</em>
</div>
</div>
<div class="form-group">
<div class="col-md-offset-2 col-md-4">
<input type="submit" name="submit" class="btn btn-primary" value="Login">
</div>
</div>
</form>
</div>
</div>
</body>
</html>