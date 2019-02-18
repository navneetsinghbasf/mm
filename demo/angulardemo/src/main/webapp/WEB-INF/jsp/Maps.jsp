<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
/* Set the width of the side navigation to 250px */
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
}

/* Set the width of the side navigation to 0 */
function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}
</script>
	
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/ng-dialog/1.4.0/js/ngDialog.min.js"></script>
	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/ng-dialog/1.4.0/css/ngDialog.css"></script>	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/ng-dialog/1.4.0/css/ngDialog-theme-default.css"></script> -->

	<!-- <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script> -->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDtwLGMk2mRH8pFkhJrRtJ0lTyT0PokK4Q"></script>
	<!-- <script src="js/googlemaps.js"></script> -->
	<script src="js/script.js"></script>

	
<head>
   
    <link href="css/custom.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ng-dialog/1.0.1/css/ngDialog.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ng-dialog/1.0.1/css/ngDialog-theme-default.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	
    <title>Map example</title>
    
</head>

<body >
	
	
	

    

    

  	<div id="pageheader" ng-app="map-example" ng-controller="MapController">
  	<div align="left" id="mySidenav" class="sidenav">
	  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
	  <a href="/maps">LIVE Location</a>
	  <a href="" data-ng-click="geoFence()">Geo-Fence</a>
	  <a href="/history">Trip History</a>
	  <a href="/conf">Configure Vehicle</a>
	  <a href="/behavior">Driver Behavior</a>
	</div>
	
	<!-- Use any element to open the sidenav -->
	<span span style="float:left;font-size:30px;cursor:pointer" onclick="openNav()">&#9776;Menu</span>
  	
  	
  			</br>
  			<div class="left-aligned" align="left">
  			<p >Please select the vehicle</p>
  		    <select align="left" name="cars"  ng-change="setLocation()" ng-model="vehicle" >
  		    <option value="" selected disabled hidden>Choose here</option>
			    <option value="AP16AK4834">Fiat 500X Trekking Plus</option>
			    <option value="AP16AK4834">Fiat 124 Spider Lusso</option>
		  	</select>
  			</div>
  			
		  	<div class="right-aligned" align="right">
		  	<i class="material-icons" style="font-size:48px;color:red;align:right" ng-click="clickToOpen()">add_alert</i>
		  	</div>
		  	
		  	<!-- <button ng-click="clickToOpen()">Alerts</button> -->
    

		  	
		  	

		  	
		  	
  	</div>
    <div id="map" ></div>
    

    


</body>

</html>