<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Kickstarter projects</title>
	</head>
	<body>
		<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>name</th>
					<th>description</th>
				</tr>
			</thead>
		<tbody>
			<c:forEach items="${projects}" var="project">
				<tr>
					<td>
						<strong>
							<a href="project?id=${project.id}">
							<c:out value="${project.name}"/></a>
						</strong>
					</td>
					<td>
						<c:out value="${project.description}"/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
	</body>
</html>