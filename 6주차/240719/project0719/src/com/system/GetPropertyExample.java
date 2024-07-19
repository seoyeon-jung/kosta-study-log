package com.system;

import java.util.Properties;
import java.util.Set;

public class GetPropertyExample {

	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");
		System.out.println(osName + ", " + userName + ", " + userHome);

		Properties props = System.getProperties();
		Set keys = props.keySet();
		for (Object key : keys) {
			System.out.println(key + " : " + System.getProperty((String) key));
		}
	}

}
