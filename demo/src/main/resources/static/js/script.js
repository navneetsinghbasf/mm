var myapp = angular.module('map-example', ['ngDialog']);


myapp.controller('MapController', function($scope, $rootScope, $compile, $window,$http,ngDialog) {
    	 
    	
        function initialize() {

            $scope.map = new google.maps.Map(document.getElementById('map'), {
                zoom: 12,
                center: { lat: 12.9716, lng: 77.5946 }
            });

            var image = 'http://maps.google.com/mapfiles/kml/pal2/icon39.png';

            $scope.cities = [
                { title: 'KA1MG1892', lat: $scope.latitude, lng: $scope.longitude },
                /*{ title: 'Mysore', lat: 12.2958, lng: 76.6394 }*/
            ];


            $scope.infowindow = new google.maps.InfoWindow({
                content: ''
            });
            


            for (var i = 0; i < $scope.cities.length; i++) {


                var marker = new google.maps.Marker({
                    position: new google.maps.LatLng($scope.cities[i].lat, $scope.cities[i].lng),
                    map: $scope.map,
                    title: $scope.cities[i].title,
                    icon: image
                });
                
                

                var content = '<a ng-click="cityDetail(' + i + ')" class="btn btn-default">View details</a>';
                var compiledContent = $compile(content)($scope)

                google.maps.event.addListener(marker, 'click', (function(marker, content, scope) {
                    return function() {
                        scope.infowindow.setContent(content);
                        scope.infowindow.open(scope.map, marker);
                    };
                })(marker, compiledContent[0], $scope));

            }

        }

        $scope.cityDetail = function(index) {
            alert(JSON.stringify($scope.cities[index]));
        }

        google.maps.event.addDomListener(window, 'load', initialize);
        
        //setting live location
        $scope.setLocation = function() {
        	
        	$http.get('http://localhost:8080/vehicles/' + $scope.vehicle).
            then(function(response) {
            	$scope.results = response.data;
            	$scope.latitude=$scope.results.currentLatitue;
            	$scope.longitude=$scope.results.currentLongitude;
            	initialize();
            	
            },function (failure) { console.log("failed :", failure); });
        	
        	/*$http.get('/vehicles/' + $scope.vehicle).then
               function (response) { 
        		$scope.results = response; 
        		alert($scope.results.currentLatitue);
        		},
               function (failure) { console.log("failed :(", failure); });*/

        	/*alert($scope.results.currentLatitue);
        	alert($scope.results.currentLongitude)*/;
        	
        }
        
        //Geo-Fence
        $scope.geoFence = function(){
        	$scope.map = new google.maps.Map(document.getElementById('map'), {
                zoom: 10,
                center: { lat: 12.93, lng: 77.59 }
            });



            $scope.cities = [
                { title: 'KA1MG1892', lat: $scope.latitude, lng: $scope.longitude },
                /*{ title: 'Mysore', lat: 12.2958, lng: 76.6394 }*/
            ];


            $scope.infowindow = new google.maps.InfoWindow({
                content: ''
            });
            


            for (var i = 0; i < $scope.cities.length; i++) {
            	var latLng = new google.maps.LatLng($scope.cities[i].lat, $scope.cities[i].lng);

                var marker = new google.maps.Marker({
                    position: new google.maps.LatLng($scope.cities[i].lat, $scope.cities[i].lng),
                    map: $scope.map,
                    title: $scope.cities[i].title
                });
                
                var circle = new google.maps.Circle({
                	  map: $scope.map,
                	  radius: 16093,    // 10 miles in metres
                	  fillColor: '#ffff00',
                	  fillOpacity: 0.2,
                      strokeWeight: 3,
                      clickable: true,
                      draggable : true,
                      editable: true,
                      zIndex: 1
                	});
                	circle.bindTo('center', marker, 'position');

                var content = '<a ng-click="cityDetail(' + i + ')" class="btn btn-default">View details</a>';
                var compiledContent = $compile(content)($scope)

                google.maps.event.addListener(marker, 'click', (function(marker, content, scope) {
                    return function() {
                        scope.infowindow.setContent(content);
                        scope.infowindow.open(scope.map, marker);
                    };
                })(marker, compiledContent[0], $scope));
                
               

            }
        	
        	
        	
        }
        
        $scope.clickToOpen = function () {
        	
        	var fuel;var speed;var arealimit;var seatbelt;var parkBreak;var crash;
        	$http.get('http://localhost:8080/alerts/' + $scope.vehicle).
            then(function(response) {
            	$scope.results = response.data;
            	
            	
            	 $scope.fuel = $scope.results.lowFuel;
            	 $scope.speed = $scope.results.speedLimit;
            	 $scope.arealimit = $scope.results.areaLimit;
            	 $scope.seatbelt = $scope.results.seatBelt;
            	 $scope.parkBreak = $scope.results.parkingBreak;
            	 $scope.crash = $scope.results.crashDetection;
            	
            	//initialize();
            	
            });
        	
        	//$scope.normalMessage = "This is simple ng Dialog"
        	ngDialog.open({ 
            	template: '/alert',
                className: 'ngdialog-theme-default',
                scope: $scope,
            		});
        };
        
        $scope.OpenPopupWindow = function () {
            $window.open("/alert", "popup", "width=300,height=200,left=10,top=150");
        }
        
        function tt($scope)
        {
            $scope.test = function()
            {
                console.log("AaA");
            }
        }
        
        //Alerts
        $scope.init = function () {
        	
        	if ($scope.fuel == "Y") {
        		$scope.fuel = {"background-color" : "red"};
            } 
        	if ($scope.speed == "Y") {
        		$scope.speed = {"background-color" : "red"};
            } 
        	if ($scope.arealimit == "Y") {
        		$scope.arealimit = {"background-color" : "red"};
            } 
        	if ($scope.seatbelt == "Y") {
        		$scope.seatbelt = {"background-color" : "red"};
            } 
        	if ($scope.parkBreak == "Y") {
        		$scope.parkBreak = {"background-color" : "red"};
            } 
        	if ($scope.crash == "Y") {
        		$scope.crash = {"background-color" : "red"};
            } 
        	};
        	
        

    });



