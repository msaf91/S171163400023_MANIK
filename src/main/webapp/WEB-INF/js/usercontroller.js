angular.module('myApp').controller('UserContoller',['$scope','Userservice', function($scope, Userservice){
	
	var self=this;
	self.user={id:null, username:'', address:'', email:''};
	self.users=[];
	
	self.submit = submit;
	self.reset = reset;
	
	function fetchAllUsers(){
		Userservice.fetchAllUsers()
		   .then(
		function(d){
			self.users=d;
		},
		function(errResponse){
			console.error('Error while fetching Users');
		}
		);
		
	}
	
	function createUser(){
		Userservice.createUser(user)
		  .then(
		fetchAllUsers,
		function(errResponse){
			console.error('Error while creating User');
		}
		  );
		
	}
	
	
	
	
	
	
}]);