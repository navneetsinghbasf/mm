package org.tcs.fca.repo;

import org.tcs.fca.vo.VehicleVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleVO, Long> {
	public VehicleVO findVehicleByVehicleNumber(String vehicleNumber);
}