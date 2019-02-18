package org.tcs.fca.service.impl;

import org.tcs.fca.repo.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tcs.fca.service.VehicleService;
import org.tcs.fca.vo.VehicleVO;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepo;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public VehicleVO fetchVehicleCurrentLocation(String vehicleNumber) {
		logger.info("Fetching the current location for the vehicle number"+ vehicleNumber);
		VehicleVO findVehicleByVehicleNumber = vehicleRepo.findVehicleByVehicleNumber(vehicleNumber);
		logger.info("Current location for the vehicle number"+ vehicleNumber+ " is"+ findVehicleByVehicleNumber);
		return findVehicleByVehicleNumber;
	}
}
