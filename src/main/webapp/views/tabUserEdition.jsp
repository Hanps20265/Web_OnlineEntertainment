<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form  method="post">
					<div class="card-body border border-warning m-0">
					
						<div class="row">
							<div class="mb-2 col-6 ">
								<label for="username" class="form-label fv">Username?</label> 
								<input name="userId" value="${user.userId}"
									type="text" class="form-control" id="username" placeholder="username">
							</div>
							<div class="mb-2 col-6 ">
								<label for="password" class="form-label fv">Password?</label> 
								<input name="password" value="${user.password}"
									type="password" class="form-control" id="password"
									placeholder="*********">
							</div>
						</div>
					
						<div class="row">
							<div class="mb-2 col-6 ">
							<label for="Fullname" class="form-label fv">Fullname?</label> 
							<input name="fullname" value="${user.fullname}"
								type="text" class="form-control" id="fullname"
								placeholder="Fullname">
							</div>
				
							<div class="mb-2 col-6 ">
								<label for="Email" class="form-label fv">Email Address?</label> 
								<input name="email" value="${user.email}"
									type="email" class="form-control" id="email"
									placeholder="name@example.com">
							</div>
						</div>
				
						<div class="form-check form-check-inline">
						  <input name="admin" class="form-check-input" type="radio" id="inlineRadio1" ${user.admin==true?"checked":""}  value="true">
						  <label class="form-check-label" for="inlineRadio1">Admin</label>
						</div>
						<div class="form-check form-check-inline">
						  <input name="admin" class="form-check-input" type="radio" id="inlineRadio2" ${user.admin==false?"checked":""} value="false">
						  <label class="form-check-label" for="inlineRadio2">User</label>
						</div>
					</div>
					<div class="card-footer d-flex justify-content-end border border-warning bg-body-secondary">
						<button type="submit" formaction="/SOF3011.AssignmentFinal/User/update"
							id="update" class="btn btn-outline-primary text-danger text-danger me-2">Update</button>
						<button type="submit" formaction="/SOF3011.AssignmentFinal/User/delete"
							id="delete" class="btn btn-outline-primary text-danger text-danger me-2">Delete</button>
					</div>
				</form>
</body>
</html>