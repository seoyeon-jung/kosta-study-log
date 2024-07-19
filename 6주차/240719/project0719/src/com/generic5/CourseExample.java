package com.generic5;

public class CourseExample {

	public static void main(String[] args) {
		Applicant<Person> p = new Applicant<>(new Person());
		Applicant<Worker> w = new Applicant<>(new Worker());
		Applicant<Student> s = new Applicant<>(new Student());
		Applicant<HighStudent> hs = new Applicant<>(new HighStudent());
		Applicant<MiddleStudent> ms = new Applicant<>(new MiddleStudent());

		Course.registercourse1(p);
		Course.registercourse1(w);
		Course.registercourse1(s);
		Course.registercourse1(hs);
		Course.registercourse1(ms);
		System.out.println();

		Course.registercourse2(s);
		Course.registercourse2(hs);
		Course.registercourse2(ms);
		System.out.println();

		Course.registercourse3(p);
		Course.registercourse3(w);

	}

}
