<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
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
</style> -->
</head>
<body>
	<div class="card shadow col-5 mt-5 m-auto">
		<h5 class="card-title mb-0 fv border border-warning p-3 m-0 bg-success-subtle fv">Change Password</h5>
		<form action="/SOF3011.AssignmentFinal/change-password" method="post">
		<div class="card-body border border-warning m-0">
			
				<div class="row">
					<div class="mb-3 col-6 ">
						<label for="username" class="form-label fv">Username?</label> 
						<input name="username" value="${sessionScope.authUser.userId}"
							type="text" class="form-control" id="username" disabled>
					</div>
					<div class="mb-3 col-6 ">
						<label for="password" class="form-label fv">Current Password?</label> 
						<input name="password"
							type="password" class="form-control" id="password" placeholder="Mật khẩu hiện tại!">
					</div>
				</div>

				<div class="row">
					<div class="mb-3 col-6 ">
						<label for="new" class="form-label fv">New Password?</label> 
						<input name="newpass"
							type="password" class="form-control" id="new" placeholder="Mật khẩu mới!">
					</div>
	
					<div class="mb-3 col-6 ">
						<label for="confirm" class="form-label fv">Confirm New Password?</label> 
						<input name="confirm"
							type="password" class="form-control" id="confirm" placeholder="Xác nhận lại mật khẩu mới!">
					</div>
				</div>
			
		</div>
		<div
			class="card-footer d-flex justify-content-end border border-warning">
			<button type="submit" class="btn btn-warning">Change</button>
		</div>
		</form>
	</div>
</body>
</html>