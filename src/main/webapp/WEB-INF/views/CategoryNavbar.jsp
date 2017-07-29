
<a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Cotegories<span class="caret"></span></a>
<ul class="dropdown-menu">
<c:forEach items="${Categories}" var="category">
<li><a href="${contextRoot}/show/category/${category.id}/products">${category.name}</a></li>
</c:forEach><!--  it will show the fetched category id and based on thet id it will show all the products--> 
</ul>
