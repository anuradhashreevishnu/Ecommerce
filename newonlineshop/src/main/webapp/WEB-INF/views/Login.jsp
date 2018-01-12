<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bootstrap Example</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<jsp:include page="Navbar.jsp"></jsp:include>
<div class="container" style="width: 550px; height: 300px;">
      <div class="row">
          <div class="col-xs-12 col-sm-12 col-md-12">
            <center>
                  <h1>LOGIN</h1>
             </center>
             
      <form method="post" action="<c:url value='j_spring_security_check' />" >  
       <c:if test="${not empty error}">
                    <div class="error" style="color: #ff0000;">${error}</div>
                </c:if>
                <div class="span9 center">
                   	<c:if test="${not empty msg}">
                 		<div class="msg">${msg} <br><br></div>
            		</c:if>
            		</div>
            		 <div class="form-group">		
					 <label class="col-sm-2 control-label">UserName</label>
			<div class="col-sm-10">
                	<input type="text" placeholder="Username" name="username"/></div></div>
                	<br>
                	<br>
                	
                	<div class="form-group">
			 <label  class="col-sm-2 control-label">Password</label>		 	 
		<div class="col-sm-10">
					<input type="password" placeholder="Password"  name="password" /></div></div>
					<br>
                	<br>
                	
                	<div class="form-group">
		 <div class="col-sm-1"></div>
		 <div class="col-sm-10">
			<button class="btn btn-lg btn-primary btn-block" type="submit">
				LOG IN</button>			
		</div>
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		
		
            </form>
            </div>
            </div>
            </div>
            </body>
            </html>
         
