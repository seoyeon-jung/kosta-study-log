package com.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrintAnnoExample {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		Method[] methods = Service.class.getDeclaredMethods();
		for (Method m : methods) {
			PrintAnnotation pa = m.getAnnotation(PrintAnnotation.class);
			print(pa);
			m.invoke(new Service());
			print(pa);
		}
	}

	public static void print(PrintAnnotation pa) {
		String sign = pa.value();
		int number = pa.number();
		for (int i = 0; i < number; i++) {
			System.out.print(sign);
		}
		System.out.println();
	}

}
