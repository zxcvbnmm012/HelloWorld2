package com.haemin.person;

public class Teacher {
	private String teacherName;
	private String teacherPermission;
	private String teacherLoginId;
	private String teacherLoginPw;
	private String teacherBirth;
	private String teacherPhone;
	private String teacherClass;
	
	public Teacher() {}
	
	public Teacher(String teacherName, String teacherPermission, String teacherLoginId, String teacherLoginPw,
			String teacherBirth, String teacherPhone, String teacherClass) {
		this.teacherName = teacherName;
		this.teacherPermission = teacherPermission;
		this.teacherLoginId = teacherLoginId;
		this.teacherLoginPw = teacherLoginPw;
		this.teacherBirth = teacherBirth;
		this.teacherPhone = teacherPhone;
		this.teacherClass = teacherClass;
		
	}


	public String getTeacherName() {
		return teacherName;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}


	public String getTeacherPermission() {
		return teacherPermission;
	}


	public void setTeacherPermission(String teacherPermission) {
		this.teacherPermission = teacherPermission;
	}


	public String getTeacherLoginId() {
		return teacherLoginId;
	}


	public void setTeacherLoginId(String teacherLoginId) {
		this.teacherLoginId = teacherLoginId;
	}


	public String getTeacherLoginPw() {
		return teacherLoginPw;
	}


	public void setTeacherLoginPw(String teacherLoginPw) {
		this.teacherLoginPw = teacherLoginPw;
	}


	public String getTeacherBirth() {
		return teacherBirth;
	}


	public void setTeacherBirth(String teacherBirth) {
		this.teacherBirth = teacherBirth;
	}


	public String getTeacherPhone() {
		return teacherPhone;
	}


	public void setTeacherPhone(String teacherPhone) {
		this.teacherPhone = teacherPhone;
	}


	public String getTeacherClass() {
		return teacherClass;
	}


	public void setTeacherClass(String teacherClass) {
		this.teacherClass = teacherClass;
	}
	
	
	
}
