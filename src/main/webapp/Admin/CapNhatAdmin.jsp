<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Cập nhật admin</title>

<!-- Custom fonts for this template-->
<jsp:include page="../head.jsp" />
</head>

<body id="page-top">
<%
	    String maND = (String) session.getAttribute("maND");
	    if (maND == null) {
	    	request.setAttribute("errMsg", "Phải đăng nhập trước khi sử dụng");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("../DangNhap.jsp");
	        dispatcher.forward(request, response);
	    }
	%>
	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<jsp:include page="./sidebar_admin.jsp" />
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<jsp:include page="./topbar_admin.jsp" />
				<!-- End of Topbar -->

				<!-- Your Slide bar and main content goes here -->
				<div class="container">
				<form action="updateadmin" method="post">
					<div class="row">
						<!-- Bảng Thông tin cá nhân -->
						<div class="col-lg-6">
							<table class="table">
								<thead>
									<tr>
										<th colspan="2" class="h3">Thông tin cá nhân</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><label for="mssv" class="h4">ID:</label></td>
										<td><input type="text" id="mssv" name="id" class="form-control" value="${quanly.ID_QuanLy}" readonly></td>
									</tr>
									<tr>
										<td><label for="name" class="h4">Họ tên:</label></td>
										<td><input type="text" id="name" name="name" class="form-control" value="${quanly.getHoTen()}"></td>
									</tr>
									<tr>
										<td><label for="dob" class="h4">Ngày sinh:</label></td>
										<td><input type="date" id="dob" name="date" class="form-control" value="${quanly.getNgaySinh()}"></td>
									</tr>
									<tr>
										<td><label class="h4">Giới tính:</label></td>
										<td>
											<input type="text" id="dob" name="gender" class="form-control"
											value="${quanly.getGioiTinh()}">

										</td>
									</tr>
									<tr>
										<td><label for="cccd" class="h4">CCCD:</label></td>
										<td><input type="text" id="cccd" name="cccd" class="form-control" value="${quanly.getCCCD()}"></td>
									</tr>
									<tr>
										<td><label for="faculty" class="h4">SDT:</label></td>
										<td><input type="text" id="faculty" name="sdt" class="form-control" value="${quanly.getSDT()}"></td>
									</tr>
									<tr>
										<td><label for="course" class="h4">Email:</label></td>
										<td><input type="text" id="course" name="email" class="form-control" value="${quanly.getEmail()}"></td>
									</tr>
								</tbody>
							</table>
							<!-- Nút Đổi mật khẩu và Cập nhật thông tin -->
							<div class="text-center mt-3">
								<button class="btn btn-primary mr-3">Cập nhật Admin</button>
							</div>
							<div style="margin-top: 40px;"></div>
						</div>

						</form>

						<!-- Hình ảnh -->
						<input type="hidden" name="encodedImage" id="encodedImage" value="${encodedImage}">
						<div class="col-lg-2 d-flex flex-column justify-content-center">
				            <div class="mb-3 text-center" style="height: 200px;">
					            <img id="image" src="data:image/jpeg;base64,${encodedImage}"
	                 alt="Hình ảnh" class="img-fluid mx-auto d-block mw-100 mh-100">
                 			</div>
				            <div class="text-center"><input type="file" id="selectImage" accept="image/*"></div>
				        </div>
					</div>
				</div>


				<!-- End of Main Content -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<jsp:include page="./footer_admin.jsp" />
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>



	<!-- Bootstrap core JavaScript-->
	<jsp:include page="../Scripts.jsp" />
	<script>    
		document.getElementById('selectImage').addEventListener('change', function(event) {
	        var files = event.target.files;
	        if (files && files.length > 0) {
	            var reader = new FileReader();
	            reader.onload = function() {
	                var dataURL = reader.result;
	                if (dataURL != null) {
	                    document.getElementById('image').src = dataURL;
	                    document.getElementById('encodedImage').value = dataURL;
	                }
	            };
	            reader.readAsDataURL(files[0]);
	        } else {
	            console.error("No files selected or FileReader not supported.");
	        }
	    });
	</script>
</body>

</html>