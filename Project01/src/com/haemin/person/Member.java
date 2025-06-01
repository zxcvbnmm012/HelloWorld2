package com.haemin.person;

public class Member {
	private int id;
	private String name;
	private String permission;
	private String loginid;
	private String loginPw;
	private String birth;
	private String phone;
	private String className;
	private String classLevel;
 
	public Member() {};
	
	public Member(int id, String name, String loginid, String loginPw, String birth, String phone, String className, String classLevel) {
		this.id = id;
		this.name = name;
		this.loginid = loginid;
		this.loginPw = loginPw;
		this.birth = birth;
		this.phone = phone;
		this.className = className;
		this.classLevel = classLevel;
	}
	
	public Member(int id, String name, String loginid, String loginPw, String birth, String phone){
		this.id = id;
		this.name = name;
		this.loginid = loginid;
		this.loginPw = loginPw;
		this.birth = birth;
		this.phone = phone;
	}
	
	public Member(String name, String permission, String loginid, String loginPw, String birth, String phone){
		this.name = name;
		this.setPermission(permission);
		this.loginid = loginid;
		this.loginPw = loginPw;
		this.birth = birth;
		this.phone = phone;
	}
	
	public Member(String loginid, String loginPw) {
		this.loginid = loginid;
		this.loginPw = loginPw;
	}
	
	public Member(int id) {
		this.id = id;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getLoginId() {
		return loginid;
	}

	public void setLoginId(String loginid) {
		this.loginid = loginid;
	}

	public String getLoginPw() {
		return loginPw;
	}

	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(String classLevel) {
		this.classLevel = classLevel;
	}

}

