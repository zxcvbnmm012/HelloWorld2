package com.yedam.api;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassExe {
	public static void main(String[] args) {
		try {
			// 클래스의 정보를 반환하는 방법 : 1) Class 클래스 활용
			Class cls = Class.forName("com.yedam.api.Member");  // class의 풀네임 입력
			System.out.println("1) Class 클래스 활용");
			System.out.println(cls.getName());
			System.out.println();

			Field[] fieldAry = cls.getDeclaredFields();  // 클래스 안에 선언된 필드들을 배열로 반환하는 메소드
			
			System.out.println("<선언된 필드명>");
			for (Field field : fieldAry) {
				System.out.println(field.getName());  // 선언된 필드의 필드명 출력
			}
			System.out.println();
			
			Method[] methodAry = cls.getDeclaredMethods(); // 클래스 안에 선언된 메소드들을 배열로 반환하는 메소드
			
			System.out.println("<선언된 메소드>");
			for (Method method : methodAry) {
				System.out.println(method.getName());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} 
		System.out.println();
		
		
		// 클래스의 정보를 반환하는 방법 : 2) 인스턴스.getClass() 활용
		Member member = new Member();
		Class cls2 = member.getClass();
		System.out.println("2) 인스턴스.getClass() 활용"); // Member 클래스의 풀네임 반환
		System.out.println(cls2);
		
		System.out.println();
		
		
		// 클래스의 정보를 반환하는 방법 : 3) 클래스.Class 활용
		System.out.println("3) 클래스.Class 활용");
		Class cls3 = Member.class;  // Member 클래스의 풀네임 반환
		System.out.println(cls3);
		
		System.out.println();
	} // end of main
} // end of class
