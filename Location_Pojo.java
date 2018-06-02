package com.bean.table;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Location")
public class Location_Pojo implements Serializable {

	@Id
	@Column(name = "Locality")
	private String Locality;
	@Column(name = "Place")
	private String Place;
	@Column(name = "longitude")
	private int longitude;
	@Column(name = "latitude")
	private int latitude;

	public Location_Pojo() {
		super();
	}

	public Location_Pojo(String locality, String place, int longitude, int latitude) {
		super();
		Locality = locality;
		Place = place;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public String getLocality() {
		return Locality;
	}

	public void setLocality(String locality) {
		Locality = locality;
	}

	public String getPlace() {
		return Place;
	}

	public void setPlace(String place) {
		Place = place;
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

}
