package com.lambda3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Person {
	private String name, job, nation;

	public void action1(Workable workable) {
		workable.work(name, job);
	}

	public void action2(Speakable speakable) {
		speakable.speak(nation);
	}
}
