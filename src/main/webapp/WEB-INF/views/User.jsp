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
      <script src="<c:url value='/js/app.js' />"></script>
      <script src="<c:url value='/js/service/user_service.js' />"></script>
      <script src="<c:url value='/js/controller/user_controller.js' />"></script>
</head>
<body ng-app="myApp">
<div class = "generic-container" ng-controller="UserController as ctrl">
<div class = "panel panel-default">
  <div class = "panel heading"><span class="lead">User Registration Form</span></div>
  <div class = "formcontainer">
   <form ng-submit="ctrl.submit()" name="myForm" class = "form-horizontal">
     <input type="hidden" ng-model="ctrl.userid" />
     <div class = "row">
     <div class = "form-group col-md-12">
     <label class = "col-md-2 control-label" for ="file">Name</label>
     <div class = "col-md-7">
     <input type = "text" ng-model="ctrl.user.username" name="uname" class ="username form-control input-sm" placeholder = "Enter your name here"/>
   </div>
   </div>
   </div>
   <div>
   </div>
   <div class = "row">
   <div class = "form actions floatright">
   <input type = "submit" value ="{{!cntrl.user.id ? 'Add' : 'Update'}}" class = "btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
   <button type = "button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
    </div>
    </div>
    </form>
</div>

</body>
</html>