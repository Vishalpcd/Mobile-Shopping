<html>
<head>
</head>
<body>
<div class="container">
<c:forEach items="${Categories}" var="category">
<li><a href="#">${category.name}</a></li>
</c:forEach>

</div>
</body>
</html>