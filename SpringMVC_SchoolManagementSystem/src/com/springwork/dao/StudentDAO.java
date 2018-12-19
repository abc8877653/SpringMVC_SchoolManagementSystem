package com.springwork.dao;

import java.sql.*;
import com.springwork.models.Student;
import com.springwork.system_interfaces.StudentDAOI;

/*
 * Yu Wang
 * 11/5/18
 * School Management System
 * StudentDAO.java
 */

public class StudentDAO extends OracleConnection implements StudentDAOI{

    /**
     * Gets a student object based on student email
     *  String studentEmail
     * @return Student
     */
    public Student getStudentByEmail(String studentEmail){
    	connect();
		try {
			ps = conn.prepareStatement(SQL.GET_STUDENT_BY_EMAIL.getQuery());
			ps.setString(1, studentEmail);
			rs = ps.executeQuery();
			if (rs.next()) {
				Student student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getString(5), rs.getInt(6));
				return student;
				
			}	
		} catch (SQLException e) {
			System.out.println("SQL Error!");
		}
		return null;
    }
    
    /**
     * Validate if the students password matches the database's password
     * @param databasePass, userInputPass
     * @return boolean
     */
    public boolean validateUser(String databasePass, String userInputPass){
    	return databasePass.equals(userInputPass);
    }
}
