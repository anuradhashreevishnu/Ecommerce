<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> My Cart</title>
</head>
<style>
body{
background-image: url(resources/images/k4.jpg);
background-size:     cover;                      
    background-repeat:   no-repeat;
}
th{
    color:white;
    background-color:black;
    
}
table, th, td {
    border: 1px solid black;
    align:center;
}
h2{
color:black;
font-family: "Times New Roman", Times, serif;
}
</style>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Onlineshop</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="home">Home</a></li>
      </ul></div></nav>



 <div class="container-fluid">
	<%-- <h3><center>YOUR CART</center></h3>
	<br>
	<br> --%>
	
	
	<c:if test="${!empty cartList}">
		<table  class="table table-condensed"  align="center">
			<tr>
				<th  width="125">Product Name</th>
				<th  width="125">Image</th> 
				<th  width="125">Price</th>
				
				<th width="125" align="center">Delete</th>
				
			</tr>
			<c:forEach items="${cartList}" var="cart">
				<tr>
					<td  align="center">${cart.productName}</td>
					<td><img src="<c:url value="resources/images/${cart.cartproduct_id}.jpg"/>" style="width: 100px;"></td>
					<td  align="center">${cart.price}</td>
					
					
					
					
					<td align="center"><a href="<c:url value='cart/delete/${cart.id}' />"><button type="button" class="btn btn-default">Delete</button></a></td>
				</tr>
			</c:forEach>
		</table>
	
	</c:if>
	</div>
	<br>
	<br>
			<c:if test="${pageContext.request.userPrincipal.name  != null}">
		<h2><center> Total:${sum}</center></h2>
		</c:if>
	
	<div style="text-align: center;">
	
	<a href="home"><button type="button" class="btn  btn-primary" align="center">CONTINUE SHOPPING</button>
	</h4></a>
	
	
	<br>
	<br>
	<c:if test="${!empty cartList}">
	<a href="payment"><h4 style="color: #c19a6b "><button type="button" class="btn  btn-primary">Checkout and Pay</button></h4></a>
	</c:if>
	</div>
</body>
</html>