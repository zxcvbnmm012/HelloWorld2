package com.yedam;

/*
 * 실행 클래스
 */

public class StudentExample {
	public static void main(String[] args) {
	//   클래스     변수     예약어   생성자	
		Student student = new Student(); 
		// Student student : student 변수의 데이터타입을 Student class로 지정
		// new Student : 인스턴스 생성
//		student.studentNo = 1001;
		student.setStudentNo(1001);
//		student.studentName = "홍길동";
		student.setStudentName("홍길동");
//		student.engScore  = 80;
		student.setEngScore(80);  // engScore은 private 속성 -> 메소드를 통해서 기능 수행
//		student.mathScore = 85;
		student.setMathScore(85);
		student.study();
		student.introduce();
		System.out.printf("영어점수: " + " %d" + " 수학점수: " + " %d\n",
				student.getEngScore(), student.getMathScore());
		
		Student student2 = new Student(1002, "김민규"); 
//		student2.studentNo = 1002;
//		student2.studentName = "박철수";
		student2.setStudentName("박철수");
//		student2.engScore = 50;
		student2.setEngScore(50);
//		student2.mathScore = 150;
		student2.setMathScore(100);
		student2.study();
		student2.introduce();
		System.out.printf("영어점수: " + " %d" + " 수학점수: " + " %d\n",
				student2.getEngScore(), student2.getMathScore());
		

		
	}
}
