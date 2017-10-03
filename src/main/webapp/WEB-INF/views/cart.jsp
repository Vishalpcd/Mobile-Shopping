<div class="container">
<c:if test="${not empty message}">
<div class="panel">
<div class="panel-heading panel-success">
<h3>${message}</h3>
</div>
</div>
</c:if>
<c:choose>
<c:when test="${not empty cartLines}">
<c:forEach items="${cartLines}" var="cartLine">
<div class="row">
<div class="col-md-3">

<img src="${images}/${cartLine.product.code}.jpg" class="img-responsive" width="300px" height="300px">
</div>
<div class="col-md-9">
<h2>${cartLine.product.name}</h2><br>
<h3>${cartLine.product.brand}</h3><br>
<h4>&#8377; ${cartLine.product.unitPrice}</h4><br>
<h4>${cartLine.product.description}</h4><br>
<a href="${contextRoot}/cart/${cartLine.id}/remove" class="btn btn-danger">Remove</a>
<hr class="divider" role="seperator"></hr>
</div>
</div>
</c:forEach>
<div class="row">
<div class="col-md-offset-3">
<div class="col-md-3">
<a href="${contextRoot}/checkout" class="btn btn-success" >Checkout</a>
</div>
<div class="col-md-3">
<h5>Grand Total: &#8377; ${userModel.cart.grandTotal}</h5>
</div>
</div>
</div>
</c:when>
<c:otherwise>
<h1>cart is empty!!</h1>
</c:otherwise>
</c:choose>

</div>