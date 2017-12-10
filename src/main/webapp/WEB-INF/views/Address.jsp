<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- container  -->
<div class="row">
<div class="container">
<!-- Panel for address  -->
<div class="col-md-offset-2 col-md-8">
<div class="panel">
<h3>Address</h3>
<c:if test="${not empty message}">
<h5>${message}</h5>
</c:if>
</div>
</div>

<!-- form element -->
<sf:form action="${contextRoot}/Address"
 class="form-horizontal"
 enctype="multipart/form-data"
 method="POST"
 modelAttribute="address">
<div class="form-group">
<label class="control-label col-md-4" for="address">Enter your address:</label>
<div class="col-md-5">
<sf:textarea path="address" class="form-control" rows="6"/>
</div>
</div>
<div class="form-group">
<label class="control-label col-md-4" for="landmark">Enter landmark:</label>
<div class="col-md-5">
<sf:input path="landmark" class="form-control" />
</div>
</div>
<div class="form-group">
<label class="control-label col-md-4" for="pincode">Enter the pincode:</label>
<div class="col-md-5">
<sf:input path="pincode" type="number" class="form-control"/>
</div>
</div>
<div class="form-group">
<label class="control-label col-md-4" for="city">Enter your city name:</label>
<div class="col-md-5">
<sf:input path="city" class="form-control"/>
</div>
</div>
<div class="form-group">
<label class=" control-label col-md-4" for="state">Enter your state name:</label>
<div class="col-md-5">
<sf:input path="state" class="form-control"/>
</div>
</div>
<div class="form-group">
<label class="control-label col-md-4" for="country">Enter your country:</label>
<div class="col-md-5">
<sf:input path="country" class="form-control"/>
</div>
</div>
<div class="form-group">
<input type="submit" class="btn btn-primary col-md-offset-5 col-md-2" name="submit" value="Add"/>
<sf:hidden path="id"/>
<sf:hidden path="cartid"/>
</div>
</sf:form>
</div>
</div>
