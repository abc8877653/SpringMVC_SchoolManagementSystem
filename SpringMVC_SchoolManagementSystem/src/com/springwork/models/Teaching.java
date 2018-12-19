package com.springwork.models;

public class Teaching {

	private String course_name;
	private double minimun_gpa;
	private String full_name;
	private String email;
	
	
	public Teaching() {

	}

	public Teaching(String course_name, double minimun_gpa, String full_name, String email) {

		this.course_name = course_name;
		this.minimun_gpa = minimun_gpa;
		this.full_name = full_name;
		this.email = email;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public double getMinimun_gpa() {
		return minimun_gpa;
	}

	public void setMinimun_gpa(double minimun_gpa) {
		this.minimun_gpa = minimun_gpa;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
