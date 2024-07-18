package com.nested.interface1;

import com.nested.interface1.Button.ClickListener;

public class ButtonExample {
	public static void main(String[] args) {
		Button btnOK = new Button();

//		// 로컬 클래스 생성
//		class OKListener implements ClickListener {
//			// override 필수
//			@Override
//			public void onClick() {
//				System.out.println("OK 버튼을 눌렀습니다");
//			}
//		}
//
//		// 매개변수가 인터페이스인데 직접 생성할 수 없으므로 클래스를 생성하고 implements 한다
//		// 중첩 클래스로 만들 수 있음
//		btnOK.setClickListener(new OKListener());
//		btnOK.click(); // OK 버튼을 눌렀습니다

		// 익명 객체
		btnOK.setClickListener(new ClickListener() {
			@Override
			public void onClick() {
				System.out.println("OK 버튼을 눌렀습니다.");
			}
		});
		btnOK.click();

		// 다른 버튼 생성
		Button btnCANCEL = new Button();

		class CANCELLIstener implements ClickListener {
			@Override
			public void onClick() {
				System.out.println("CANCEL 버튼을 눌렀습니다");
			}
		}

		btnCANCEL.setClickListener(new CANCELLIstener());

		// btnCANCEL.setClickListener(() -> System.out.println("CANCEL 버튼을 눌렀습니다"));
		btnCANCEL.click(); // CANCEL 버튼을 눌렀습니다
	}
}
