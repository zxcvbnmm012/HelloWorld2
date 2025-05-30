package com.yedam.api;

import java.util.HashSet;
import java.util.Set;

public class ObjectExe {
	public static void main(String[] args) {
		exe2();
		
	} // end of main
	
	
	
	
	// equals()
	public static void exe1() {
		int num1 = 10, num2 = 10;
		System.out.println(num1 == num2);

		String str1 = new String("Hello");
		String str2 = new String("Hello");
		System.out.println(str1 == str2);
		// str1과 str2는 서로 다른 인스턴스의 주소값을 참조 -> 같지 않음
		System.out.println(str1.equals(str2));
		
		Member mem1 = new Member(); // 인스턴스의 주소
		mem1.memberName = "홍길동";
		mem1.age = 10;
		
		Member mem2 = new Member();
		mem2.memberName = "홍길동";
		mem2.age = 10;
		
		
		System.out.println(mem1 == mem2);
		// mem1과 mem2는 주소값이 다름 -> 같지 않음
		System.out.println(mem1.equals(mem2)); // equals 재정의

	} // end of exe1()
	
	
	
	// 배열[여러건 저장] => 컬렉션(1.List 2.Set 3.Map)
	public static void exe2() {
		int[] ary = new int[5];
		
		// 확장된 for>>  num : ary -> 배열의 크기만큼 반복
		for (int num : ary) {
			System.out.println(num);
		}
		
		// Set 컬렉션
		// Set 컬렉션 특징 : 순서가 없음, 중복된 값을 받지 않음
		// Integer : Lang 패키지에 저장된 기본클래스 -> int
		// HashSet : Set 인터페이스를 구현하는 클래스
		Set<Integer> set = new HashSet<Integer>(); // Integer 클래스를 여러건 담을 수 있는 Set 컬렉션

		set.add(10); // set 인터페이스에 값을 추가
		set.add(20);
		set.add(30);
		
		// 사용자가 선언하는 클래스
		Set<Member> members = new HashSet<Member>();
		members.add(new Member("홍길동", 10));
		members.add(new Member("김민석", 20));
		members.add(new Member("홍길동", 10));
		
		for (Integer num : set) {
			System.out.println(num);
		}

		for (Member num : members) {
			System.out.println(num.toString());
			// 기본메소스 toStrinf() : 인스턴스의 주소값을 16진수로 반환
			// 재정의 : 이름, 나이 반환
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // end of exe2()
	
} // end of class
