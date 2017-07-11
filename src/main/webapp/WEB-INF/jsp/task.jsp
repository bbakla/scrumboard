<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css">

<title>Create Backlog</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-11">

				<form:form method="POST" modelAttribute="task">

					<div class="form-group">
						<label for="projectName" class="col-2 col-form-label">Project
							Name</label> <input id="projectName" type="text" class="form-control"
							value="${project.name}" readonly>
					</div>

					<div class="form-group">
						<label for="projectName" class="col-2 col-form-label">Backlog
							Name</label> <input id="projectName" type="text" class="form-control"
							value="${backlog.name}" readonly>
					</div>

					<div class="form-group">
						<label for="taskName" class="col-2 col-form-label">Task id</label>
						<form:input path="id" id="taskId" class="form-control" readonly="true"/>
					</div>
					
					<div class="form-group">
						<label for="taskName" class="col-2 col-form-label">Task
							name</label>
						<form:input path="taskName" id="taskName" class="form-control" />
					</div>

					<div class="form-group">
						<label for="startedDate" class="col-2 col-form-label">Started
							Date</label>
						<form:input path="startedDate" id="startedDate"
							class="form-control" />
					</div>

					<div class="form-group">
						<label for="startedDate" class="col-2 col-form-label">Created
							Date</label>
						<form:input path="startedDate" id="startedDate"
							class="form-control" />
					</div>

					<div class="form-group">
						<label for="startedDate" class="col-2 col-form-label">Last
							Update</label>
						<form:input path="startedDate" id="startedDate"
							class="form-control" />
					</div>

					<div class="form-group">
						<label for="status" class="col-2 col-form-label">Status</label>
						<form:input path="status" id="status" class="form-control" />
					</div>

					<div class="form-group">
						<label for="description" class="col-2 col-form-label">Description</label>
						<form:input path="taskDetails.taskDescription" id="description"
							class="form-control" />
					</div>

					<div class="form-group">
						<label class="col-2 col-form-label">Comments</label> <br /> <br />

						<c:forEach items="${task.taskDetails.comments}" var="comment">
							<label>${comment.name} </label>
							<label>${comment.person.personName}</label>
						</c:forEach>
					</div>
					

					<form:button name="Create" class="btn btn-primary">Create task</form:button>
				</form:form>
				<br />
			</div>
		</div>
	</div>


</body>
</html>