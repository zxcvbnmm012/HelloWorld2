package com.haemin;

public class ClassApp {
	private String classCenter;
	private String className;
	private String classLevel;
	private String classDate;
	private String classTime;
	private String classFee;
	private String classTeacher;
	private int classNow;
	private String classLimit;
	
	public ClassApp() {};
	
	public ClassApp(String classCenter, String className, String classLevel, String classDate, String classTime, String classFee, String classTeacher,
			int classNow, String classLimit) {
		this.classCenter = classCenter;
		this.className = className;
		this.classLevel = classLevel;
		this.classDate = classDate;
		this.classTime = classTime;
		this.classFee = classFee;
		this.classTeacher = classTeacher;
		this.classNow = classNow;
		this.classLimit = classLimit;
	}

	
	
	public String getClassCenter() {
		return classCenter;
	}

	public void setClassCenter(String classCenter) {
		this.classCenter = classCenter;
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
	
	public String getClassDate() {
		return classDate;
	}

	public void setClassDate(String classDate) {
		this.classDate = classDate;
	}

	public String getClassTime() {
		return classTime;
	}

	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}

	public String getClassFee() {
		return classFee;
	}

	public void setClassFee(String classFee) {
		this.classFee = classFee;
	}

	public String getClassTeacher() {
		return classTeacher;
	}

	public void setClassTeacher(String classTeacher) {
		this.classTeacher = classTeacher;
	}

	public int getClassNow() {
		return classNow;
	}

	public void setClassNow(int classNow) {
		this.classNow = classNow;
	}

	public String getClassLimit() {
		return classLimit;
	}

	public void setClassLimit(String classLimit) {
		this.classLimit = classLimit;
	}
}
