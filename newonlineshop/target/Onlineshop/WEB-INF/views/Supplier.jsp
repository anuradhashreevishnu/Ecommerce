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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="Navbar.jsp"></jsp:include>
<div class="container">
<form:form method="post" action="addsupplier" modelAttribute="supplier" > 
  <div class="form-group">
      
      <c:if test="${empty supplier.id}">
      <form:label path="id" class="control-label" for="sid"><spring:message text="sup id"></spring:message></form:label>
     
    <form:input path="id" class="form-control" type="text" id="sid" placeholder="Enter Id"/>
 </c:if> 
      <c:if test="${!empty supplier.id}"> 
        <form:input path="id" type="hidden" value="${supplier.id}" class="form-control" id="id" />
        </c:if>   
    </div>
  <div class="form-group">
      <form:label path="suppliername"  class="control-label col-sm-2" for="sn">Supplier-Name:</form:label>
      <div class="col-sm-10">
        <form:input path="suppliername" type="text" value="${supplier.suppliername}"  class="form-control" id="sn" placeholder="Enter Suppliername" name="sn"/>
       </div>
    </div>
    <div class="form-group">      
       <div class="col-sm-offset-2 col-sm-10">
      <c:if test="${!empty supplier.suppliername}">
      		<a href=""><input type="submit" value="Edit supplier" /></a>
			</c:if>
			<c:if test="${empty supplier.suppliername}">
				<a href=""><input type="submit" value="Add Supplier"/></a>
			</c:if>
        
      
      </div>
    </div> 
    
   
  </form:form>
</div>

	<c:if test="${!empty supplierList}">
		<table class="table table-bordered">
			<tr>
				<th>SupplierID</th>
				<th>Supplier Name</th>
			</tr>
			<c:forEach items="${supplierList}" var="supplier">
				<tr>
					<td>${supplier.id}</td>
					<td>${supplier.suppliername}</td>
				   <td><a href="updatesup-${supplier.id}"><button type="button" class="btn btn-primary">Update</button></a></td>
				  <td><a href="deletesup-${supplier.id}"><button type="button" class="btn btn-primary">Delete</button></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>