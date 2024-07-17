package com.practice3;

import java.util.Scanner;

public class CompanyExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Company com = new Company("NAVER");

		for (int i = 0; i < 10; i++) {
			String employeeName = sc.next();
			int employeeSalary = sc.nextInt();

			com.addEmployee(employeeName, employeeSalary);
		}

		System.out.println();

		int salaryCut = sc.nextInt();

		sc.close();

		System.out.println();

		com.printEmployeeArr(salaryCut);
		System.out.println("연봉 평균: " + com.calcAvgSalary());

	}

}
