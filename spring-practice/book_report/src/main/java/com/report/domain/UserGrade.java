package com.report.domain;

public enum UserGrade {
	// 회원 등급
	EXPLORER("ROLE_EXPLORER"), EXPORT("ROLE_EXPORT"), MASTER("ROLE_MASTER");

	private final String grade;

	// 생성자
	UserGrade(String grade) {
		this.grade = grade;
	}

	// Getter
	public String getGrade() {
		return grade;
	}
}
