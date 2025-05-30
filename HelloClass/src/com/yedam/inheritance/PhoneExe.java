package com.yedam.inheritance;

public class PhoneExe {
	public static void main(String[] args) {
		// 부모클래스
		Cellphone phone1 = new Cellphone();
		phone1.model = "IT203";
		phone1.color = "red";
		phone1.powerOn();
		phone1.powerOff();
		System.out.println(phone1.toString());
		
		
		// 자식클래스
		Cellphone phone2 = new Smartphone();  // 부모클래스타입의 변수에 자식클래스 인스턴스 할당 가능
		phone2.model = "S21";
		phone2.color = "white";
		phone2.powerOn();   // 자식클래스에서 재정의된 powerOn()을 실행
		phone2.powerOff();  // 자식클래스에서 재정의된 powerOff()를 실행

		Smartphone phone3 = null;
		// 부모클래스 타입을 자식클래스 타입에 넣으려면 강제형변환 casting이 필요
		if (phone2 instanceof Smartphone) {
			phone3 = (Smartphone) phone2;
			phone3.channel = 3;
			phone3.watch();
			
		}
		// 부모클래스타입을 가진 인스턴스를 자식클래스 인스턴스에 담으면 에러 
//		phone3 = (Smartphone) phone1;
		// instanceOf 메소드를 사용해 변환 가능한지 체크 -> 실제로 담겨있는 인스턴스를 찾음
		if (phone1 instanceof Smartphone) {
			phone3 = (Smartphone) phone1;
			phone3.channel = 3;
			phone3.watch();
		}
		
		
	}
	
}
