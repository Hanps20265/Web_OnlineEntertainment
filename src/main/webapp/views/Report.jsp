<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage</title>
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
	<div class="card shadow col-8 mt-5 m-auto">
		<ul class="nav nav-tabs" id="myTab" role="tablist">
			<!-- tab Favorite  -->
			<li class="nav-item" role="presentation">
				<button class="nav-link active" id="home-tab" data-bs-toggle="tab"
					data-bs-target="#home-tab-pane" type="button" role="tab"
					aria-controls="home-tab-pane" aria-selected="true">
					Favorite</button>

			</li>
			<!-- tab Favorite User  -->
			<li class="nav-item" role="presentation">
				<button class="nav-link" id="profile-tab" data-bs-toggle="tab"
					data-bs-target="#profile-tab-pane" type="button" role="tab"
					aria-controls="profile-tab-pane" aria-selected="false">
					Favorite User</button>

			</li>
			<!-- tab Shared Friends  -->
			<li class="nav-item" role="presentation">
				<button class="nav-link" id="contact-tab" data-bs-toggle="tab"
					data-bs-target="#contact-tab-pane" type="button" role="tab"
					aria-controls="contact-tab-pane" aria-selected="false">
					Shared Friends</button>
			</li>
		</ul>

		<div class="tab-content" id="myTabContent">
			<!-- tab User Edition  -->
			<div class="tab-pane fade show active" id="home-tab-pane"
				role="tabpanel" aria-labelledby="home-tab" tabindex="0">
				<table class="table table-bordered m-0 border-warning">
					<thead>
						<tr>
							<th scope="col">Video Title</th>
							<th scope="col">Favorite Count</th>
							<th scope="col">Latest Date</th>
							<th scope="col">Oldest Date</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${!empty listR}">
							<c:forEach var="report" items="${listR}">
								<tr>
									<td>${report.group}</td>
									<td>${report.likes}</td>
									<td>${report.newest}</td>
									<td>${report.oldest}</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>

			<!-- tab User List  -->
			<div class="tab-pane fade" id="profile-tab-pane" role="tabpanel"
				aria-labelledby="profile-tab" tabindex="0">
				<div class="border border-warning">
					<form action="/SOF3011.AssignmentFinal/report" class="d-flex col-10 ms-5 mb-3 py-0 " role="search" method="post">
						<label for="username" class="col-sm-2 col-form-label my-3 ms-4 fv"> Video Title?</label> 
						<select name="title" 
							class="col-sm-9 col-form-select my-3 p-2 border border-warning rounded-2 " aria-label="Default select example">
							<c:if test="${!empty listVAll}">
								<c:forEach var="video" items="${listVAll}">
					  				<option  value="${video.title}">${video.title}</option>
								</c:forEach>
							</c:if>	
						</select>
						<button class="btn btn-outline-success py-0 my-2 ms-3" type="submit">Search</button>
	    			</form>
				</div>
				<table class="table table-bordered m-0 border-warning">
					<thead>
						<tr>
							<th scope="col">Username</th>
							<th scope="col">Fullname</th>
							<th scope="col">Email</th>
							<th scope="col">Favorite Date</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${!empty listUser}">
							<c:forEach var="user" items="${listUser}">
								<tr>
									<td>${user[0]}</td>
									<td>${user[1]}</td>
									<td>${user[2]}</td>
									<td>${user[3]}</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>

			<!-- tab Shared Friends  -->
			<div class="tab-pane fade" id="contact-tab-pane" role="tabpanel" aria-labelledby="contact-tab" tabindex="0">
				
				<div class="border border-warning">
				<form action="/SOF3011.AssignmentFinal/report" class="d-flex col-10 ms-5 mb-3 py-0 " role="search" method="post">
					<label for="username" class="col-sm-2 col-form-label my-3 ms-4 fv">
					Video Title?</label> 
					<select name="titleShared" 
						class="col-sm-9 col-form-select my-3 p-2 border border-warning rounded-2 " aria-label="Default select example">
						<c:if test="${!empty listVAll}">
							<c:forEach var="video" items="${listVAll}">
				  				<option  value="${video.title}">${video.title}</option>
							</c:forEach>
						</c:if>	
					</select>
					<button class="btn btn-outline-success py-0 my-2 ms-3" type="submit">Search</button>
	    			</form>
				</div>

				<table class="table table-bordered m-0 border-warning">
					<thead>
						<tr>
							<th scope="col">Sender Name</th>
							<th scope="col">Sender Email</th>
							<th scope="col">Receiver Email</th>
							<th scope="col">Send Date</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${!empty listUserShared}">
							<c:forEach var="user" items="${listUserShared}">
								<tr>
									<td>${user[0]}</td>
									<td>${user[1]}</td>
									<td>${user[2]}</td>
									<td>${user[3]}</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>

		</div>
	</div>
</body>
</html>