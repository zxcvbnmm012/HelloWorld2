package com.yedam;

import java.util.Scanner;

public class Calendar {
	static void showMonth() {
		boolean run = true;
		while (run) {
		// Sun Mon Tue Wed Thu Fri Sat
		// =============================
		// 1 2 3
		// 4 5 6 7 8 9 10
		Scanner scn = new Scanner(System.in);
		int blank = 0;
		System.out.println("Month >> ");
		int month = Integer.parseInt(scn.nextLine());
		String str = " ";
			switch (month) {
			case 1:
				System.out.println("            1월 달력           ");
				System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
				System.out.println("=============================");
				blank = 3;
				for (int i = 0; i < blank; i++) {
					System.out.printf("%4s", str);
				}
				for (int i = 1; i <= 31; i++) {
					System.out.printf("%4d", i);
					if ((blank + i) % 7 == 0) {
						System.out.println();
					}
				}
				System.out.println();
				System.out.println("\n계속 확인하겠습니까 n or y >> ");
				String check1 = scn.nextLine();
				if (check1.equals("n")) {
					System.out.println("end of prog.");
					run = false;
				} else if (check1.equals("y")) {
					continue;
				}
				break;

			case 2:
				System.out.println("            2월 달력           ");
				System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
				System.out.println("=============================");
				blank = 6;
				for (int i = 0; i < blank; i++) {
					System.out.printf("%4s", str);
				}
				for (int i = 1; i <= 28; i++) {
					System.out.printf("%4d", i);
					if ((blank + i) % 7 == 0) {
						System.out.println();
					}
				}
				System.out.println();
				System.out.println("\n계속 확인하겠습니까 n or y >> ");
				String check2 = scn.nextLine();
				if (check2.equals("n")) {
					System.out.println("end of prog.");
					run = false;
				} else if (check2.equals("y")) {
					continue;
				}
				break;

			case 3:
				System.out.println("            3월 달력           ");
				System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
				System.out.println("=============================");
				blank = 6;
				for (int i = 0; i < blank; i++) {
					System.out.printf("%4s", str);
				}
				for (int i = 1; i <= 31; i++) {
					System.out.printf("%4d", i);
					if ((blank + i) % 7 == 0) {
						System.out.println();
					}
				}
				System.out.println();
				System.out.println("\n계속 확인하겠습니까 n or y >> ");
				String check3 = scn.nextLine();
				if (check3.equals("n")) {
					System.out.println("end of prog.");
					run = false;
				} else if (check3.equals("y")) {
					continue;
				}
				break;

			case 4:
				System.out.println("            4월 달력           ");
				System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
				System.out.println("=============================");
				blank = 2;
				for (int i = 0; i < blank; i++) {
					System.out.printf("%4s", str);
				}
				for (int i = 1; i <= 30; i++) {
					System.out.printf("%4d", i);
					if ((blank + i) % 7 == 0) {
						System.out.println();
					}
				}
				System.out.println();
				System.out.println("\n계속 확인하겠습니까 n or y >> ");
				String check4 = scn.nextLine();
				if (check4.equals("n")) {
					System.out.println("end of prog.");
					run = false;
				} else if (check4.equals("y")) {
					continue;
				}
				break;

			case 5:
				System.out.println("            5월 달력           ");
				System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
				System.out.println("=============================");
				blank = 4;
				for (int i = 0; i < blank; i++) {
					System.out.printf("%4s", str);
				}
				for (int i = 1; i <= 31; i++) {
					System.out.printf("%4d", i);
					if ((blank + i) % 7 == 0) {
						System.out.println();
					}
				}
				System.out.println();
				System.out.println("\n계속 확인하겠습니까 n or y >> ");
				String check5 = scn.nextLine();
				if (check5.equals("n")) {
					System.out.println("end of prog.");
					run = false;
				} else if (check5.equals("y")) {
					continue;
				}
				break;

			case 6:
				System.out.println("            6월 달력           ");
				System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
				System.out.println("=============================");
				blank = 0;
				for (int i = 0; i < blank; i++) {
					System.out.printf("%4s", str);
				}
				for (int i = 1; i <= 30; i++) {
					System.out.printf("%4d", i);
					if ((blank + i) % 7 == 0) {
						System.out.println();
					}
				}
				System.out.println();
				System.out.println("\n계속 확인하겠습니까 n or y >> ");
				String check6 = scn.nextLine();
				if (check6.equals("n")) {
					System.out.println("end of prog.");
					run = false;
				} else if (check6.equals("y")) {
					continue;
				}
				break;

			case 7:
				System.out.println("            7월 달력           ");
				System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
				System.out.println("=============================");
				blank = 2;
				for (int i = 0; i < blank; i++) {
					System.out.printf("%4s", str);
				}
				for (int i = 1; i <= 31; i++) {
					System.out.printf("%4d", i);
					if ((blank + i) % 7 == 0) {
						System.out.println();
					}
				}
				System.out.println();
				System.out.println("\n계속 확인하겠습니까 n or y >> ");
				String check7 = scn.nextLine();
				if (check7.equals("n")) {
					System.out.println("end of prog.");
					run = false;
				} else if (check7.equals("y")) {
					continue;
				}
				break;

			case 8:
				System.out.println("            8월 달력           ");
				System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
				System.out.println("=============================");
				blank = 5;
				for (int i = 0; i < blank; i++) {
					System.out.printf("%4s", str);
				}
				for (int i = 1; i <= 31; i++) {
					System.out.printf("%4d", i);
					if ((blank + i) % 7 == 0) {
						System.out.println();
					}
				}
				System.out.println();
				System.out.println("\n계속 확인하겠습니까 n or y >> ");
				String check8 = scn.nextLine();
				if (check8.equals("n")) {
					System.out.println("end of prog.");
					run = false;
				} else if (check8.equals("y")) {
					continue;
				}
				break;

			case 9:
				System.out.println("            9월 달력           ");
				System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
				System.out.println("=============================");
				blank = 1;
				for (int i = 0; i < blank; i++) {
					System.out.printf("%4s", str);
				}
				for (int i = 1; i <= 30; i++) {
					System.out.printf("%4d", i);
					if ((blank + i) % 7 == 0) {
						System.out.println();
					}
				}
				System.out.println();
				System.out.println("\n계속 확인하겠습니까 n or y >> ");
				String check9 = scn.nextLine();
				if (check9.equals("n")) {
					System.out.println("end of prog.");
					run = false;
				} else if (check9.equals("y")) {
					continue;
				}
				break;

			case 10:
				System.out.println("            10월 달력           ");
				System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
				System.out.println("=============================");
				blank = 3;
				for (int i = 0; i < blank; i++) {
					System.out.printf("%4s", str);
				}
				for (int i = 1; i <= 31; i++) {
					System.out.printf("%4d", i);
					if ((blank + i) % 7 == 0) {
						System.out.println();
					}
				}
				System.out.println();
				System.out.println("\n계속 확인하겠습니까 n or y >> ");
				String check10 = scn.nextLine();
				if (check10.equals("n")) {
					System.out.println("end of prog.");
					run = false;
				} else if (check10.equals("y")) {
					continue;
				}
				break;

			case 11:
				System.out.println("            11월 달력           ");
				System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
				System.out.println("=============================");
				blank = 6;
				for (int i = 0; i < blank; i++) {
					System.out.printf("%4s", str);
				}
				for (int i = 1; i <= 30; i++) {
					System.out.printf("%4d", i);
					if ((blank + i) % 7 == 0) {
						System.out.println();
					}
				}
				System.out.println();
				System.out.println("\n계속 확인하겠습니까 n or y >> ");
				String check11 = scn.nextLine();
				if (check11.equals("n")) {
					System.out.println("end of prog.");
					run = false;
				} else if (check11.equals("y")) {
					continue;
				}
				break;

			case 12:
				System.out.println("           12월 달력           ");
				System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
				System.out.println("=============================");
				blank = 1;
				for (int i = 0; i < blank; i++) {
					System.out.printf("%4s", str);
				}
				for (int i = 1; i <= 31; i++) {
					System.out.printf("%4d", i);
					if ((blank + i) % 7 == 0) {
						System.out.println();
					}
				}
				System.out.println();
				System.out.println("\n계속 확인하겠습니까 n or y >> ");
				String check12 = scn.nextLine();
				if (check12.equals("n")) {
					System.out.println("end of prog.");
					run = false;
				} else if (check12.equals("y")) {
					continue;
				}
				break;
				
				default:
					System.out.println("** 그런 달은 없습니다. 다시 입력하세요! **");
					continue;

			} // end of switch
			


		}
	} // end of showMonth()
	
	
	static boolean isLeapYear(int year) {
		// 윤년이면 true, 평년이면 false
		
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		} 
		return false;
	}
	
//	교수님 코드
//	static boolean isLeapYear(int year) {
//		boolean leapYear = true;
//		if (year % 4 != 0) {
//			leapYear = false;
//		}
//		if (leapYear && year % 100 == 0) {
//			leapYear = false;
//		}
//		if (!leapYear && year % 400 == 0) {
//			leapYear = true;
//		}
//		return leapYear;
//	}
	
	
} // end of class
