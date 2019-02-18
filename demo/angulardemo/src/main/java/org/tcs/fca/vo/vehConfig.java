package org.tcs.fca.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "VEHICLES")
@Entity
public class vehConfig {

	@Id
	@Column(name = "vehName")
	private String vehName;

	@Column(name = "mob_no")
	private String mobNo;

	@Column(name = "speed")
	private String speed;

	@Column(name = "brk_alrt")
	private String brkAlrt;

	@Column(name = "seat_alrt")
	private String seatAlrt;

	@Column(name = "near_alrt")
	private String nearAlrt;

	@Column(name = "drv_hst_date")
	private String drvHstDate;

	public vehConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	public vehConfig(String vehName, String mobNo, String speed, String brkAlrt, String seatAlrt, String nearAlrt,
			String drvHstDate) {
		super();
		this.vehName = vehName;
		this.mobNo = mobNo;
		this.speed = speed;
		this.brkAlrt = brkAlrt;
		this.seatAlrt = seatAlrt;
		this.nearAlrt = nearAlrt;
		this.drvHstDate = drvHstDate;
	}

	public String getVehName() {
		return vehName;
	}

	public void setVehName(String vehName) {
		this.vehName = vehName;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getBrkAlrt() {
		return brkAlrt;
	}

	public void setBrkAlrt(String brkAlrt) {
		this.brkAlrt = brkAlrt;
	}

	public String getSeatAlrt() {
		return seatAlrt;
	}

	public void setSeatAlrt(String seatAlrt) {
		this.seatAlrt = seatAlrt;
	}

	public String getNearAlrt() {
		return nearAlrt;
	}

	public void setNearAlrt(String nearAlrt) {
		this.nearAlrt = nearAlrt;
	}

	public String getDrvHstDate() {
		return drvHstDate;
	}

	public void setDrvHstDate(String drvHstDate) {
		this.drvHstDate = drvHstDate;
	}

	@Override
	public String toString() {
		return "vehConfig [vehName=" + vehName + ", mobNo=" + mobNo + ", speed=" + speed + ", brkAlrt=" + brkAlrt
				+ ", seatAlrt=" + seatAlrt + ", nearAlrt=" + nearAlrt + ", drvHstDate=" + drvHstDate + "]";
	}

}
