package com.oop.interface5;

public class SmartPhone extends Phone implements SmartService {

	@Override
	public void openApp(String appName) {
		System.out.println(appName + "을(를) 실행합니다.");

	}

}
