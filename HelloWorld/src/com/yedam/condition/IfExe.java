package com.yedam.condition;

import java.util.Scanner;

public class IfExe {
	public static void main(String[] args) {
		test3();
	} // end of main()
	
	
// test1()	
	public static void test1() {
		int score = 80;
		
		if (score >= 90) {
			System.out.println("A학점");
		} else if (score >= 80) {
			System.out.println("B학점");
		} else if (score >= 70) {
			System.out.println("C학점");
		} else {
			System.out.println("불합격");
		}
	} // end of test1()
	
	
	
	
// test2()
	public static void test2() {
		int score = 85;
		
		score = score / 10;
		switch (score) {
		case 10:  // 100점
		case 9:   // 90점대
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		default:
			System.out.println("불합격");
		} // end of switch
	} // end of test2()
	
	
	
// test3()	
// 1 ~ 1000 사이의 임의의 값 생성
	public static void test3() {
		int randomValue = (int)(Math.random() * 1000) + 1;
		int count = 0;
		while(true) {
			Scanner scn = new Scanner(System.in);
			System.out.println("값을 입력하세요>> ");
			count++;
			int intscn = Integer.parseInt(scn.nextLine());
			if (intscn >= 1 && intscn <= 1000) {
				if (intscn < randomValue) {
					System.out.println("입력값보다 큽니다");
					continue;
				} else if (intscn > randomValue) {
					System.out.println("입력값보다 작습니다");
				} else {
					System.out.println("정답입니다");
					break;
				}
			} else {
				System.out.println("1 ~ 1000사이의 값을 입력하세요");
				continue;
			}
			
		} 
		System.out.println("\n프로그램 종료");
		System.out.printf("임의의 값은 %d입니다. 시도한 횟수: %d", randomValue, count);
		
		
	} // end of test3()
	
} // end of class
