package com.yedam.member;

public class Member {
	
	private String memberId;
	private String memberName;
	private String phone;
	private int point;
	
	
	// 기본 생성자
	public Member(){
		
	}
	
	// 생성자 정의 : source -> Generate constructor using Fields
	// 사용자 정의 생성자
	public Member(String memberId, String memberName, String phone, int point) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.phone = phone;
		this.point = point;
	}

	// method
	// get,set 메소드 생성 : source -> Generate getters and setters
	void setMemberId (String memberId) {
		this.memberId = memberId;
	}
	
	void setMemberName (String memberName) {
		this.memberName = memberName;
	}
	
	void setPhone (String phone) {
		this.phone = phone;
	}
	
	void setPoint (int point) {
		this.point = point;
	}
	
	String getMemberId () {
		return memberId;
	}
	
	public String getMemberName () {
		return memberName;
	}
	
	String getPhone () {
		return phone;
	}
	
	public int getPoint () {
		return point;
	}
	
	public void showInfo() {
		System.out.printf("이름: %s, 연락처: %s, 포인트: %d\n", memberName, phone, point);
	}

} // end of class



