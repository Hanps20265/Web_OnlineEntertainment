<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ListVideos</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<style>
	.fv {
		font-variant: small-caps;
	}
	
	.high {
	 	height: 200px;
	}
	.h-60{
		height: 60px;
	}
</style>
</head>
<body>
	<div class="m-auto mt-3 pt-2 pb-2 ps-2 pe-2">
		<!-- Header -->
		<header class="bg-success-subtle text-center py-2 mb-4">
			<div class="container">
				<h3 class="fw-light text-dark fv">${titleList}</h3>
			</div>
		</header>

		<!-- Page Content -->
		<form class="container" method="post">
			<div class="row">
				<c:forEach var="video" items="${listV}">
					<!-- Video -->
					<div class="col-xl-4 col-md-6 mb-4">
						<div class="card shadow border border-warning">
							<a class="d-block mb-4 high" href="/SOF3011.AssignmentFinal/video/detail?videoId=${video.videoId}">
								<img src="/SOF3011.AssignmentFinal/public/${video.poster}" alt="${video.poster}"
									class="card-img-top mx-auto d-block img-thumbnail img-fluid border border-info high w-75 my-3" >
							</a>
							<div class="card-body text-center border border-warning h-60">
								<h6 class="card-title mb-0 bg-success-subtle">${video.title}</h6>
							</div>
							<div class="card-footer d-flex justify-content-end border border-warning">
								<!-- varLike -->
								<c:set var="varLike" scope="session" value="Like"/>
								<c:forEach var="videof" items="${listF}">
									<c:if test="${video.videoId == videof.videoId}" var="booleanValue">
										<c:set var="varLike" scope="session" value="Unlike"/>
									</c:if>
								</c:forEach>
								
								<button name="varLike" value="${varLike}" type="submit" class="btn btn-success me-2"
									formaction="/SOF3011.AssignmentFinal/video/like?videoId=${video.videoId}">
									${varLike}
								</button>
								<button name="varShare" type="submit" class="btn btn-warning"
									formaction="/SOF3011.AssignmentFinal/video/share?videoId=${video.videoId}">
									Share
								</button>
							</div>
						</div>
					</div>
				</c:forEach>
		
			</div>
			<!-- /.row -->
			<div class="d-flex justify-content-center me-3 mt-2 mb-3">
				<button formaction="/SOF3011.AssignmentFinal/index/control/first"
					type="submit" class="col-2 border-danger me-3 btn btn-outline-danger">
					<i class="bi bi-skip-backward-fill"></i> 
				</button>
				<button formaction="/SOF3011.AssignmentFinal/index/control/back"
					type="submit" class="col-2 border-info me-3 btn btn-outline-info">
					<i class="bi bi-skip-backward"></i> 
				</button>
				<button formaction="/SOF3011.AssignmentFinal/index/control/next"
					type="submit" class="col-2 border-info me-3 btn btn-outline-info">
					<i class="bi bi-skip-forward"></i> 
				</button>
				<button formaction="/SOF3011.AssignmentFinal/index/control/last"
					type="submit" class="col-2 border-danger btn btn-outline-danger">
					<i class="bi bi-skip-forward-fill"></i>
				</button>
			</div>
		</form>
	</div>
</body>
</html>