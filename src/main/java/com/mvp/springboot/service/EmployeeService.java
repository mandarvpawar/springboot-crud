package com.mvp.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvp.springboot.exception.RecordNotFoundException;
import com.mvp.springboot.model.EmployeeEntity;
import com.mvp.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<EmployeeEntity> getAllEmployees() {
		List<EmployeeEntity> employees = employeeRepository.findAll();
		if (employees.size() > 0)
			return employees;
		else
			return new ArrayList<>();
	}

	public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = employeeRepository.findById(id);
		if (employee.isPresent())
			return employee.get();
		else
			throw new RecordNotFoundException("No employee record exist for given id");
	}

	public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) {

		Optional<EmployeeEntity> employee = employeeRepository.findById(entity.getId());
		if (employee.isPresent()) {
			EmployeeEntity newEntity = employee.get();
			newEntity.setEmail(entity.getEmail());
			newEntity.setFirstName(entity.getFirstName());
			newEntity.setLastName(entity.getLastName());
			newEntity = employeeRepository.save(newEntity);

			return newEntity;
		} else {
			entity = employeeRepository.save(entity);
			return entity;
		}
	}

	public void deleteEmployeeById(Long id) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = employeeRepository.findById(id);

		if (employee.isPresent())
			employeeRepository.deleteById(id);
		else
			throw new RecordNotFoundException("No employee record exist for given id");
	}
}