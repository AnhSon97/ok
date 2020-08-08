package com.vti.dto;

import com.vti.entity.Car;

public class CarDTO {
	private String repairdate;
	private String customername;
	private String catalogs;
	private String carmarket;

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

	public CarDTO() {
	}

	public Car toEntity() {
		return new Car(repairdate,customername,catalogs,carmarket);
	}

}
