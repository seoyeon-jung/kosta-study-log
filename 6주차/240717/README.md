## 목차
- [인터페이스](#인터페이스)

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
- 