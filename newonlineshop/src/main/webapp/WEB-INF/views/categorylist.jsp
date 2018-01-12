<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Navbar.jsp"></jsp:include>
<div class="container-fluid">

<c:if test="${!empty pcatlist}">
<c:forEach items="${pcatlist}" var="catproductlist">	
<div class="row">
<div class="col-md-4">
<div class="thumbnail">
<img src="resources/images/${catproductlist.id}.jpg">
</div>
</div>
</div>
<div class="row">
<div class="caption">
<h2>${catproductlist.productname}</h2>
<h2>${catproductlist.productDescription}</h2>
<h2>${catproductlist.price}</h2>
<p>

	<a class="btn btn-primary" href="cart/add/${catproductlist.id}">Add to Cart</a> <a
		class="btn" href="payment">Buy now</a>
								
	</p>
</div>
</div>
</c:forEach>
</c:if>

</div>
</body>
</html>