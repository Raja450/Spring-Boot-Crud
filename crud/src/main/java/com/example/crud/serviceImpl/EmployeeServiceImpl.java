package com.example.crud.serviceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.dto.EmployeeDTO;
import com.example.crud.model.Employee;
import com.example.crud.repository.EmployeeRepository;
import com.example.crud.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void createOrUpdateEmployee(EmployeeDTO empDto) {
		Employee emp = convertDtoToModel(empDto);
		employeeRepository.save(emp);
	}

	public List<EmployeeDTO> getAllEmployee() {
		List<Employee> list = employeeRepository.findAll();
		List<EmployeeDTO> employeeList = list.stream().map(EmployeeDTO::new)
				.collect(Collectors.toCollection(ArrayList::new));
		return employeeList;
	}

	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

	public EmployeeDTO editEmployee(Long id) {
		Employee emp = employeeRepository.getOne(id);
		return convertModelToDTO(emp);
	}

	private Employee convertDtoToModel(EmployeeDTO empDto) {
		Employee emp = new Employee();
		if (empDto.getId() != null) {
			emp.setId(empDto.getId());
		}
		emp.setAge(empDto.getAge());
		emp.setDateOfBirth(empDto.getDateOfBirth());
		emp.setMobile(empDto.getMobile());
		emp.setAddress1(empDto.getAddress1());
		emp.setFirstName(empDto.getFirstName());
		emp.setLastName(empDto.getLastName());
		emp.setAddress2(empDto.getAddress2());
		emp.setGender(empDto.getGender());
		emp.setEmail(empDto.getEmail());
		return emp;
	}

	private EmployeeDTO convertModelToDTO(Employee emp) {
		EmployeeDTO empDTO = new EmployeeDTO();
		empDTO.setId(emp.getId());
		empDTO.setAge(emp.getAge());
		empDTO.setDateOfBirth(emp.getDateOfBirth());
		empDTO.setMobile(emp.getMobile());
		empDTO.setAddress1(emp.getAddress1());
		empDTO.setFirstName(emp.getFirstName());
		empDTO.setLastName(emp.getLastName());
		empDTO.setAddress2(emp.getAddress2());
		empDTO.setGender(emp.getGender());
		empDTO.setEmail(emp.getEmail());
		return empDTO;
	}

	
}