<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="container">
<div class="row">
<div class="col-md-offset-2 col-md-8">

<div class="panel">
<div class="panel-heading">
<h3>Manage Brands</h3>
</div>
</div>
<sf:form class="form-horizontal" method="POST" action="${contextRoot}/Manage/brand" modelAttribute="brand">
<div class="form-group">
<label class="control-label col-md-4" for="name">Enter brand name :</label>
<div class="col-md-8">
<sf:input type="text" path="name" id="name" placeholder="Enter brand name" class="form-control"></sf:input>
<sf:errors path="name" cssClass="help-block" element="em"></sf:errors>
</div>
</div>
<div class="form-group">
<label class="control-label col-md-4" for="description">Enter description name :</label>
<div class="col-md-8">
<sf:textarea type="text" rows="4" path="description" id="description" placeholder="Enter description " class="form-control"></sf:textarea>
<sf:errors path="description" cssClass="help-block" element="em"></sf:errors>
</div>
</div>
<div class="col-md-offset-2 col-md-4">
<input type="submit" name="submit" id="submit" class="btn btn-primary" value="Add Brand">
<sf:hidden path="id"/>
<sf:hidden path="active"/>
</div>
</sf:form>
</div>
</div>
</div>

