package com.haemin.person;

public class Manager {
	private String managerName;
	private String managerPermission;
	private String managerLoginId;
	private String managerLoginPw;
	private String managerBirth;
	private String managerPhone;
	
	
	public Manager(String managerName, String managerPermission, String managerLoginId, String managerLoginPw,
			String managerBirth, String managerPhone) {
		this.managerName = managerName;
		this.managerPermission = managerPermission;
		this.managerLoginId = managerLoginId;
		this.managerLoginPw = managerLoginPw;
		this.managerBirth = managerBirth;
		this.managerPhone = managerPhone;
	}


	public String getManagerName() {
		return managerName;
	}


	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}


	public String getManagerPermission() {
		return managerPermission;
	}


	public void setManagerPermission(String managerPermission) {
		this.managerPermission = managerPermission;
	}


	public String getManagerLoginId() {
		return managerLoginId;
	}


	public void setManagerLoginId(String managerLoginId) {
		this.managerLoginId = managerLoginId;
	}


	public String getManagerLoginPw() {
		return managerLoginPw;
	}


	public void setManagerLoginPw(String managerLoginPw) {
		this.managerLoginPw = managerLoginPw;
	}


	public String getManagerBirth() {
		return managerBirth;
	}


	public void setManagerBirth(String managerBirth) {
		this.managerBirth = managerBirth;
	}


	public String getManagerPhone() {
		return managerPhone;
	}


	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}
	
	
	
	
}
