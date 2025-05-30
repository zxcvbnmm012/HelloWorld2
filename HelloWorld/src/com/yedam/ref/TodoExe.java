package com.yedam.ref;

import java.util.Scanner;

public class TodoExe {
	public static void main(String[] args) {
		boolean run = true; // 반복문 실행 / 종료
		int studentNum = 0; // 학생수
		int[] scores = null; // 학생점수저장
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			
			System.out.println("--------------------------------------");
			System.out.println("1.학생수 2.점수입력 3.점수리스트 4.분석 5.종료");
			System.out.println("--------------------------------------");
			System.out.println("선택>> ");
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			if (selectNo == 2 || selectNo == 3 || selectNo == 4) {  // NullPointerException 처리
				if (scores == null) {
					System.out.println("학생수를 지정하세요.");
					continue;
				}
			}
			
			if (selectNo == 1) {
				System.out.println("학생수>> ");
				studentNum = Integer.parseInt(scanner.nextLine());
				scores = new int[studentNum]; // 배열의 크기 지정
			} else if (selectNo == 2) {
				for (int i = 0; i < scores.length; i++) {
					System.out.printf("scores[%d]> ", i);
					scores[i] = Integer.parseInt(scanner.nextLine());
				}

			} else if (selectNo == 3) {  // scores 리스트 출력
				int sum = 0;
				for (int i = 0; i < scores.length; i++) {
					sum += scores[i];
				}
				if (sum == 0) {
					System.out.println("점수를 입력하세요");
					continue;
				}
				
				System.out.println("< scores 점수리스트 >");
				for (int i = 0; i < scores.length; i++) {
					System.out.printf("scores[%d]> %d \n", i, scores[i]);
				}
				
			} else if (selectNo == 4) {  // 분석 ( avg, max )
				int sum = 0;
				int max = 0;
				double avg = 0;
				
				for (int i = 0; i < scores.length; i++) {
					sum += scores[i];
					if (max < scores[i]) {
						max = scores[i];
					}
				}
				
				avg = 1.0 * sum / scores.length;
				
				System.out.printf("avg> %f \n", avg);
				System.out.printf("max> %d \n", max);

			} else if (selectNo == 5) {
				run = false;
				
			}
		} // end of while
		System.out.println("프로그램 종료");
		
	} // end of main
} // end of class
