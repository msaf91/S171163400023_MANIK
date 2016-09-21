
<html ng-app>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>

angular.module('myApp')
.factory('Userservice',['$http', '$q', function($http,$q)
 {
	var REST_SERVICE_URI = "http://localhost:8080/com.niit.cars/User/";
	var factory = {
			fetchAllUser: fetchAllUsers,
			createUser: createUser,
			
	};
	
	return factory;
	
	function fetchAllUsers(){
		var deferred = $q.defer();
		$http.get(REST_SERVICE_URI)
		.then(
		function(response){
			deferred.resolve(response.data);
		},
		function(errResponse){
			console.error('Error while fetching Users');
			deferred.reject(errResponse);
		}
    	);
		return deferred.promise;
	}
	
	function createUser(user){
		var deferred = $q.defer();
		$http.post(REST_SERVICE_URI,user)
		   .then(
			function(response){
				deferred.resolve(response.data);
			},
			function(errResponse){
				console.error('Error while creating User');
				deferred.reject(errResponse);
			}
		   );
		return deferred.promise;
	}
	
	
 }                                              
  ])};