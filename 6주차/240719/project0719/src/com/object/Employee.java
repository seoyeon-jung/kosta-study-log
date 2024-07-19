package com.object;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Employee {
	private int id;
	private String name;
	private String position;
	private String department;
	private int salary;

}
