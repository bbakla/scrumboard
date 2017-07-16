<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%-- <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"> --%>
<link type="text/css" rel="stylesheet" href="/css/main.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">




<title>Project page</title>
</head>
<body>
	<!-- <div class="container">
		<div class="row">
			<div class="col-md-11">
				<div class="panel panel-default">
					<div class="panel-heading" id="title">Project details</div>
					<div class="panel-body">

						<form:form method="POST" modelAttribute="project">
							<div class="form-group">
								<label for="id" class="col-2 col-form-label">Project Id</label>
								<form:input path="id" id="id" class="form-control" readonly="true"/>
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
							<form:button name="Update" class="btn btn-primary">Update</form:button>
							<form:button name="Cancel" class="btn btn-primary">Cancel</form:button>
						</form:form>
						<br />
						</div>
					</div>
				</div>
			</div>
		</div>
		
		-->

	<div class="modal fade" id="peopleInTeam" tabindex="-1" role="dialog"
		aria-labelledby="title" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="title">Add task to the sprint</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form method="POST"
					action="/projects/${project.id}/team/${team.id}/sprint/${sprint.id}">
					<div class="modal-body">

						<div class="form-group">
							<label for="taskId" class="col-2 col-form-label">Task
								name</label> <select id="taskId" name="taskId" class="form-control">

								<c:forEach items="${sprint.team.backlog.tasks}" var="task">
									<option value="<c:out value="${task.value.id}" />"><c:out value="${task.value.taskName}" /></option>
								</c:forEach>

							</select>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<input type="submit" name="Create" value="Create"
							class="btn btn-primary" />
					</div>
				</form>
			</div>
		</div>
	</div>


	<div class="container">

		<div class="col-md-11">

			<div class="panel panel-default">
				<div class="panel-heading clearfix" id="goalTitle">
					<h4 class="panel-title pull-left" style="padding-top: 7.5px;">${sprint.sprintName}</h4>
					<button type="button" class="btn btn-primary pull-right"
						data-toggle="modal" data-target="#peopleInTeam"
						data-whatever="@getbootstrap">
						<i class="glyphicon glyphicon-plus"> </i>Add task to the sprint
					</button>
				</div>
				<div class="panel-body">

					<div class="table-responsive">
						<table id="mytable" class="table table-bordred table-striped">
							<thead>
								<th><input type="checkbox" id="checkall" /></th>
								<th>Id</th>
								<th>Task name</th>
								<th>Task status</th>
								<th>Assigned to</th>
								<th>Last update</th>
								<th>Edit</th>
								<th>Delete</th>
							</thead>

							<tbody>
								<c:forEach items="${sprint.tasks}" var="task">
									<tr>
										<td><input type="checkbox" class="checkthis" /></td>
										<td>${task.id}</td>
										<td><a
											href="<c:url value='/projects/${project.id}/backlog/${team.backlog.id}/task/${task.id}'/>">${task.taskName}</a></td>
										<td>${task.status}</td>
										<td>${task.assignedTo}</td>
										<td>${task.lastUpdate}</td>
										<td><p title="Edit">
												<button class="btn btn-primary btn-xs" data-title="Edit"
													data-toggle="modal" data-target="#edit">
													<span class="glyphicon glyphicon-pencil"></span>
												</button>
											</p></td>
										<td><p data-placement="top" data-toggle="tooltip"
												title="Delete">
												<button class="btn btn-danger btn-xs" data-title="Delete"
													data-toggle="modal" data-target="#delete">
													<span class="glyphicon glyphicon-trash"></span>
												</button>
											</p></td>
									</tr>
								</c:forEach>

							</tbody>

						</table>

						<div class="clearfix"></div>
						<ul class="pagination pull-right">
							<li class="disabled"><a href="#"><span
									class="glyphicon glyphicon-chevron-left"></span></a></li>
							<li class="active"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#"><span
									class="glyphicon glyphicon-chevron-right"></span></a></li>
						</ul>

					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="modal fade" id="edit" tabindex="-1" role="dialog"
		aria-labelledby="edit" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					</button>
					<h4 class="modal-title custom_align" id="Heading">Edit Your
						Detail</h4>
				</div>

				<div class="modal-footer ">
					<button type="button" class="btn btn-warning btn-lg"
						style="width: 100%;">
						<span class="glyphicon glyphicon-ok-sign"></span> Update
					</button>
				</div>
			</div>
		</div>
	</div>


	<div class="modal fade" id="delete" tabindex="-1" role="dialog"
		aria-labelledby="edit" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					</button>
					<h4 class="modal-title custom_align" id="Heading">Delete this
						entry</h4>
				</div>
				<div class="modal-body">

					<div class="alert alert-danger">
						<span class="glyphicon glyphicon-warning-sign"></span> Are you
						sure you want to delete this Record?
					</div>

				</div>
				<div class="modal-footer ">
					<button type="button" class="btn btn-success">
						<span class="glyphicon glyphicon-ok-sign"></span> Yes
					</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
						<span class="glyphicon glyphicon-remove"></span> No
					</button>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="col-lg-12">
			<div id="not_started" class="col-lg-2 clone_container">
				<h4>Not started</h4>
				<c:forEach items = "${sprint.tasks}" var ="task">
					<c:if test="${task.status eq 'NOT_STARTED'}">
						 <div class="thumbnail">
						 	<p><b>Task name:</b> ${task.taskName}</h2>
						 	<p><b>task Id:</b>   ${task.id}</p>
						 </div>
					</c:if>
				</c:forEach>
			</div>
			
			<div id="analysed" class="col-lg-2 clone_container">
				<h4>Analysed</h4>
				<c:forEach items = "${sprint.tasks}" var ="task">
					<c:if test="${task.status eq 'ANALYSED'}">
						 <div class="thumbnail">
						 	<h2>${task.taskName}</h2>
						 	<p>taskId:  ${task.id}</p>
						 </div>
					</c:if>
				</c:forEach>
			</div>
			
			<div id="in_progress" class="col-lg-2 clone_container">
				<h4>In Progress</h4>
				<c:forEach items = "${sprint.tasks}" var ="task">
					<c:if test="${task.status eq 'IN_PROGRESS'}">
						 <div class="thumbnail">
						 	<h2>${task.taskName}</h2>
						 	<p>taskId:  ${task.id}</p>
						 </div>
					</c:if>
				</c:forEach>
			</div>
			
			<div id="completed" class="col-lg-2 clone_container">
				<h4>Completed</h4>
				<c:forEach items = "${sprint.tasks}" var ="task">
					<c:if test="${task.status eq 'COMPLETED'}">
						 <div class="thumbnail">
						 	<h2>${task.taskName}</h2>
						 	<p>taskId:  ${task.id}</p>
						 </div>
					</c:if>
				</c:forEach>
			</div>
			
			<div id="verified" class="col-lg-2 clone_container">
				<h4>Verified</h4>
				<c:forEach items = "${sprint.tasks}" var ="task">
					<c:if test="${task.status eq 'VERIFIED'}">
						 <div class="thumbnail">
						 	h2>${task.taskName}</h2>
						 	<p>taskId:  ${task.id}</p>
						 </div>
					</c:if>
				</c:forEach>
			</div>
			
			<div id="integrated" class="col-lg-2 clone_container">
				<h4>Integrated</h4>
				<c:forEach items = "${sprint.tasks}" var ="task">
					<c:if test="${task.status eq 'INTEGRATED'}">
						 <div class="thumbnail">
						 	<h2>${task.taskName}</h2>
						 	<p>taskId:  ${task.id}</p>
						 </div>
					</c:if>
				</c:forEach>
			</div>
			
		</div>
	</div>



</body>
</html>