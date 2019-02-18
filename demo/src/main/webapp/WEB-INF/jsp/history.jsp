<!DOCTYPE html>
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
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDtwLGMk2mRH8pFkhJrRtJ0lTyT0PokK4Q"></script>
	<script src="js/script.js"></script>
  <head>
    <link href="css/custom.css" rel="stylesheet" type="text/css">
 	<style>
 	#historymap {
 	padding:20px;
    height:720px;
    width:1100px;
	}	
 	
 	</style>
    <title>Driver History</title>
  </head>
  <body>
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
		</br></br>
  <div  ng-app="map-example" ng-controller="historyController">
    <div id="historymap" data-ng-int="initMap()"></div>
  </div>
   
  </body>
</html>