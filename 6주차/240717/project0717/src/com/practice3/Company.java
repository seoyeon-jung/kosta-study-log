package com.practice3;

public class Company {
	private String name; // 회사 이름
	private Employee[] employeeArr; // 회사 소속 직원 배열
	private int employeeCount; // 회사 직원 수

	public Company(String name) {
		this.name = name;
		// 직원 수는 최대 10명
		this.employeeArr = new Employee[10];
		// 처음 직원 수는 0
		this.employeeCount = 0;
	}

	// 입사 메소드
	public void addEmployee(String employeeName, int salary) {
		if (employeeCount < employeeArr.length) {
			employeeArr[employeeCount] = new Employee(employeeName, salary);
			employeeCount++;
		} else {
			System.out.println("직원을 추가할 수 없습니다.");
		}
	}

	// 연봉 합계 메소드 (int)
	private int calcSumSalary() {
		int sum = 0;
		for (int i = 0; i < employeeCount; i++) {
			sum += employeeArr[i].getSalary();
		}
		return sum;
	}

	// 연봉 평균 메소드 (double)
	public double calcAvgSalary() {
		if (employeeCount == 0) {
			return 0;
		}

		return (double) calcSumSalary() / employeeCount;
	}

	// 직원 정보 출력 메소드 (int salary) -> salary 연봉 이상 받는 직원들 출력
	public void printEmployeeArr(int salary) {
		System.out.println("연봉이 " + salary + "원 이상인 사람들");
		for (int i = 0; i < employeeCount; i++) {
			if (employeeArr[i].getSalary() >= salary) {
				System.out.println(employeeArr[i]);
			}
		}
	}

	private class Employee {
		private String name; // 직원 이름
		private int salary; // 연봉

		public Employee(String name, int salary) {
			this.name = name;
			this.salary = salary;
		}

		public String getName() {
			return name;
		}

		public int getSalary() {
			return salary;
		}

		// 직원 정보 출력
		@Override
		public String toString() {
			return "이름: " + getName() + "\t\t연봉: " + getSalary();
		}

	}
}
