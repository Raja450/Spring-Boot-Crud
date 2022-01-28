package com.example.crud.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.crud.enumtest.GenderConverter;

import lombok.Data;

@Entity
@Data 

@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Employee FirstName can't be blank.")
	@Size(min = 2, max = 50)
	@Column(name = "firstname", nullable = false)
	private String firstName;

	@NotNull(message = "Employee LastName can't be blank.")
	@Size(min = 2, max = 50)
	@Column(name = "lastname", nullable = false)
	private String lastName;

	@Column(name = "date_of_birth")
	@DateTimeFormat(pattern = "dd-MM-yy")
	private Date dateOfBirth;

	@NotNull(message = "Employee mobile can't be blank.")
	@Column(name = "mobile", nullable = false)
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String mobile;

	@NotNull(message = "Employee Address can't be blank.")
	@Column(name = "address1", nullable = false)
	private String address1;

	
	@Column(name = "address2")
	private String address2;

	@NotNull(message = "Employee age can't be blank.")
	@Column(name = "age", nullable = false)
	private int age;

	@Convert(converter = GenderConverter.class)
	@Enumerated(EnumType.ORDINAL)
	Gender gender;

	@NotNull(message = "Employee Email can't be blank.")
	@Size(min = 6, max = 100)
	@Email(message = "Please Enter Valid Email.")
	@Column(name = "email", nullable = false, unique = true)
	private String email;

}
