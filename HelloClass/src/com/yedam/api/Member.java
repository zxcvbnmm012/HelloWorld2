package com.yedam.api;

public class Member { // public class Member extends Object
	public String memberName;
	public int age;
	
	public Member() {
		
	}
	
	public Member(String memberName, int age) {
		this.memberName = memberName;
		this.age = age;
	}

	@Override
		public int hashCode() {
			return age;
		}
	
	// 이름, 나이 => 같으면 논리적 동등한지
	// Object 클래스가 가진 equals()를 재정의
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {   // obj가 Member class 타입의 인스턴스가 아니면 false
			Member member = (Member) obj;  // obj를 Member class로 casting해서 Member class 타입의 member와 비교
			return this.memberName == member.memberName && this.age == member.age;
			// 이름도 같고 나이도 같으면 true 반환
		}
		return false;
	}  // end of equals()
	
	
	@Override
		public String toString() {
			return "이름: " + memberName + ", 나이: " + age;
			
		}
} // end of class
