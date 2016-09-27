<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User Registration</title>
<style>
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      
</head>
<body>
     <nav class="navbar -navbar-inverse navbar-fixed-top">
       <div class="container-fluid">
         <div class="navbar-header">
         <a class="navbar-brand" href="#">Blog</a>
         </div>
         <div>
         <ul class="nav navbar-nav">
            <li class="active"><a href="#/">Home</a></li>
            <li><a href="#/jobopportunities">Job Opportunities</a></li>
             <li><a href="#/Home">Home</a></li>
             <li><a href="#/About us">About us</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
             <li><a href="#/register"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
             <li><a href="#/Login"><span class="glyphicon glyphicon-user"></span>Login</a></li>
             </ul>
             </div>
             </nav>
             
      <script src="<c:url value='/WEB-INF/js/app.js' />"></script>
      <script src="<c:url value='/WEB-INF/js/userservice.js' />"></script>
      <script src="<c:url value='/WEB-INF/js/usercontroller.js' />"></script>
      <script src="<c:url value='/WEB-INF/js/homecontroller.js' />"></script>       
             