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
	<form method="post">
					<table class="table table-bordered m-0 border-warning fs-6">
						<thead>
							<tr class="text-center">
								<th scope="col">Username</th>
								<th scope="col">Password</th>
								<th scope="col">Fullname</th>
								<th scope="col">Email</th>
								<th scope="col">Role</th>
							</tr>
						</thead>
						<tbody>
						<c:if test="${!empty listU}">
							<c:forEach var="item" items="${listU}">
								<tr>
									<td>${item.userId}</td>
									<td>${item.password}</td>
									<td>${item.fullname}</td>
									<td>${item.email}</td>
									<td>${item.admin}</td>
									<td><a id="edit" href="/SOF3011.AssignmentFinal/User/edit?userId=${item.userId}">edit</a></td>
								</tr>
							</c:forEach>
						</c:if>
						</tbody>
					</table>

					<!-- Footer -->
					<div
						class="border border-warning bg-body-secondary d-flex justify-content-around">
						<div class="me-auto my-2 mx-1 text-center text-danger p-2">${sumUsers} Users</div>
						<div class="d-flex justify-content-end my-2 mx-4">
							<button type="submit" formaction="/SOF3011.AssignmentFinal/User/control/first"
							class="col-3 border-danger me-3 btn btn-outline-danger">
								<i class="bi bi-skip-backward-fill"></i>
							</button>
							<button type="submit" formaction="/SOF3011.AssignmentFinal/User/control/prev"
							class="col-3 border-info me-3 btn btn-outline-info">
								<i class="bi bi-skip-backward"></i>
							</button>
							<button type="submit" formaction="/SOF3011.AssignmentFinal/User/control/next"
							class="col-3 border-info me-3 btn btn-outline-info">
								<i class="bi bi-skip-forward"></i>
							</button>
							<button type="submit" formaction="/SOF3011.AssignmentFinal/User/control/last"
							class="col-3 border-danger btn btn-outline-danger">
								<i class="bi bi-skip-forward-fill"></i>
							</button>
						</div>
					</div>
				</form>
</body>
</html>