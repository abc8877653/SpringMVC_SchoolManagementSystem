package com.springwork.custom_exceptions;

public class StudentRegisterationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentRegisterationException(String e) {
		System.out.println(e);
	}
}
