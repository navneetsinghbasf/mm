var app = angular.module('vehicleConf', [])
        app.controller('configController', function($scope,$http) {
           $scope.showDetails = function() {
        	    vehKey = $scope.configVehicle;

        	    
        	        alert('veh1'); 
        	       
        	        $http.get("http://localhost:8080/findbyvehName?vehName="+vehKey)
        	        .success(function(response)
        	          {
        	        	console.log(response);
        	        	alert(response.nearAlrt);
        	        	$scope.speed = response.speed;
        	        	$scope.mobNo = response.mobNo;
        	        	$scope.drvHstDate = response.drvHstDate;
        	        	$scope.brkAlrt = response.brkAlrt == 'Enable' ? 'brkalr1' : 'brkalr2';
        	        	$scope.setAlrt = response.seatAlrt == 'Enable' ? 'satalr1' : 'satalr2';
        	        	$scope.nerAlrt = response.nearAlrt == 'Enable' ? 'nerby1' : 'nerby2';
        	          }	        	      
        	        )
        	        .error(function(response)
        	          {
        	        	console.log(response);
        	        	$scope.vehArr = {};
        	          }
        	        );
        	  }
           
           $scope.saveConfDetails = function() {
        	   
        	   var data = {
        			 speed : $scope.speed,
        			 mobNo : $scope.mobNo,
        			 drvHstDate : $scope.drvHstDate,
        			 brkAlrt : $scope.brkAlrt == 'brkalr1' ? 'Enable' : 'Disable',
        			 seatAlrt : $scope.setAlrt == 'satalr1' ? 'Enable' : 'Disable',
        			 nearAlrt : $scope.nerAlrt == 'nerby1' ? 'Enable' : 'Disable',
       	        	vehName : $scope.configVehicle
        			   };
        	   alert($scope.configVehicle);
        	   $http.put('http://localhost:8080/saveConfig',JSON.stringify(data)).
               then(function(response) {
               	alert(response.status);
               });
           }
           
        	});