myapp.controller('historyController', function($scope,$compile) {
	 
	
    	/*$scope.initMap = function() {
    		alert('Init Map');
            $scope.map = new google.maps.Map(document.getElementById('historymap'), {
              zoom: 10,
              center: {lat: 12.93, lng: 77.59},
              mapTypeId: 'roadmap'
            });
            
            var flightPlanCoordinates = [
                {lat: 12.9275, lng: 77.6810},
  	    	  {lat: 12.9302, lng: 77.6843},
  	    	  {lat: 12.9334, lng: 77.6914},
  	    	  {lat: 12.9420, lng: 77.6940},
  	    	  {lat: 12.9569, lng: 77.7008},
  	    	  {lat: 12.9906, lng: 77.7277}
              ];
              flightPath = new google.maps.Polyline({
                path: flightPlanCoordinates,
                geodesic: true,
                strokeColor: '#FF0000',
                strokeOpacity: 1.0,
                strokeWeight: 2,
                map : $scope.map
              });
              
              alert(flightPlanCoordinates[0].lat+' '+flightPlanCoordinates[0].lng);
              alert(flightPlanCoordinates[flightPlanCoordinates.length-1].lat);
              
              //marking start and end
              $scope.cities = [
                  { title: 'KA1MG1892 Start', lat: flightPlanCoordinates[0].lat, lng: flightPlanCoordinates[0].lng },
                  { title: 'KA1MG1892 End', lat: flightPlanCoordinates[flightPlanCoordinates.length-1].lat, lng: flightPlanCoordinates[flightPlanCoordinates.length-1].lng },
                  { title: 'Mysore', lat: 12.2958, lng: 76.6394 }
              ];


              $scope.infowindow = new google.maps.InfoWindow({
                  content: ''
              });
              


              for (var i = 0; i < $scope.cities.length; i++) {


                  var marker = new google.maps.Marker({
                      position: new google.maps.LatLng($scope.cities[i].lat, $scope.cities[i].lng),
                      map: $scope.map,
                      title: $scope.cities[i].title
                  });
                  
                  

                  var content = '<a ng-click="cityDetail(' + i + ')" class="btn btn-default">View details</a>';
                  var compiledContent = $compile(content)($scope)

                  google.maps.event.addListener(marker, 'click', (function(marker, content, scope) {
                      return function() {
                          scope.infowindow.setContent(content);
                          scope.infowindow.open(scope.map, marker);
                      };
                  })(marker, compiledContent[0], $scope));

              }

          

              flightPath.setMap($scope.map);
            
            
        };*/
	
	$scope.initMap = function() {
		var directionsService = new google.maps.DirectionsService;
		var directionsService2 = new google.maps.DirectionsService;
        var directionsDisplay = new google.maps.DirectionsRenderer;
        var directionsDisplay2 = new google.maps.DirectionsRenderer;
        var start = new google.maps.LatLng(12.9275, 77.6810);
        var end = new google.maps.LatLng(12.9906, 77.7277);
        
        var waypts=[];
        var wayptArray = [
        	new google.maps.LatLng(12.9302, 77.6843),
        	new google.maps.LatLng(12.9334, 77.6914),
        	new google.maps.LatLng(12.9420, 77.6940),
        	new google.maps.LatLng(12.9569, 77.7008),
          ];
        /*for (var i = 0; i < wayptArray.length; i++) {
              waypts.push({
                location: wayptArray[i],
                stopover: false
              });
            
          }*/
        $scope.map = new google.maps.Map(document.getElementById('historymap'), {
          zoom: 4,
          center: {lat: 12.95, lng: 77.69}
        });
        directionsDisplay.setMap($scope.map);
        directionsDisplay2.setMap($scope.map);
        
        var request = {
            origin: start,
            destination: end,
            waypoints: waypts,
            travelMode: google.maps.DirectionsTravelMode.DRIVING
          };
       directionsService.route(request, function (response, status) {
          if (status == google.maps.DirectionsStatus.OK) {
            directionsDisplay.setDirections(response);
          }
        });

        
        /*Request two*/
       var request2 = {
               origin: new google.maps.LatLng(12.9610, 77.6387),
               destination: new google.maps.LatLng(12.9690, 77.7209),
               waypoints: waypts,
               travelMode: google.maps.DirectionsTravelMode.DRIVING
             };
          directionsService2.route(request2, function (response, status) {
             if (status == google.maps.DirectionsStatus.OK) {
               directionsDisplay2.setDirections(response);
             }
           });
	};



         google.maps.event.addDomListener(window, 'load', $scope.initMap());

});




