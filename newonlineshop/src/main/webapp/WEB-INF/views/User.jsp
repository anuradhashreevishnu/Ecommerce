<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<div class="Container">
<h2>Registration form</h2>

	<form:form method="post" modelAttribute="user" action="Register">
	
	<div class="form-group">
	<form:label path="username" class="control-label col-sm-2" for="un">UserName:</form:label>
	<div class="col-sm-10">
	<form:input path="username" type="text" class="form-control" id="un" placeholder="Enter Username" name="un"/>
	</div>
	</div>
	<div class="form-group">
	<form:label path="usermailid" class="control-label col-sm-2" for="un">UserMailid:</form:label>
	<div class="col-sm-10">
	<form:input path="usermailid" type="Mailid" class="form-control" id="mailid" placeholder="Enter UserMailid" name="mailid"/>
	</div>
	</div>
	<div class="form-group">
	<form:label path="password" class="control-label col-sm-2" for="un">Password:</form:label>
	<div class="col-sm-10">
	<form:input path="password" type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd"/>
	</div>
	</div>
	<div class="form-group">
	<form:label path="contactno" class="control-label col-sm-2" for="un">ContactNo:</form:label>
	<div class="col-sm-10">
	<form:input path="contactno" type="text" class="form-control" id="cno" placeholder="Enter Contactno" name="cno"/>
	</div>
	</div>
	<div class="form-group">
	<div class="col-sm-offset-2 col-sm-10">
	<form:button type="submit" class="btn btn-primary">Submit</form:button>
	<button type="reset" class="btn btn-warning">Reset</button>
	</div>
	</div>
</form:form>
</div>

</body>
</html>