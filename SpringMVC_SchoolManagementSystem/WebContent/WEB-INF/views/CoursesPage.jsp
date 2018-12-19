<%@page import="com.springwork.models.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h1>Student Course Registration</h1>
	
	<div class ="center">
		${registrationError}
	</div>
	<!-- List of course with a button to register. button for each class and check using dao method as dasdasd 
		Each button should store that one course for checking
	-->
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
		
		<div class="center">
			${message}
		</div><br>
		
		<div class="center">
			<form class="form-horizontal" method="POST" action="studentCourseRegistration">
				Input Course ID: <input type="number" name="courseID" placeholder="Course ID">
				<div>
					<input type="submit" id="submit" name="submit" value="Register">
				</div>
			</form>
		</div>
	
</body>
</html>