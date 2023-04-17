<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>
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
		<h5 class="card-title mb-0 fv border border-warning p-3 m-0 bg-success-subtle fv">Forgot Password</h5>
		<form action="/SOF3011.AssignmentFinal/forgot-password" method="post">
			<div class="card-body border border-warning m-0">
				<div class="mb-3">
					<label for="username" class="form-label fv">Username?</label> 
					<input name="username" 
						type="text" class="form-control" id="username" placeholder="username">
				</div>
	
				<div class="mb-3">
					<label for="email" class="form-label fv">Email?</label> 
					<input name="email" 
						type="email" class="form-control" id="email" placeholder="name@example.com">
				</div>
			</div>
			<div
				class="card-footer d-flex justify-content-end border border-warning">
				<button type="submit" class="btn btn-warning">Retrieve</button>
			</div>
		</form>
	</div>
</body>
</html>