package com.vti.repository;

import java.util.List;

import com.vti.entity.Car;

public interface ICarRepository {

	public List<Car> getAllDepartments();

	public Car getDepartmentByID(short id);

	public Car getDepartmentByName(String name);

	public void createDepartment(Car department);

	public void updateDepartment(short id, String newName);

	public void updateDepartment(Car department);

	public void deleteDepartment(String customername);

	public boolean isDepartmentExistsByID(short id);

	public boolean isDepartmentExistsByName(String name);

}
