<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Login Page</h1>

	${loginError}
	<form class="form-horizontal" method="POST" action="loginProcess">
		<fieldset>
			<!-- Form Name -->
			<legend>Login</legend>

			<!-- Multiple Radios -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="userType">userType</label>
				<div class="col-md-4">
					<div class="radio">
						<label for="userType-0"> <input type="radio"
							name="userType" id="userType-0" value="student" checked="checked">
							Student
						</label>
					</div>
					<div class="radio">
						<label for="userType-1"> <input type="radio"
							name="userType" id="userType-1" value="instructor">
							Instructor
						</label>
					</div>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="email">email</label>
				<div class="col-md-4">
					<input id="email" name="email" type="text" placeholder="email"
						class="form-control input-md">

				</div>
			</div>

			<!-- Password input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="pass">pass</label>
				<div class="col-md-4">
					<input id="pass" name="pass" type="password" placeholder="pass"
						class="form-control input-md">

				</div>
			</div>

			<!-- Submit Button -->
			<div class="btn">
				<input type="submit" id="submit" name="submit" value="Login">
			</div>

		</fieldset>
	</form>





</body>
</html>