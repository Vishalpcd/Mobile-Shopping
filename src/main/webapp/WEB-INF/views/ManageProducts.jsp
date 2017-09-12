<!-- to use the spring form -->
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="container">
<div class="row">
<div class="col-md-offset-2 col-md-8">
<div class="panel">

<div class="panel-heading">

<h3>Manage Products</h3>
</div>
</div>
<!-- form elements -->
<sf:form class="form-horizontal" modelAttribute="product"
action="${contextRoot}/Manage/products"
method="POST"
>
<div class="form-group">
<!-- for product name -->
<label class="control-label col-md-4" for="name">Enter product name :</label>
<div class="col-md-8">
<sf:input type="text" path="name" id="name" placeholder="Enter product name" class="form-control"></sf:input>
<sf:errors path="name" cssClass="help-block" element="em"></sf:errors>
</div>
</div>
<!-- brand name  -->
<div class="form-group">
<!-- for product name -->
<label class="control-label col-md-4" for="brand">Enter brand name :</label>
<div class="col-md-8">
<sf:input type="text" path="brand" id="brand" placeholder="Enter brand name" class="form-control"></sf:input>
<sf:errors path="brand" cssClass="help-block" element="em"></sf:errors>
</div>
</div>
<!-- description -->
<div class="form-group">
<label class="control-label col-md-4" for="name">Enter product Description :</label>
<div class="col-md-8">
<sf:textarea rows="4" path="description" id="description" placeholder="Enter product description" class="form-control"></sf:textarea>
<sf:errors path="description" cssClass="help-block" element="em"></sf:errors>
</div>
</div>
<!-- amount -->
<div class="form-group">

<label class="control-label col-md-4" for="unitPrice">Enter amount :</label>
<div class="col-md-8">
<sf:input type="number" path="unitPrice" id="unitPrice" placeholder="Enter amount name" class="form-control"></sf:input>
<sf:errors path="unitPrice" cssClass="help-block" element="em"></sf:errors>
</div>
</div>
<!-- quantity -->
<div class="form-group">
<label class="control-label col-md-4" for="quantity">Enter quantity :</label>
<div class="col-md-8">
<sf:input type="number" path="quantity" id="quantity" placeholder="Enter product quantity" class="form-control"></sf:input>
<sf:errors path="quantity" cssClass="help-block" element="em"></sf:errors>
</div>
</div>
<!-- category slection -->
<div class="form-group">
<label class="control-label col-md-4" for="categoryId">selecct category :</label>
<div class="col-md-8">
<sf:select  path="categoryId" id="categoryId" class="form-control"
items="${categories}"
itemLabel="name"
itemValue="id"
/>


<em class="help-block">Please select category </em>
</div>
</div>
<!-- brand selection -->
<div class="form-group">
<label class="control-label col-md-4" for="brandId">selecct brand :</label>
<div class="col-md-8">
<sf:select  path="brandId" id="brandId" class="form-control" 
items="${brands}"
itemLabel="name"
itemValue="id"


/>
<!-- type selection -->
</div>
</div>
<!-- type selection -->
<div class="form-group">
<label class="control-label col-md-4" for="typeId">select type :</label>
<div class="col-md-8">
<sf:select  path="typeId" id="typeId" class="form-control"
items="${types}"
itemLabel="name"
itemValue="id"
/>


</div>
</div>

<!-- submit button -->
<div class="col-md-offset-4 col-md-4">
<input type="submit" class="btn btn-primary" value="Submit" id="submit" name="submit"/>
<!-- hidden fields -->
<sf:hidden path="id"/>
<sf:hidden path="code"/>
<sf:hidden path="supplierId"/>
<sf:hidden path="active"/>
<sf:hidden path="purchases"/>
<sf:hidden path="views"/>


</div>
</sf:form>
</div>


</div>
</div>




