<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hearder</title>
	<!-- JavaScript & CSS -->
	<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
	<style>
		.h-35{
			height:380px;
		}
	</style> -->
</head>
<body>
		
      <div class="p-0 m-0 m-auto w-100">
         <div id="carouselExample" class="carousel slide m-0 p-0 border border-warning" data-bs-ride="carousel">
             <div class="carousel-inner m-auto m-0 p-0">
                 <div class="carousel-item active ">
					<img src="/SOF3011.AssignmentFinal/public/banner1.jpg" 
					class="d-block w-100 h-35">
                 </div>
                 <div class="carousel-item ">
                     <img src="/SOF3011.AssignmentFinal/public/banner2.jpg"
                     class="d-block w-100 h-35">
                 </div>
                 <div class="carousel-item ">
                     <img src="/SOF3011.AssignmentFinal/public/banner3.jpg"
                     class="d-block w-100 h-35">
                 </div>
             </div>
             <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample"
                 data-bs-slide="prev">
                 <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                 <span class="visually-hidden">Previous</span>
             </button>
             <button class="carousel-control-next" type="button" data-bs-target="#carouselExample"
                 data-bs-slide="next">
                 <span class="carousel-control-next-icon" aria-hidden="true"></span>
                 <span class="visually-hidden">Next</span>
             </button>
         </div>
         <div name="visitors" class="position-absolute top-0 end-0 bg-warning-subtle shadow-lg text-danger fs-5" id="visitors">
          	${visitors}
          </div>
    </div>
        
</body>
</html>