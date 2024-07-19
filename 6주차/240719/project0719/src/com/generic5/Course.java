package com.generic5;

public class Course {
	// 모든 사람이 들을 수 있는 과정을 등록
	public static void registercourse1(Applicant<?> applicant) {
		String simpleName = applicant.kind.getClass().getSimpleName();
		System.out.println(simpleName + ": 코스1 등록");
	}

	// 학생만 들을 수 있는 과정을 등록
	public static void registercourse2(Applicant<? extends Student> applicant) {
		String simpleName = applicant.kind.getClass().getSimpleName();
		System.out.println(simpleName + ": 코스2 등록");
	}

	// 직장인과 일반인만 들을 수 있는 과정을 등록
	public static void registercourse3(Applicant<? super Worker> applicant) {
		String simpleName = applicant.kind.getClass().getSimpleName();
		System.out.println(simpleName + ": 코스3 등록");
	}
}
