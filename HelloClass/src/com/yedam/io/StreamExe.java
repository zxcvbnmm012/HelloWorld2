package com.yedam.io;

import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

public class StreamExe {
	public static void main(String[] args) {
		copy2();
	
	} // end of main
	
	
	
	public static void write() {
		// 출력 스트림(파일) -> 바이트 기반
		// FileOutputStream : OutputStream을 상속 받은 자식 클래스
		try {
			OutputStream os = new FileOutputStream("c:/temp/os1.db");
			byte b1 = 10;
			byte b2 = 20;
			byte b3 = 30;
			os.write(b1);
			os.write(b2);
			os.write(b3);
			os.close();
			
		} catch (IOException e) {  // FileNotFoundExceptin의 상위 Exception
			e.printStackTrace();
			
		}
		System.out.println("end of prog.");
		
	} // end of write()
	
	
	public static void read() {
		// 입력 스트림(파일) -> 바이트 기반
				try {
					InputStream is = new FileInputStream("c:/temp/os1.db");
					// read() : 1바이트씩 읽기 -> 더이상 읽어올 데이터가 없으면 -1 반환
					while(true){
						int data = is.read();
						if (data == -1) {  // 데이터를 모두 읽어오면 종료
							break;
						}
						System.out.println(data);
					}
					
				} catch (IOException e) {
					e.printStackTrace();
					
				} System.out.println("end of prog.");
				
	} // end of read()
	
	
	
	
	public static void copy() {
		// 입력 -> 출력
		try {
			// 입력스트림(original.PNG)
			InputStream is = new FileInputStream("c:/temp/original.PNG");
			
			// 출력스트림(copy.PNG)
			OutputStream os = new FileOutputStream("c:/temp/copy.PNG");
			
			while(true) {
				int data = is.read(); // 읽기
				if(data == -1) {
					break;
				}
				os.write(data);       // 쓰기
				
			}
			os.close();
			is.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		System.out.println("end of prog.");
		
	} // end of copy()
	
	
	
	public static void copy2() {
		// 입력 -> 출력.
		try {
			// 입력스트림(original.PNG)
			// 1MB => 1000,000 바이트.
			InputStream is = new FileInputStream("c:/temp/original2.PNG");
			// 출력스트림(copy.PNG)
			OutputStream os = new FileOutputStream("c:/temp/copy2.PNG");
			// 한번에 읽기쓰기 byte[] 만큼 한번에 처리.
			byte[] buf = new byte[10];  // 한번에 10byte씩 처리
			long start = System.currentTimeMillis(); // 시작시점.
			while (true) {
				int data = is.read(buf); // 읽기.
				if (data == -1) { // end of file.
					break;
				}
				os.write(buf); // 쓰기.
			}
			os.close();
			is.close();
			long end = System.currentTimeMillis(); // 종료시점.
			System.out.println("걸린시간: " + (end - start));

		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end of copy2
	
	
	
	
	public static void bufferexe() {
		try {
			InputStream is = new FileInputStream("c:/temp/original.PNG");
			OutputStream os = new FileOutputStream("c:temp/copy3.PNG");
			
			// 보조스트림에 연결
			BufferedInputStream bis = new BufferedInputStream(is);
			// 기본스트림을 보조스트림의 생성자의 매개값으로 넣으면 기본스트림과 보조스트림 연결
			
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			// 읽기 - 쓰기
			while(true) {
				int data = bis.read();
				if(data == -1) {
					break;
				}
				bos.write(data);
			}
			bos.close();
			bis.close();
			os.close();
			is.close();
			// 호출한 역순으로 stream들을 close
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} System.out.println("end of prog.");
	} // end of bufferexe()
	
	
} // end of class
