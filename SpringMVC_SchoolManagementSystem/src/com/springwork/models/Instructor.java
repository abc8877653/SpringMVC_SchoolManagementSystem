package com.springwork.models;

import javax.validation.constraints.NotNull;

public class Instructor {
	@NotNull
	private int instructor_id;
	private String full_name;
	private String email;
	private String specialty;
	private int admin_role;
	private String pass;
	
	public Instructor() {
	}

	public Instructor(int instructor_id, String full_name, String email, String specialty, int admin_role,
			String pass) {
		this.instructor_id = instructor_id;
		this.full_name = full_name;
		this.email = email;
		this.specialty = specialty;
		this.admin_role = admin_role;
		this.pass = pass;
	}

	/**
	 * @return the instructor_id
	 */
	public int getInstructor_id() {
		return instructor_id;
	}

	/**
	 * @param instructor_id the instructor_id to set
	 */
	public void setInstructor_id(int instructor_id) {
		this.instructor_id = instructor_id;
	}

	/**
	 * @return the full_name
	 */
	public String getFull_name() {
		return full_name;
	}

	/**
	 * @param full_name the full_name to set
	 */
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the specialty
	 */
	public String getSpecialty() {
		return specialty;
	}

	/**
	 * @param specialty the specialty to set
	 */
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	/**
	 * @return the admin_role
	 */
	public int getAdmin_role() {
		return admin_role;
	}

	/**
	 * @param admin_role the admin_role to set
	 */
	public void setAdmin_role(int admin_role) {
		this.admin_role = admin_role;
	}

	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
}
