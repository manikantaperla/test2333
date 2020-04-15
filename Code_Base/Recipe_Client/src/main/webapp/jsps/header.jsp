<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="appPath" value="${pageContext.request.contextPath}"/>
<%
	String contextPath = request.getContextPath();
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href='<%=contextPath+"/css/bootstrap.min.css" %>' rel="stylesheet">
<link href='<%=contextPath+"/css/font-awesome.min.css" %>' rel="stylesheet">
<link href='<%=contextPath+"/css/customer.css" %>' rel="stylesheet">
</head>
<body>
<!--  <div class="navbar navbar-inverse navbar-fixed-left"> -->
 <!--     <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
    
        <li ><a href="#">Recipes</a></li>
      </ul>
      
    </div>
  </div>
  </div> -->