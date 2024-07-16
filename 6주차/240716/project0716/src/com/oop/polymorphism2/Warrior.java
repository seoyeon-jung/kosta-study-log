package com.oop.polymorphism2;

public class Warrior {
	Weapon weapon = new Weapon(); // 기본은 맨손

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public void attack() {
		weapon.use();
	}
}
