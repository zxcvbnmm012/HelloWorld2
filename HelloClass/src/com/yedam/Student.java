package com.yedam;

/*
 * 라이브러리 클래스
 */

public class Student {
	
	// field (속성)
	private int studentNo;  // private : 클래스에 접근하는 수준을 제어 -> Student 클래스 외부에서의 접근을 막음
	private String studentName;
	private double height;
	private int engScore;
	private int mathScore;
	
	// 생성자 (instance의 초기화)
	public Student() {
		// 매개값이 없는 생성자 : 기본생성자
		// java 규칙 : 생성자를 정의하지 않은면 컴파일러에서 기본생성자를 생성함
		// 생성자는 반드시 존재함
	}
	
	// 매개값이 있는 생성자
	// 직접 생성자를 정의해주면 컴파일러는 기본생성자를 생성하지 않음
	public Student(int studentNo, String studentName) {
		this.studentNo = studentNo;      // 첫번째 매개값은 학생번호 할당
		this.studentName = studentName;  // 두번째 매개값은 학생이름 할당 
	}
	
	public Student(int studentNo, int engScore, int mathScore) {
		this.studentNo = studentNo;
		this.engScore  = engScore;
		this.mathScore = mathScore;
	}
	
	// method (기능)
	// java 규칙 : static이 없는 method는 인스턴스를 생성해줘야만 사용 가능
	void study() {   // void study : return type이 없음
		System.out.println("공부를 합니다.");
	}
	
	void introduce() {
		System.out.printf("학번은 %d이고 이름은 %s\n", studentNo, studentName);
	}
	
	// set 메소드 : 값을 설정함 -> setter
	void setEngScore(int engScore) {
		if(engScore < 0 || engScore > 100) {
			return;
		}
		this.engScore = engScore;
	}
	
	void setMathScore(int mathScore) {
		if(mathScore < 0 || mathScore > 100) {
			return;
		}
		this.mathScore = mathScore;
	}
	
	void setStudentNo(int studentNo) {
		if(studentNo < 0 ) {
			return;
		}
		this.studentNo = studentNo;
	}
	
	void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	// get 메소드 : 값을 가져옴 -> getter
	int getStudentNo() {
		return studentNo;
	}
	
	String getStudentName() {
		return studentName;
	}
	
	int getMathScore() {
		return mathScore;
	}
	
	int getEngScore() {
		return engScore;
	}
}
