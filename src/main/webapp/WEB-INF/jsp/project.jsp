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



<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-11">
				<div class="panel panel-default">
					<div class="panel-heading" id="title">Project details</div>
					<div class="panel-body">

						<form:form method="POST" modelAttribute="project">
							<div class="form-group">
								<label for="id" class="col-2 col-form-label">Project Id</label>
								<form:input path="id" id="id" class="form-control" />
							</div>

							<div class="form-group">
								<label for="title" class="col-2 col-form-label">Project
									Name</label>
								<form:input path="name" id="name" class="form-control" />
							</div>

							<div class="form-group">
								<label for="description" class="col-2 col-form-label">Description</label>
								<form:input path="description" id="description"
									class="form-control" />
							</div>

							<div class="form-group">
								<label for="backlogs" class="col-2 col-form-label">Backlog</label>
								<div class="input-group">

									<c:forEach items="${project.backlogs}" var="backlog">
										<a href="<c:url value='${project.id}/backlog/${backlog.id}'/>">${backlog.name}</a>
										<br />
									</c:forEach>
									<span class="input-group-btn"> <a
										href="<c:url value='${project.id}/backlog'/>"
										class="btn btn-primary">Add Backlog</a>
									</span>
								</div>

							</div>

							<form:button name="Update" class="btn btn-primary">Update</form:button>
							<form:button name="Cancel" class="btn btn-primary">Cancel</form:button>
						</form:form>
						<br />
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>