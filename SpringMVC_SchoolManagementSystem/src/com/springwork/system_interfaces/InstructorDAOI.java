package com.springwork.system_interfaces;
import java.util.List;

import com.springwork.models.Instructor;

public interface InstructorDAOI {

	enum SQL{
		GET_INSTRUCTORS("SELECT * FROM instructor"),
		GET_INSTRUCTOR_BY_ID("SELECT * From instructor WHERE email = ?");
		
		private final String query;
		private SQL(String query) {
			this.query = query;
		}
		
		public String getQuery() {
			return this.query;
		}
	}
	
	public List<Instructor> getAllInstructors();
	
	public Instructor getInstructorByEmail(String emal);
}
