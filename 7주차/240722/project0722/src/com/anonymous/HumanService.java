package com.anonymous;

//@FunctionalInterface
public interface HumanService {
	public default void run() {
		System.out.println("농사를 짓는다");
	}
}
