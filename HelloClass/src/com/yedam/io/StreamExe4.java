package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * 객체 입출력 스트림
 * 기본타입 - 참조타입
 * int num = 10;
 * Member member = new Member();  -> 객체는 객체가 만들어져있는 주소값을 가짐
 * 직렬화(Serialization) : 객체를 기본타입으로 변경하는 작업 ; 객체 -> 기본
 * 역직렬화(Deserialization) : 기본 -> 객체
 * Serializable 인터페이스 구현 클래스들에만 직렬화 가능
 */


class Product implements Serializable{  // Product class를 Serializable 구현클래스로 정의 -> ObjectStream 사용하기 위해
	String prodCode;
	
	public Product(String prodCode) {
		this.prodCode = prodCode;
	}
}




public class StreamExe4 {
	public static void main(String[] args) {
		deserial();
		
	} // end of main
	
	
	
	// 직렬화
	static void serial() {
		List<Product> list = new ArrayList<>();
		list.add(new Product("P001"));
		list.add(new Product("P002"));
		
		try {
			OutputStream os = new FileOutputStream("c:/temp/object.db"); // 기본스트림
			ObjectOutputStream oos = new ObjectOutputStream(os);  // 객체 입출력 보조스트림 연결
			oos.writeObject(list); // 객체를 출력 스트림에 전달 : 객체 -> 기본
			oos.close();
			os.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog.");
		
	} // end of serial()
	
	
	
	static void deserial() {
		
		try {
			InputStream is = new FileInputStream("c:/temp/object.db");
			ObjectInputStream ois = new ObjectInputStream(is);
			List<Product> list = (List<Product>) ois.readObject();
			for (Product product : list) {
				System.out.println("상품코드: " + product.prodCode);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
	}
	
} // end of class
