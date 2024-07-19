package com.reflection;

import java.lang.reflect.Field;

public class ReflectionExample {

	public static void main(String[] args) {
		Class clazz = Car.class;
		System.out.println(clazz.getPackageName());
		System.out.println(clazz.getSimpleName());

		Field[] declareFields = clazz.getDeclaredFields();
		for (Field f : declareFields) {
			System.out.println(f.getType().getName() + " " + f.getName());
		}

	}

}
