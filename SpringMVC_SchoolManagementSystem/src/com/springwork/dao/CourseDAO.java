package com.springwork.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.springwork.models.Course;
import com.springwork.system_interfaces.CourseDAOI;

/*
 * Yu Wang
 * 11/5/18
 * School Management System
 * CourseDAO.java
 */


public class CourseDAO extends OracleConnection implements CourseDAOI{
	
	/**
	 * Create a list of all courses
	 * @return List<Course>
	 */
    public List<Course> getAllCourses(){
    	ArrayList<Course> courseList = new ArrayList<Course>();
    	connect();
    	
    	try {
			Statement st = conn.createStatement();
			rs = st.executeQuery(SQL.GET_COURSES.getQuery());
			
			while(rs.next()) {
				courseList.add(new Course(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
			}
			return courseList;
    	} catch (SQLException e) {
			System.out.println("SQL Error!");
		}
		return courseList;
    }

    /**
     * Get all courses using instructor id
     * @param int
     * @return List<Course>
     */
	public List<Course> getCourseByInstructor(int instructor_id) {
		List<Course> courseList = new ArrayList<Course>();
		connect();
		
		try {
			ps = conn.prepareStatement(SQL.GET_COURSE_BY_INSTRUCTOR.getQuery());
			ps.setInt(1, instructor_id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				courseList.add(new Course(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
			}
			return courseList;
		} catch (SQLException e) {
			System.out.println("SQL Error!");
		}
		System.out.println("Instructor ID not found!");
		return null;
	}
}
