<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Instructor</title>

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
	<h1>Admin Instructor Page</h1>

	<c:if test="${not empty teachingList}">
			<div class="table-style">
				 <table style="width:100%">
                 	<thead>
                            <tr>
                                <th colspan="4" style="font-size: 1rem;">Courses</th>
                            </tr>
                            <tr>
                                <th>Course Name</th>
                                <th>Minimum GPA</th>
                                <th>Instructor Name</th>
                                <th>Instructor Email</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="teaching" items="${teachingList}">
                            <tr>

                                <td>${teaching.getCourse_name()}</td>
                                <td>${teaching.getMinimun_gpa()}</td>
                                <td>${teaching.getFull_name()}</td>
                                <td>${teaching.getEmail()}</td>
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
			<form class="form-horizontal" method="POST" action="CoursesInstructors">
					<input type="submit" id="submit" name="submit" value="Click Here To Assign Instructors!">
			</form>
			<form class="form-horizontal" method="POST" action="logout">
					<input type="submit" id="submit" name="submit" value="Logout">
			</form>
		</div>
		
	
</body>
</html>