package com.haemin.person;

public class Member {
	private int memberId;
	private String memberName;
	private String loginId;
	private String loginPw;
	private int memberBirth;
	private String memberPhone;
	private String memberClassName;
	private String memberClassLevel;
 
	public Member() {};
	
	public Member(int memberId, String memberName, String loginId, String loginPw, int memberBirth, String memberPhone, String memberClassName, String memberClassLevel) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.memberBirth = memberBirth;
		this.memberPhone = memberPhone;
		this.memberClassName = memberClassName;
		this.memberClassLevel = memberClassLevel;
	}
	
	public Member(int memberId, String memberName, String loginId, String loginPw, int memberBirth, String memberPhone){
		this.memberId = memberId;
		this.memberName = memberName;
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.memberBirth = memberBirth;
		this.memberPhone = memberPhone;
	}
	
	public Member(String loginId, String loginPw) {
		this.loginId = loginId;
		this.loginPw = loginPw;
	}


	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPw() {
		return loginPw;
	}

	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}

	public int getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(int memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberClassName() {
		return memberClassName;
	}

	public void setMemberClassName(String memberClassName) {
		this.memberClassName = memberClassName;
	}

	public String getMemberClassLevel() {
		return memberClassLevel;
	}

	public void setMemberClassLevel(String memberClassLevel) {
		this.memberClassLevel = memberClassLevel;
	}

}

