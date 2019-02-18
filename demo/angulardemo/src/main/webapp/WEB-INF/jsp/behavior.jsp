<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to MMPoc</title>
<head>
<!-- <link rel="stylesheet" href="css/bootstrap.min.css">
 -->
	<!-- Including AngularJS -->
    <!-- <script type="text/javascript" src=" https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.2/angular.min.js"></script>  
    
    <!-- Including the fusioncharts core library -->
    <!-- <script type="text/javascript" src=" https://cdn.fusioncharts.com/fusioncharts/latest/fusioncharts.js"></script> 
    <script type="text/javascript" src=" https://unpkg.com/angularjs-fusioncharts@4.0.1/dist/angular-fusioncharts.js"></script> 
    <script type="text/javascript" src=" https://cdn.fusioncharts.com/fusioncharts/latest/themes/fusioncharts.theme.fusion.js"></script> -->
    
    <script type="text/javascript" src="js/angular/angular.min.js"></script>
    <script type="text/javascript" src="js/fusioncharts/angular-fusioncharts.js"></script>
    <script type="text/javascript" src="js/fusioncharts/fusioncharts.js"></script>
    <script type="text/javascript" src="js/fusioncharts/fusioncharts.theme.fusion.js"></script>
    <script type="text/javascript" src="js/mm/vehicleBehavior.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    
    
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href="css/custom.css" rel="stylesheet" type="text/css">
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
 
 
 </head>

</head>
<body>
	<!-- <h1>Welcome</h1> -->
	
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
	<br/><br/><br/>
	<div ng-app="behaviorApp" ng-controller="behaviorController">
		<div>
			<p>Select one vehicle number</p>
			<select ng-model="vehicleNumber" ng-options="x for x in vehicleNumbers"></select>
			<input type="button" value="Get Details" ng-click="getDeatils()" />
		</div>
        <div id="graph_div_id" ng-show="myValue">
	        <section class="section mt-5">
	        	<div class="container-fluid">
		        	<div class="row">
			        	<div class="col-sm-5">
			        		<p> Total Idle Hours</p>
			        		<fusioncharts id="idle-time" width="400" height="250" type="line" dataSource="{{idleTimeDataSource}}"></fusioncharts>
			        	</div>
		        	
			        	<div class="col-sm-5">
			        		<p> Total Speed events Over 75 Kph</p>
			        		<fusioncharts  id="over-speed" width="400" height="250" type="line" dataSource="{{overSpeedEventsDataSource}}">></fusioncharts>
			        	</div>
		        	</div>
	        	</div>
	        </section>
	        
	        <section class="section mt-5">
	        	<div class="container-fluid">
	        		<div class="row">
			        	<div class="col-sm-5">
			        		<p> Daily Fuel Consumed </p>
			        		<fusioncharts id="daily-fuel-consumed" width="400" height="250" type="line" dataSource="{{fuelConsumedDataSource}}"></fusioncharts>
			        	</div>
	        	
			        	<div class="col-sm-5">
			        		<p> Ignition On/Off Status</p>
			        		<fusioncharts  id="ignition-on-off" width="400" height="250" type="line" dataSource="{{ignitionOnOffDataSource}}">></fusioncharts>
			        	</div>
	        		</div>
	        	</div>
	        </section>
        </div>
	</div>
</body>
</html>