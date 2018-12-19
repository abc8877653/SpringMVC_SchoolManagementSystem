package com.springwork.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.springwork.dao.AttendingDAO;
import com.springwork.dao.CourseDAO;
import com.springwork.dao.InstructorDAO;
import com.springwork.dao.StudentDAO;
import com.springwork.dao.TeachingDAO;
import com.springwork.models.Attending;
import com.springwork.models.Course;
import com.springwork.models.Instructor;
import com.springwork.models.Student;
import com.springwork.models.Teaching;

@Controller
//@SessionAttributes("studentKey")
//@SessionAttributes("instructorKey")
public class AppController {
	
	@RequestMapping("/")
	public ModelAndView loginPage() {
		return new ModelAndView("welcome");
	}
	
	@RequestMapping("/login")
	public ModelAndView loginPage(HttpSession session) {
		session.setAttribute("student", null);
		session.setAttribute("adminInstructor", null);
		session.setAttribute("regularInstructor", null);
		return new ModelAndView("login");
	}
	
	/*
	 * -----------------------------------------------------------------------------------------------------------------
	 */
	

	/*
	 * -----------------------------------------------------------------------------------------------------------------
	 */
	

	@RequestMapping("/loginProcess")
	public ModelAndView processLogin(@RequestParam("userType") String userType,
			@RequestParam(required=true, defaultValue="email") String email,
			@RequestParam(required=true, defaultValue="pass") String pass, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		//Student Login
		if (userType.equals("student")) {
			Student student = new StudentDAO().getStudentByEmail(email);
			//Check if student of 'email' exists
			if (student == null) {
				mav = new ModelAndView("login");
				mav.addObject("loginError",  "Wrong Credentials");
				return mav;
			}
			boolean validateStudent = new StudentDAO().validateUser(new StudentDAO().getStudentByEmail(email).getPass(), pass);
			//Validated student. Add Attending list to mav for return.
			if (validateStudent) {
				mav = new ModelAndView("studentPage");
				session.setAttribute("student", student);
				List<Attending> studentCourses = new AttendingDAO().getStudentCourse(student.getStudent_id());
				mav.addObject("studentCourses", studentCourses);
				return mav;
			}
		}
		//Instructor Login
		if (userType.equals("instructor")) {
			Instructor instructor = new InstructorDAO().getInstructorByEmail(email);
			if (instructor == null) {
				mav = new ModelAndView("login");
				mav.addObject("loginError",  "Wrong Credentials");
				return mav;
			}
			//Get ready to return
			String instructorType = new InstructorDAO().validateUser(new InstructorDAO().getInstructorByEmail(email), pass);
			if (instructorType.equals("Admin")) {
				mav = new ModelAndView("adminInstructor");
				session.setAttribute("adminInstructor", instructor);
				List<Teaching> teachingList = new TeachingDAO().getInstructorsCourses();
				mav.addObject("teachingList", teachingList);
				return mav;
			} else if (instructorType.equals("Instructor")) {
				mav = new ModelAndView("regularInstructor");
				session.setAttribute("instructor", instructor);
				List<Course> instructorCourses = new CourseDAO().getCourseByInstructor(instructor.getInstructor_id());
				mav.addObject("instructorCourses", instructorCourses);
				return mav;
			}
		}
		mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping("/studentPage")
	public ModelAndView studentPage(HttpSession session) {
		if (session.getAttribute("student") == null) {
			return new ModelAndView("login");
		}
		ModelAndView mav = new ModelAndView("studentPage");
		return mav;
	}
	
	@RequestMapping("/regularInstructor")
	public ModelAndView regularInstructorPage(HttpSession session) {
		if (session.getAttribute("regularInstructor") == null) {
			return new ModelAndView("login");
		}
		ModelAndView mav = new ModelAndView("regularInstructor");
		return mav;
	}
	
	@RequestMapping("/adminInstructor")
	public ModelAndView adminInstructorPage(HttpSession session) {
		if (session.getAttribute("adminInstructor") == null) {
			return new ModelAndView("login");
		}
		ModelAndView mav = new ModelAndView("adminInstructor");
		return mav;
	}
	
	@RequestMapping("/CoursesPage")
	public ModelAndView coursesPage(HttpSession session) {
		if (session.getAttribute("student") == null) {
			return new ModelAndView("login");
		}
		ModelAndView mav = new ModelAndView("CoursesPage");
		List<Course> courseList = new CourseDAO().getAllCourses();
		mav.addObject("courseList", courseList);
		return mav;
	}
	
	@RequestMapping("/CoursesInstructors")
	public ModelAndView coursesInstructors(HttpSession session) {
		if (session.getAttribute("adminInstructor") == null) {
			return new ModelAndView("login");
		}
		ModelAndView mav = new ModelAndView("CoursesInstructors");
		
		List<Course> courseList = new CourseDAO().getAllCourses();
		mav.addObject("courseList", courseList);
		
		List<Instructor> instructorList = new InstructorDAO().getAllInstructors();
		mav.addObject("instructorList", instructorList);
		
		return mav;
	}
	
	@RequestMapping("/studentCourseRegistration")
	public ModelAndView studentCourseRegistration(HttpSession session, @RequestParam("courseID") String courseID) {
		ModelAndView mav = new ModelAndView("studentPage");
		Student student = (Student) session.getAttribute("student");
		List<Attending> updatedCourses = new AttendingDAO().getStudentCourse(student.getStudent_id());
		if (session.getAttribute("student") == null) {
			return new ModelAndView("login");
		}
		else{
			List<Course> courseList = new CourseDAO().getAllCourses();
			try {
				//Check if courseID is valid, then update the 'updatedCourses' list
				int cid = Integer.parseInt(courseID);
				if(cid >= 1 && cid <= courseList.size()) {
					int register = new AttendingDAO().registerStudentToCourse(student, courseList.get(cid - 1));
					updatedCourses = new AttendingDAO().getStudentCourse(student.getStudent_id());
					
					if(register == -1) {
						mav.addObject("updatedCourses", updatedCourses);
						mav.addObject("message", "Failed to Register");
						return mav;
					}
					mav.addObject("updatedCourses", updatedCourses);
					mav.addObject("message", "Registration Successful");
					return mav;
				}
				mav.addObject("updatedCourses", updatedCourses);
				mav.addObject("message", "Invalid Course ID");
				return mav;
			} catch (Exception e) {
				System.out.println("Registration Error");
			}
		}
		mav.addObject("updatedCourses", updatedCourses);
		mav.addObject("message", "Please input a number");
		return mav;
	}
	
	@RequestMapping("/assignInstructor")
	public ModelAndView assignInstructor(HttpSession session, @RequestParam("courseID") String courseID, @RequestParam("instructorID") String instructorID) {
		ModelAndView mav = new ModelAndView("adminInstructor");
		List<Teaching> teachingList = new TeachingDAO().getInstructorsCourses();
		mav.addObject(teachingList);
		if (session.getAttribute("adminInstructor") == null) {
			return new ModelAndView("login");
		}
		else {
			if (courseID.equals("") || instructorID.equals("")) {
				mav.addObject("updatedTeachingList", teachingList);
				mav.addObject("message", "Input all fields");
				return mav;
			}
			int cid = Integer.parseInt(courseID);
			int iid = Integer.parseInt(instructorID);
			if(cid >= 1 && cid <= 4 && iid >= 1 && iid <= 3) {
				int assign = new TeachingDAO().assignInstructorToCourse(cid, iid);
				teachingList = new TeachingDAO().getInstructorsCourses();
				
				if(assign == -1) {
					mav.addObject("updatedTeachingList", teachingList);
					mav.addObject("message", "Failed to assign Instructor to Course");
					return mav;
				}
				mav.addObject("updatedTeachingList", teachingList);
				mav.addObject("message", "Instructor successfully assigned to Course");
				return mav;
			}
			mav.addObject("updatedTeachingList", teachingList);
			mav.addObject("message", "Invalid Course ID / Instructor ID");
			return mav;
		}
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.setAttribute("student", null);
		session.setAttribute("adminInstructor", null);
		session.setAttribute("regularInstructor", null);
		return new ModelAndView("login");
	}
//	@ModelAttribute("studentKey") User u
//	public Student setUpStudentForm() {
//		return new Student();
//	}
//	
//	@ModelAttribute("instructorKey")
//	public Instructor setUpInstructor(int instructor_id, String full_name, String email, String specialty, int admin_role,
//			String pass) {
//		return new Instructor(instructor_id, full_name, email, specialty, admin_role,pass);
//	}
}
