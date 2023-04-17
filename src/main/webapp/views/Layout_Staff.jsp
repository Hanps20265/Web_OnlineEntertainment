<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Layout</title>
	<!-- JavaScript & CSS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
	<style>
		article, aside {
		    min-height: 550px;
		}
		.fv {
			font-variant: small-caps;
		}
		.text-shadow {
			text-shadow: 1px 2px red;
		}
		.text-shadow2 {
			text-shadow: 1px 1px green;
		}
		footer{
			height : 100px;
			background-color : lightblue;
			line-height: 30px;
			padding-left: 10px
		}
		.h-10{
			height:25px;
		}
		.h-35{
			height:200px;
		}
		.h-300{
			height:200px;
		}
	</style>
</head>
<body>
	<fmt:setLocale value="${sessionScope.lang}" scope="request"/>
	<fmt:setBundle  basename="global" scope="request"/>
	<!--  -->
	<div class="col-8 m-auto mt-2 border border-dark p-0">
		<!-- Navigation -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
			<div class="container">
				<a class="navbar-brand text-warning" href="/SOF3011.AssignmentFinal/admin?userId=${authUser.userId}"><fmt:message key="menu.admin"/></a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ms-auto text-info">
						<li class="nav-item"><a class="nav-link active" aria-current="page fv" 
							href="/SOF3011.AssignmentFinal/home"><fmt:message key="menu.home"/></a></li>
						<li class="nav-item"><a class="nav-link active" aria-current="page fv" 
							href="/SOF3011.AssignmentFinal/manage-videos"><fmt:message key="menu.video"/></a></li>
						<li class="nav-item"><a class="nav-link active" aria-current="page fv" 
							href="/SOF3011.AssignmentFinal/manage-users"><fmt:message key="menu.user"/></a></li>
						<li class="nav-item"><a class="nav-link active" aria-current="page fv" 
							href="/SOF3011.AssignmentFinal/report"><fmt:message key="menu.report"/></a></li>
						<li class="nav-item"><a class="nav-link active" aria-current="page fv" href="?lang=vi">
							<img class="h-10" src="/SOF3011.AssignmentFinal/public/vietnam-icon.jpeg"></a></li>
						<li class="nav-item"><a class="nav-link active" aria-current="page fv" href="?lang=en">
							<img class="h-10" src="/SOF3011.AssignmentFinal/public/english-icon.jpeg"></a></li>
					</ul>
				</div>
			</div>
		</nav>

		<!-- Header -->
		<jsp:include page="layout/Header.jsp"/>
		<!-- Page Content -->
		<h3 id="xinchao" class="text-center text-danger">${alert}</h3>
		<jsp:include page="${page}">
			<jsp:param name="listF" value="${listF}"/>
			<jsp:param name="titleList" value="${titleList}"/>

			<jsp:param name="videoEdition" value="${videoEdition}"/>
			<jsp:param name="tabVideo1" value="${tabVideo1}"/>
			<jsp:param name="tabVideo2" value="${tabVideo2}"/>
			<jsp:param name="listV" value="${listV}"/>
			<jsp:param name="video" value="${video}"/>
			<jsp:param name="sumVideos" value="${sumVideos}"/>
			
			<jsp:param name="img" value="${img}"/>
			
			<jsp:param name="userEdition" value="${userEdition}"/>
			<jsp:param name="tabVideo1" value="${tabUser1}"/>
			<jsp:param name="tabVideo2" value="${tabUser2}"/>
			<jsp:param name="user" value="${user}"/>
			<jsp:param name="listU" value="${listU}"/>
			<jsp:param name="sumUsers" value="${sumUsers}"/>
			
			<jsp:param name="listR" value="${listR}"/>
			<jsp:param name="listUserShared" value="${listUserShared}"/>
			<jsp:param name="listUserFavorited" value="${listUserShared}"/>
		</jsp:include> 
		<!-- Footer -->
		<jsp:include page="layout/Footer.jsp"/>
	</div>

	
</body>
</html>