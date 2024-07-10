package com.statement.condition;

public class SwtichExample2 {

	public static void main(String[] args) {
		char grade = (char) ((Math.random() * 6) + 'A');
//		Scanner sc = new Scanner(System.in);
//		String grade = sc.nextLine();
		System.out.println("등급: " + grade);

		switch (grade) {
		case 'A':
			System.out.println("훌륭합니다!");
			break;
		case 'B':
			System.out.println("좋습니다!");
			break;
		case 'C':
			System.out.println("나쁘지 않습니다!");
			break;
		case 'D':
			System.out.println("조금 아쉽습니다!");
			break;
		case 'E':
			System.out.println("나쁩니다!");
			break;
		case 'F':
			System.out.println("실패했습니다");
			break;
		default:
			System.out.println("잘못된 등급입니다.");
		}
	}

}
