'use strict';

angular.module('myApp').factory('Userservice', ['$http', '$q', function($http, $q){
	
	var REST_SERVICE_URI = 'http://localhost:8080/com.niit.cars/user/';
	
	var factory = {
	  fetchAllUsers: fetchAllUsers,
	  createUser: createUser,
	};
	
	return factory;
	
	function fetchAllUsers(){
		var deferred =$q.defer();
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
			
	function createUser(){
		var deferred = $q.defer();
		$http.post(REST_SERVICE_URI, user)
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
}]);