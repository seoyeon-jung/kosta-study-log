## 목차
- [인스턴스 멤버 \& 정적 멤버](#인스턴스-멤버--정적-멤버)
  - [인스턴스 멤버](#인스턴스-멤버)
  - [정적 멤버](#정적-멤버)
- [final 필드와 상수](#final-필드와-상수)
- [패키지](#패키지)
- [접근 제한자](#접근-제한자)
- [Getter, Setter](#getter-setter)
  - [Setter](#setter)
  - [Getter](#getter)
- [싱글톤 패턴](#싱글톤-패턴)

<br/>
<br/>
<br/>



# 인스턴스 멤버 & 정적 멤버
- 필드와 메소드는 선언 방법에 따라 인스턴스 멤버와 정적 멤버로 분류할 수 있다.
- 인스턴스 멤버(Instance Member)
  - 객체에 소속된 멤버
  - 객체를 생성해야만 사용할 수 있는 멤버
- 정적 멤버(Static Member)
  - 클래스에 고정된 멤버
  - 객체 없어도 사용할 수 있는 멤버
## 인스턴스 멤버
- 객체에 소속된 멤버를 의미
- 메소드가 객체마다 공유된다면 중복 저장으로 인해 메모리 효율이 떨어진다.
- 따라서 메소드 코드는 메소드 영역에서 공유해서 사용하고, 객체 없이는 사용을 못하도록 제한을 걸어둔 것으로 볼 수 있다.
```java
public class Car {
    String model;
    int gas, speed;
    Car(String model) {
        this.model = model;
        }
        void setSpeed(int speed) {
            this.speed = speed;
        }
        void run() {
            // this 생략 가능
            // this.setSpeed(100);
            // System.out.println(this.model + " 이/가 달립니다. (시속: " + this.speed + "km/h)");
            setSpeed(100);
            System.out.println(model + " 이/가 달립니다. (시속: " + speed + "km/h)");
            }
}
```
```java
public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car("소나타");
        myCar.run();
        }
}
```
## 정적 멤버
- Java는 클래스 로더(class loader)를 이용해서 클래스를 메소드 영역에 저장하고 사용한다.
- 정적 멤버란 메소드 영역의 클래스에 고정적으로 위치하는 멤버를 마한다.
- 그렇게 함으로써 정적 멤버는 객체를 생성할 필요 없이 클래스 등을 통해 바로 사용이 가능하다.
- 필드와 메소드 앞에 `static` 키워드를 추가하면 된다.
- 정적 멤버는 객체 생성없이 클래스 이름과 객체 접근 연산자(.)로 접근 가능하다.
- 정적 멤버는 객체 참조 변수를 통해서 접근도 가능하지만
클래스 이름으로 접근하는 것이 정석이다.
```java
public class KoreanExample {
    public static void main(String[] args) {
        Korean.sayHello();
        System.out.println(Korean.nation);
        Korean sunsin = new Korean("이순신");
        System.out.println(sunsin.nation);
        sunsin.sayName();
        }
}
```
```java
public class Korean {
    String name;
    static String nation = "KOREA";
    Korean(String name) {
        this.name = name;
    }
    void sayName() {
        System.out.println("제 이름은 " + name + "입니다.");
    }
    static void sayHello() {
        System.out.println("안녕하세요");
    }
}
```
- 정적 필드는 객체 생성 없이도 사용할 수 있기 때문에 생성자에서 초기화 작업을 하지 않는다. (생성자는 객체 생성 후 실행된다.)
- 객체마다 가지고 있을 필요성이 없는 공용적인 필드는 객체마다 따로 가지고 있을 필요가 없기 때문에 정적 필드로 선언하는 것이 좋다.
- 인스턴스 필드를 이용하지 않는 메소드는 정적 필드로 선언하는 것이 좋다.
- 정적 필드에 초기값을 주는 작업이 복잡하다면, 정적 블록을 이용해야 한다.
- 정적 블록은 클래스가 메모리로 로딩될 때 자동으로 실행된다.
```java
public class SmartPhone {
	static String company = "Apple";
	static String model = "iPhone16";
	static String info;
	static {
		System.out.println("정적 블록을 실행합니다.");
		info = company + "-" + model;
	}
}
```
```java
public class SmartPhoneExample {

	public static void main(String[] args) {
		System.out.println(SmartPhone.company);
		System.out.println(SmartPhone.model);
		System.out.println(SmartPhone.info);

	}

}
// 정적 블록을 실행합니다.
// Apple
// iPhone16
// Apple-iPhone16
```
- 정적 메소드와 정적 블록은 객체가 없어도 실행된다는 특징이 있다.
- 따라서 내부에서 인스턴스를 사용할 수 없고, this 키워드도 사용할 수 없다.
- 만약 정적 메소드와 정적 블록 내부에서 인스턴스 멤버를 사용하고 싶다면, 내부에서 객체를 생성하고 참조변 수로 접근해야 한다.
- main() 메소드도 정적 메소드이기 때문에 객체를 생성하지 않으면 인스턴스 멤버를 main() 메소드에서 사용할 수 없다.

``` java
public class ClassName {
	String instanceField = "인스턴스";

	void instanceMethod() {
		// 인스턴스 메소드는 객체가 생성된 뒤에 호출
		System.out.println("인스턴스 객체를 호출합니다.");
		// 생성자에 의해 자동으로 0으로 초기화되어 사용된다.

		// instance, static field 둘 다 가져올 수 있다.
		// => 인스턴스 필드, 정적 필드를 사용할 수 있다.
		System.out.println(instanceField);
		System.out.println(staticField);

		instanceField = "Instance";
		// staticField = "Static"; // 정적 필드 값을 변경하는 것은 일반적이지는 않다.

		System.out.println(instanceField);
		// System.out.println(staticField);
	}

	static String staticField = "정적";

	static void staticMethod1() {
		// 중요!
		// 정적 메소드에서는 인스턴스 멤버(필드, 메소드)를 사용할 수 없다.
		// System.out.println(instanceField);

		// 정적 메소드에서는 this 도 사용할 수 없다.
		// System.out.println(this.instanceField);

		// 오직 정적 메소드만이 사용 가능하다.
		System.out.println(staticField);
		staticMethod2();

		// 굳이 인스턴스를 사용하고 싶다면, 인스턴스를 여기서 생성해서 사용해야 한다
		ClassName cn = new ClassName();
		System.out.println(cn.instanceField);
	};

	static void staticMethod2() {
		staticField = "static";
	};
}
```

<br/>
<br/>
<br/>


# final 필드와 상수
- 인스턴스 필드와 정적 필드의 값을 변경하는 것을 막고 읽기만 허용할 때 final 필드와 상수를 선언해서 사용해야 한다.
- final 필드에 초기값을 주는 방법은 두 가지가 있다.
  1. 필드 선언 시에 초기값 대입
     ```java
     public class ClassName {
      final int final_field_1 = 10;
      }
     ```
  2. 생성자에서 초기값 대입
     ```java
     public class ClassName {
          final int final_field_2;
          ClassName() {
              FINAL_FIELD_2 = 10;
          }
      }
     ``` 
- 객체마다 따로 저장할 필요가 없고, 여러 개의 값을 가질 필요가 없는 경우에는 static이면서 final인 특성을 부여하여 상수로 선언할 수 있다.
- 상수명은 모두 대문자로 작성하는 것이 관례이며, 단어가 혼합된 경우에는 언더스코어(_)로 단어를 연결해 사용한다.


<br/>
<br/>
<br/>

# 패키지
- Java의 패키지는 단순히 디렉토리(폴더)만을 의미하는 것이 아니라, 클래스의 일부분이 되어 클래스를 식별하는 용도로 사용된다.
- 따라서 클래스의 전체 이름에 패키지도 포함된다.
- 패키지는 상위 패키지와 하위 패키지를 점(.)으로 구분하며 ,주로 개발 회사 도메인 이름의 역순으로 만드는 것이 관례이다.
- 패키지는 클래스를 컴파일하는 과정에서 클래스의 패키지 선언을 보고 자동으로 디렉토리를 생성시킨다.
- 패키지 이름은 모두 소문자로 작성하고, 회사도 메인 이름의 역순을 적은 후, 마지막에는 프로젝트의 이름을 붙여주는 것이 일반적이다.
- 만약 동일한 패키지에 포함된 다수의 클래스를 사용해야 한다면, 클래스 이름을 생략하고 `*`을 사용할 수 있다.
```java
package com.mycompany;

import com.hankook.Tire;

public class Car {
	String brand, model;
	int speed;
	final int MAX_SPEED;
	Tire tire1 = new Tire();
    // 다른 패키지를 사용할 경우
	com.kumho.Tire tire2 = new com.kumho.Tire();

	public Car(String brand, String model, int speed, int MAX_SPEED) {
		this.brand = brand;
		this.model = model;
		this.speed = speed;
		this.MAX_SPEED = MAX_SPEED;
	}
}
```

<br/>
<br/>
<br/>

# 접근 제한자
|접근 제한자|제한 대상|제한 범위|
|---|---|---|
|public|클래스, 필드, 생성자, 메소드|없음|
|protected|필드, 생성자, 메소드|같은 패키지이거나, 자식 객체만 사용 가능|
|(default)|클래스, 필드, 생성자, 메소드|같은 패키지에서만 사용 가능|
|private|필드, 생성자, 메소드|객체 내부에서만 사용 가능|
- (default) : 접근 제한자가 붙지 않은 상태
  
<br/>
<hr/>
<br/>


- 클래스는 public과 default 접근 제한을 가질 수 있다.
```java
class A {}
public class B {}
```
```java
package c;

//import a.A;
import b.B;

public class C {
    // A a; The type A is not visible
    B b = new B();
    // public 클래스만 접근 가능
}
```

<br/>
<hr/>
<br/>


- 생성자는 public, default, protected, private 접근 제한을 가질 수 있다.
```java
package a;

public class ClassName {
	byte byteValue;
	short shortValue;
	int intValue;

	public ClassName(byte byteValue) {
		this.byteValue = byteValue;
	}

	ClassName(short shortValue) {
		this.shortValue = shortValue;
	}

	private ClassName(int intValue) {
		this.intValue = intValue;
	}

	// 같은 객체(클래스) 내에서 생성자 호출
	ClassName cn1 = new ClassName(byteValue);

	// default : 같은 패키지 내에서만 사용 가능
	ClassName cn2 = new ClassName(shortValue);

	// private : 같은 객체 내에서만 사용 가능;
	ClassName cn3 = new ClassName(intValue);
}
```
```java
package b;

import a.ClassName;

public class B {
	byte byteValue = 1;
	short shortValue = 1;
	int intValue = 1;

	// 다른 패키지에서 생성자 호출 가능

	ClassName cn1 = new ClassName(byteValue);

	// default : 같은 패키지 내에서만 사용 가능
	// ClassName cn2 = new ClassName(shortValue);

	// private : 같은 객체 내에서만 사용 가능;
	// ClassName cn3 = new ClassName(intValue);
}
```

<br/>
<hr/>
<br/>


- 필드와 메소드는 public, protected, private 접근 제한을 가질 수 있다.


<br/>
<br/>
<br/>

# Getter, Setter
- 객체지향 프로그래밍에서는 외부에서 직접적인 필드의 접근을 차단한다.
- 메소드를 통해 필드에 접근할 수 있도록 한다.
## Setter
- 메소드를 통해 필드 접근을 하면, 메소드가 데이터 값을 검증해서 유효한 값만 필드 값으로 저장할 수 있게 만드는 메소드

<br/>

```java
public class Car {
	String name;
	private int speed;
	final int MAX_SPEED = 200;

	Car(String name) {
		this.name = name;
	}

	// setter 메소드
	// speed 의 조건을 지키는 유효한 값만 저장할 수 있도록 만드는 메소드
	public void setSpeed(int speed) {
		this.speed = speed >= 0 && MAX_SPEED >= speed ? speed : 0;
	}

	void Info() {
		System.out.println(name + "의 현재 속도: " + speed + "km/h");
	}
}
```

<br/>

```java
public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car("Jack");
		myCar.Info(); // Jack 의 현재 속도: 0km/h

		myCar.setSpeed(50);
		myCar.Info(); // Jack 의 현재 속도: 50km/h

		myCar.setSpeed(-50);
		myCar.Info(); // Jack 의 현재 속도: 0km/h

		myCar.setSpeed(5000);
		myCar.Info(); // Jack 의 현재 속도: 0km/h

	}

}
```
## Getter
- 외부에서 객체의 필드를 읽을 때에도 메소드가 필요한 경우가 있다.
- 필드값이 객체 외부에서 사용하기에 적절하지 않은 경우, 메소드를 이용해 적절한 형태로 변환해서 반환할 수 있기 때문
- 필드타입이 boolean인 경우, 
Getter는 get으로 시작하지 않고 is로 시작하는 것이 관례
```java
// Car
	// getter 메소드
	public int getSpeed() {
		return speed;
	}
```

<br/>

```java
// CarExample
System.out.println(5 * myCar.getSpeed());
```

<br/>
<br/>
<br/>

# 싱글톤 패턴
- 클래스의 객체를 단 하나만 생성하고, 해당 객체를 어디서든지 접근할 수 있도록 하는 디자인 패턴
- 주로 애플리케이션 전체에서 하나의 객체만 존재해야 하는 경우 사용
- 싱글톤 패턴의 핵심은 생성자를 private으로 접근을 제한하여 외부에서 new연산자로 객체를 생성할 수 없도록 하는 것이다.
- 외부에서 생성자 호출이 불가능해지고, 정적 메소드를 통해 간접적으로 객체를 얻는 것만이 가능해진다.
- 싱글톤 패턴을 사용하는 이유
  1. 공통된 자원을 관리하거나 설정값을 유지할 수 있다.
  2. 불필요한 객체 생성을 방지하여 메모리를 절약할 수 있다.

- ㄸ