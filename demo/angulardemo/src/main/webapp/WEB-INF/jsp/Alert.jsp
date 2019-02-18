<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="js/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.js"></script>
<script src="js/script.js"></script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<div class="alert-header">
  <h3>Alerts</h3>
</div>
</head>
<body onload="load();">
<div class="target" ng-app="map-example" ng-controller="MapController" data-ng-init="init()" >
  <p ng-style="fuel" id="fuel">Low Fuel</p>
  <p ng-style="speed">Speed Limit</p>
  <p ng-style="arealimit">Area Limit</p>
  <p ng-style="seatbelt">Seat Belt</p>
  <p ng-style="parkBreak">Parking Break</p>
  <p ng-style="crash">Crash Detection</p>
</div>
<!-- <div>{{normalMessage}}</div> -->
</body>
</html>