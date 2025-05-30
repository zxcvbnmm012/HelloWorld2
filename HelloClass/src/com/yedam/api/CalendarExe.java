package com.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/* 
 * Calendar: 날짜, 시간 관련 class
 * Date: 날짜, 시간... 관련 class
 */

public class CalendarExe {
	public static void main(String[] args) {
		makeCalendar(2025, 1);

	} // end of main

	public static void cal() {
		// Calendar 클래스
		Calendar now = Calendar.getInstance(); // getInstance() : Calendar 클래스의 인스턴스를 생성하는 메소드

		// 시간변경
		now.set(2025, 0, 1); // Month 0 == 1월
		now.set(Calendar.YEAR, 2024); // Year -> 2024 변경
		now.set(Calendar.DATE, 10); // Date -> 10 변경

		// 요일
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		switch (dayOfWeek) {
		case 1:
			System.out.println("일요일");
			break;
		case 2:
			System.out.println("월요일");
			break;
		case 3:
			System.out.println("화요일");
			break;
		case 4:
			System.out.println("수요일");
			break;
		case 5:
			System.out.println("목요일");
			break;
		case 6:
			System.out.println("금요일");
			break;
		case 7:
			System.out.println("토요일");
			break;
		}

		System.out.printf("년도: %d, 월: %d, 날짜: %d, 요일: %d, 말일: %d \n", //
				now.get(Calendar.YEAR) //
				, now.get(Calendar.MONTH) //
				, now.get(Calendar.DATE) //
				, now.get(Calendar.DAY_OF_WEEK) //
				, now.getActualMaximum(Calendar.DATE));

	} // end of cal()

	public static void date() {
		Date today = new Date();
		System.out.println(today.toString());

		// 생성자의 매개값으로 포맷지정; 포맷변경
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 / HH시 mm분 ss초");

		// format 메소드 : 출력하고 싶은 형태의 문자열을 반환
		String timeStr = sdf.format(today); // Date -> String
		System.out.println(timeStr);

		// parse 메소드 : 문자열을 Date 타입으로 반환
		try {
			today = sdf.parse("2025년 08월 01일 / 09시 00분 00초"); // String -> Date
			// sdf에서 지정한 포맷으로 String을 작성해야함
			// 다른 포맷으로 작성하면 ParseException 에러

		} catch (ParseException e) {
			e.printStackTrace();

		}
		System.out.println(today);

	} // end of date()
	
	
	public static int getSpace(int month) {
		int space = 0;
		Calendar now = Calendar.getInstance();
		now.set(2025, month - 1, 1);
		space = now.get(Calendar.DAY_OF_WEEK) - 1;
		return space;
	}
	
	public static void makeCalendar(int year, int month) {
		getSpace(month);
		Calendar now = Calendar.getInstance();


		System.out.println();
		System.out.printf("         %d년 %02d월 \n", year, month);
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		
		// 공란을 포함해 달력 형태로 출력
		int space = getSpace(month);      // 빈공간
		int lastDate = now.getActualMaximum(Calendar.DATE);  // 마지막 날짜
		for(int s = 1; s <= space; s++) {
			System.out.printf("%4s", " ");
		}
		for(int day2 = 1; day2 <=lastDate; day2++) {
			System.out.printf("%4d", day2);
			if((day2 + space) % 7 == 0) {
				System.out.println();
			}
		}



	} // end of makeCalendar();
	


} // end of class
//https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html