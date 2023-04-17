<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
<!-- <link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"> -->
	
</head>
<body>
	<div class="row m-auto p-2 mt-0">

		<!-- Video  -->
		<div class="col-xl-7 col-md-6 mb-4">
		<form method="post">
			<div class="card shadow border border-warning p-0 m-0">
				<a class="d-block mb-4 h-100" href="/SOF3011.AssignmentFinal/video/detail?videoId=${video.videoId}">
					<img src="/SOF3011.AssignmentFinal/public/${video.poster}" alt="${video.poster}"
						class="card-img-top mx-auto d-block img-thumbnail img-fluid border border-info w-75 high my-3" />
				</a>
				<h5 class="card-title mb-0 fv border border-warning p-2 m-0 bg-success-subtle">${video.title}</h5>
				<div class="card-body border border-warning m-0">
					<div class="card-text text-black-50 fw-bold m-0 p-0">${video.descriptions}</div>
				</div>
				<div
					class="card-footer d-flex justify-content-end border border-warning">
					<!-- varLike -->
					<c:set var="varLike" scope="session" value="Like"/>
					<c:forEach var="videof" items="${listF}">
						<c:if test="${video.videoId == videof.videoId}" var="booleanValue">
							<c:set var="varLike" scope="session" value="Unlike"/>
						</c:if>
					</c:forEach>
					
					<button name="varLike" value="${varLike}" type="submit" class="btn btn-success me-2"
						formaction="/SOF3011.AssignmentFinal/detail/like?videoId=${video.videoId}">
						${varLike}
					</button>
					<button name="varShare" type="submit" class="btn btn-warning"
						formaction="/SOF3011.AssignmentFinal/detail/share?videoId=${video.videoId}">
						Share
					</button>
				</div>
			</div>
			</form>
		</div>

		<!-- List  -->
		<div class="col-xl-5 col-md-6 mb-4 border border-warning px-4">
			<!-- Page Heading -->
			<h1 class="my-2 "> List Video </h1>
			<form>
			
			<c:forEach var="video" items="${listV}">
				<!-- Video -->
				<div class="row shadow border border-warning">
					<div class="col-md-5 p-2">
						<a class="d-block mb-4 h-100" href="/SOF3011.AssignmentFinal/video/detail?videoId=${video.videoId}">
							<img src="/SOF3011.AssignmentFinal/public/${video.poster}" 
								alt="${video.poster}"
								class="card-img-top mx-auto d-block img-thumbnail img-fluid border border-info w-75 high my-3" >
						</a>
					</div>
					<div class="col-md-7 my-3">
						<h3>${video.title}</h3>
						<p>${video.descriptions}</p>
						<a class="btn btn-primary ms-0" href="/SOF3011.AssignmentFinal/video/detail?videoId=${video.videoId}">View video</a>
					</div>
				</div>
			</c:forEach>
			<hr>
			<hr>
			<!-- Pagination -->
					<!-- /.row -->
			<div class="d-flex justify-content-center me-3 mt-2 mb-3">
				<button formaction="/SOF3011.AssignmentFinal/detail/control/first"
					type="submit" class="col-2 border-danger me-3 btn btn-outline-danger">
					<i class="bi bi-skip-backward-fill"></i> 
				</button>
				<button formaction="/SOF3011.AssignmentFinal/detail/control/back"
					type="submit" class="col-2 border-info me-3 btn btn-outline-info">
					<i class="bi bi-skip-backward"></i> 
				</button>
				<button formaction="/SOF3011.AssignmentFinal/detail/control/next"
					type="submit" class="col-2 border-info me-3 btn btn-outline-info">
					<i class="bi bi-skip-forward"></i> 
				</button>
				<button formaction="/SOF3011.AssignmentFinal/detail/control/last"
					type="submit" class="col-2 border-danger btn btn-outline-danger">
					<i class="bi bi-skip-forward-fill"></i>
				</button>
			</div>

		</form>

		</div>
		<!-- /.container -->

	</div>
</body>
</html>