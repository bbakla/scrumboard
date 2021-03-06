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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css">



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
	
	<!-- SPRINT -->
	<div class="modal fade" id="projectRecord" tabindex="-1" role="dialog"
		aria-labelledby="title" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="title">New sprint</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form:form method="POST" action = "${team.id}/sprint" modelAttribute="sprint">
					<div class="modal-body">

						<div class="form-group">
							<label for="sprintName" class="col-2 col-form-label">Sprint name</label>
							<form:input path="sprintName" id="sprintName" class="form-control"/>
							<form:hidden path="team" id="team" class="form-control"/>
						</div>
						
						<div class="form-group">
							<label for="startDate" class="col-2 col-form-label">Start date</label>
							<form:input path="sprintStartAt" id="startDate" class="form-control"/>
						</div>
						
						<div class="form-group">
							<label for="endDate" class="col-2 col-form-label">End date</label>
							<form:input path="sprintEndAt" id="endDate" class="form-control"/>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<form:button name="Create" class="btn btn-primary">Create</form:button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	
		<div class="container">
		
			<div class="col-md-11">
				<div class="panel panel-default">
					<div class="panel-heading clearfix" id="goalTitle">
						<h4 class="panel-title pull-left" style="padding-top: 7.5px;">${team.name}</h4>
						<button type="button" class="btn btn-primary pull-right" data-toggle="modal" 
					data-target="#projectRecord" data-whatever="@getbootstrap">
					<i class="glyphicon glyphicon-plus"> </i>Add sprint</button>
					</div>
					<div class="panel-body">

						<div class="table-responsive">
							<table id="mytable" class="table table-bordred table-striped">
								<thead>
									<th><input type="checkbox" id="checkall" /></th>
									<th>Id</th>
									<th>Sprint name</th>
									<th>Sprint start</th>
									<th>Sprint end</th>
									<th>Edit</th>
									<th>Delete</th>
								</thead>

								<tbody>
									<c:forEach items="${team.sprints}" var="sprint">
										<tr>
											<td><input type="checkbox" class="checkthis" /></td>
											<td>${sprint.id}</td>
											<td><a href="<c:url value='/projects/${project.id}/team/${team.id}/sprint/${sprint.id}'/>">${sprint.sprintName}</a></td>
											<td>${sprint.sprintStartAt}</td>
											<td>${sprint.sprintEndAt}</td>
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
	<!-- END OF SPRINT -->
	
	<!-- PEOPLE -->
	<div class="modal fade" id="peopleInTeam" tabindex="-1" role="dialog"
		aria-labelledby="title" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="title">Add person to the team</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form method="POST" action="/projects/${project.id}/team/${team.id}/member">
					<div class="modal-body">

						<div class="form-group">
							<label for="personId" class="col-2 col-form-label">Person name</label>
							<select id="personId" name="personId"
									class="form-control">
									
									 <c:forEach items="${team.project.people}" var="person">
        								<option value="<c:out value="${person.id}" />"><c:out value="${person.personName}" /></option>
    								 </c:forEach>
									
								</select>
						</div>
						
						

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<input type="submit" name="Create" value="Create" class="btn btn-primary"/>
					</div>
				</form>
			</div>
		</div>
	</div>
	
		<div class="container">
		
			<div class="col-md-11">
				<div class="panel panel-default">
					<div class="panel-heading clearfix" id="goalTitle">
						<h4 class="panel-title pull-left" style="padding-top: 7.5px;">${team.name}</h4>
						<button type="button" class="btn btn-primary pull-right" data-toggle="modal" 
					data-target="#peopleInTeam" data-whatever="@getbootstrap">
					<i class="glyphicon glyphicon-plus"> </i>Add person to the team</button>
					</div>
					<div class="panel-body">

						<div class="table-responsive">
							<table id="mytable" class="table table-bordred table-striped">
								<thead>
									<th><input type="checkbox" id="checkall" /></th>
									<th>Id</th>
									<th>Person name</th>
									<th>Person email</th>
									<th>Edit</th>
									<th>Delete</th>
								</thead>

								<tbody>
									<c:forEach items="${team.members}" var="person">
										<tr>
											<td><input type="checkbox" class="checkthis" /></td>
											<td>${person.id}</td>
											<td><a href="<c:url value='/projects/${project.id}/team/${team.id}/person/${person.id}'/>">${person.personName}</a></td>
											<td>${person.email}</td>
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
	
</body>
</html>