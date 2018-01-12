<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="Navbar.jsp"></jsp:include>
	<div class="container">
		<form:form method="POST" action="addproduct" modelAttribute="product" enctype="multipart/form-data">
		<div class="form-group">
			<c:if test="${!empty product.id }">
				
				<form:input path="id" type="hidden" value="${product.id}" class="form-control" />
				</c:if>
			</div>
			<div class="form-group">
			
				<label for="Name">Enter Product Name:</label>
				<form:input path="productname" type="text" value="${product.productname}" class="form-control"
					id="Name" name="Name" />
			</div>

			<div class="form-group">
				<label for="quantity">Enter Quantity</label>
				<form:input path="quantity" type="text" value="${product.quantity}" class="form-control"
					id="quantity" name="quantity" />
			</div>

			<div class="form-group">
				<label for="price">Enter price</label>
				<form:input path="price" type="text"  value="${product.price}" class="form-control" id="price"
					name="price" />
			</div>
			<div class="form-group">
				<label for="productdescription">Enter ProductDescription</label>
				<form:input path="productDescription" type="text" value="${product.productDescription}"
					class="form-control" id="productdescription"
					name="product description" />
					</div>
					<div class="form-group">
					<label >select image</label>
					<form:input path="image" type="file" class="form-control" placeholder="select an image" id="productimage" name="product image"/>
					</div>
					</div>
			<div class="form-group">
				<label>Select Category</label>
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button"
						data-toggle="dropdown" >
						Select <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" >
						<li><a href="#">General</a></li>
						<li><a href="#">Discount Sale</a></li>
						<li><a href="#">Hot sale</a></li>
						<li><a href="#">New arrivals</a></li>
					</ul>
				</div>
			</div>
			<br/>
			<c:if test="${empty product.productname}">
			<input class="btn btn-primary" type="submit" value="Add product"/>
			</c:if>
			<c:if test="${!empty product.productname}">
			<input class="btn btn-primary" type="submit" value="Edit product"/>
			</c:if>
		</form:form>
	</div>

	<div>
	<br/>
	<br/>
		<table class="table">
			<tr>
				<th>ProductId</th>
				<th>Product name</th>
				<th>Product desc</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Image</th>
			</tr>

			<c:forEach var="p" items="${allproducts}">
				<tr>
					<td>${p.id }</td>
					 <td>${p.productname }</td>
					<td>${p.productDescription }</td>
					<td>${p.price }</td>
					<td>${p.quantity }</td>
					<td><img src="resources/images/${p.id}.jpg" width="150 px" height="150 px"/></td>
					<td><a href="editproduct-${p.id}"><button class="btn btn-warning">Update</button></a></td>
					<td><a href="deleteproduct-${p.id}"><button class="btn btn-danger">Delete</button></a></td>
				</tr>
			</c:forEach>
</table>
</div>
</body>
</html>
