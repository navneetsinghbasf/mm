package org.tcs.fca.service;
import org.tcs.fca.vo.vehConfig;


public interface vehConfigService {
	
	public  vehConfig retrieveVehicle(String name);  
	
	
	 public void saveVehicle(vehConfig vehicle);
	 
	 public void deleteVehicle(Long vehicle);
	 
	 public void updateVehicle(vehConfig vehicle);

}
