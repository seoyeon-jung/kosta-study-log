package com.assignment;

import java.util.Arrays;
import java.util.List;

public class EmployeeExample {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee(1, "심유경", "Engineering", 75000, "sim@example.com"),
				new Employee(2, "유선웅", "Marketing", 60000, "ysw@example.com"),
				new Employee(3, "설경하", "Engineering", 80000, "snow@example.com"),
				new Employee(4, "성인옥", "Sales", 55000, "inok@example.com"),
				new Employee(5, "허형민", "Marketing", 70000, "hhhhhm@example.com"));
		EMSystem system = new EMSystem();

		System.out.println("부서별 필터링 (Engineering):");
		system.filterByDepartment(employees, "Engineering").forEach(System.out::println);

		System.out.println("\n이메일 주소:");
		system.getEmailAddresses(employees).forEach(System.out::println);

		System.out.println("\n총 급여:");
		System.out.println(system.getTotalSalary(employees));

		System.out.println("\n급여 필터링 (>= 70000):");
		system.filterBySalary(employees, 70000).forEach(System.out::println);

		System.out.println("\n부서별 평균 급여:");
		system.getAverageSalaryByDepartment(employees)
				.forEach((dept, avgSalary) -> System.out.println(dept + ": " + avgSalary));

		System.out.println("\n직원명 정렬:");
		system.sortEmployeesByName(employees).forEach(System.out::println);

		System.out.println("\nID로 찾기:");
		system.findEmployeeById(employees, 3).ifPresent(System.out::println);

	}

}
