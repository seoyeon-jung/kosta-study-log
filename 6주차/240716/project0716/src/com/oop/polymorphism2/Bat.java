package com.oop.polymorphism2;

public class Bat extends Weapon {
	int damage = 10;

	@Override
	public void use() {
		System.out.println("몽둥이로 퍽퍽: " + damage);
	}
}
