<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Share</title>
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
	<div class="card shadow col-5 mt-5 m-auto">
		<form action="/SOF3011.AssignmentFinal/video/share?videoId=${videoId}">
			<h5 class="card-title mb-0 fv border border-warning p-3 m-0 bg-success-subtle fv">
				Send Video To Your Friend
			</h5>
			<div class="card-body border border-warning m-0">
				<div class="mb-3">
					<label for="Email" class="form-label fv">Your Friend's Email</label> 
					<input name = email type="email" class="form-control"
						id="mail" placeholder="name@example.com">
				</div>
			</div>
			<div
				class="card-footer d-flex justify-content-end border border-warning">
				<button name="videoId" value="${videoId}" type="submit" class="btn btn-warning">Send</button>
			</div>
		</form>
	</div>
</body>
</html>