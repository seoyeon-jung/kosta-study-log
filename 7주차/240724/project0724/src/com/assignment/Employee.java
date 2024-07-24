package com.assignment;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Employee {

	private int id;
	private String name;
	private String department;
	private double salary;
	private String email;

}
