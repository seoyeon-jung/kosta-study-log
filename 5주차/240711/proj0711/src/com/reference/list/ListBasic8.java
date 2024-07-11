package com.reference.list;

public class ListBasic8 {

	public static void main(String[] args) {
		int[] score = { 95, 71, 84, 93, 86 };
		int sum = 0;

		for (int s : score) {
			sum += s;
		}

		double avg = (double) sum / score.length;

		System.out.println("합계: " + sum + ", 평균: " + avg);
	}
}
