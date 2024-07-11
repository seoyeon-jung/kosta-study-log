package com.reference.list;

public class ListBasic {

	public static void main(String[] args) {
		int[] score = { 100, 70, 75, 43, 96 };
		int sum = 0;

		for (int i = 0; i < score.length; i++) {
			sum += score[i];
		}

		System.out.println("총합: " + sum);

	}

}
