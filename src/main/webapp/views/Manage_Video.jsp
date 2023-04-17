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
	<div class="card shadow my-2 p-0 m-auto">
		<ul class="nav nav-tabs" id="myTab" role="tablist">
			<c:set var="tab1" scope="request" value="Video Edition"/>
			<c:set var="tab2" scope="request" value="Video List"/>
			<c:if test="${!empty videoEdition}">
				<c:set var="tab2" scope="request" value="Video Edition"/>
				<c:set var="tab1" scope="request" value="Video List"/>
			</c:if>
			
			<!-- tab Video Edition  -->
			<li class="nav-item" role="presentation">
				<button class="nav-link active" id="home-tab" data-bs-toggle="tab"
					data-bs-target="#home-tab-pane" type="button" role="tab"
					aria-controls="home-tab-pane" aria-selected="true">
					
					${tab1} 
				</button>

			</li>
			<!-- tab Video List  -->
			<li class="nav-item" role="presentation">
				<button class="nav-link" id="profile-tab" data-bs-toggle="tab"
					data-bs-target="#profile-tab-pane" type="button" role="tab"
					aria-controls="profile-tab-pane" aria-selected="false">
					
					${tab2} 
				</button>

			</li>
		</ul>

		<div class="tab-content" id="myTabContent">
			<!-- tab Video Edition  -->
			<div class="tab-pane fade show active" id="home-tab-pane" role="tabpanel" aria-labelledby="home-tab" tabindex="0">
				<jsp:include page="${tabVideo1}">
					<jsp:param name="listV" value="${listV}"/>
					<jsp:param name="video" value="${video}"/>
					<jsp:param name="sumVideos" value="${sumVideos}"/>
					<jsp:param name="img" value="${img}"/>
				</jsp:include> 
				
			</div>

			<!-- tab Video List  -->
			<div class="tab-pane fade" id="profile-tab-pane" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">
				<jsp:include page="${tabVideo2}">
					<jsp:param name="listV" value="${listV}"/>
					<jsp:param name="video" value="${video}"/>
					<jsp:param name="sumVideos" value="${sumVideos}"/>
					<jsp:param name="img" value="${img}"/>
				</jsp:include> 
			</div>
		</div>
		
	</div>
</body>
</html>