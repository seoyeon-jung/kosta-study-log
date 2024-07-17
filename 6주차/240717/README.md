## 목차
- [인터페이스](#인터페이스)
	- [인터페이스가 가질 수 있는 필드와 메소드의 종류](#인터페이스가-가질-수-있는-필드와-메소드의-종류)
		- [필드](#필드)
		- [메소드](#메소드)
			- [추상 메소드](#추상-메소드)
			- [default 메소드](#default-메소드)
			- [정적 메소드](#정적-메소드)
			- [private 메소드](#private-메소드)
- [다중 인터페이스 구현](#다중-인터페이스-구현)
- [인터페이스 상속](#인터페이스-상속)
- [인터페이스 타입 변환](#인터페이스-타입-변환)
- [인터페이스 다형성](#인터페이스-다형성)
	- [instanceof](#instanceof)
- [중첩 클래스 (Nested Class)](#중첩-클래스-nested-class)
	- [인스턴스 멤버 클래스](#인스턴스-멤버-클래스)
	- [정적 멤버 클래스](#정적-멤버-클래스)
	- [로컬 클래스](#로컬-클래스)



<br/>
<br/>
<br/>
<br/>

# 인터페이스
- 인터페이스의 상수 필드, 추상 메소드, 디폴트 메소드, 정적 메소드는 모두 public 접근 제한을 갖는다.
- public을 생략하더라도 컴파일 과정에서 public 접근 제한자가 붙어 항상 외부에서의 접근이 가능해진다.
- 인터페이스 외부에서는 접근할 수 없고, 인스턴스 내부에서만 접근할 수 있는 private 메소드를 알아보자.
  - `private 메소드` : 디폴트 메소드에서만 호출이 가능
  - `private 정적메소드` : 디폴트 메소드와 정적 메소드 안에서 호출 가능
## 인터페이스가 가질 수 있는 필드와 메소드의 종류
### 필드
상수 필드 (public static final 자동으로 붙는다)
### 메소드
#### 추상 메소드
- 실제 구현되어 있지 않은 중괄호가 없는 메소드
#### default 메소드
- Java 8 이상
- 기본 구현 정의 (필요에 따라 구현 클래스에서 public 오버라이딩)
- 기본값 메소드
#### 정적 메소드 
- Java 8 이상
- 독립적인 인터페이스의 메소드 (public, private)
	- public 정적 메소드 : 외부에서, default 메소드에서 쓰인다.
	- private 정적 메소드 : default 메소드에서만 쓰인다
#### private 메소드
- Java 9 이상
- 내부 default 메소드에서 사용

<br/>
<br/>
<br/>
<br/>

# 다중 인터페이스 구현
- 구현 객체는 하나 이상의 인터페이스를 implements 할 수 있다.
- implements 뒤에 쉼표(,)를 이용해 구분 작성하면 된다.
- 다중 인터페이스를 구현하는 객체이므로 각 인터페이스 타입의 변수에 각각 대입할 수 있다.
- 구현 객체가 어떤 인터페이스 변수에 대입되느냐에 따라 변수를 통해 호출할 수 있는 추상 메소드가 결정된다.
<hr/>

[예시]
```java
package com.oop.interface3;

public interface PhoneService {
	void turnOn();

	void turnOff();

	void call(String number);
}
```
```java
package com.oop.interface3;

public interface SmartService {
	void openAll(String appName);
}
```
```java
package com.oop.interface3;

public class SmartPhone implements PhoneService, SmartService {

	@Override
	public void openAll(String appName) {
		System.out.println(appName + "을 열었습니다.");

	}

	@Override
	public void turnOn() {
		System.out.println("스마트폰을 켭니다.");

	}

	@Override
	public void turnOff() {
		System.out.println("스마트폰을 끕니다");

	}

	@Override
	public void call(String number) {
		System.out.println(number + "에 전화 거는 중...");

	}

}
```
```java
package com.oop.interface3;

public class SmartPhoneExample {
	public static void main(String[] args) {
		PhoneService ps = new SmartPhone(); // smart phone 으로 이루어짐
		ps.turnOn();
		ps.call("112");
		ps.turnOff();

		System.out.println();

		// openAll()을 사용하기 위해 SmartService 가지고 있는지 확인
		SmartService ps_ss = (SmartService) ps;
		ps_ss.openAll("instagram");

		System.out.println();

		SmartService ss = new SmartPhone();
		// ss.turnOn();
		// ss.call("112");
		// ss.turnOff();
		ss.openAll("카카오톡");

		System.out.println();

		SmartPhone sp = new SmartPhone();
		sp.turnOn();
		sp.call("112");
		sp.openAll("유투브");
		sp.turnOff();
	}
}
```

<br/>
<br/>
<br/>
<br/>

# 인터페이스 상속
- 인터페이스는 다른 인터페이스를 상속할 수 있고, 다중 상속을 허용한다.
- `public interface 인터페이스 extends 부모인터페이스1, 부모인터페이스2 { }`
  - 해당 인터페이스의 구현 클래스는 인터페이스가 가진 추상 메소드 뿐만 아니라 부모 인터페이스가 가지고 있는 추상 메소드까지 모두 오버라이딩해야 한다.
  - 그리고 구현 객체는 자식과 부모 인터페이스 변수에 모두 대입될 수 있다.
```java
인터페이스 변수A = new 구현클래스();
부모인터페이스1 변수B = new 구현클래스();
부모인터페이스2 변수C = new 구현클래스();
```
  - 구현 객체가 자식 인터페이스 변수에 대입되면 자식과 부모 인터페이스의 추상 메소드를 모두 호출 할 수 있으나, 
  부모 인터페이스 변수에 대입되면 부모 인터페이스에 선언된 추상 메소드만 호출 가능하다.
<hr/>

[예시]
```java
package com.oop.interface4;

public interface Child extends Mother, Father {
	void methodC();
}
```
```java
public class InterfaceImpl implements Child {

	@Override
	public void methodM() {
		System.out.println("엄마 메소드 실행");

	}

	@Override
	public void methodF() {
		System.out.println("아빠 메소드 실행");

	}

	@Override
	public void methodC() {
		System.out.println("자식 메소드 실행");

	}
}
```
```java
public class InterfaceExample {
	public static void main(String[] args) {
		// 구현 객체: InterfaceImpl 가 자식 인터페이스에 대입되면, 자식과 부모 추상 메서드 모두 호출 가능
		Child ic = new InterfaceImpl();
		// mother, father, child 모두 사용 가능
		ic.methodM();
		ic.methodF();
		ic.methodC();

		Mother im = new InterfaceImpl();
		im.methodM(); // mother 만 사용 가능

		Father iF = new InterfaceImpl();
		iF.methodF(); // father 만 사용 가능

	}
}
```

<br/>
<br/>
<br/>
<br/>

# 인터페이스 타입 변환
- 인터페이스의 타입 변환은 인터페이스와 구현 클래스 간에 발생한다.
- 부모 클래스가 인터페이스를 구현하고 있다면 자식 클래스도 해당 인터페이스 타입으로 자동 타입 변환될 수 있다.
- 인터페이스 타입을 구현 클래스 타입으로 강제로 타입 변환을 시킬 수 있다.
- 인터페이스 타입으로 변환된 구현 객체는 인터페이스에 선언된 메소드만 사용 가능하기 때문에, 만약 구현 클래스의 메소드를 호출하고 싶다면 구현 클래스 타입으로 강제 타입 변환을 시켜주어야 한다.
<hr/>

[예시]
```java
public interface PhoneService {
	void turnOn();

	void turnOff();

	void call(String number);
}
```
```java
public class Phone implements PhoneService {

	@Override
	public void turnOn() {
		System.out.println("전화기를 켭니다.");

	}

	@Override
	public void turnOff() {
		System.out.println("전화기를 끕니다.");
	}

	@Override
	public void call(String number) {
		System.out.println(number + "에 전화거는 중...");
	}

}
```
```java
public interface SmartService {
	void openApp(String appName);

}
```
```java
public class SmartPhone extends Phone implements SmartService {

	@Override
	public void openApp(String appName) {
		System.out.println(appName + "을(를) 실행합니다.");

	}

}
```
```java
public class SmartPhoneExample {

	public static void main(String[] args) {
		// Phone 은 PhoneService 직접적으로 구현하고 있기 때문에 자동 형 변환이 가능
		PhoneService ps1 = new Phone();

		// SmartPhone 은 Phone 을 상속받아 PhoneService 간접적으로 구현하고 있기 대문에 자동 형 변환이 가능
		PhoneService ps2 = new SmartPhone();

		// PhoneService => SmartService 기능이 없다
		// 따라서 SmartSerivice 메소드릃 호출하고 싶다면 강제 타입 변환이 필요하다
		// SmartService ss1 = (PhoneService) ps1;
		// 강제 타입 변환을 SmartPhone 으로 해줘야 한다
		// SmartPhone sp1 = (SmartPhone) ps1; // 애초에 phone 이기 때문에 바꿀 수 없음
		SmartPhone sp2 = (SmartPhone) ps2;

		// SmartService ss1 = (SmartService) sp1;
		SmartService ss2 = (SmartService) sp2;

	}

}
```
``

<br/>
<br/>
<br/>
<br/>

# 인터페이스 다형성
- 현업에서는 상속보다 인터페이스를 통해 다형성 구현을 더 많이 한다.
- 매개변수 타입을 인터페이스로 선언하여, 메소드 호출 시 다양한 구현 객체를 대입할 수 있다.
<hr/>

[예시]
```java
public interface Vehicle {
	void run();
}
```
```java
public class Taxi implements Vehicle {

	@Override
	public void run() {
		System.out.println("택시가 달립니다.");
	}

}
```
```java
public class Bus implements Vehicle {

	@Override
	public void run() {
		System.out.println("버스가 달립니다.");
	}

}
```
```java
public class Driver {
	void drive(Vehicle v) {
		v.run();
	}
}
```
```java
public class DriveExample {

	public static void main(String[] args) {
		Driver james = new Driver();
		james.drive(new Bus());
		james.drive(new Taxi());
	}

}
```
## instanceof
- 인터페이스에서도 `instanceof` 연산자를 사용 가능하다.
- java 12 버전 이상부터 사용 가능하다.
```java
public class Bus implements Vehicle {
	public void checkFare() {
		System.out.println("돈 내세요~");
	}

	@Override
	public void run() {
		System.out.println("버스가 달립니다.");
	}

}
```
```java
public class Driver {
	void drive(Vehicle v) {
		if (v instanceof Bus b) {
			b.checkFare();
		}
		
		//Bus b = (Bus) v;
		//b.checkFare();
		// => taxi 가 bus 로 형변환이 안되기 때문에 이대로 작성하면 오류가 난다.

		v.run();
	}
}

```

<br/>
<br/>
<br/>
<br/>

# 중첩 클래스 (Nested Class)
- 클래스 간 서로 긴밀한 관계를 맺고 상호 작용하면서 객체지향 프로그램은 동작한다.
- 클래스가 여러 클래스와 관계를 맺는 경우에는 독립적으로 선언하는 것이 좋다.
- 특정 클래스만 관계를 맺어야 하는 경우에는 중첩 클래스로 선언하는 것이 유지보수에 도움이 되는 경우가 많다.
- 위치에 따라 두 가지로 분류한다.
  - 멤버 클래스 : 클래스의 멤버로서 선언되는 중첩 클래스 (인스턴스 멤버, 정적 멤버 클래스)
  - 로컬 클래스 : 메소드 내부에서 선언되는 중첩 클래스
    - 메소드가 끝나면 사라진다.
- 중첩 클래스도 컴파일 시에 별도의 바이트코드 파일이 생성된다.

<br/>
<br/>

## 인스턴스 멤버 클래스
```java
public class A {
	// 인스턴스 필드
	int number = 1;

	// 중첩 클래스를 인스턴스 용도로 사용
	B b = new B();
	C c = new C();
	D d = new D();

	// 정적 필드
	static int totalNumber;

	// 기본 생성자 (클래스이면 기본으로 들어있음)
	A() {
		// 중첩 클래스를 생성자 내부에서 사용
		this.b = new B();
		this.c = new C();
		this.d = new D();
	}

	// 인스턴스 메소드
	void hello() {

		// 중첩 클래스를 메소드 내부에서 사용 (로컬 클래스)
		B b = new B();
		C c = new C();
		D d = new D();

		System.out.println("Hello");
	}

	// 정적 메소드
	static void staticHello() {
		System.out.println("static Hello");

	}

	// 중첩 클래스 (인스턴스 필드와 동일하게 동작)
	public class B {
		// 다른 패키지에서도 사용 가능
	}

	class C {
		// 같은 패키지에서만 사용 가능
	}

	private class D {
		// A 클래스 내부에서만 사용 가능
	}
}
```
- 주로 클래스 내부에서 사용되기 때문에 `private`으로 선언하는 것이 일반적이다.
- 인스턴스 맴버 클래스는 `필드값`, `생성자`, `메소드`에서 생성할 수 있다.
- 인스턴스 멤버 클래스 내부에는 필드, 생성자, 메소드 선언이 올 수 있다.
  - Java17부터는 정적 필드와 정적 메소드의 선언도 가능하다.
- 외부에서 중첩 클래스를 생성하려면, 바깥 클래스(객체)를 생성한 후에 중첩 클래스를 생성해야 한다.
```java
public class AExample {
	public static void main(String[] args) {
		// public B와 default C 사용 가능
		// A.B b = new B();
		// => 중첩 클래스는 인스턴스 필드와 동일하게 동작
		// 외부에서 중첩 클래스를 사용하기 위해서는 바깥 클래스(객체)를 생성한 뒤에 내부 중첩 클래스를 생성해야 한다.
		A a = new A();
		A.B b = a.new B();
	}

}
```

<br/>
<br/>

## 정적 멤버 클래스
- 클래스 내부에 `static` 키워드와 함께 선언된 클래스를 말한다.
```java
public class A {
	public static class B {
		// 다른 패키지에서 B 클래스 사용가능
	}
	static class C {
		// 같은 패키지에서만 C 클래스 사용가능
	}
	private static class D {
		// A 클래스 내부에서만 D 클래스 사용가능
	}
}
```
- 정적 멤버 클래스는 주로 클래스 외부에서 함께 쓰이기 때문에 `default` 또는 `public`으로 선언하는 것이 일반적이다.
- 정적 멤버 클래스는 `필드값`, `정적필드값`, `생성자`, `메소드`, `정적 메소드`에서 생성 가능하다.
```java
public class A {
	static class NestedClass { }
	// 필드값으로 생성
	NestedClass nc1 = new NestedClass();

	// 정적필드값으로 생성
	static NestedClass nc2 = new NestedClass();

	// 생성자에서 생성
	A() {
		NestedClass nc = new NestedClass();
	}

	// 메소드에서 생성
	void method1() {
		NestedClass nc = new NestedClass();
	}

	// 정적메소드에서 생성
	static void method2() {
		NestedClass nc = new NestedClass();
	}
}
```
- 외부에서 중첩 클래스를 생성할 때, 바깥 클래스(객체) 생성 없이 바로 생성할 수 있다.
```java
public class AExample {
public static void main(String[] args) {
	A.NestedClass nc = new A.NestedClass();
}
}
```
- 정적 멤버 내부에도 필드, 생성자, 메소드 선언이 올 수 있다. 
- Java 17부터 정적 필드와 정적 메소드의 선언도 가능하다.

<br/>
<br/>

## 로컬 클래스
- 생성자 도는 메소드 내부에서 선언된 클래스이다.
```java
public class A {
	public A() {
		// 생성자 내부에서 선언된 로컬클래스
		class B {}
		// 생성자 실행동안만 객체 생성 가능
		B b = new B();
	}

	public void method() {
		// 메서드 내부에서 선언된 로컬클래스
		class B {}

		// 메소드 실행동안만 객체 생성 가능
		B b = new B();
	}
}
```
- 생성자 또는 메소드의 매개변수나 내부에서 선언된 변수를 로컬 클래스에서 사용할 경우에는 로컬 클래스 내부에서 값을 변경하지 못하도록 제한되어 있다. 
- 즉, final 특성을 갖게 된다.
- Java 8부터 final을 붙이지 않아도 final 특성을 갖는다.
- 로컬 클래스 내부에도 필드, 생성자, 메소드 선언이 올 수 있다.
- Java 17부터 정적 필드와 정적 메소드의 선언도 가능하다.