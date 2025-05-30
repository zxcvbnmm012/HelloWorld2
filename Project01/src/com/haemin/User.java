package com.haemin;

public class User {
	private String name;
	private String position;
	private String userClassName;
	private String userClassLevel;
	
	
	public User() {}
	
	public User(String name, String position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getUserClassName() {
		return userClassName;
	}

	public void setUserClassName(String userClassName) {
		this.userClassName = userClassName;
	}

	public String getUserClassLevel() {
		return userClassLevel;
	}

	public void setUserClassLevel(String userClassLevel) {
		this.userClassLevel = userClassLevel;
	}
}
