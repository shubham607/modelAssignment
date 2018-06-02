package com.bean.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Longitude_Latitude")
public class Longitude_Latitude_Pojo {

	@Id
	@Column(name = "Locality")
	private String Locality;
	@Column(name = "place")
	private String place;
	@Column(name = "longitude")
	private int longitude;
	@Column(name = "latitude")
	private int latitude;
	
	
	public Longitude_Latitude_Pojo() {
		super();
	}


	public Longitude_Latitude_Pojo(String locality, String place, int longitude, int latitude) {
		super();
		Locality = locality;
		this.place = place;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public String getLocality() {
		return Locality;
	}


	public void setLocality(String locality) {
		Locality = locality;
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

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	
}
