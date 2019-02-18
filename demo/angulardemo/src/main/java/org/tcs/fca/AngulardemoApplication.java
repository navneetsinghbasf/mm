package org.tcs.fca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tcs.fca.service.VehicleAlertService;
import org.tcs.fca.service.VehicleService;
import org.tcs.fca.vo.VehicleAlertsVO;
import org.tcs.fca.vo.VehicleVO;
@Controller
@SpringBootApplication
public class AngulardemoApplication {
	
	@Autowired
	VehicleService service;
	
	@Autowired
	VehicleAlertService alertService;
 
	public static void main(String[] args) {
		SpringApplication.run(AngulardemoApplication.class, args);
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "Welcome";
	}
	
	@RequestMapping("/maps")
	public String showMap() {
		return "Maps";
	}
	
	@RequestMapping("/alert")
	public String showAlert() {
		return "Alert";
	}
	
	@RequestMapping("/behavior")
	public String getHomePage() {
		String view = "behavior";
		return view;
	}
	
	@RequestMapping("/conf")
	public String getConfigPage() {
		String view = "config";
		return view;
	}
	
	@RequestMapping("/vehicles/{vehicle_id}")
	@ResponseBody
	public VehicleVO getVehicleDetails(@PathVariable String vehicle_id) {
		VehicleVO fetchVehicleCurrentLocation = service.fetchVehicleCurrentLocation(vehicle_id);
		return fetchVehicleCurrentLocation;
	}
	
	@RequestMapping("/alerts/{vehicle_id}")
	@ResponseBody
	public VehicleAlertsVO getVehicleAlertDetails(@PathVariable String vehicle_id) {
		VehicleAlertsVO fetchVehicleAlerts = alertService.fetchVehicleAlerts(vehicle_id);
		return fetchVehicleAlerts;
	}
	
	@RequestMapping("/history")
	public String getVehicleHistory() {
		String view = "history";
		return view;
	}
	
}
