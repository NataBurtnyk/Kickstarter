<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Project</title>
	</head>
	<body>
		<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>name</th>
					<th>description</th>
					<th>story</th>
					<th>requiredAmount</th>
					<th>total</th>
					<th>days</th>
					<th>link</th>
				</tr>
			</thead>
				<tbody>
				<tr>
					<td>
						<strong>
							<c:out value="${project.name}"/></a>
						</strong>
					</td>
					<td>
						<c:out value="${project.description}"/>
					</td>
					<td>
						<c:out value="${project.history}"/>
					</td>	
					<td>
						<c:out value="${project.requiredAmount}"/>
					</td>
					<td>
						<c:out value="${project.total}"/>
					</td>
					<td>
						<c:out value="${project.days}"/>
					</td>
					<td>
						<c:out value="${project.url}"/>
					</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>