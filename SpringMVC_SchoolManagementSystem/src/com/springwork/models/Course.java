package com.springwork.models;


/*
 * Yu Wang
 * 11/5/18
 * School Management System
 * Course.java
 */

public class Course {

	private int course_id;
	private String course_name;
	private double minimun_gpa;
	
	
	
	public Course() {
		super();
	}



	/**
	 * @param course_id
	 * @param course_name
	 * @param minimum_gpa
	 */
	public Course(int course_id, String course_name, double minimun_gpa) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.minimun_gpa = minimun_gpa;
	}



	/**
	 * @return the course_id
	 */
	public int getCourse_id() {
		return course_id;
	}



	/**
	 * @param course_id the course_id to set
	 */
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}



	/**
	 * @return the course_name
	 */
	public String getCourse_name() {
		return course_name;
	}



	/**
	 * @param course_name the course_name to set
	 */
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}



	/**
	 * @return the minimum_gpa
	 */
	public double getMinimun_gpa() {
		return minimun_gpa;
	}



	/**
	 * @param minimum_gpa the minimum_gpa to set
	 */
	public void setMinimun_gpa(double minimun_gpa) {
		this.minimun_gpa = minimun_gpa;
	}
}
