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

 <script type="text/javascript">
 $(function () {
     $('.tree li:has(ul)').addClass('parent_li').find(' > span').attr('title', 'Collapse this branch');
     $('.tree li.parent_li > span').on('click', function (e) {
         var children = $(this).parent('li.parent_li').find(' > ul > li');
         if (children.is(":visible")) {
             children.hide('fast');
             $(this).attr('title', 'Expand this branch').find(' > i').addClass('icon-plus-sign').removeClass('icon-minus-sign');
         } else {
             children.show('fast');
             $(this).attr('title', 'Collapse this branch').find(' > i').addClass('icon-minus-sign').removeClass('icon-plus-sign');
        }
         e.stopPropagation();
    });
 });
 </script>

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
								<label for="title" class="col-2 col-form-label">Project Name</label>
								<form:input path="name" id="name" class="form-control" />
							</div>
							
							<div class="form-group">
								<label for="description" class="col-2 col-form-label">Description</label>
								<form:input path="description" id="description" class="form-control" />
							</div>
							
							<div class="form-group">
								<label for="backlogs" class="col-2 col-form-label">Backlog</label>
								
							<div class="tree">
							<ul>
								<li>
								<c:forEach items="${project.backlogs}" var="backlog">
								<span><i class="icon-folder-open"></i> ${backlog.name}</span>
			
			<a href="<c:url value='/backlogs/${backlog.id}'/>"
				class="form-control"></a>
			<br/>
		</c:forEach>
		</li>
		</ul>
		
		
    <ul>
        <li>
            <span><i class="icon-folder-open"></i> Parent</span> <a href="">Goes somewhere</a>
            <ul>
               
                <li>
                	<span><i class="icon-minus-sign"></i> Child</span> <a href="">Goes somewhere</a>
                    <ul>
                        <li>
	                        <span><i class="icon-leaf"></i> Grand Child</span> <a href="">Goes somewhere</a>
                        </li>
                        <li>
                        	<span><i class="icon-minus-sign"></i> Grand Child</span> <a href="">Goes somewhere</a>
                            <ul>
                                <li>
	                                <span><i class="icon-minus-sign"></i> Great Grand Child</span> <a href="">Goes somewhere</a>
		                            <ul>
		                                <li>
			                                <span><i class="icon-leaf"></i> Great great Grand Child</span> <a href="">Goes somewhere</a>
		                                </li>
		                               
		                             </ul>
                                </li>
                                <li>
	                                <span><i class="icon-leaf"></i> Great Grand Child</span> <a href="">Goes somewhere</a>
                                </li>
                                
                            </ul>
                        </li>
                        <li>
	                        <span><i class="icon-leaf"></i> Grand Child</span> <a href="">Goes somewhere</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>
      
    </ul>
</div>
								
							</div>
							
							
							
							<div class="form-group">
								<label for="backlogs" class="col-2 col-form-label">Backlog</label>
								<form:select id="parentList" path="backlogs" class="form-control">
 									<form:options items="${backlogs}" itemLabel="name"
										itemValue="id"></form:options> 
								</form:select>
							</div>
							
 							
							<form:button name="Update" class="btn btn-primary">Create</form:button>
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