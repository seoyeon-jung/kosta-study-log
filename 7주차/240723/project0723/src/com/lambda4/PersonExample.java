package com.lambda4;

import java.util.Comparator;
import java.util.TreeSet;

public class PersonExample {

	public static void main(String[] args) {
		// treeset (오름차순으로 자동정렬)

		// comparator 클래스를 따로 생성
		// TreeSet<Person> treeSet = new TreeSet<>(new AgeComparator());

		// 한번 사용할 것이므로 익명으로 생성
//		TreeSet<Person> treeSet = new TreeSet<>(new Comparator<Person>() {
//			@Override
//			public int compare(Person o1, Person o2) {
//				return o1.getAge() - o2.getAge();
//			}
//		});

		// 매개변수가 무엇인지 알고 있으므로
		// TreeSet<Person> treeSet = new TreeSet<>((o1, o2) -> o1.getAge() -
		// o2.getAge());

		TreeSet<Person> treeSet = new TreeSet<Person>(Comparator.comparingInt(Person::getAge)
				.thenComparing((o1, o2) -> o1.getName().compareTo(o2.getName())));

		treeSet.add(new Person("권지훈", 7));
		treeSet.add(new Person("김태환", 8));
		treeSet.add(new Person("성제환", 6));

		System.out.println(treeSet);

	}

}
