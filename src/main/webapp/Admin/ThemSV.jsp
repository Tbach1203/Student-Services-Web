<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Thêm sinh viên</title>

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
					<form action="insertsv" method="post">
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
											<td><label for="name" class="h4">Họ tên:</label></td>
											<td><input type="text" id="name" name="name"
												class="form-control"></td>
										</tr>
										<tr>
											<td><label for="cccd" class="h4">CCCD:</label></td>
											<td><input type="text" id="cccd" name="cccd"
												class="form-control"></td>
										</tr>
										<tr>
											<td><label class="h4">Giới tính:</label></td>
											<td>
												<div class="form-check form-check-inline">
													<input class="form-check-input" type="radio" name="gender"
														id="male" value="1"> <label
														class="form-check-label h4" for="male"> Nam </label>
												</div>
												<div class="form-check form-check-inline">
													<input class="form-check-input" type="radio" name="gender"
														id="female" value="0"> <label
														class="form-check-label h4" for="female"> Nữ </label>
												</div>
											</td>
										</tr>
										<tr>
											<td><label for="dob" class="h4">Ngày sinh:</label></td>
											<td><input type="date" id="dob" name="date"
												class="form-control"></td>
										</tr>
										<tr>
											<td><label for="faculty" class="h4">SDT:</label></td>
											<td><input type="text" id="faculty" name="sdt"
												class="form-control"></td>
										</tr>
										<tr>
											<td><label for="course" class="h4">Email:</label></td>
											<td><input type="text" id="course" name="email"
												class="form-control"></td>
										</tr>
										<tr>
											<td><label for="course" class="h4">Khóa học:</label></td>
											<td><input type="text" id="course" name="khoaHoc"
												class="form-control"></td>
										</tr>
										<tr>
											<td><label for="course" class="h4">Khoa:</label></td>
											<td><select class="form-control" id="khoa" name="khoa"
												required>
													<c:forEach var="khoa" items="${khoaList}">
														<option value="${khoa.ID_Khoa}"><c:out
																value="${khoa.getTenKhoa()}" /></option>
													</c:forEach>
											</select></td>
										</tr>

										<!-- <tr>
											<td><label for="course" class="h4">ID tài khoản:</label></td>
											<td><input type="text" id="course" name="idTK"
												class="form-control"></td>
										</tr> -->


									</tbody>
								</table>
								<div style="margin-top: 40px;"></div>
							</div>
							<div class="col-lg-4">
								<table class="table">
									<thead>
										<tr>
											<th colspan="2" class="h3">Cấp tài khoản:</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><label for="contact-name" class="h4">Tài
													khoản:</label></td>
											<td><input type="text" id="contact-name"
												class="form-control" name="taikhoan"></td>
										</tr>
										<tr>
											<td><label for="contact-name" class="h4">Mật
													khẩu:</label></td>
											<td><input type="text" id="contact-name"
												class="form-control" name="matkhau"></td>
										</tr>

									</tbody>
								</table>
								<div class="text-center mt-3">
									<button class="btn btn-primary mr-3">Thêm sinh viên</button>
								</div>
							</div>

							<!-- Hình ảnh -->
							<div class="col-lg-2 d-flex justify-content-center">
								<img src="đường dẫn đến hình ảnh của bạn" alt="Hình ảnh">
							</div>
						</div>
					</form>
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

</body>

</html>