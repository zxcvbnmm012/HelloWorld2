package com.yedam;

import com.yedam.member.Member;

public class CalculatorExe {
	public static void main(String[] args) {
		
		Calculator cal = new Calculator(); // 인스턴스 생성
		
		int num1 = 10;
		String str = "🍔🍸🍓";
		
		cal.printStar1(num1, str);       // 매개값 10을 넣어줌
		String result = cal.printStar2(num1, str);
		System.out.println(result);
		
		int sum = cal.add(num1, num1);
		System.out.println(sum);

		double sum2 = cal.add(num1, 10.5);
		System.out.println(sum2);
		System.out.println();
		
		int[] numAry = {10, 20, 30};
		double sum3 = cal.add(numAry);
		System.out.println(sum3);
		System.out.println();
		
		// Member[] 중에서 point가 가장 큰 회원을 반환
		Member[] members = {new Member("user01", "홍길동", "1111", 1000),
				            new Member("user02", "김민규", "2222", 2200),
				            new Member("user03", "황선홍", "3333", 2700),
				            new Member("user04", "홍명보", "4444", 1900)};
		
		Member member = cal.getMaxPoint(members);
		System.out.println("포인트가 가장 많은 member는?");
		System.out.println(member.getMemberName());
		member.showInfo();
		
		System.out.println();
		
		
	// 오버로딩을 적용한 println 메소드	
//		System.out.println("10");
//		System.out.println(10);
//		System.out.println(true);
		
	} // end of main
} // end of class
