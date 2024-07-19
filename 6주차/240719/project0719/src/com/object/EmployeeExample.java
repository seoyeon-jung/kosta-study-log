package com.object;

public class EmployeeExample {
	public static void main(String[] args) {
		Employee emp = new Employee(1, "정서연", "과장", "개발팀", 20000);

		emp.setSalary(50000);
		emp.setPosition("대표");
		emp.setDepartment(null);
		System.out.println(emp);
	}
}
