package org.tcs.fca.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "vehicle_alert_details")
public class VehicleAlertsVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_alert_id")
	private long alertId;

	@Column(name = "low_fuel_flag")
	private String lowFuel;

	@Column(name = "speed_limit")
	private String speedLimit;

	@Column(name = "area_limit")
	private String areaLimit;

	@Column(name = "seat_belt")
	private String seatBelt;

	@Column(name = "parking_break")
	private String parkingBreak;

	@Column(name = "crash_detection")
	private String crashDetection;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vehicle_id")
	@JsonIgnore
	private VehicleVO vehicleDetails;

	public VehicleAlertsVO(long alertId, String lowFuel, String speedLimit, String areaLimit, String seatBelt,
			String parkingBreak, String crashDetection, VehicleVO vehicleDetails) {
		super();
		this.alertId = alertId;
		this.lowFuel = lowFuel;
		this.speedLimit = speedLimit;
		this.areaLimit = areaLimit;
		this.seatBelt = seatBelt;
		this.parkingBreak = parkingBreak;
		this.crashDetection = crashDetection;
		this.vehicleDetails = vehicleDetails;
	}
	
	public VehicleAlertsVO() {super();}

	public long getAlertId() {
		return alertId;
	}

	public void setAlertId(long alertId) {
		this.alertId = alertId;
	}

	public String getLowFuel() {
		return lowFuel;
	}

	public void setLowFuel(String lowFuel) {
		this.lowFuel = lowFuel;
	}

	public String getSpeedLimit() {
		return speedLimit;
	}

	public void setSpeedLimit(String speedLimit) {
		this.speedLimit = speedLimit;
	}

	public String getAreaLimit() {
		return areaLimit;
	}

	public void setAreaLimit(String areaLimit) {
		this.areaLimit = areaLimit;
	}

	public String getSeatBelt() {
		return seatBelt;
	}

	public void setSeatBelt(String seatBelt) {
		this.seatBelt = seatBelt;
	}

	public String getParkingBreak() {
		return parkingBreak;
	}

	public void setParkingBreak(String parkingBreak) {
		this.parkingBreak = parkingBreak;
	}

	public String getCrashDetection() {
		return crashDetection;
	}

	public void setCrashDetection(String crashDetection) {
		this.crashDetection = crashDetection;
	}

	public VehicleVO getVehicleDetails() {
		return vehicleDetails;
	}

	public void setVehicleDetails(VehicleVO vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}

	@Override
	public String toString() {
		return "VehicleAlertsVO [alertId=" + alertId + ", lowFuel=" + lowFuel + ", speedLimit=" + speedLimit
				+ ", areaLimit=" + areaLimit + ", seatBelt=" + seatBelt + ", parkingBreak=" + parkingBreak
				+ ", crashDetection=" + crashDetection + ", vehicleDetails=" + vehicleDetails + "]";
	}

}
