<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<!-- JavaScript & CSS -->
 <link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<style>
.fv {
	font-variant: small-caps;
}
</style>
</head>
<body>
	<div class="card shadow col-8 mt-3 m-auto">
		<form action="/SOF3011.AssignmentFinal/sign-up" method="post">
			<h5 class="card-title mb-0 fv border border-warning p-3 m-0 bg-success-subtle fv">Registration</h5>
			<div class="card-body border border-warning m-0">
				<h1>${message}</h1>
				<div class="row">
					<div class="mb-3 col-6 ">
						<label 
							for="username" class="form-label fv">Username?</label> 
						<input name="userId" 
							type="text" class="form-control" id="username"
							placeholder="username">
					</div>
					<div class="mb-3 col-6 ">
						<label 
							for="password" class="form-label fv">Password?</label> 
						<input name="password"
							type="password" class="form-control" id="password"
							placeholder="*********">
					</div>
				</div>
				
				<div class="row">
					<div class="mb-3 col-6 ">
					<label 
						for="Fullname" class="form-label fv">Fullname?</label> 
					<input name="fullname"
						type="text" class="form-control" id="Fullname"
						placeholder="Fullname">
					</div>
		
					<div class="mb-3 col-6 ">
						<label 
							for="Email" class="form-label fv">Email Address?</label> 
						<input name="email"
							type="email" class="form-control" id="Email"
							placeholder="name@example.com">
					</div>
				</div>
				<div class="form-check form-check-inline">
				  <input name="admin" class="form-check-input" type="radio" id="inlineRadio1" value="true">
				  <label class="form-check-label" for="inlineRadio1">Admin</label>
				</div>
				<div class="form-check form-check-inline">
				  <input name="admin" class="form-check-input" type="radio" id="inlineRadio2" value="false">
				  <label class="form-check-label" for="inlineRadio2">User</label>
				</div>
				
			</div>
			<div class="card-footer d-flex justify-content-end border border-warning">
				<button type="submit" class="btn btn-warning" id="commit">Sign Up</button>
				
			</div>
		</form>
	</div>
</body>
</html>