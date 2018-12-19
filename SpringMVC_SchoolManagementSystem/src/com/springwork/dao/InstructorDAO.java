package com.springwork.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.springwork.models.Instructor;
import com.springwork.system_interfaces.InstructorDAOI;

public class InstructorDAO extends OracleConnection implements InstructorDAOI{

	/**
	 * Create a list of all instructors
	 * @return List<Instructor>
	 */
	public List<Instructor> getAllInstructors() {
		connect();
		List<Instructor> instructorsList = new ArrayList<Instructor>();
		
		try {
			Statement st = conn.createStatement();
			rs = st.executeQuery(SQL.GET_INSTRUCTORS.getQuery());
			
			while(rs.next()) {
				instructorsList.add(new Instructor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
			}
			return instructorsList;
		} catch (SQLException e) {
			System.out.println("SQL Error!");
		}
		return instructorsList;
	}

	/**
	 * Get a instructor object by email
	 * @param String
	 * @return Instructor
	 */
	public Instructor getInstructorByEmail(String email) {
		connect();
		try {
			ps = conn.prepareStatement(SQL.GET_INSTRUCTOR_BY_ID.getQuery());
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				Instructor instructor = new Instructor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
				return instructor;
			}
		} catch (SQLException e) {
			System.out.println("SQL Error!");
		}
		return null;
	}
	
	/**
	 * Validate if the instructor is a admin or not, or if the the credentials are correct
	 * @param instructor, comparablePass
	 * @return 
	 */
	public String validateUser(Instructor instructor, String comparablePass) {
		if(instructor.getAdmin_role() == 1 && instructor.getPass().equals(comparablePass)) {
			return "Admin";
		}
		else if (instructor.getPass().equals(comparablePass)) {
			return "Instructor";
		}
		else {
			return "Wrong Credentials";
		}
	}
	
}
