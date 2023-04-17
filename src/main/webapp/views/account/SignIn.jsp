<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<!-- <!-- JavaScript & CSS -->
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
	
	<!-- Page Content -->
		<form action="/SOF3011.AssignmentFinal/sign-in" method="post">
			<h5 class="card-title mb-0 fv border border-warning p-3 m-0 bg-success-subtle fv">Login</h5>
			<div class="card-body border border-warning m-0">
				<div class="mb-3">
					<label for="username" class="form-label fv">Username?</label> 
					<input name="username" value="${username}"
						type="text" class="form-control" id="username">
				</div>
				<div class="mb-3">
					<label for="password" class="form-label fv">Password?</label> 
					<input name="password" value="${password}"
						type="password" class="form-control" id="password">
				</div>
				<div class="form-check">
					<input name="remember" value=""
						class="form-check-input" type="checkbox" id="check"> 
					<label class="form-check-label" for="check"> Remember me? </label>
				</div>
			</div>
			<div class="card-footer d-flex justify-content-end border border-warning">
				<button  id="commit" type="submit" class="btn btn-warning">Login</button>
			</div>
		</form>
	</div>
</body>
</html>