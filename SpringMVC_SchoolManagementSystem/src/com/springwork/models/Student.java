package com.springwork.models;

import org.hibernate.validator.constraints.NotEmpty;

/*
 * Yu Wang
 * 11/5/18
 * School Management System
 * Student.java
 */

public class Student {
	private int student_id;
	private String fullName;
	@NotEmpty(message = "{YEEEEET}")
	private String email;
	private double gpa;
	private String pass;
	private int studentRole;
	
	public Student() {

	}



	/**
	 * @param student_id
	 * @param fullName
	 * @param email
	 * @param gpa
	 * @param pass
	 * @param studentRole
	 */
	public Student(int student_id, String fullName, String email, double gpa, String pass, int studentRole) {
		this.student_id = student_id;
		this.fullName = fullName;
		this.email = email;
		this.gpa = gpa;
		this.pass = pass;
		this.studentRole = studentRole;
	}


	/**
	 * @return the student_id
	 */
	public int getStudent_id() {
		return student_id;
	}


	/**
	 * @param student_id the student_id to set
	 */
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}


	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}


	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}


	/**
	 * @param gpa the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}


	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}


	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}


	/**
	 * @return the studentRole
	 */
	public int getStudentRole() {
		return studentRole;
	}


	/**
	 * @param studentRole the studentRole to set
	 */
	public void setStudentRole(int studentRole) {
		this.studentRole = studentRole;
	}
	
	
	
}
