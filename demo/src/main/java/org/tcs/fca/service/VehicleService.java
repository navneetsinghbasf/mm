package org.tcs.fca.service;

import org.tcs.fca.vo.VehicleVO;

public interface VehicleService {

	public VehicleVO fetchVehicleCurrentLocation(String vehicleNumber);
}
