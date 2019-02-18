package org.tcs.fca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tcs.fca.service.vehConfigService;
import org.tcs.fca.vo.vehConfig;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/config")
public class VehicleRestController {
	
	

@Autowired
private vehConfigService vehConfigService;
 
 public void setvehicleService(vehConfigService vehConfigService) {
	  this.vehConfigService = vehConfigService;
	 }

 
 @GetMapping("/{vehicle}")
 public vehConfig getVehicle(@PathVariable String vehName) {
	  vehConfig vehicle = vehConfigService.retrieveVehicle(vehName);
	  System.out.println("Hello vehicle");
	  if (vehicle == null) 
	  {
		//  logger.error("User with vehName {} not found", vehName);
		   
      //  return new ResponseEntity(new CustomErrorType("User with vehName " + vehName 
	//       + " not found"), HttpStatus.NOT_FOUND);
	  }
	  return vehicle;
 }
 
 	
	
/* @GetMapping(value = "vehicle/{name}")
 public List<vehConfig> findByName(@PathVariable String name) 
 { 
	List<vehConfig> vehicles = repository.findByName(name);
	return vehicles;
 }*/
 
 /*private vehConfigService vehConfigService;
 
 public void setvehicleService(vehConfigService vehConfigService) {
  this.vehConfigService = vehConfigService;
 }

 @GetMapping("/api/vehicle")
 public List<vehConfig> getVehicles() {
  List<vehConfig> vehicles = vehConfigService.retrieveVehicles();
  return vehicles;
 }*/
 
  
 /*@PostMapping("/api/employees")
 public void saveEmployee(Employee employee){
  employeeService.saveEmployee(employee);
  System.out.println("Employee Saved Successfully");
 }
 
 @DeleteMapping("/api/employees/{employeeId}")
 public void deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
  employeeService.deleteEmployee(employeeId);
  System.out.println("Employee Deleted Successfully");
 }
 
 @PutMapping("/api/employees/{employeeId}")
 public void updateEmployee(@RequestBody Employee employee,
   @PathVariable(name="employeeId")Long employeeId){
  Employee emp = employeeService.getEmployee(employeeId);
  if(emp != null){
   employeeService.updateEmployee(employee);
  }
  
 }*/

}


