<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="${pageContext.request.contextPath}/js/bootstrap.js">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">

<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-11">
				<div class="panel panel-default">
					<div class="panel-heading" id="goalTitle">Create the project</div>
					<div class="panel-body">

						<form:form method="POST" modelAttribute="parent">
							<div class="form-group">

								<label for="title" class="col-2 col-form-label">Project Name</label>
							</div>
							<div class="form-group">
								<label for="description" class="col-2 col-form-label">Description</label>
							</div>

							<form:button name="Create" class="btn btn-primary btn-lg  btn-block">Create</form:button>
						</form:form>
						<br />
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>