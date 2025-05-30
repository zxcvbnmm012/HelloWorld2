package com.yedam.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.yedam.collection.Student;

/*
 * 학생(추가, 수정, 삭제, 목록) -> c:/temp/studentList.txt
 * add(추가: 이름, 점수 입력)
 * modify(수정: 이름, 점수 수정)
 * remove(삭제: 이름)
 * list(목록)
 * 종료 시 저장
 */

public class StreamExe3 {
	static Scanner scn = new Scanner(System.in); // 정적메소드 main, add 안에서 사용 -> Scanner도 static으로 선언
	static List<Student> studentList = new ArrayList<>(); // 컬렉션

	public static void main(String[] args) {
		try {
			init();
		
		} catch (IOException e) {
			e.printStackTrace();

		} catch (NoSuchElementException e) {  // 파일의 끝부분에서 더 이상 읽을 값이 없음
			
		}
		
		boolean run = true;

		while (run) {
			System.out.println("1.추가 2.수정 3.삭제 4.목록 5.종료");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				add();
				break;
			case 2:
				modify();
				break;
			case 3:
				remove();
				break;
//			case 4:
//				break;
			case 5:
				run = false;
				save();
			}

		} // end of while
		System.out.println("end of prog.");

	} // end of main

	// add() : 추가
	static void add() {
		System.out.println("학생번호: ");
		String sno = scn.nextLine();

		System.out.println("점수: ");
		String score = scn.nextLine();

		Student student = new Student(Integer.parseInt(sno), Integer.parseInt(score));
		if (studentList.add(student)) { // add() 반환값 : boolean
			System.out.println("저장완료.");

		}

	} // end of add()

	// save() : 저장
	static void save() {
		// 문자기반의 출력 스트림
		try {
			Writer writer = new FileWriter("c:/temp/studentList.txt");
			for (Student student : studentList) {
				String txt = student.getStudentNo() + " " + student.getScore() + "\n";
				writer.write(txt);
			}
			writer.close();   // Stream 종료
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // end of save()
	
	
	
	
	// 초기화
	static void init() throws IOException, NoSuchElementException {  // IOException이 발생하면 init을 호출해서 사용하는 곳에서 예외처리를 하라는 의미
		Scanner scan = new Scanner(new File("c:/temp/studentList.txt"));
		
		while(true) {
			String txt = scan.nextLine();
			String[] strAry = txt.split(" "); // " "으로 구분하여 문자열 배열에 담아줌
			studentList.add(new Student(Integer.parseInt(strAry[0])    // studentNo
					                   ,Integer.parseInt(strAry[1]))); // score
			
		}
	} // end of init()
	
	
	// 수정
	static void modify() {
		System.out.println("학생번호: ");
		int sno = scn.nextInt();  // scanner에 입력되는 값을 int 타입으로 받아옴

		System.out.println("점수: ");
		int score = scn.nextInt();
		scn.nextLine(); // enter 제거 -> nextInt는 엔터 처리 x
		
		// 컬렉션에서 검색
		for(int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getStudentNo() == sno) {
				studentList.get(i).setScore(score);
				System.out.println("수정완료.");
				
			}
			
		}
	} // end of modify.
	
	
	
	static void remove() {
		System.out.println("학생번호: ");
		int sno = scn.nextInt();
		scn.nextLine();
		
		for(int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getStudentNo() == sno) {
				studentList.remove(i);
				System.out.println("삭제완료.");
			}
		}
	} // end of remove()
	
	
} // end of class




