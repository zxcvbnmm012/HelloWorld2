package com.yedam.ref;

/*
 * 배열 + 참조타입(클래스) : 학색이름, 점수, ...
 * -> 복합적인 형태의 변수 선언
 */

public class ArrayExe3 {
	
	// class 안에서 선언한 변수는 class 내의 모든 함수에서 사용 가능 ; 전역변수
	static Student[] stdAry; // static : 정적변수 선언
	
	public static void main(String[] args) {
		
		test2();
		int sum = 0;
		int maxscore = 0;
		double maxheight = 0;
		Student maxStd = new Student();
		Student maxStd2 = new Student();
		for (int i = 0; i < stdAry.length; i++) {
			System.out.printf("이름: %s, 점수: %d\n", stdAry[i].studentName, stdAry[i].score);
			sum += stdAry[i].score;
			if (maxscore < stdAry[i].score) {
				maxscore = stdAry[i].score;
				maxStd.score = stdAry[i].score;
				maxStd.studentName = stdAry[i].studentName;
				maxStd.height = stdAry[i].height;
				maxStd.gender = stdAry[i].gender;
			}
			if (maxheight < stdAry[i].height) {
				maxheight = stdAry[i].height;
				maxStd2.score = stdAry[i].score;
				maxStd2.studentName = stdAry[i].studentName;
				maxStd2.height = stdAry[i].height;
				maxStd2.gender = stdAry[i].gender;
			}
		}
		double avg = 1.0 * sum / stdAry.length;
		String strFmt = "최고점수학생: %s, 최고점수: %d, 평균: %.2f";
		System.out.printf(strFmt, maxStd.studentName, maxStd.score, avg);
		System.out.println();
		System.out.printf("최고점수 받은 학생 -> %s : 점수> %d, 키> %.1f, 성별> %s \n", maxStd.studentName, maxStd.score, maxStd.height, maxStd.gender);
		System.out.printf("키가 가장 큰 학생 -> %s : 점수> %d, 키> %.1f, 성별> %s \n", maxStd2.studentName, maxStd2.score, maxStd2.height, maxStd2.gender);
		
	} // end of main
	
	
	
	
// test1()
	public static void test1() {
		// Student class를 참조하여 Student 데이터타입의 변수 생성
		// 홍길동, 80
		Student s1 = new Student();  // instance 생성 -> 생성자 호출
		s1.studentName = "홍길동";     // s1에는 Student class의 studentName 속성을 활용해 값을 저장
		s1.score = 80;               // s1에는 Student class의 score 속성을 활용해 값을 저장
		// 김민규, 85
		Student s2 = new Student();  // instance 생성 -> 생성자 호출
		s2.studentName = "김민규";     // s2에는 Student class의 studentName 속성을 활용해 값을 저장
		s2.score = 85;               // s2에는 Student class의 score 속성을 활용해 값을 저장
	
		// 홍길동의 점수 80 => 90
		s1.score = 90;
		
		// 학생정보를 하나의 배열에 저장
		Student[] students = {s1, s1}; // Student에 있는 데이터들을 담을 수 있는 배열 생성 -> 데이터타입 : Student
		// students[] =>            students[0]        |         students[1]
		//                [studentName:홍길동, score:90] | [studentName:김민규, score:85]
		
		// 홍길동의 이름 "홍길동" => "홍길도"
		// s1이 가지고 있는 주소값의 studentName을 바꿔줌 -> 단순히 배열의 값을 바꾼 것이 아니라 참조하는 주소의 값을 바꿔주는 것과 동일
		// s1.studentName을 하지 않아도 배열의 값을 바꾸는 것만으로 s1의 studentName의 값이 변경됨
		students[0].studentName = "홍길도"; // 배열의 [0]이 가진 주소값 == s1이 가진 주소값
	
		System.out.printf("이름: %s, 점수: %d\n", s1.studentName, s1.score);
	} // end of tets1()
	
	
	

// test2()
	public static void test2() {
		Student s1 = new Student(); // 인스턴스 생성
		s1.studentName = "홍길동";
		s1.score = 90;
		s1.height = 170.8;
		s1.gender = Gender.MALE;
		
		Student s2 = new Student(); // 인스턴스 생성
		s2.studentName = "김민선";
		s2.score = 85;
		s2.height = 165.7;
		s2.gender = Gender.FEMALE;
		
		Student s3 = new Student(); // 인스턴스 생성
		s3.studentName = "박철민";
		s3.score = 80;
		s3.height = 180.3;
		s3.gender = Gender.MALE;
		
		stdAry = new Student[] { s1, s2, s3 }; // stdAry는 전역변수로 생성된 배열이므로 모든 함수에서 사용 가능
	}
	
} // end of class
