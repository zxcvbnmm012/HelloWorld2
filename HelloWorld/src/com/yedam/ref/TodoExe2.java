package com.yedam.ref;

import java.util.Scanner;

// Student class를 참조하는 코드

public class TodoExe2 {
	static Student[] scores = null; // 학생점수저장
	
	public static void main(String[] args) {
		test2();
		boolean run = true; // 반복문 실행 / 종료
		int studentNum = 0; // 학생수
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
				scores = new Student[studentNum]; // 배열의 크기 지정
				
			} else if (selectNo == 2) {
				for (int i = 0; i < scores.length; i++) {
					System.out.printf("scores[%d] 이름>> ", i);
					String name = scanner.nextLine();
					
					System.out.printf("scores[%d] 점수>> ", i);
					int score = Integer.parseInt(scanner.nextLine());
					
					System.out.printf("scores[%d] 키>> ", i);
					double height = Double.parseDouble(scanner.nextLine());  // Double.parseDouble("176.5"); 문자를 실수타입으로 변환
					
					System.out.printf("scores[%d] 성별>> ", i);
					String gender = scanner.nextLine();
					Gender gen = Gender.MALE;

					if (gender.equals("남") || gender.equals("남자")) {
						gen = Gender.MALE;
					} else if (gender.equals("여") || gender.equals("여자")) {
						gen = Gender.FEMALE;
					}
					
					Student student = new Student();
					student.studentName = name;
					student.score = score;
					student.height = height;
					student.gender = gen;
					
					scores[i] = student;
				}

			} else if (selectNo == 3) {  // scores 리스트 출력
				int sum = 0;
				for (int i = 0; i < scores.length; i++) {
					sum += scores[i].score;
				}
				if (sum == 0) {
					System.out.println("점수를 입력하세요");
					continue;
				}
				
				System.out.println("검색조건 ex) 남 또는 여 >>");
				String keyword = scanner.nextLine();
				Gender gen = Gender.MALE;
				if(keyword.equals("남")||keyword.equals("남자")) {
					gen = Gender.MALE;
				} else if(keyword.equals("여")||keyword.equals("여자")){
					gen = Gender.FEMALE;
				}
				for (int i = 0; i < scores.length; i++) {
					if (keyword.equals("") || gen == scores[i].gender) {
						System.out.printf("scores[%d]> 이름: %s, 점수: %d, 키: %.1f, 성별: %s \n", i, scores[i].studentName, scores[i].score, scores[i].height, scores[i].gender);
					}
				}
				
			} else if (selectNo == 4) {  // 분석 ( avg, max )
				int sum = 0;
				int max = 0;
				double maxheight = 0;
				double avg = 0;
				Student maxStd = new Student();
				Student maxStd2 = new Student();
				
				for (int i = 0; i < scores.length; i++) {
					sum += scores[i].score;
					if (max < scores[i].score) {
						max = scores[i].score;
						maxStd.score = scores[i].score;
						maxStd.studentName = scores[i].studentName;
					}
					if (maxheight < scores[i].height) {
						maxheight = scores[i].height;
						maxStd2.height = scores[i].height;
						maxStd2.studentName = scores[i].studentName;
						maxStd2.gender = scores[i].gender;
					}
				}
				
				avg = 1.0 * sum / scores.length;
				
				System.out.println("점수가 가장 높은 학생");
				System.out.printf("학생이름: %s, 최고점수: %d\n평균점수: %.2f\n", maxStd.studentName, maxStd.score, avg);
				System.out.println();
				System.out.println("키가 가장 큰 학생");
				System.out.printf("학생이름: %s, 키: %.1f, 성별: %s\n", maxStd2.studentName, maxStd2.height, maxStd2.gender);

			} else if (selectNo == 5) {
				run = false;
				
			}
		} // end of while
		System.out.println("프로그램 종료");
		
	} // end of main
	
	
	
	public static void test2() {
		Student s1 = new Student(); // 인스턴스 생성
		s1.studentName = "홍길동";
		s1.score = 90;
		s1.height = 170.8;
		s1.gender = Gender.MALE; // Gender라는 타입에 있는 MALE 상수로 지정
		
		Student s2 = new Student(); // 인스턴스 생성
		s2.studentName = "김민선";
		s2.score = 85;
		s2.height = 165.7;
		s2.gender = Gender.FEMALE; // Gender라는 타입에 있는 FEMALE 상수로 지정
		
		Student s3 = new Student(); // 인스턴스 생성
		s3.studentName = "박철민";
		s3.score = 80;
		s3.height = 180.3;
		s3.gender = Gender.MALE;
		
		scores = new Student[] { s1, s2, s3 }; // stdAry는 전역변수로 생성된 배열이므로 모든 함수에서 사용 가능
	}
}
