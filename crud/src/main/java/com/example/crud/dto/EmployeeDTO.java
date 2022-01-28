package com.example.crud.dto;

import java.util.Date;


import com.example.crud.model.Employee;
import com.example.crud.model.Gender;

import lombok.Data;

@Data



public class EmployeeDTO {
	private long id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String mobile;
	private String address1;
	private String address2;
	private int age;
	private Gender gender;
	private String email;

	public EmployeeDTO() {
	}

	public EmployeeDTO(Employee employee) {
		this.firstName = employee.getFirstName();
		this.lastName = employee.getLastName();
		this.dateOfBirth = employee.getDateOfBirth();
		this.mobile = employee.getMobile();
		this.address1 = employee.getAddress1();
		this.address2 = employee.getAddress2();
		this.age = employee.getAge();
		this.gender = employee.getGender();
		this.email = employee.getEmail();
		this.id = employee.getId();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
