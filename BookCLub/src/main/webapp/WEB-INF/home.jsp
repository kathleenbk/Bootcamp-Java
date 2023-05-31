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
<body class="p-5">
	<div class="d-flex justify-content-between">
		<div>
			<h1>
				Welcome,
				<c:out value="${ user.userName }"></c:out>
			</h1>
			<p>Books from everyone's shelves:</p>
		</div>
		<div>
			<a href="/logout">Logout</a><br /> <a href="/books/new">+ Add a
				book to my shelf!</a>
		</div>
	</div>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Posted By</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${ books }">
				<tr>
					<td><c:out value="${ book.id }"></c:out></td>
					<td><a href="/books/${ book.id }"><c:out
								value="${ book.title }"></c:out></a></td>
					<td><c:out value="${ book.author }"></c:out></td>
					<td><c:out value="${ book.user.userName }"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</body>
</html>