package com.ip.check;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPExample {
	public static void main(String[] args) {
		// IP 주소를 확인할 때는 java.net 패키지의 InetAddress 클래스를 사용한다.
		try {
			InetAddress local = InetAddress.getLocalHost();
			String myIP = local.getHostAddress();
			System.out.println("내 IP 주소 > " + myIP);

			InetAddress[] remoteArr = InetAddress.getAllByName("google.com");
			for (InetAddress remote : remoteArr) {
				String naverIP = remote.getHostAddress();
				System.out.println("구글 IP 주소 > " + naverIP);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
