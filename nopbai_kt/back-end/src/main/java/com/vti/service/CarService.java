package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Car;
import com.vti.repository.ICarRepository;

@Service
public class CarService implements ICarService {

	@Autowired
	private ICarRepository repository;

	public void createDepartment(Car car) {
		repository.createDepartment(car);
	}
	public List<Car> getAllDepartments() {
		return repository.getAllDepartments();
	}

	public Car getDepartmentByID(short id) {
		return repository.getDepartmentByID(id);
	}

	public Car getDepartmentByName(String name) {
		return repository.getDepartmentByName(name);
	}


	public void updateDepartment(short id, String newName) {
		repository.updateDepartment(id, newName);
	}

	public void updateDepartment(Car department) {
		repository.updateDepartment(department);
	}



	public boolean isDepartmentExistsByID(short id) {
		return repository.isDepartmentExistsByID(id);
	}

	public boolean isDepartmentExistsByName(String name) {
		return repository.isDepartmentExistsByName(name);
	}
	@Override
	public void deleteDepartment(String customername) {
		// TODO Auto-generated method stub
		
	}

//	public void deleteDepartment(String customername) {
//		return repository.deleteDepartment(customername);
//	}
}
