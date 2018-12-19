package com.springwork.system_interfaces;

import java.util.List;

import com.springwork.models.Teaching;

public interface TeachingDAOI {

	enum SQL{
		CHECK_IF_TEACHING("SELECT * FROM teaching WHERE course_id = ? AND instructor_id = ?"),
		ASSIGN_TO_TEACHING("INSERT INTO teaching (course_id, instructor_id) VALUES (?, ?)"),
		GET_TEACHING_ID("SELECT MAX(teaching_id) FROM teaching"),
		GET_INSTRUCTRORS_ASSIGNED("SELECT course.course_name, course.minimun_gpa, instructor.full_name, instructor.email FROM course\r\n" +
                "JOIN teaching ON course.course_id = teaching.course_id\r\n" +
                "JOIN instructor ON teaching.instructor_id = instructor.instructor_id");
		private final String query;
		private SQL(String query) {
			this.query = query;
		}
		
		public String getQuery() {
			return this.query;
		}
	}
	
	public int assignInstructorToCourse(int course_id, int instructor_id);
	
	public List<Teaching> getInstructorsCourses();
}
