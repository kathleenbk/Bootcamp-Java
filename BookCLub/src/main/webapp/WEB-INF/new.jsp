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
	<h1>Add a Book to Your Shelf!</h1>
	<form:form action="/books/new" method="post" modelAttribute="book">
		<form:errors path="title" class="text-danger" />
		<form:errors path="author" class="text-danger" />
		<form:errors path="thoughts" class="text-danger" />
		<form:label path="title">Title</form:label>
		<form:input path="title" class="form-control" />
		<form:label path="author">Author</form:label>
		<form:input path="author" class="form-control" />
		<form:label path="thoughts">My Thoughts</form:label>
		<form:input path="thoughts" class="form-control" />
		<input type="submit" class="btn btn-success" />
	</form:form>

</body>
</html>