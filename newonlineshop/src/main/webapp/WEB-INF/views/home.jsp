<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
   .carousel-inner>.item>img,
   .carousel-inner>.item> a> img{
   width:70%;
   margin:auto;
   }
   </style>
</head>
<body>

<jsp:include page="Navbar.jsp"></jsp:include>
<div class="container">
   
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
     <li data-target="#myCarousel" data-slide-to="4"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
     <!--  <div class="item active">
        <img src="resources/images/FallCoats_400.jpg" alt="Clothing" style:"width:100%;">
      </div> -->

      <div class="item active">
        <img src="C:/Users/shree/Downloads/040213-Shoes-Main-400x300.png" alt="Shoes" style="width:100%;">
      </div>
      <div class="item">
        <img src="resources/images/download.jpg" alt="Clothing" style="width:100%;">
      </div> 
    
      <div class="item">
        <img src="resources/images/2afa73dcf1733b556d134c47a083f478--crystal-pendant.jpg" alt="Jewellery" style="width:100%;">
      </div>
      <div class="item">
      <img src="C:/Users/shree/Downloads/d015fc35ad7c937af8f5dd52048e792f--gq-style-male-style.jpg" alt="Mens Clothing" style="width:100%;">
      </div>
      <div class="item">
      <img src="C:/Users/shree/Downloads/images.jpg" alt="Mens Shoes" style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<div class="container">
<div class="row">

	
		
			
				
				
				<c:if test="${!empty hproList}">
		
					<c:forEach items="${hproList}" var="homeproductList">	
					<div class="col-md-4">
						<div class="thumbnail">
							<img alt="Bootstrap Thumbnail First" src="resources/images/${homeproductList.id}.jpg" />
							<div class="caption">
								<h3>${homeproductList.productname}</h3>
								<h6>${homeproductList.productDescription}</h6>
								<h5>Rs ${homeproductList.price}</h5>
								
								<p>
									 <a class="btn" href="payment">Buy now</a>
									 <a class="btn" href="cart/add/${homeproductList.id}">Add to cart</a>
								</p>
							</div>

						</div>
					</div>
					</c:forEach>
				
				</c:if>		


</div>
</div>



  



</body>
</html>