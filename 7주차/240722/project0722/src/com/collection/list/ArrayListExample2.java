package com.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample2 {

	public static void main(String[] args) {
		// Board를 요소로 갖는 ArrayList 생성
		List<Board> list = new ArrayList<>();

		// 객체를 추가
		// 제목1, 내용1, 글쓴이1
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		// 제목2, 내용2, 글쓴이2
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		// 제목3, 내용3, 글쓴이3
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		// 제목4, 내용4, 글쓴이4
		list.add(new Board("제목4", "내용4", "글쓴이4"));
		// 제목5, 내용5, 글쓴이5
		list.add(new Board("제목5", "내용5", "글쓴이5"));

		// 저장된 객체의 총 개수를 출력
		int size = list.size();
		System.out.println("객체의 총 개수: " + size);

		// 객체 내용 전체 출력
		System.out.println("객체 내용 전체 출력: " + list);

		// 2번째 객체 요소 삭제
		list.remove(2);

		// 2번째 인덱스의 객체 가져와서 출력
		System.out.println("2번째 인덱스 출력: " + list.get(2));

		// 반복문을 통해서 하나의 객체를 출력
		for (Board item : list) {
			System.out.println(item);
		}

	}

}
