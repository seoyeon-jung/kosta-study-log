package com.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		Queue<Message> msgQueue = new LinkedList<>();

		msgQueue.offer(new Message("sendMail", "카리나"));
		msgQueue.offer(new Message("Call", "윈터"));
		msgQueue.offer(new Message("sendKakao", "지젤"));
		msgQueue.offer(new Message("CallDeny", "닝닝"));

		while (!msgQueue.isEmpty()) {
			Message msg = msgQueue.poll();
			switch (msg.getCommand()) {
			case "sendMail":
				System.out.println(msg.getTo() + "에게 메일을 보냅니다");
				break;
			case "Call":
				System.out.println(msg.getTo() + "에게 전화합니다");
				break;
			case "sendKakao":
				System.out.println(msg.getTo() + "에게 카톡합니다");
				break;
			case "CallDeny":
				System.out.println(msg.getTo() + "에게 오는 전화를 무시합니다");
				break;
			}
		}

	}

}
