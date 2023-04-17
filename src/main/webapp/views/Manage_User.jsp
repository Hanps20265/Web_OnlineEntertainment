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
	<div class="card shadow col-10 my-2 m-auto">
		<ul class="nav nav-tabs" id="myTab" role="tablist">
			
			<c:set var="tab1" scope="request" value="User Edition"/>
			<c:set var="tab2" scope="request" value="User List"/>
			<c:if test="${!empty userEdition}">
				<c:set var="tab2" scope="request" value="User Edition"/>
				<c:set var="tab1" scope="request" value="User List"/>
			</c:if>
			<!-- tab User Edition  -->
			<li class="nav-item" role="presentation">
				<button class="nav-link active" id="home-tab" data-bs-toggle="tab"
					data-bs-target="#home-tab-pane" type="button" role="tab"
					aria-controls="home-tab-pane" aria-selected="true">
					${tab1} </button>
			</li>
			<!-- tab User List  -->
			<li class="nav-item" role="presentation">
				<button class="nav-link" id="profile-tab" data-bs-toggle="tab"
					data-bs-target="#profile-tab-pane" type="button" role="tab"
					aria-controls="profile-tab-pane" aria-selected="false">
					${tab2} </button>
			</li>
		</ul>
		<div class="tab-content" id="myTabContent">
			<!-- tab User Edition  -->
			<div class="tab-pane fade show active" id="home-tab-pane" role="tabpanel" aria-labelledby="home-tab" tabindex="0">
				<jsp:include page="${tabUser1}">
					<jsp:param name="user" value="${user}"/>
					<jsp:param name="listU" value="${listU}"/>
					<jsp:param name="sumUsers" value="${sumUsers}"/>
				</jsp:include> 
			</div>
				
			<!-- tab User List  -->
			<div class="tab-pane fade" id="profile-tab-pane" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">
				<jsp:include page="${tabUser2}">
					<jsp:param name="user" value="${user}"/>
					<jsp:param name="listU" value="${listU}"/>
					<jsp:param name="sumUsers" value="${sumUsers}"/>
				</jsp:include>
			</div>

		</div>
	</div>
</body>
</html>