package com.anonymous.implement;

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
