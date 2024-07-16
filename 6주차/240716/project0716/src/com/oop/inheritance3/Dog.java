package com.oop.inheritance3;

public class Dog extends Animal {
	@Override
	public void makeSound() {
		System.out.println("멍멍");
	}

	public void bite() {
		System.out.println("앙!");
	}
}
