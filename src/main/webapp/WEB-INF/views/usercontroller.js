angular.module('myApp').controller('UserController',['$scope', 'Userservice', function($scope, Userservice){
   var self = this;
   self.user = {id:null, username:'', address:'', email:''}
   self.users = [];
   
   self.submit = submit;
   self.reset = reset;
   
   fetchAllUsers();
   
   function fetchAllUsers(){
     Userservice.fetchAllUsers()
     .then(
     function(d) {
       self.users = d;     
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
    
    function submit() {
      if(self.user.id==null){
        console.log('Saving new User', self.user);
        createuser(self.user);
      }else
      {
       updateUser(self.user, self.user.id);
       console.log('User updated with id ', self.user.id);      
      }
      reset();
    }    
    
    function reset(){ 
      self.user={id:null, username:'',email:'', address:''};
      $scope.myForm.$setPristine(); //Set Form
    }
   


}]);