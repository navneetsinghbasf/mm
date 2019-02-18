package org.tcs.fca.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tcs.fca.repo.VehicleConfigRepository;
import org.tcs.fca.service.vehConfigService;
import org.tcs.fca.vo.vehConfig;

@Service
public class vehicleInterImpl implements vehConfigService
{
	@Autowired
	 private VehicleConfigRepository vehicRepository;


	public vehConfig retrieveVehicle(String vehName)
	{
	  vehConfig vehicle = vehicRepository.findByvehName(vehName);
	  return vehicle;
	}
	 
	 
	 
	 public void saveVehicle(vehConfig vehicle)
	 {
		 
	 }
	 
	 public void deleteVehicle(Long vehicle)
	 {
		 
	 }
	 
	 public void updateVehicle(vehConfig vehicle)
	 {
		 
	 }
}
