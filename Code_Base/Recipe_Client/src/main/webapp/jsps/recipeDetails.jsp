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
   <h1>Details of the Recipe</h1>
   <hr />

   <table class="table table-striped table-bordered">
    <tr>
     <td><b>Recipe Name</b>: ${recpObj.recpName}</td>
    </tr>
    <tr>
     <td><b>vegetarian</b> : ${recpObj.recpInd}</td>
    </tr>
    
    <tr>
     <td><b>serves</b> : ${recpObj.recpCount}</td>
    </tr>
    <tr>
     <td><b>Ingredients</b> : ${recpObj.recpIng}</td>
    </tr>
    <tr>
     <td><b>Preparation</b> : ${recpObj.recpPrepa}</td>
    </tr>
    <tr>
     <td><b>Last Update At</b>: ${recpObj.recpDateTime}</td>
    </tr>
   </table>

  </div>
 </div>
</body>
</html>