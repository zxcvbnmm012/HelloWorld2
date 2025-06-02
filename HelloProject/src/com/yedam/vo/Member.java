package com.yedam.vo;

/*
 * db의 테이블의 데이터 (tbl_member)를 하나씩 대응
 */

public class Member {
	// 필드
	private String memberId; // member_id
	private String memberName;
	private String phone;
	private int point;
	
	// 생성자
	public Member() {
		
	}
	
	public Member(String memberId) {
		this.memberId = memberId;
	}
	
	public Member(String memberId, String memberName, String phone, int point) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.phone = phone;
		this.point = point;
	}
	
	public Member(String memberId, String phone, int point) {
		this.memberId = memberId;
		this.phone = phone;
		this.point = point;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", phone=" + phone + ", point=" + point
				+ "]";
	}
	
	
}
