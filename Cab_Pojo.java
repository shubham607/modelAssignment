package com.bean.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cab")
public class Cab_Pojo {

	@Id
	@Column(name = "cabNo")
	private int cabNo;
	@Column(name = "driverNo")
	private String driverNo;
	@Column(name = "cabModel")
	private String cabModel;
	@Column(name = "cabColor")
	private String cabColor;
	@Column(name = "place")
	private String place;
	@Column(name = "status")
	private String status;
	@Column(name = "longitude")
	private int longitude;
	@Column(name = "latitude")
	private int latitude;

	public Cab_Pojo() {
		super();
	}

	public Cab_Pojo(int cabNo, String driverNo, String cabModel, String cabColor, String place, String status,
			int longitude, int latitude) {
		super();
		this.cabNo = cabNo;
		this.driverNo = driverNo;
		this.cabModel = cabModel;
		this.cabColor = cabColor;
		this.place = place;
		this.status = status;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public int getCabNo() {
		return cabNo;
	}

	public void setCabNo(int cabNo) {
		this.cabNo = cabNo;
	}

	public String getCabModel() {
		return cabModel;
	}

	public void setCabModel(String cabModel) {
		this.cabModel = cabModel;
	}

	public String getCabColor() {
		return cabColor;
	}

	public void setCabColor(String cabColor) {
		this.cabColor = cabColor;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public String getDriverNo() {
		return driverNo;
	}

	public void setDriverNo(String driverNo) {
		this.driverNo = driverNo;
	}

}
