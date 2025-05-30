package com.yedam.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
 * Map 컬렉션
 * {키: 값} 추가
 * key에 순서가 없음
 */


// 학생(이름, 점수)
class Student2{
	// 필드.
	private String studentName;
	private int score;
	
	// 생성자.
	public Student2(String studentName, int score) {
		this.studentName = studentName;
		this.score = score;
	}
	
	
	// equals() 메소드: 주소값이 다른 객체는 서로 다른 객체로 판단 -> 두 객체를 동등객체로 만들어 비교하려면 메소드를 재정의해야 함
	// HashMap의 키로 사용할 객체 -> hashCode()와 equals() 메소드를 재정의하여 동등객체가 될 조건 정하기
	// 이름, 점수 같으면 논리적으동등객체
	@Override
	public int hashCode() {
		return score;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student2) {  // obj가 Student2 인스턴스가 맞는가
			Student2 std = (Student2) obj;  // casting
			return this.studentName.equals(std.getStudentName()) //
					&& this.score == std.getScore();
		}
		return false;
	}
	
	
	// getter.
	public String getStudentName() {
		return studentName;
	
	}
	
	public int getScore() {
		return score;
		
	}
	
} // end of class Student2




public class MapExe {
	public static void main(String[] args) {
		exe4();
		
	} // end of main
	
	
	
	// exe1()
	public static void exe1() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		// key: String 타입 / value: Integer 타입
		
		// 추가: put 메소드 활용
		map.put("홍길동", 80);
		map.put("김민수", 70);
		map.put("홍길동", 85);  // 중복된 키를 넣으면 나중에 추가된 값으로 값이 변경됨 -> 키는 중복될 수 없음
		map.put("박철민", 90);
		
		// 제거: remove 메소드 활용
		map.remove("홍길동");
		
		// 조회(키 -> 값)
		Integer score = map.get("김민수");
		System.out.println(score); // 70
		
		score = map.get("홍길동");
		System.out.println(score); // null
		
		map.put("홍길동", 85);
		
		// 반복: keyset 메소드 활용 -> key에 해당하는 부분은 Set 컬렉션으로 반환
		Set<String> keyset = map.keySet();		
		
		// 반복자 Iterator
		Iterator<String> iter = keyset.iterator();
		while(iter.hasNext()) {  // hasNext() : iterator 안에 다음 값이 들어있는지 확인 -> true / false
			// 반환되는 타입 : String
			String key = iter.next(); // 반복요소 획득 -> iterator의 다음 값 가져옴
			Integer value = map.get(key); // key를 활용해서 key에 해당되는 value를 가져옴
			// get(key) : key에 해당하는 value 값을 가져오는 메소드
			System.out.printf("키: %s, 값: %d\n", key, value);
		}
		
		// Map.entry 타입 -> {키: 값} 반환
		Set<Entry<String, Integer>> entryset = map.entrySet();
		
		// 반복자
		Iterator<Entry<String, Integer>> iter2 = entryset.iterator(); // 반복된 요소를 하나씩 가져오기 위한 반복자를 엔트리 타입으로 선언
		while(iter2.hasNext()) {
			// 반환되는 타입 : Entry<String, Integer>
			Entry<String, Integer> entry = iter2.next();
			System.out.printf("키: %s, 값: %d\n", entry.getKey(), entry.getValue());
			// getKey() : entry의 key를 가져오는 메소드
			// getValue() : entry의 value를 가져오는 메소드
			
		}
		
		// 자바객체(map) -> JSON 문자열 출력
		System.out.println();
		System.out.println(">> Gson을 이용한 JSON 문자열 출력");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map);
		System.out.println(json);
		
	} // end of exe1()
	
	
	public static void exe2() {
		Map<String, String> map;
		map = new HashMap<String, String>();
	
		map.put("user01", "1111");
		map.put("user02", "2222");
		map.put("user03", "3333");
	
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("아이디를 입력>> ");
			String id = scanner.nextLine();
			
			System.out.print("비밀번호를 입력>> ");
			String pw = scanner.nextLine();
		
			if(map.containsKey(id)) { // containsKey() : key 중에 id가 있는지 찾음
				if(map.get(id).equals(pw)) {  // get(id)로 id key에 해당하는 값과 pw가 동일한지 비교
					System.out.println("로그인되었습니다.");
					break;
				}
				System.out.println("입력하신 비밀번호가 일치하지 않습니다.");
				
			} else {
				System.out.println("입력하신 아이디가 없습니다.");
			}
			
		} // end of while
		
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map);
		System.out.println(json);
		
	} // end of exe2()
	
	
	
	public static void exe3() {
		// 학생, 반
		Map<Student2, String> map;
		map = new HashMap<Student2, String>();
		
		map.put(new Student2("홍길동", 70), "1반");
		map.put(new Student2("김민규", 80), "2반");

		map.put(new Student2("빅철승", 75), "1반");
		map.put(new Student2("최성철", 85), "2반");
		
		// 반복문
		// key가 Student2 타입의 두 개의 필드로 정의된 형태이므로 containsKey() 메소드로 해당하는 key가 있는지 확인 불가
		String keyword = "홍길동";
		Set<Student2> set = map.keySet(); // 반환되는 형태가 Student2 타입의 Set.
		
		// 반복문 M1) 확장된 for
//		for(Student2 std : set) {
//			
//		}
		
		// 반복문 M2) 반복자 iterator
		Iterator<Student2> iter = set.iterator();
		while(iter.hasNext()) {
			Student2 std = iter.next(); // 획득
			if(std.getStudentName().equals(keyword)){  // map의 key의 studentName에 keyword에 해당하는 부분이 있으면
				System.out.println("점수: " + std.getScore());  // 그 studentName에 해당하는 score 출력
				String cls = map.get(std); // std(studentName, score)에 해당하는 value를 cls에 저장
				System.out.printf("이름: %s, 점수: %d, 반: %s", std.getStudentName(), std.getScore(), cls);
			
			}
		} // end of while

	} // end of exe3()
	
	
	// exe4() : containsKey() 메소드 사용
	public static void exe4() {
		Map<Student2, String> map;
		map = new HashMap<Student2, String>();
		
		map.put(new Student2("홍길동", 70), "1반");
		map.put(new Student2("김민규", 80), "2반");

		map.put(new Student2("빅철승", 75), "1반");
		map.put(new Student2("최성철", 85), "2반");
		
		// 반복문
		String keyword = "홍길동";
		int score = 70;
		
		System.out.println(new Student2(keyword, score) == new Student2(keyword, score));
		// 객체를 비교연산자(==)로 비교할 경우: false -> 서로 다른 주소값을 가지는 서로 다른 객체이기 때문
		
		
		// containskey() : equals(), hashcode()를 재정의해주지 않으면 object 클래스의 equals(), hashcode() 메소드를 활용해 판단함
		// -> 주소값은 다르지만 동등객체로 판단하기 위해서는 equals(), hashcode() 재정의 필요
		if(map.containsKey(new Student2(keyword, score))) {  // map의 key에 Student2(keyword, score)이 있으면
			System.out.println("반: " + map.get(new Student2(keyword, score)));  // get(key)를 활용해 해당하는 value 값 출력
		}
		
		
		
		
		
		
		
		
		
		
	} // end of exe4()
	
	
	
} // end of class


// Gson 라이브러리 추가
// https://mvnrepository.com/artifact/com.google.code.gson/gson/2.13.1
// HelloClass -> Build path -> Configure Build path -> Classpath -> add external path
