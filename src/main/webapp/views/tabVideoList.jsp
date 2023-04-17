<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form >
	<table class="table table-bordered m-0 border-warning fs-6">
		<thead>
			<tr class="text-center">
				<th scope="col">Youtube ID</th>
				<th scope="col">Video Title</th>
				<th scope="col">View Count</th>
				<th scope="col">Status</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${!empty listV}">
				<c:forEach var="v" items="${listV}">
					<tr class="fs-10">
						<td>${v.videoId}</td>
						<td>${v.title}</td>
						<td>${v.views}</td>
						<td>${v.descriptions}</td>
						<td><a id="edit" href="/SOF3011.AssignmentFinal/Video/edit?videoId=${v.videoId}">edit</a></td>
					</tr>
				</c:forEach>
			</c:if>

		</tbody>
	</table>

	<!-- Footer -->
	<div
		class="border border-warning bg-body-secondary d-flex justify-content-around">
		<div class="me-auto my-2 mx-4 text-center p-2">${sumVideos} Videos</div>
		
		<div class="d-flex justify-content-center me-3 mt-2 mb-3">
			<button formaction="/SOF3011.AssignmentFinal/Video/control/first"
				type="submit" class="col-2 border-danger me-3 btn btn-outline-danger">
				<i class="bi bi-skip-backward-fill"></i> 
			</button>
			<button formaction="/SOF3011.AssignmentFinal/Video/control/prev"
				type="submit" class="col-2 border-info me-3 btn btn-outline-info">
				<i class="bi bi-skip-backward"></i> 
			</button>
			<button formaction="/SOF3011.AssignmentFinal/Video/control/next"
				type="submit" class="col-2 border-info me-3 btn btn-outline-info">
				<i class="bi bi-skip-forward"></i> 
			</button>
			<button formaction="/SOF3011.AssignmentFinal/Video/control/last"
				type="submit" class="col-2 border-danger btn btn-outline-danger">
				<i class="bi bi-skip-forward-fill"></i>
			</button>
		</div>
	</div>
</form>
</body>
</html>