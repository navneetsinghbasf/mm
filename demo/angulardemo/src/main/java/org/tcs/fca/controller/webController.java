package org.tcs.fca.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tcs.fca.repo.VehicleConfigRepository;
import org.tcs.fca.vo.vehConfig;



@RestController
public class webController {
	@Autowired
	VehicleConfigRepository repository;
	
	@RequestMapping("/save")
    public String process(){
        repository.save(new vehConfig("Vehicle1" ,"9003104679", "30KM" , "Enable" , "Enable" ,"Enable", "2018-10-12"));
        repository.save(new vehConfig("Vehicle2" ,"9003134679", "32KM" , "Enable" , "Enable" ,"Enable", "2018-12-12"));
        repository.save(new vehConfig("Vehicle3" ,"9003124679", "33KM" , "Enable" , "Enable" ,"Enable", "2018-11-12"));
        repository.save(new vehConfig("Vehicle4" ,"9003134679", "35KM" , "Enable" , "Enable" ,"Enable", "2018-10-13"));
        
        return "Done";
    }
       
       
    @RequestMapping("/findall")
    public String findAll(){
        String result = "";
           
        for(vehConfig veh : repository.findAll()){
            result += veh.toString() + "</br>";
        }
           
        return result;
    }
       
    
    @RequestMapping("/findbyvehName")
    public vehConfig fetchDataByLastName(@RequestParam("vehName") String vehName){
           
        vehConfig veh= repository.findByvehName(vehName);
        System.out.println("----------->"+veh);
            System.out.println("******");
            return veh;
    }
    
    @PutMapping("/saveConfig")
    public ResponseEntity<Object> saveConfigData(@RequestBody vehConfig veh) {
    	System.out.println(veh);
    	repository.save(veh);
		return ResponseEntity.status(HttpStatus.OK).build();
    }

}
