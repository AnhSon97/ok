package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.CarDTO;
import com.vti.entity.Car;
import com.vti.service.ICarService;

@RestController
@RequestMapping(value = "api/v1/Car")
@CrossOrigin(origins = "http://127.0.0.1:5500")

public class DepartmentController {

	@Autowired
	private ICarService service;

	@GetMapping()
	public ResponseEntity<?> getAllDepartments() {

		// get data
		List<Car> entities = service.getAllDepartments();
		return new ResponseEntity<List<Car>>(entities, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getDepartmentByID(@PathVariable(name = "id") short id) {
		return new ResponseEntity<Car>(service.getDepartmentByID(id), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createDepartment(@RequestBody CarDTO dto) {
		service.createDepartment(dto.toEntity());
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

	@PutMapping(value = "/{customername}")
	public ResponseEntity<?> updateDepartment(@PathVariable(name = "customername") String customername, @RequestBody CarDTO dto) {
		Car department = dto.toEntity();
		department.setCustomername(customername);
		service.updateDepartment(department);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{customername}")
	public ResponseEntity<?> deleteDepartment(@PathVariable(name = "customername") String customername) {
		service.deleteDepartment(customername);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
}
