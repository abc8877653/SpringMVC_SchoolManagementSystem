package com.springwork.system_interfaces;

import com.springwork.models.Student;

public interface StudentDAOI {

	enum SQL{
		GET_STUDENT_BY_EMAIL("SELECT * FROM student WHERE email = ?");
		
		private final String query;
		
		private SQL(String query) {
			this.query = query;
		}
		
		public String getQuery() {
			return this.query;
		}
	}
	
	public Student getStudentByEmail(String email);
	
	
}
