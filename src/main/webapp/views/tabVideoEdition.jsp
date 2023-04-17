<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>

<script type="text/javascript">
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#img')
                .attr('src', e.target.result)
                
        };

        reader.readAsDataURL(input.files[0]);
    }
}
</script>
</head>
<body>

	<form method="post" enctype="multipart/form-data"> 
		<div class="row">
			<div class="col-md-4 p-2 m-3 h-300">
				<div class="p-2 border border-warning h-300">
					<img  name="image" id="img" src="/SOF3011.AssignmentFinal/public/${video.poster}"
							class="card-img-top mx-auto d-block img-thumbnail img-fluid h-300 w-75 my-2"> 
					<h6 class="text-center"></h6>
				</div>
				<input type="file" name="poster" value="${video.poster}" onchange="readURL(this);">
			</div>

			<div class="col-md-7 my-2 p-2">
				<div class="mb-2 pe-2">
					<label for="videoId" class="form-label fv">Youtube ID?</label> 
					<input name="videoId" value="${video.videoId}"
						type="text" class="form-control" id="videoId">
				</div>
				<div class="mb-2">
					<label for="title" class="form-label fv">Video Title</label>
					<input name="title" value="${video.title}"
						type="text" class="form-control" id="title">
				</div>
				<div class="mb-2">
					<label for="view" class="form-label fv">View Count</label>
					<input name="view" value="${video.views}"
						type="number" class="form-control" id="view">
				</div>

				<div>
					<div class="form-check form-check-inline">
						<input name="active" 
						class="form-check-input" type="radio"
							id="check1" ${video.active==true?"checked":""}  value="true"> 
							<label class="form-check-label  fv" for="check1">Active</label>
					</div>
					<div class="form-check form-check-inline">
						<input name="active" 
						class="form-check-input" type="radio"
							id="check2" ${video.active==false?"checked":""}  value="false"> 
							<label class="form-check-label fv" for="check2">Inactive</label>
					</div>
				</div>
			</div>
		</div>
		<div class="form-floating p-2 my-1 mx-4 ms-auto">
		  <textarea name="descriptions" class="form-control" placeholder="Leave a comment here" 
		  			id="floatingTextarea">${video.descriptions}</textarea>
		  <label for="floatingTextarea">DESCRIPTION:</label>
		</div>
		
		
		<!-- Footer -->
		<div class="border border-warning bg-body-secondary d-flex justify-content-around">
			<div class="d-flex justify-content-end my-1 mx-4">
				<button type="submit" formaction="/SOF3011.AssignmentFinal/Video/create"
				id="Create" class="col-3 border-danger me-3 btn btn-outline-danger">Create
				</button>
				<button type="submit" formaction="/SOF3011.AssignmentFinal/Video/update"
				id="Update" class="col-3 border-info me-3 btn btn-outline-info">Update
				</button>
				<button type="submit" formaction="/SOF3011.AssignmentFinal/Video/delete"
				id="Delete" class="col-3 border-info me-3 btn btn-outline-info">Delete
				</button>
				<button type="submit" formaction="/SOF3011.AssignmentFinal/Video/reset"
				id="Reset" class="col-3 border-danger btn btn-outline-danger">Reset
				</button>
			</div>
		</div>
	</form>
</body>
</html>