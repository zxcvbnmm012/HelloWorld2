package com.yedam;

import java.util.Scanner;

// java 규칙 : 객체(Object) = 속성(field) + 동작(method)

public class ObjectExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int year = 0;

		while (true) {
			System.out.println("");
			System.out.println("년도를 입력하세요>> ");
			String msg = scn.nextLine();
			try {
				year = Integer.parseInt(msg);

			} catch (NumberFormatException e) {
				if (msg.equals("quit")) {
					System.out.println("\nend of prog.");
					break;
				}
				System.out.println("숫자로 년도를 입력하세요!!!");
				continue;

			}
			if (!Calendar.isLeapYear(year)) {
				System.out.printf("%d년은 윤년이 아닙니다", year);
			} else {
				System.out.printf("%d년은 윤년입니다", year);	
			}

		} // end of while
	} // end of main
} // end of class
