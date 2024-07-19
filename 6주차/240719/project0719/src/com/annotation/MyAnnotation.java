package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 클래스, 필드, 메소드에 적용 가능한 어노테이션 (생성자에는 적용 불가)
@Target({ ElementType.METHOD, ElementType.FIELD })
// 실행할 때 적용하여 계속 유지되는 어노테이션
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	String value();

	String prop1();

	int prop2() default 1;
}