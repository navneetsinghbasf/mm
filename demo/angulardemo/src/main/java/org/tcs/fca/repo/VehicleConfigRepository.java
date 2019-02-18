package org.tcs.fca.repo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.tcs.fca.vo.vehConfig;


@Repository
public interface VehicleConfigRepository extends CrudRepository<vehConfig,String>
{	
		
    vehConfig findByvehName(String vehName); 
    
}
