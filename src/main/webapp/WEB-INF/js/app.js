var App = angular.module('myApp',['ngRoute']);

app.controller('HomeController', function($scope){
	$scope.message = 'Hello from HomeController';
});

app.config(function($routeProvider){
	$routeProvider
	
	.when('/', {
		templateUrl : 'home.jsp',
		controller : 'homecontroller'
	})
	
	.when('/blog',{
	    templateUrl : 'blog.jsp',
	    controller : 'blogcontroller'
	})
	
	



	 
	
