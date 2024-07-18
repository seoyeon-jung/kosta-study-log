package com.anonymous.inheritance;

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
