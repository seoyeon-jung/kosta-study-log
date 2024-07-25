package com.assignment;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EMSystem {
	// 부서별 직원 필터링 - 특정 부서(department)에 속한 직원들을 필터링하여 반환하는 메소드를 작성하세요.
	public List<Employee> filterByDepartment(List<Employee> employees, String department) {
		return employees.stream().filter(e -> e.getDepartment().equals(department)).toList();

	}

	// 직원 이메일 목록 추출 - 모든 직원의 이메일 주소를 추출하여 리스트로 반환하는 메소드를 작성하세요.
	public List<String> getEmailAddresses(List<Employee> employees) {
		return employees.stream().map(Employee::getEmail).toList();
	}

	// 직원 급여 합계 계산 - 모든 직원의 급여 합계를 계산하여 반환하는 메소드를 작성하세요.
	public double getTotalSalary(List<Employee> employees) {
		return employees.stream().mapToDouble(Employee::getSalary).sum();
	}

	// 특정 급여 이상의 직원 필터링 - 특정 급여(salary) 이상을 받는 직원들을 필터링하여 반환하는 메소드를 작성하세요.
	public List<Employee> filterBySalary(List<Employee> employees, double salary) {
		return employees.stream().filter(e -> e.getSalary() >= salary).toList();
	}

	// 부서별 평균 급여 계산 - 각 부서별로 평균 급여를 계산하여 맵 형태로 반환하는 메소드를 작성하세요. 부서 이름을 키로 하고 평균 급여를
	// 값으로 하는 맵을 반환하세요.
	public Map<String, Double> getAverageSalaryByDepartment(List<Employee> employees) {
		return employees.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
	}

	// 직원 이름 정렬 - 직원들의 이름을 가나다 순서로 정렬하여 반환하는 메소드를 작성하세요.
	public List<Employee> sortEmployeesByName(List<Employee> employees) {
		return employees.stream().sorted((emp1, emp2) -> emp1.getName().compareTo(emp2.getName())).toList();
	}

	// 직원 ID로 직원 찾기 - 직원 ID로 특정 직원을 찾아 반환하는 메소드를 작성하세요. 직원이 존재하지 않으면
	// Optional.empty()를 반환하세요.
	public Optional<Employee> findEmployeeById(List<Employee> employees, int id) {
		return employees.stream().filter(emp -> emp.getId() == id).findFirst();
	}
}
