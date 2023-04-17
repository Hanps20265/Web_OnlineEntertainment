<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>
<!-- JavaScript & CSS -->
<!-- <link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<style>
.fv {
	font-variant: small-caps;
} 
</style>-->
</head>
<body>
	<div class="card shadow col-8 mt-3 m-auto">
	<form action="/SOF3011.AssignmentFinal/edit-profile" method="post">
		<h5 class="card-title mb-0 fv border border-warning p-3 m-0 bg-success-subtle fv">Edit Profile</h5>
		<div class="card-body border border-warning m-0">
			
			<div class="row">
				<div class="mb-3 col-6 ">
				<label for="username" class="form-label fv">Username?</label> 
				<input name="id" value="${sessionScope.authUser.userId}"
					type="text" class="form-control" id="username"/>
				</div>
				<div class="mb-3 col-6 ">
					<label for="password" class="form-label fv">Password?</label> 
					<input name="password" value="${sessionScope.authUser.password}"
						type="password" class="form-control" id="password"/>
				</div>
			</div>
			<div class="row">
				<div class="mb-3 col-6 ">
				<label for="Fullname" class="form-label fv">Fullname?</label> 
				<input name="fullname" value="${sessionScope.authUser.fullname}"
					type="text" class="form-control" id="fullname"/>
				</div>
				<div class="mb-3 col-6 ">
					<label for="Email" class="form-label fv">Email Address?</label> 
					<input name="email" value="${sessionScope.authUser.email}"
						type="email" class="form-control" id="email"/>
				</div>
			</div>

			<%-- <div class="form-check form-check-inline">
			  <input name="admin" class="form-check-input" type="radio" id="inlineRadio1" ${sessionScope.authUser.admin==true?"checked":""}  value="true">
			  <label class="form-check-label" for="inlineRadio1">Admin</label>
			</div>
			<div class="form-check form-check-inline">
			  <input name="admin" class="form-check-input" type="radio" id="inlineRadio2" ${sessionScope.authUser.admin==false?"checked":""} value="false">
			  <label class="form-check-label" for="inlineRadio2">User</label>
			</div> --%>
			
		</div>
		<div
			class="card-footer d-flex justify-content-end border border-warning">
			<button type="submit" class="btn btn-warning" id="updateUser" >Update</button>
		</div>
		</form>
	</div>
</body>
</html>