package com.oop.inheritance3;

public class AnimalExample {

	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.makeSound();

		// Dog dog = (Dog) animal;
		// dog.makeSound();

		Animal animalD = new Dog();
		animalD.makeSound(); // 멍멍
		// 일반 동물 타입이므로 makeSound만 출력 가능
		// bite()는 불러오지 못한다.

		Dog dog = (Dog) animalD;
		dog.makeSound();
		dog.bite(); // 앙!

		// ==============
		Animal animalC = new Cat();
		animalC.makeSound();

		Cat cat = (Cat) animalC;
		cat.makeSound();
		cat.scratch(); // 벅벅

	}

}
