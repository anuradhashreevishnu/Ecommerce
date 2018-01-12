<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
<title>Bootstrap Example</title> 
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Anu</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="home">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="categorylist">Categories <span class="caret"></span></a>
        <ul class="dropdown-menu">
        <c:forEach items="${hcatList}" var="homecategoryList">
        <li><a tabindex="-1" href="category-${homecategoryList.category_id }">${homecategoryList.categoryname }</a></li>
        </c:forEach>
          </ul>
          </li>
          
          <li><a href="#">Contact Us</a></li>
          <c:if test="${pageContext.request.userPrincipal.name=='Anuradha'}">
          <c:if test="${pageContext.request.userPrincipal.name != null}">
          <li><a href="admin">Admin</a></li>
          </c:if>
          </c:if>
     </ul>
      
      
    
    <ul class="nav navbar-nav navbar-right">
    <c:if test="${pageContext.request.userPrincipal.name !=null}" >
    <li><a>Hello,${pageContext.request.userPrincipal.name}</a></li>
    <li><a href="myCart"><span class="glyphicon glyphicon-shopping-cart"></span>Cart</a>${CartSize}</li>
    <li><a href="<c:url value='/j_spring_security_logout' />"><span class="glyphicon glyphicon-log-in"></span>logout</a></li>
    </c:if>
   <li><a href="#"><span class="glyphicon glyphicon-search"></span>Search</a></li>
   <c:if test ="${pageContext.request.userPrincipal.name == null}"> 
   <li><a href="newuser"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> Sign Up</a></li>
   <li><a href="login"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> Login</a></li>
   
   </c:if>
  
    </ul>
  </div>
</nav>

</body>
</html>