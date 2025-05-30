package com.yedam;

import com.yedam.member.Member;

/*
 * 메소드 연습
 * 1) 메소드의 선언
 * 2) 매개변수
 * 3) 반환유형
 */

public class Calculator {
	// 필드
	// 생성자
	// 메소드
	void printStar1(int times, String shape){   // 매개변수(times)
		for (int i = 1; i <= times; i++) {
			System.out.println(shape);			
		}
	} // end of printStar1
	
	String printStar2(int times, String shape){   // 매개변수(times)
		String str = "";
		for (int i = 1; i <= times; i++) {
			str += shape + "\n";			
		}
		return str;
	} // end of printStar2
	
	
	
	// method overloading : 동일한 이름의 메소드를 중복 정의 -> 매개변수의 데이터타입/개수가 다르거나 반환값이 달라야함
	int add(int num1, int num2) {
		return num1 + num2;
	}
	
	double add(double num1, double num2) {
		return num1 + num2;
	}
	
	double add(int[] num1) {
		int sum = 0;
		for (int i = 0; i < num1.length; i++) {
			sum += num1[i];
		}
		return sum;
	}
	
	Member getMaxPoint(Member[] memberArray) {
		Member max = null;
		int maxPoint = 0;
		for ( int i = 0; i < memberArray.length; i++) {
			if( maxPoint < memberArray[i].getPoint()) {
				maxPoint = memberArray[i].getPoint();
				max = memberArray[i];
			}
		}
		return max;
	}
	
	// point에 젤 높은 사람과 낮은 사람을 뽑아서 두개의 평균
	int getAvgPoint(Member[] memberArray) {
		int avg = 0;
		int maxPoint = 0;
		int minPoint = 0;
		for ( int i = 0; i < memberArray.length; i++) {
			if( maxPoint < memberArray[i].getPoint()) {
				maxPoint = memberArray[i].getPoint();
			
			}
			if( minPoint > memberArray[i].getPoint()){
				minPoint = memberArray[i].getPoint();
				
			}
			avg = (maxPoint + minPoint / 2);
		}
		return avg;
	}
	
}
