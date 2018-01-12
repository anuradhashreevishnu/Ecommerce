<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Details</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap-3.1.1.min.js"/>"></script>
<script src="<c:url value="/resources/js/simpleCart.min.js"/>">
	
</script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/flexslider.css"/>" type="text/css"
	media="screen" />
	<style>
li.uppercase {
	text-transform: uppercase;
}
h2{
color:#ff3399;
font-family: calibre;
}
.btn {
    background-color: #ff3399;
    }
</style>
</head>
<body>
<nav class="navbar navbar-inverse ">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Bootstrap Example</a>
			</div>
			<ul class="nav navbar-nav">
			
      <li class="active"><a href="home"><span class="glyphicon glyphicon-home"></span></a></li>
	
				
			</ul>
			<ul class="nav navbar-nav navbar-right">
      
      <li class="divider-vertical"></li>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			
			
			
			<c:if test="${pageContext.request.userPrincipal.name  == 'admin'}">
				<li><a href="<c:url value="/admin" />">View ALL</a></li>
			</c:if>
			
			<li><a>Hello, ${pageContext.request.userPrincipal.name}</a></li>
			<li><a href="<c:url value="/j_spring_security_logout" />"> <span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
		</c:if>
								
		<c:if test="${pageContext.request.userPrincipal.name  == null}">
			<li><a href="<c:url value="/loginUser" />"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
			<li><a href="<c:url value="memberShip.obj" />"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
		</c:if>
	</ul>		
	</ul>      
  </div>
</nav>
<div class="header">
		<div class="header-top-strip">
			<div class="container">
				
				<div class="clearfix"></div>
			</div>
		</div>
	</div>

	<div class="container">
		
		
		<center>
			<h2>ENTER YOUR PAYMENT DETAILS</h2>
		</center>
		<br>
	</div>
	<center>
		<div class="content">
			<fieldset>
				<br>
				<form:form action="addpayment" modelAttribute="payment" method="POST">
					<table>
						<tr>
							<td>Street Address:</td>
							<td><form:input path="Streetaddrs" placeholder="Street Address"/></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>City:</td>
							<td><form:input path="city" placeholder="City"/></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>ZIP:</td>
							<td><form:input path="zip" placeholder="ZIP code"/></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>Mobile:</td>
							<td><form:input path="mob"   placeholder="Mobile No"/></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>Email:</td>
							<td><form:input path="payemail" placeholder="Email"/></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>FirstName:</td>
							<td><form:input path="payfnam" placeholder="First Name"/></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						
						<tr>
							<td>LastName:</td>
							<td><form:input path="paylname" placeholder="Last Name"/></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>Card Number:</td>
							<td><form:input path="paycardno" placeholder="Card Number"/></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>Expiry Date:</td>
							<td><form:input path="cardexpirydate" placeholder="DD/MM/YYYY"/></td>							
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>CCV:</td>
							<td><form:input path="ccv" placeholder="CCV"/></td>
						</tr>
						
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<br>
						
						<tr>
							<td align="center" colspan="2">
								<input type="submit" value="Submit" class="btn btn-success"/>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
					</table>
				</form:form>
			</fieldset>
		</div>
	</center>

</body>
</html>