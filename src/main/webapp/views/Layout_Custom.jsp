<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Layout</title>
	<!-- JavaScript & CSS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
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
		.dropdown:hover .dropdown-menu {
		    display: block;
		}
		
	}
	</style>
</head>
<body>
	<fmt:setLocale value="${sessionScope.lang}" scope="request"/>
	<fmt:setBundle  basename="global" scope="request"/>
	<!--  -->
	<div class="col-8 m-auto mt-2 border border-warning p-0">
	
		<!-- Navigation -->
		<jsp:include page="layout/Nav.jsp"/>
		<!-- Header -->
		<jsp:include page="layout/Header.jsp">
			<jsp:param name="visitors" value="${visitors}"/>
		</jsp:include> 
		<!-- Page Content -->
		<h2 id="xinchao" class="text-center text-danger">${alert}</h2>
		
		<jsp:include page="${page}">
			<jsp:param name="listV" value="${listV}"/>
			<jsp:param name="listF" value="${listF}"/>
			<jsp:param name="titleList" value="${titleList}"/>
			<jsp:param name="videoId" value="${videoId}"/>
			
		</jsp:include> 
		<!-- Footer -->
		<jsp:include page="layout/Footer.jsp"/>
	</div>

	
		
</body>
</html>