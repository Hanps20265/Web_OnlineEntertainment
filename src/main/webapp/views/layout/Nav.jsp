<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:setLocale value="${sessionScope.lang}" scope="request"/>
	<fmt:setBundle  basename="global" scope="request"/>
		<!-- Navigation -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-success static-top p-2">
				<a class="navbar-brand" href="/SOF3011.AssignmentFinal/home">
					<fmt:message key="menu.index"/>
				</a>
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto">
						<li class="nav-item">
							<a class="nav-link active" aria-current="page" href="/SOF3011.AssignmentFinal/my-favorite">
								<fmt:message key="menu.favorite"/></a></li>
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#"  role="button" data-bs-toggle="dropdown" aria-expanded="false">
								<fmt:message key="menu.account"/></a>
							<ul class="dropdown-menu dropdown-menu-end" >
								<c:if test="${empty authUser}">
									<li>
										<a class="dropdown-item" id="login" href="/SOF3011.AssignmentFinal/sign-in">
											<fmt:message key="menu.login"/></a></li>
									<li>
										<a class="dropdown-item" id="signup" href="/SOF3011.AssignmentFinal/sign-up">
											<fmt:message key="menu.registration"/></a></li>
									<li>
										<a class="dropdown-item" id="forgot" href="/SOF3011.AssignmentFinal/forgot-password">
											<fmt:message key="menu.forget-password"/></a></li>
								</c:if>
								<c:if test="${!empty authUser}">
									<li>
										<a class="dropdown-item" href="/SOF3011.AssignmentFinal/sign-out">
											<fmt:message key="menu.log-off"/>
										</a>
									</li>
									<li>
										<a class="dropdown-item" href="/SOF3011.AssignmentFinal/change-password">
											<fmt:message key="menu.change-password"/>
										</a>
									</li>
									<li>
										<a class="dropdown-item" href="/SOF3011.AssignmentFinal/edit-profile">
											<fmt:message key="menu.edit-profile"/>
										</a>
									</li>
									<c:if test="${authUser.admin}">
										<li>
											<a class="dropdown-item" href="/SOF3011.AssignmentFinal/admin/userId=${authUser.userId}">
												<fmt:message key="menu.administration"/></a></li>
									</c:if>
								</c:if>
							</ul>
						</li>
					</ul>
					<!-- Choose Language -->
					<ul class="navbar-nav ms-auto text-info">
						<li class="nav-item">
							<a class="nav-link active" aria-current="page fv" href="?lang=vi">
								<img class="h-10" src="/SOF3011.AssignmentFinal/public/vietnam-icon.jpeg">
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link active" aria-current="page fv" href="?lang=en">
								<img class="h-10" src="/SOF3011.AssignmentFinal/public/english-icon.jpeg">
							</a>
						</li>
					</ul>
				</div>
		</nav>
</body>
</html>