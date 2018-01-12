<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Women <span class="caret"></span></a>
        <ul class="dropdown-menu">
        <li><a tabindex="-1" href="#">Clothing</a></li>
          <li><a tabindex="-1" href="#">Sandals</a></li>
          <li><a tabindex="-1" href="#">Jewellery</a></li>
          <li><a tabindex="-1" href="#">Watches</a></li>
          </ul>
          </li>
          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Men <span class="caret"></span></a>
        <ul class="dropdown-menu">
        <li><a tabindex="-1" href="#">Clothing</a></li>
         <li><a tabindex="-1" href="#">Shoes</a></li>
         <li><a tabindex="-1" href="#">Watches</a></li>
          </ul>
          </li>
          <li><a href="#">Contact Us</a></li>
          <li><a href="admin">Admin</a></li>
     </ul>
      
      
    
    <ul class="nav navbar-nav navbar-right">
   <li><a href="#"><span class="glyphicon glyphicon-search"></span>Search</a></li>
   <li><a href="newuser"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
   <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>

</body>
</html>