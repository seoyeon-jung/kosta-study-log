package com.oop.abstract1;

public class AnimalExample {
	public static void main(String[] args) {
		// 추상 클래스는 인스턴스화하지 못한다.
		// Animal animal = new Animal();

		Pig p = new Pig();
		Monkey m = new Monkey();
		Panda pd = new Panda();
		Rabbit r = new Rabbit();

//		p.sound();
//		m.sound();
//		pd.sound();
//		r.sound();

//		Animal[] aniArr = { p, m, pd, r };
//		for (Animal animal : aniArr) {
//			animal.sound();
//		}

		animalSound(p);
		animalSound(m);
		animalSound(pd);
		animalSound(r);

	}

	public static void animalSound(Animal a) {
		a.sound();
	}
}
