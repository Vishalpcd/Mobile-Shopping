<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="container">
<div class="panel">
<div class="panel-heading">
<h3>Signup</h3>
</div>
</div>
<c:if test="${not empty message}">
<div class="panel">
<h5>${message}</h5>
</div>
</c:if>
<div class="col-md-offset-2 col-md-8">
<sf:form name="frm" class="form-horizontal" method="POST" action="${contextRoot}/signup" modelAttribute="user" onSubmit="return PassWordMatch()">
<div class="form-group">
<label class="control-label col-md-4" for="firstName">Enter your first name  :</label>
<div class="col-md-8">
<sf:input type="text" path="firstName" id="firstName" placeholder="Enter first name" class="form-control"></sf:input>
<sf:errors path="firstName" cssClass="help-block" element="em"></sf:errors>
</div>
</div>
<div class="form-group">
<label class="control-label col-md-4" for="lastName">Enter last name :</label>
<div class="col-md-8">
<sf:input type="text" path="lastName" id="lastName" placeholder="Enter your last name  " class="form-control"></sf:input>
<sf:errors path="lastName" cssClass="help-block" element="em"></sf:errors>
</div>
</div>

<!-- email -->
<div class="form-group">
<label class="control-label col-md-4" for="email">Enter your email id :</label>
<div class="col-md-8">
<sf:input type="email" path="email" id="email" placeholder="Enter your email id  " class="form-control" ></sf:input>
<sf:errors path="email" cssClass="help-block" element="em"></sf:errors>
</div>
</div>


<!-- password -->
<div class="form-group">
<label class="control-label col-md-4" for="pasword">Enter your password :</label>
<div class="col-md-8">
<sf:input type="password" path="password" id="ps1" placeholder="Enter your password  " class="form-control"></sf:input>
<sf:errors path="password" cssClass="help-block" element="em"></sf:errors>
</div>
</div>
<!-- re-enter -->
<div class="form-group">
<label class="control-label col-md-4" for="password">Re-enter your password :</label>
<div class="col-md-8">
<input type="password" name="re-password" id="ps2" placeholder="Enter your password  " class="form-control"/>
</div>
</div>

<!-- contact number  -->
<div class="form-group">
<label class="control-label col-md-4" for="contactNumber">Provide your contact number :</label>
<div class="col-md-8">
<sf:input type="contactNummber" path="contactNumber" id="contactNumber" placeholder="Provide your contact number  " class="form-control"></sf:input>

</div>
</div>



<!-- submit -->
<div class="col-md-offset-2 col-md-4">
<input type="submit" name="submit" id="submit" class="btn btn-primary" onclick="match()" value="Signup">
<sf:hidden path="id"/>
<sf:hidden path="role"/>
<sf:hidden path="enabled"/>
</div>
</sf:form>

</div>
</div>
