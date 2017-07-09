<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">



<title>Create Backlog</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-11">

						<form:form method="POST" modelAttribute="backlog">
							
							<div class="form-group">
								<label for="projectName" class="col-2 col-form-label">Project Name</label>
								<input id="projectName" type="text" class="form-control" value="${projectName}" readonly>
							</div>
							
							<div class="form-group">
								<label for="title" class="col-2 col-form-label">Backlog Name</label>
								<form:input path="name" id="name" class="form-control" />
							</div>
							
							<form:button name="Update" class="btn btn-primary">Create</form:button>
						</form:form>
						<br />
					</div>
				</div>
			</div>
			
</body>
</html>