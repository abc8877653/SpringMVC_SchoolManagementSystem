package com.springwork.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.springwork.models.Teaching;
import com.springwork.system_interfaces.TeachingDAOI;

public class TeachingDAO extends OracleConnection implements TeachingDAOI{

	/**
	 * Assign a instructor to a course
	 * @param course_id, instructor_id
	 * @return int
	 */
	public int assignInstructorToCourse(int course_id, int instructor_id) {
		connect();
		try {
			//Prepare SQL statement to check if instructor is already assigned to the course
			ps = conn.prepareStatement(SQL.CHECK_IF_TEACHING.getQuery());
			ps.setInt(1, course_id);
			ps.setInt(2, instructor_id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				System.out.println("Instructor already teaching this course");
				return -1;
			}
			//Assign the instructor if not assigned
			else {
				ps = conn.prepareStatement(SQL.ASSIGN_TO_TEACHING.getQuery());
				ps.setInt(1, course_id);
				ps.setInt(2, instructor_id);
				rs = ps.executeQuery();
				
				//Get the teaching id for return
				Statement st = conn.createStatement();
				rs = st.executeQuery(SQL.GET_TEACHING_ID.getQuery());
				rs.next();
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL Error!");
		}
		return -1;
	}

	
	/**
	 * This method takes no parameters and queries the database 
	 * for every instructor assigned to a course.
	 * @return List<Teaching>
	 */
	public List<Teaching> getInstructorsCourses() {
		connect();
		List<Teaching> teachingList = new ArrayList<Teaching>();
		try {
			Statement st = conn.createStatement();
			rs = st.executeQuery(SQL.GET_INSTRUCTRORS_ASSIGNED.getQuery());
			
			while(rs.next()) {
				 teachingList.add(new Teaching(rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getString(4)));
			}
			return teachingList;
		} catch (SQLException e) {
			System.out.println("SQL Error!");
		}
		
		return teachingList;
	}

}
