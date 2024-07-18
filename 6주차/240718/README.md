## 목차
- [중첩 클래스 - 바깥 클래스에 접근](#중첩-클래스---바깥-클래스에-접근)
- [중첩 인터페이스 (Nested Interface)](#중첩-인터페이스-nested-interface)
- [익명 객체(Anonymous Object)](#익명-객체anonymous-object)
	- [익명 자식 객체](#익명-자식-객체)
	- [익명 구현 객체](#익명-구현-객체)
- [라이브러리(Library)와 모듈(Module)](#라이브러리library와-모듈module)
	- [라이브러리](#라이브러리)
		- [라이브러리 생성해보기](#라이브러리-생성해보기)

<br/>
<br/>
<br/>
<br/>

# 중첩 클래스 - 바깥 클래스에 접근
- 인스턴스 멤버 클래스는 바깥 클래스가 생성되어야 생성이 가능하다는 특징이 있다.
- 따라서 바깥 클래스의 모든 필드와 메소드에 접근 가능하다.
- 하지만 정적 클래스는 바깥 클래스 없어도 사용 가능해야 한다.
- 따라서 바깥 클래스의 인스턴스 필드와 인스턴스 메소드 접근은 불가능하고, 정적 필드와 정적 메소드만 접근할 수 있다.
- 만약 중첩 클래스 안에서 바깥 클래스의 객체를 얻기 위해서는 바깥클래스 이름에 `this`를 붙여주면 된다.
- 바깥 클래스에서 중첩 클래스의 인스턴스를 사용하려면 안쪽 인스텉스를 생성하고 사용해야 한다.
```java
public class Outter {
	// 바깥 클래스의 필드
	String name = "바깥쪽";

	// 바깥 클래스의 (인스턴스) 메소드
	void method() {
		System.out.println("\t바깥쪽 메소드");
	}

	// 바깥에서 바깥 필드와 (인스턴스) 메소드 사용
	void useOutter() {
		System.out.println("바깥에서 바깥 필드와 (인스턴스) 메소드 사용");
		System.out.println("\t" + name);
		method();
	}

	// 바깥에서 안쪽 필드와 (인스턴스) 메소드 사용
	// 바깥에서 안쪽 인스턴스를 생성하고 사용해야 한다.
	void useInner() {
		System.out.println("안쪽에서 안쪽 필드와 (인스턴스) 메소드 사용");

		// 안쪽 인스턴스 생성
		Inner i = new Inner();
		System.out.println("\t" + i.name);
		i.method();
	}

	// 중첩 (인스턴스 멤버) 클래스 선언
	class Inner {
		// 안쪽 클래스의 필드
		String name = "안쪽";

		// 안쪽 클래스의 (인스턴스) 메소드
		void method() {
			System.out.println("\t안쪽 메소드");
		}

		// 안쪽에서 안쪽 필드와 (인스턴스) 메소드 사용
		void useInner() {
			System.out.println("안쪽에서 안쪽 필드와 (인스턴스) 메소드 사용");
			System.out.println("\t" + name);
			method();
		}

		// 안쪽에서 바깥 필드와 (인스턴스) 메소드 사용
		void useOutter() {
			System.out.println("안쪽에서 바깥 필드와 (인스턴스) 메소드 사용");
			// System.out.println("\t" + name); => 안쪽 name 으로 출력
			// method(); => 안쪽 method 이용해서 출력
			System.out.println("\t" + Outter.this.name);
			Outter.this.method();

		}
	}

}
```
```java
public class OuterExample {
	public static void main(String[] args) {
		Outter o = new Outter();
		o.useOutter();
		// 바깥에서 바깥 필드와 (인스턴스) 메소드 사용
		// 바깥쪽
		// 바깥쪽 메소드
		o.useInner();
		// 바깥에서 안쪽 필드와 (인스턴스) 메소드 사용
		// 안쪽
		// 안쪽 메소드

		Outter.Inner i = o.new Inner();
		i.useInner();
		// 안쪽에서 안쪽 필드와 (인스턴스) 메소드 사용
		// 안쪽
		// 안쪽 메소드
		i.useOutter();
		// 안쪽에서 바깥 필드와 (인스턴스) 메소드 사용
		// 바깥쪽
		// 바깥쪽 메소드
	}
}
```

<br/>
<br/>
<br/>
<br/>

# 중첩 인터페이스 (Nested Interface)
- 클래스의 멤버로 선언된 인터페이스를 중첩 인터페이스라고 한다.
- 특정 클래스와 긴밀한 관계를 맺는 구현 객체를 만들기 위해서 중첩 인터페이스를 선언한다.
- 외부의 접근을 막지 않으려면 `public`을 붙이고, 클래스 내부에서만 사용하려면 `private`을 붙이고, 접근 제한자를 붙이지 않으면 같은 패키지 내에서만 접근 가능하다.
- 중첩 인터페이스는 암시적으로 `static`이므로 생략해도 항상 바깥 클래스(객체) 없이 인터페이스 사용이 가능하다.
```java
public class Button {
	// 중첩 인터페이스 선언 (static 생략)
	public /* static */ interface ClickListener {
		void onClick();
	}

	// 필드 선언
	private ClickListener clickListener;

	// method 선언 (setter)
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}

	public void click() {
		this.clickListener.onClick();
	}
}
```
```java
import com.nested.interface1.Button.ClickListener;

public class ButtonExample {
	public static void main(String[] args) {
		Button btnOK = new Button();

		// 로컬 클래스 생성
		class OKListener implements ClickListener {
			// override 필수
			@Override
			public void onClick() {
				System.out.println("OK 버튼을 눌렀습니다");
			}
		}

		// 매개변수가 인터페이스인데 직접 생성할 수 없으므로 클래스를 생성하고 implements 한다
		// 중첩 클래스로 만들 수 있음
		btnOK.setClickListener(new OKListener());
		btnOK.click(); // OK 버튼을 눌렀습니다

		// 다른 버튼 생성
		Button btnCANCEL = new Button();

		class CANCELLIstener implements ClickListener {
			@Override
			public void onClick() {
				System.out.println("CANCEL 버튼을 눌렀습니다");
			}
		}

		btnCANCEL.setClickListener(new CANCELLIstener());
		btnCANCEL.click(); // CANCEL 버튼을 눌렀습니다
	}
}
```

<br/>
<br/>
<br/>
<br/>

# 익명 객체(Anonymous Object)
- 명시적으로 클래스를 선언하지 않은 이름이 없는 객체를 의미한다.
- 명시적으로 클래스를 선언하지 않았기 때문에 쉽게 객체 생성이 가능하다.
- 익명 객체는 필드값, 로컬변수값, 매개변수값으로 주로 사용된다.
- 익명 객체를 생성하기 위해서는 클래스를 상속하거나 인터페이스를 구현해야 한다.
  - 클래스를 상속해서 만들면 `익명 자식 객체`라고 한다.
  - 인터페이스를 구현해서 만들면 `익명 구현 객체`라고 한다.
```java
// 익명 객체
btnOK.setClickListener(new ClickListener() {
	@Override
	public void onClick() {
		System.out.println("OK 버튼을 눌렀습니다.");
	}
});
btnOK.click();
```

<br/>
<br/>

## 익명 자식 객체
- 부모 클래스를 상속받아 생성된다.
- 익명 자식 객체는 부모 타입의 필드, 로컬 변수, 매개변수의 값으로 대입할 수 있다.
```java
public class Car {
	// 필드에 Tire 객체 대입
	private Tire frontLeft = new Tire();
	private Tire frontRight = new KumhoTire();
	private Tire rearLeft = new HankookTire();

	// 필드에 익명 자식 객체 대입
	private Tire rearRight = new Tire() {
		@Override
		public void roll() {
			System.out.println("3. 익명 타이어 굴라간다.");
		}
	};

	// 필드 사용 메소드
	public void run1() {
		frontLeft.roll();
		frontRight.roll();
		rearLeft.roll();
		rearRight.roll();
	}

	// 로컬 변수 사용 메소드
	public void run2() {
		// 로컬 변수에 익명 자식 객체 대입
		Tire tire = new Tire() {
			@Override
			public void roll() {
				System.out.println("2. 익명 자식 객체 Tire가 굴러갑니다");
			}
		};
		tire.roll();
	}

	public void start() {
		Engine e = new Engine() {
			// 로컬 변수에 익명 자식 객체르 대입해서 사용 => 익명 엔진 생성
			@Override
			void use() {
				System.out.println("익명 엔진이 사용됩니다");
			}
		};
		e.use();
	}

	public void curve(Handle h) {
		h.turn();
	}
}
```
```java
public class CarExample {
	public static void main(String[] args) {
		Car c = new Car();
		c.run1();

		System.out.println();

		c.run2();

		System.out.println();

		c.start();

		System.out.println();

		c.curve(new Handle());
		c.curve(new PowerHandle());

		// 메소드의 매개변수 값으로 대입되는 익명 자식 객체
		// 필드 로컬 변수 매개값으로 사용하는 익명 자식 객체
		c.curve(new Handle() {
			@Override
			void turn() {
				System.out.println("익명 핸들을 돌립니다");
			}
		});
	}
}
```

<br/>
<br/>

## 익명 구현 객체
- 인터페이스를 구현해서 생성된다.
- 익명 구현 객체는 인터페이스 타입의 필드, 로컬 변수, 매개변수의 값으로 대입할 수 있다.
```java
public class Home {

	// 필드에 인터페이스 구현 객체 대입
	// private RemoteControl rc = new Television();

	// 필드에 인터페이스 익명 구현 객체 대입
	private RemoteControl rc = new RemoteControl() {
		@Override
		public void turnOn() {
			System.out.println("내 방 불 전원을 켭니다.");
		}

		@Override
		public void turnOff() {
			System.out.println("내 방 불 전원을 끕니다");
		}
	};

	public void play() {
		rc.turnOn();
	}

	public void useSwtich() {
		// 로컬 변수에 인터페이스 구현 객체 대입
		// Switch s = new BathRoomSwitch();

		// 로컬 변수에 인터페이스 익명 구현 객체 대입
		Switch s = new Switch() {
			@Override
			public void click() {
				System.out.println("익명 두꺼비집 동작시킵니다");
			}
		};
		s.click();
	}

	// 매개변수로 인터페이스 구현 객체 사용
	public void exercise(GymLink g) {
		g.use();
	}
}
```
```java
public class HomeExample {
	public static void main(String[] args) {
		Home home = new Home();
		home.play();

		System.out.println();
		home.useSwtich();

		System.out.println();

		// 매개변수 값으로 인터페이스 구현 객체 대입
		// home.exercise(new RunningMachine());

		// 매개변수 값으로 인터페이스 익명 구현 객체 대입
		home.exercise(new GymLink() {
			@Override
			public void use() {
				System.out.println("줄넘기를 하러 갑니다.");
			}
		});
	}
}
```

<br/>
<br/>
<br/>
<br/>

# 라이브러리(Library)와 모듈(Module)
- 라이브러리
  - 프로그램 개발 시 활용할 수 있는 클래스와 인터페이스들을 모아놓은 것을 의미
  - 일반적으로 `JAR(Java Archive)` 압축 파일 형태로 존재한다.
- 모듈
  - 패키지 관리 기능까지 포함된 라이브러리로, Java 9 부터 지원한다.
  - 라이브러리 일종이므로 `JAR` 파일 형태로 배포 가능하다.

<br/>

## 라이브러리
- 특정 클래스와 인터페이스가 응용 프로그램을 개발할 때 공통으로 자주 사용된다면, JAR 파일로 압축해서 라이브러리로 관리하는 것이 좋다.
- 프로그램 개발  라이브러리를 이용하려면 JAR 파일을 `ClassPath`(클래스 경로)에 추가해야 한다.
- ClassPath에 라이브러리를 추가하는 방법
  - 콘솔(명령프롬프트, 터미널등)에서 프로그램을 실행할 경우
    - java 명령어를 실행할 때­ classpath로 제공하거나 CLASSPATH 환경변수에 경로를 추가
  - 이클립스 프로젝트에서 실행할 경우
    - 프로젝트의 BuildPath에 추가
### 라이브러리 생성해보기
1. 프로젝트 만들기
2. 패키지와 클래스 생성
   1. project: my_library
   2. package pack1 > class A
   3. package pack2 > class B
3. 프로젝트 선택 후, 마우스 우클릭[New > Folder로  dist 폴더 생성]
4. export
   ![alt text](image.png)   
   ![alt text](image-1.png)   
   ![alt text](image-2.png)
5. 