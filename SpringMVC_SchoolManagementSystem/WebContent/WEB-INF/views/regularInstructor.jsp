<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Instructor Page</title>

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
	<h1>Instructor Page</h1>
	

	
	<c:if test="${not empty instructorCourses}">
			<div class="table-style">
				 <table style="width:100%">
                 	<thead>
                            <tr>
                                <th colspan="3" style="font-size: 1rem;">My Courses</th>
                            </tr>
                            <tr>
                                <th>CourseID</th>
                                <th>Course Name</th>
                                <th>Minimum GPA</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="courses" items="${instructorCourses}">
                            <tr>
                                <td>${courses.getCourse_name()}</td>
                                <td>${courses.getFull_name()}</td>
                                <td>${courses.getEmail()}</td>
                            </tr>
                        </c:forEach>    
                        </tbody>
                    </table>
			</div>
		</c:if>
	
		<div class="center">
			<form class="form-horizontal" method="POST" action="logout">
					<input type="submit" id="submit" name="submit" value="Logout">
			</form>
		</div>
	
	
</body>
</html>