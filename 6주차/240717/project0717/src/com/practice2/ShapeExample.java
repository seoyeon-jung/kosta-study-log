package com.practice2;

public class ShapeExample {

	public static void main(String[] args) {
		// Shape type 객체 생성
		Shape[] shapeArr = new Shape[6];

		shapeArr[0] = new Triangle(7, 5, "Blue");
		shapeArr[1] = new Rectangle(4, 6, "Blue");
		shapeArr[2] = new Triangle(6, 7, "Red");
		shapeArr[3] = new Rectangle(7, 5, "Red");
		shapeArr[4] = new Triangle(9, 8, "White");
		shapeArr[5] = new Rectangle(5, 7, "White");

		// rectangle, triangle 출력

		// 모든 객체의 넓이 정보와 색상 정보를 for Loop 이용해서 화면에 출력
//		System.out.println("기본정보");
//		for (Shape s : shapeArr) {
//			if (s instanceof Rectangle) {
//				System.out.print("Rectangle\t");
//			} else if (s instanceof Triangle) {
//				System.out.print("Triangle\t");
//			}
//
//			System.out.println(s.getArea() + "\t" + s.getColors());
//		}
		printShapeInfo(shapeArr, "기본정보");

		// setResize(5) 입력 후 사이즈 변경해서 화면에 출력
		for (Shape s : shapeArr) {
			Resize rshape = (Resize) s;
			rshape.setResize(5);
		}

//		System.out.println("\n사이즈를 변경 후 정보");
//		for (Shape s : shapeArr) {
//			if (s instanceof Rectangle) {
//				System.out.print("Rectangle\t");
//			} else if (s instanceof Triangle) {
//				System.out.print("Triangle\t");
//			}
//
//			System.out.println(s.getArea() + "\t" + s.getColors());
//		}
		printShapeInfo(shapeArr, "사이즈를 변경 후 정보");

	}

	public static void printShapeInfo(Shape[] shapeArr, String title) {
		System.out.println(title);
		for (Shape s : shapeArr) {
			if (s instanceof Triangle) {
				System.out.print("triangle");
			} else if (s instanceof Rectangle) {
				System.out.print("rectangle");
			}
			System.out.println("\t" + s.getArea() + "\t" + s.getColors());
		}
		System.out.println();
	}

}
