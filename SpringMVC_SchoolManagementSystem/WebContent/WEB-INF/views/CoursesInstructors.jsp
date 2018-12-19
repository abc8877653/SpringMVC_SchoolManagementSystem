<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>

.table-style{
    width: 60%;
    margin:25px auto;
}

table, th, td {
 border: 1px solid black;
 border-collapse: collapse;
 font-size: 0.7rem;
}

th, td{
    padding: 10px;
}

.center{
	text-align:center;
}

</style>

</head>
<body>
<h1>Assign Instructors To Courses</h1>

<c:if test="${not empty courseList}">
			<div class="table-style">
				 <table style="width:100%">
                 	<thead>
                            <tr>
                                <th colspan="3" style="font-size: 1rem;">Courses</th>
                            </tr>
                            <tr>
                                <th>ID</th>
                                <th>Course Name</th>
                                <th>Minimum GPA</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="course" items="${courseList}">
                            <tr>
                                <td>${course.getCourse_id()}</td>
                                <td>${course.getCourse_name()}</td>
                                <td>${course.getMinimun_gpa()}</td>
                            </tr>
                        </c:forEach>    
                        </tbody>
                    </table>
			</div>
		</c:if>
		
		
		<d:if test="${not empty instructorList}">
			<div class="table-style">
				 <table style="width:100%">
                 	<thead>
                            <tr>
                                <th colspan="6" style="font-size: 1rem;">Courses</th>
                            </tr>
                            <tr>
                                <th>ID</th>
                                <th>Full Name</th>
                                <th>Email</th>
                                <th>Specialty</th>
                                <th>Admin Role</th>
                                <th>Password</th>
                            </tr>
                        </thead>
                        <tbody>
                        <d:forEach var="instructor" items="${instructorList}">
                            <tr>
                                <td>${instructor.getInstructor_id()}</td>
                                <td>${instructor.getFull_name()}</td>
                                <td>${instructor.getEmail()}</td>
                                <td>${instructor.getSpecialty()}</td>
                                <td>${instructor.getAdmin_role()}</td>
                                <td>${instructor.getPass()}</td>
                            </tr>
                        </d:forEach>    
                        </tbody>
                    </table>
			</div>
		</d:if>
		<div class="center">
			<form class="form-horizontal" method="POST" action="assignInstructor">
				Input Course ID: <input type="number" name="courseID" placeholder="Course ID">
				Input Instructor ID: <input type="number" name="instructorID" placeholder="Instructor ID">
				<div>
					<input type="submit" id="submit" name="submit" value="Assign">
				</div>
			</form>
		</div>

</body>
</html>