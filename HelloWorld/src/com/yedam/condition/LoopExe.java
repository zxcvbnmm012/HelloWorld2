package com.yedam.condition;

import java.util.Scanner;

public class LoopExe {
	public static void main(String[] args) {
		test2();
		
	} // end of main
	
	
	public static void test1() {
		boolean run = false;
		
		// while문 : 바로 실행
		while (run) {
			System.out.println("while문");
		}
		System.out.println("end of prog.");
		
		// do .. while 문 : do문을 먼저 실행하고 while문 실행
		do {
			System.out.println("while문");
		} while(run = !run); // true
		System.out.println("end of prog.");

		do {
			System.out.println("while문");
			run = !run;
		} while(run = !run); // true
		System.out.println("end of prog.");

	} // end of test1()
	
	
	
// test2()
// 가위(1), 바위(2), 보(3)
	public static void test2() {
		int num = 0;
		while(true) {
			int randomValue = (int)(Math.random()*3)+1;
			Scanner scn = new Scanner(System.in);
			System.out.println("가위, 바위, 보!>>");
			System.out.println(">>");
			String strscn = scn.nextLine();
			if (strscn.equals("가위")) {
				num = 1;
				if (randomValue == 3) {
					System.out.println("You win");
				} else if (randomValue == 2) {
					System.out.println("You lost");
				} else {
					System.out.println("Same");
				}
			} else if (strscn.equals("바위")) {
				num = 2;
				if (randomValue == 1) {
					System.out.println("You win");
				} else if (randomValue == 3) {
					System.out.println("You lost");
				} else {
					System.out.println("Same");
				}
			} else if (strscn.equals("보")) {
				num = 3;
				if (randomValue == 2) {
					System.out.println("You win");
				} else if (randomValue == 1) {
					System.out.println("You lost");
				} else {
					System.out.println("Same");
				}
			} else if (strscn.equals("종료")) {
				System.out.println("종료합니다");
				break;
			} if (randomValue == 1) {
				System.out.println("system은 '가위'를 냈습니다");
			} else if (randomValue == 2) {
				System.out.println("system은 '바위'를 냈습니다");
			} else if (randomValue == 3) {
				System.out.println("system은 '보'를 냈습니다");
			}
		}
	}
		
	
	
} // end of class
