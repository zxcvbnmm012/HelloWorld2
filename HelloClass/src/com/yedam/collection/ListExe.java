package com.yedam.collection;

import java.util.ArrayList;

import java.util.List;
import com.yedam.api.Member;

/*
 * 인덱스를 사용해서 객체를 관리
 * 순서를 가지고 중복된 값 가능
 */






public class ListExe {
	public static void main(String[] args) {
		// 10 ~ 100 점 점수를 임의의 값으로 생성. 정수10개 생성.
		List<Student> numbers = new ArrayList<>();
		for (int i = 1; i <= 10; i++) { // 10번 생성.
			int score = (int) (Math.random() * 91) + 10;
			numbers.add(new Student(1000 + i, score));
		}
		// 10개의 점수의 합, 평균 출력.
		int sum = 0;
		double avg = 0;
		for (int i = 0; i < numbers.size(); i++) {
			sum += numbers.get(i).getScore(); // Student(no,score)
		}
		avg = 1.0 * sum / numbers.size();
		System.out.printf("점수의 합: %d, 평균: %.1f\n", sum, avg);

	} // end of main
	
	

	public static void exe1() {
		// list 컬렉션
		// 추가하면 공간이 계속 늘어남
		// 특정 위치에 추가 가능
		// 모든 타입을 담을 수 있음
		List<String> list = new ArrayList<String>(); // 컬렉션

		// add: 추가
		list.add("10");
		list.add(new String("Hello"));
		list.add(1, "20"); // 추가할 위치 지정 가능

		// remove: 제거
		list.remove(0); // 첫번째 위치 삭제

		// set: 변경
		list.set(1, "World"); // 두번째 위치 변겅

		for (int i = 0; i < list.size(); i++) { // 리스트의 크기 : list.size()
			System.out.println(list.get(i));
		}

		for (String item : list) {
			String result = item;
			System.out.println(item);
		}
	} // end of exe1()

	public static void exe2() {
		List<Member> members = new ArrayList<>();

		Member member = new Member("홍길동", 10);
		members.add(new Member("김홍동", 20));
		members.add(member);
		members.add(new Member("김홍도", 30));

		members.remove(member);

		String search = "김홍동";

		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).memberName.equals(search)) {
				members.remove(i);
			}
		}

		for (int i = 0; i < members.size(); i++) {
			System.out.println(members.get(i).toString());
		}
	}

} // end of class
