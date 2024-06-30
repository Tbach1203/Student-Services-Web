<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="Models.SinhVien" %>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Cập nhật sinh viên</title>

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
					<form action="updatesv" method="post">
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
											<td><label for="mssv" class="h4">MSSV:</label></td>
											<td><input type="text" id="mssv" name="id"
												class="form-control" value="${sv.ID_SinhVien}" readonly></td>
										</tr>
										<tr>
											<td><label for="name" class="h4">Họ tên:</label></td>
											<td><input type="text" id="name" name="name"
												class="form-control" value="${sv.getHoTen()}"></td>
										</tr>
										<tr>
											<td><label for="dob" class="h4">Ngày sinh:</label></td>
											<td><input type="date" id="dob" name="date"
												class="form-control" value="${sv.getNgaySinh()}"></td>
										</tr>
										<tr>
											<td><label class="h4">Giới tính:</label></td>
											<td>
												<div class="form-check form-check-inline">
													<input class="form-check-input" type="radio" name="gender"
														id="male" value="1" checked> <label
														class="form-check-label h4" for="male"> Nam </label>
												</div>
												<div class="form-check form-check-inline">
													<input class="form-check-input" type="radio" name="gender"
														id="female" value="0"checked}> <label
														class="form-check-label h4" for="female"> Nữ </label>
												</div>
											</td>
										</tr>
										<tr>
											<td><label for="cccd" class="h4">CCCD:</label></td>
											<td><input type="text" id="cccd" name="cccd"
												class="form-control" value="${sv.getCCCD()}"></td>
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
										<tr>
											<td><label for="course" class="h4">Khóa học:</label></td>
											<td><input type="text" id="course" name="khoaHoc"
												class="form-control" value="${sv.getNamHoc()}"></td>
										</tr>
									</tbody>
								</table>
								<!-- Nút Đổi mật khẩu và Cập nhật thông tin -->
								<div class="text-center mt-3">
									<button class="btn btn-primary mr-3">Cập nhật sinh viên</button>
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



	<!-- Bootstrap core JavaScript-->
	<jsp:include page="../Scripts.jsp" />

</body>

</html>