<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<meta charset="ISO-8859-1">
<title>Book Club</title>
</head>
<body class="p-3">
	<h1>Book Club</h1>
	<h4>A place for friends to share thoughts on books.</h4>
	<div class="d-flex justify-content-around">
		<div>
			<h2>Register</h2>
			<form:form action="/register" method="post" modelAttribute="newUser">
				<div>
					<form:label path="userName">Username</form:label>
					<div class="col-sm-10">
						<form:input id="username" path="userName" class="form-control" />
					</div>
					<form:errors path="userName" class="text-danger" />
				</div>
				<div class="mt-2">
					<form:label path="email">Email</form:label>
					<div class="col-sm-10">
						<form:input path="email" class="form-control" />
					</div>
					<form:errors path="email" class="text-danger" />
				</div>
				<div class="mt-2">
					<form:label path="password">Password</form:label>
					<div class="col-sm-10">
						<form:input path="password" class="form-control" type="password" />
					</div>
					<form:errors path="password" class="text-danger" />
				</div>
				<div class="mt-2">
					<form:label path="confirm">Confirm Password</form:label>
					<div class="col-sm-10">
						<form:input path="confirm" class="form-control" type="password" />
					</div>
					<form:errors path="confirm" class="text-danger" />
				</div>
				<input type="submit" value="Submit" class="btn btn-success mt-3" />
			</form:form>
		</div>
		<div>
			<h2>Log in</h2>
			<form:form action="/login" method="post" modelAttribute="newLogin">

				<div>
					<form:label path="email">Email</form:label>
					<div class="col-sm-10">
						<form:input path="email" class="form-control" />
					</div>
					<form:errors path="email" class="text-danger" />
				</div>
				<div class="mt-2">
					<form:label path="password">Password</form:label>
					<div class="col-sm-10">
						<form:input path="password" class="form-control" type="password" />
					</div>
					<form:errors path="password" class="text-danger" />
				</div>
				<input type="submit" value="Submit" class="btn btn-success mt-3" />
			</form:form>

		</div>
	</div>

</body>
</html>