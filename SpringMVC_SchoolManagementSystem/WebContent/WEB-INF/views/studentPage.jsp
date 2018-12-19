<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Page</title>

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
<%int count = 1; %>
<body>
	<h1 class="center">Student Page</h1>
		
		<c:if test="${not empty studentCourses}">
			<div class="table-style">
				 <table style="width:100%">
                 	<thead>
                            <tr>
                                <th colspan="4" style="font-size: 1rem;">My Courses</th>
                            </tr>
                            <tr>
                                <th>ID</th>
                                <th>Course Name</th>
                                <th>Instructor Name</th>
                                <th>Instructor Email</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="courses" items="${studentCourses}">
                            <tr>
                                <td><%out.print(count); %></td>
                                <td>${courses.getCourse_name()}</td>
                                <td>${courses.getFull_name()}</td>
                                <td>${courses.getEmail()}</td>
                            </tr>
                            <% count++; %>
                        </c:forEach>    
                        </tbody>
                    </table>
			</div>
		</c:if>
		
		<!--  Updated Courses Table  -->
		<d:if test="${not empty updatedCourses}">
			<div class="table-style">
				 <table style="width:100%">
                 	<thead>
                            <tr>
                                <th colspan="4" style="font-size: 1rem;">My Courses</th>
                            </tr>
                            <tr>
                                <th>ID</th>
                                <th>Course Name</th>
                                <th>Instructor Name</th>
                                <th>Instructor Email</th>
                            </tr>
                        </thead>
                        <tbody>
                        <d:forEach var="updated" items="${updatedCourses}">
                            <tr>
                                <td><%out.print(count); %></td>
                                <td>${updated.getCourse_name()}</td>
                                <td>${updated.getFull_name()}</td>
                                <td>${updated.getEmail()}</td>
                            </tr>
                            <% count++; %>
                        </d:forEach>    
                        </tbody>
                    </table>
			</div>
		</d:if>
		
		<div class="center">
			${message}
		</div><br>
		<div class="center">
			<form class="form-horizontal" method="POST" action="CoursesPage">
					<input type="submit" id="submit" name="submit" value="Click Here to Register!">
			</form>
			<form class="form-horizontal" method="POST" action="logout">
					<input type="submit" id="submit" name="submit" value="Logout">
			</form>
		</div>
		
		
		
</body>
</html>