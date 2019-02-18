package org.tcs.fca.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.tcs.fca.vo.VehicleAlertsVO;
import org.tcs.fca.vo.VehicleVO;

@Repository
public interface VehicleAlertRepository extends JpaRepository<VehicleVO, Long> {
	
	@Query("select alert from VehicleVO vehicle, VehicleAlertsVO alert where alert.vehicleDetails.vehicleId = vehicle.vehicleId and vehicle.vehicleNumber = :vechicleNumber")
				public VehicleAlertsVO find(@Param("vechicleNumber") String vechicleNumber); 


}
