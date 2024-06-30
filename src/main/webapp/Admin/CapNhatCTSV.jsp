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

<title>Cập nhật CTSV</title>

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
				<form action="updatectsv" method="post">
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
										<td><input type="text" id="mssv" name="id" class="form-control" value="${ctsv.ID_CTSV}" readonly></td>
									</tr>
									<tr>
										<td><label for="name" class="h4">Họ tên:</label></td>
										<td><input type="text" id="name" name="name" class="form-control" value="${ctsv.getHoTen()}"></td>
									</tr>
									<tr>
										<td><label for="cccd" class="h4">CCCD:</label></td>
										<td><input type="text" id="cccd" name="cccd" class="form-control" value="${ctsv.getCCCD()}"></td>
									</tr>
									<tr>
										<td><label class="h4">Giới tính:</label></td>
										<td>
											<input type="text" id="dob" name="gender" class="form-control"
											value="${ctsv.getGioiTinh()}">

										</td>
									</tr>
									<tr>
										<td><label for="dob" class="h4">Ngày sinh:</label></td>
										<td><input type="date" id="dob" name="date" class="form-control" value="${ctsv.getNgaySinh()}"></td>
									</tr>
									
									
									<tr>
										<td><label for="faculty" class="h4">SDT:</label></td>
										<td><input type="text" id="faculty" name="sdt" class="form-control" value="${ctsv.getSDT()}"></td>
									</tr>
									<tr>
										<td><label for="course" class="h4">Email:</label></td>
										<td><input type="text" id="course" name="email" class="form-control" value="${ctsv.getEmail()}"></td>
									</tr>
								</tbody>
							</table>
							<!-- Nút Đổi mật khẩu và Cập nhật thông tin -->
							<div class="text-center mt-3">
								<button class="btn btn-primary mr-3">Cập nhật CTSV</button>
							</div>
							<div style="margin-top: 40px;"></div>
						</div>

						</form>

						<!-- Hình ảnh -->
						<div class="col-lg-2 d-flex justify-content-center" style="height: 200px;">
							<img id="image" src="data:image/jpeg;base64,${encodedImage}"
		                 alt="Hình ảnh" class="img-fluid mx-auto d-block mw-100 mh-100">
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

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>


	<!-- Bootstrap core JavaScript-->
	<jsp:include page="../Scripts.jsp" />

</body>

</html>