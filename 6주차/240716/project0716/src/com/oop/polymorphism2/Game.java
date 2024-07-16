package com.oop.polymorphism2;

public class Game {
	public static void main(String[] args) {
		Warrior faker = new Warrior();
		faker.attack(); // 맨 손으로 쾅쾅: 1

		System.out.println();
		faker.setWeapon(new Gun());
		faker.attack(); // 총으로 빵빵: 100

		System.out.println();
		faker.setWeapon(new Bat());
		faker.attack(); // 몽둥이로 퍽퍽: 10
	}

}
