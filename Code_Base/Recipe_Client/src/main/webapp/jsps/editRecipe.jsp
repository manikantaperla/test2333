<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Recipe</title>
<link href="<c:url value="css/bootstrap.min.css" />"
 rel="stylesheet">
<script src="<c:url value="js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="js/bootstrap.min.js" />"></script>

</head>
<body>
 <div class="container">
  <div class="col-md-offset-2 col-md-7">
  <!--  <h2 class="text-center">Add Recipe</h2> -->
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Edit Recipe</div>
    </div>
    <div class="panel-body">
     <form:form action="updateRecipe.htm" cssClass="form-horizontal"
      method="post" commandName="recipes">

      <div class="form-group">
      <tr>  
        <td></td>    
         <td><form:hidden  path="id" /></td>  
         </tr>
      
       <label for="recpName" class="col-md-3 control-label">Recipe Name</label>
       <div class="col-md-9">
        <form:input path="recpName" cssClass="form-control" />
       </div>
      </div>
      <div class="form-group">
       <label for="recpInd" class="col-md-3 control-label">Vegeterian</label>
       <div class="col-md-9">
       <%--  <form:input path="recpInd" cssClass="form-control" /> --%>
          
        Yes <form:radiobutton path="recpInd"  value="Yes" />  
        No  <form:radiobutton path="recpInd" checked="checked" value="No"/>  
       </div>
      </div>

      <div class="form-group">
       <label for="icode" class="col-md-3 control-label">Servings</label>
       <div class="col-md-9">
        <form:input path="recpCount" cssClass="form-control" />
       </div>
      </div>

      <div class="form-group">
       <label for="recpPrepa" class="col-md-3 control-label">Preparation</label>
       <div class="col-md-9">
       <%--  <form:input path="recpPrepa" cssClass="form-control" /> --%>
       <form:textarea path="recpPrepa" rows="10" cols="50" />
       </div>
      </div>
      <div class="form-group">
       <label for="recpIng" class="col-md-3 control-label">Ingredients</label>
       <div class="col-md-9">
       <%--  <form:input path="recpIng" cssClass="form-control" /> --%>
       <form:textarea path="recpIng" rows="10" cols="50" />
       </div>
      </div>
      
      <div class="form-group">
       <!-- Button -->
       <div class="col-md-offset-3 col-md-9">
        <form:button cssClass="btn btn-primary">Submit</form:button>
       </div>
      </div>

     </form:form>
    </div>
   </div>
  </div>
 </div>
</body>
</body>
</html>