<div class="responsive">
<div class="row">
<div class="col-md-4">
<img src="${images}/${product.code}.jpg" class="img-responssive"></img>
</div>
<div class="col-md-8">
<h2><strong>Name:</strong> ${product.name}</h2><br>
<p><h4><strong>Description:</strong> <br> ${product.description}</h4></p><br>
<h3><strong>Price:</strong> &#8377; ${product.unitPrice} /-</h3>
<h6><strong>Quantity available:</strong> ${product.quantity} </h6><br>
<a href="${contextRoot}/cart/add/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-shopping-cart"></span>Add to cart</a>
<a href="${contextRoot}/show/all/products" class="btn btn-success">back</a>
</div>
</div>
</div>