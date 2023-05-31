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
	<c:choose>
		<c:when test="${ userId == book.user.id }">
			<div class="d-flex justify-content-between">

				<h1>Change your Entry</h1>
				<div>
					<a href="/books">back to the shelves</a>
				</div>
			</div>

			<form:form action="/books/edit/${ book.id }" method="post"
				modelAttribute="book">
				<input type="hidden" name="_method" value="put">
				<form:input type="hidden" name="user" path="user" />
				<form:errors path="title" class="text-danger" />
				<form:errors path="author" class="text-danger" />
				<form:errors path="thoughts" class="text-danger" /><br />
				<form:label path="title">Title</form:label>
				<form:input path="title" class="form-control" />
				<form:label path="author">Author</form:label>
				<form:input path="author" class="form-control" />
				<form:label path="thoughts">My Thoughts</form:label>
				<form:input path="thoughts" class="form-control" />
				<input type="submit" class="btn btn-success" />
				
			</form:form>
			
			<a href="/delete/${ book.id }" class="btn btn-danger">Delete</a>
		</c:when>
		<c:otherwise>
			<h2 class="text-danger">You do not have permission.</h2>
			<a href="/books">back to the shelves</a>
		</c:otherwise>
	</c:choose>
</body>
</html>