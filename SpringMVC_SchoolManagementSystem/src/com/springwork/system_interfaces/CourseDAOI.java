package com.springwork.system_interfaces;

import java.util.List;

import com.springwork.models.Course;

public interface CourseDAOI {
	
	enum SQL{
		GET_COURSES("SELECT * FROM course"),
		GET_COURSE_BY_INSTRUCTOR("SELECT course.COURSE_ID, course.COURSE_NAME, course.MINIMUN_GPA FROM course INNER JOIN teaching ON\r\n" + 
				"course.course_id = teaching .course_id WHERE instructor_id = ?");
		
		private final String query;
		
		private SQL(String query) {
			this.query = query;
		}
		
		public String getQuery() {
			return this.query;
		}
	}

	public List<Course> getAllCourses();
	
	public List<Course> getCourseByInstructor(int instructor_id);
}
