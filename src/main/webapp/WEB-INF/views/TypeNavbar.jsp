<a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Types<span class="caret"></span></a>
<ul class="dropdown-menu">
<c:forEach items="${Types}" var="type">
<li><a href="${contextRoot}/show/type/${type.id}/products">${type.name}</a></li>
</c:forEach><!--  it will show the fetched category id and based on thet id it will show all the products--> 

</ul>