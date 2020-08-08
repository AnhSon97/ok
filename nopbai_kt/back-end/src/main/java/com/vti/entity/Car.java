package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car", catalog = "manager_car")
public class Car implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "license_plate")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int licenseplate;

	@Column(name = "repair_date")
	private String repairdate;

	@Column(name = "customer_name")
	private String customername;
	
	@Column(name = "catalogs")
	private String catalogs;
	
	@Column(name = "car_market")
	private String carmarket;

	public Car(String repairdate, String customername, String catalogs, String carmarket) {
		this.repairdate = repairdate;
		this.customername = customername;
		this.catalogs = catalogs;
		this.carmarket = carmarket;
	}

	public Car() {
	}

	public int getLicenseplate() {
		return licenseplate;
	}

	public void setLicenseplate(int licenseplate) {
		this.licenseplate = licenseplate;
	}

	public String getRepairdate() {
		return repairdate;
	}

	public void setRepairdate(String repairdate) {
		this.repairdate = repairdate;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCatalogs() {
		return catalogs;
	}

	public void setCatalogs(String catalogs) {
		this.catalogs = catalogs;
	}

	public String getCarmarket() {
		return carmarket;
	}

	public void setCarmarket(String carmarket) {
		this.carmarket = carmarket;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Car [licenseplate=" + licenseplate + ", repairdate=" + repairdate + ", customername=" + customername
				+ ", catalogs=" + catalogs + ", carmarket=" + carmarket + "]";
	}
	
}
