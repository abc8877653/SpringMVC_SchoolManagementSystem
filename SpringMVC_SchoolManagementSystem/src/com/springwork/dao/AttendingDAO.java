package com.springwork.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.springwork.custom_exceptions.StudentRegisterationException;
import com.springwork.models.Attending;
import com.springwork.models.Course;
import com.springwork.models.Student;
import com.springwork.system_interfaces.AttendingDAOI;

/*
 * Yu Wang
 * 11/5/18
 * School Management System
 * AttendingDAO.java
 */

public class AttendingDAO extends OracleConnection implements AttendingDAOI{


    /*
     * Registers a student to a course
     * @Throws custom exception - StudentRegisterationException
     * @param Student, Course
     * @return int
     */
    public int registerStudentToCourse(Student student, Course course) throws Exception {
    	//Check if student's gpa meets the minimum requirements for the course
    	if (student.getGpa() >= course.getMinimun_gpa()) {
			System.out.println("Student meets GPA requirment for course " + course.getCourse_name());
			System.out.println("Attempting to register . . .");
			connect();
			try {
				
				//Check if the student is already attending the course and return attending ID
				ps = conn.prepareStatement(SQL.CHECK_IF_ATTENDING.getQuery());
				ps.setInt(1, course.getCourse_id());
				ps.setInt(2, student.getStudent_id());
				rs = ps.executeQuery();
				if (rs.next()) {
					System.out.println("Student already registered");
					return 0;
				}
				//Register student to course and return the newly created attending ID
				else {
					ps = conn.prepareStatement(SQL.ADD_STUDENT_TO_ATTENDING.getQuery());
					ps.setInt(1, course.getCourse_id());
					ps.setInt(2, student.getStudent_id());
					rs = ps.executeQuery();
					System.out.println("Successful!");
					
					Statement st = conn.createStatement();
					rs = st.executeQuery(SQL.GET_ATTENDING_ID.getQuery());
					rs.next();
					return rs.getInt(1);
				}
			} catch (SQLException e) {
				System.out.println("SQL Error!");
			}
		}
    	return -1;
    }

    /**
     * Get all courses a student is attending
     * @param int
     * @return List<Attending>
     */
    public List<Attending> getStudentCourse(int student_id){
    	List<Attending> attendingList = new ArrayList<Attending>();
    	connect();
    	
		try {
			ps = conn.prepareStatement(SQL.GET_STUDENT_COURSES.getQuery());
			ps.setInt(1, student_id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				attendingList.add(new Attending(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
			return attendingList;
		} catch (SQLException e) {
			System.out.println("SQL Error!");
		}
		return attendingList;
    }
}
