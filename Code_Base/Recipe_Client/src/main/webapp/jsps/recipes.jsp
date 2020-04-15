<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>
<link href="<c:url value="css/bootstrap.min.css" />"
 rel="stylesheet">
<script src="<c:url value="js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="js/bootstrap.min.js" />"></script>
</head>
<body>
 <div class="container">
  <div class="col-md-offset-2 col-md-7">
   <h1>Recipes </h1>
 


<div class="col-md-12">
 <div class="">
 <a class="btn btn-primary" href="addRecipe.htm" style="margin-left:50%;">Add Recipe</a>
 </div>
 <br>
   <table class="table table-striped table-bordered">
   <thead>
 <th>Recipe Name</th>
 <th>Details</th>
 <th>Edit</th>
 </thead>
 <tbody>
 <c:forEach var="recpValue" items="${recpList}">
 <tr>
 <td>${recpValue.recpName}</td>
 
 <td>
 <a class="btn btn-primary" href="recpDetails.htm?id=${recpValue.id}" target="_blank">Details</a>
 </td>
 
 <td>
 <a class="btn btn-primary" href="editRecipe.htm?id=${recpValue.id}">Edit</a> 
 <a class="btn btn-warning" href="deleteRecipe.htm?id=${recpValue.id}">Delete</a>
 </td>
 </tr>
 </c:forEach>
 </tbody>
   </table>

  </div>
 </div>
 </div>
</body>
</html>