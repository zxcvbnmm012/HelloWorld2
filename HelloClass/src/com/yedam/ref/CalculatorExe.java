package com.yedam.ref;

public class CalculatorExe {
public static void main(String[] args) {
	int a = 20, b = 30;
	Calculator c1 = new Calculator();        // 인스턴스 생성
	c1.sum(a,b);
	
	Calculator.sum(a,b);
	
	CalculatorExe ce = new CalculatorExe();  // 인스턴스 생성
	ce.printStar();
}


// static (정적) : 클래스에 고정된 멤버 -> 객체를 생성하지 않고도 바로 사용 가능
//                               -> static 메모리 영역에 존재하므로 객체 생성 전에 이미 할당됨
// static method로 정의하지 않으면 main 함수에서 사용할때 인스턴스 생성을 통해 메모리에 적재해주어야 함
	void printStar() {
		System.out.println("*");
	}
}
