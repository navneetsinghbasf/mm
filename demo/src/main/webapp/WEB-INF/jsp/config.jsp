<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check Box Test</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.js"></script>
<script src="js/show_details.js"></script>
<script src="js/jquery.min.js"></script>
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
<body >
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

<div ng-app="vehicleConf" ng-controller="configController">
<p >Please select the vehicle</p>
  <div class="left-aligned" align="Left">
  <select ng-change="showDetails()" ng-model="configVehicle">
      <option   value="Vehicle1">Vehicle1</option>
      <option   value="Vehicle2">Vehicle2</option>
      <option   value="Vehicle3">Vehicle3</option>
      <option   value="Vehicle4">Vehicle4</option>
    </select>   
    </div>


<table align="Center" >

<tr>
<td>Registered Mobile Number:</td>
<td><input type="text" ng_model="mobNo" /></td>
</tr>
<tr>
<td>Speed Configuration:</td>
<td><input type="text" ng_model="speed" id="spd" /></td>
</tr>
 <tr>
<td>Parking Break Alert:</td>
<td><select ng_model="brkAlrt" id="brkid" >
<option value="brkalr1">Enable</option>
<option value="brkalr2">Disable</option></td>
</tr>
<tr>
<td>Seat Belt Alert:</td>
<td><select ng_model="setAlrt" id="seatid" >
<option value="satalr1">Enable</option>
<option value="satalr2">Disable</option></td>
</tr>
<tr>
<td>Near By:</td>
<td><select ng_model="nerAlrt" id="nerby" >
<option value="nerby1">Enable</option>
<option value="nerby2">Disable</option></td>
</tr>
<tr>
<td>Driving History:</td>
<td><input type="text" ng_model="drvHstDate" /></td>
<td>Date</td>
</tr>

<tr></tr>
<tr>
<td></td>
<td><input type="submit" value="Save" ng-click="saveConfDetails()"></td>
</tr>
</table>
</div>
</body>
</html>