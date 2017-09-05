<a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Brands<span class="caret"></span></a>
<ul class="dropdown-menu">
<c:forEach items="${Brands}" var="brand">
<li><a href="${contextRoot}/show/brand/${brand.id}/products">${brand.name}</a></li>
</c:forEach><!--  it will show the fetched category id and based on thet id it will show all the products--> 
</ul>
