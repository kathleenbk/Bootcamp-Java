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
	<div class="d-flex justify-content-between">
		<h1>
			<c:out value="${ book.title }"></c:out>
		</h1>
		<div>
			<a href="/books">back to the shelves</a>
		</div>
	</div>
	<c:choose>
		<c:when test="${ userId == book.user.id }">
	<div class="mt-4">
		<h3>
			You read
			<c:out value="${ book.title }"></c:out>
			by
			<c:out value="${ book.author }"></c:out>
		</h3>
		<h4>
			Here are your thoughts:
		</h4>
		<hr />
		<p>
			<c:out value="${ book.thoughts }"></c:out>
		</p>
		<hr />
	</div>
	</c:when>
	<c:otherwise>
	<div class="mt-4">
		<h3>
			<c:out value="${ book.user.userName }"></c:out>
			read
			<c:out value="${ book.title }"></c:out>
			by
			<c:out value="${ book.author }"></c:out>
		</h3>
		<h4>
			Here are
			<c:out value="${ book.user.userName }"></c:out>
			's thoughts:
		</h4>
		<hr />
		<p>
			<c:out value="${ book.thoughts }"></c:out>
		</p>
		<hr />
	</div>
	</c:otherwise>
	</c:choose>
	<c:if test="${ userId == book.user.id }">
		<a href="/books/edit/${ book.id }" class="btn btn-primary">Edit</a>
	</c:if>

</body>
</html>