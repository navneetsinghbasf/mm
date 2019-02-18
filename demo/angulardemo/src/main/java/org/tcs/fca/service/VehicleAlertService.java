package org.tcs.fca.service;

import org.tcs.fca.vo.VehicleAlertsVO;

public interface VehicleAlertService {
	public VehicleAlertsVO fetchVehicleAlerts(String vehicleNumber);
}
