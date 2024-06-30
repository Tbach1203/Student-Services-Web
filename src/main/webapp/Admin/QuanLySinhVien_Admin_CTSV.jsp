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

<title>Quản lý sinh viên</title>

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
				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">Quản lý sinh viên</h1>
					<!-- DataTales Example -->
					<div>
						<div class="card shadow mb-4">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">Thông tin
									sinh viên</h6>
							</div>
							<div class="card-body">
								<div>
									<a href="insertsv"
										class="btn btn-primary btn-icon-split"> <span class="text">Thêm
											sinh viên</span>
									</a>

								</div>
								<div style="margin-top: 20px;"></div>
								<div class="table-responsive">
									<table class="table table-bordered" id=" dataTable"
										width="100%" cellspacing="0"">
										<thead>
											<tr>
												<th>MSSV</th>
												<th>Họ tên</th>
												<th>Ngày sinh</th>
												<th>Giới tính</th>
												<th>CCCD</th>
												<th>Khoa</th>
												<th>Khóa học</th>
												<th>Actions</th>
											</tr>
										</thead>
										<tbody>
											<!--   for (Todo todo: todos) {  -->
											<c:forEach var="SV" items="${svList}">

												<tr>
													<td><c:out value="${SV.ID_SinhVien}" /></td>
													<td><c:out value="${SV.getHoTen()}" /></td>
													<td><c:out value="${SV.getNgaySinh()}" /></td>
													<td><c:if test="${SV.getGioiTinh()==1}">Nam</c:if> <c:if
															test="${SV.getGioiTinh()==0}">Nữ</c:if></td>
													<td><c:out value="${SV.getCCCD()}" /></td>
													<td><c:out value="${SV.getTenKhoa()}" /></td>
													<td><c:out value="${SV.getNamHoc()}" /></td>
													<td><a
														href="updatesv?id=<c:out value='${SV.ID_SinhVien}' />">Edit</a>
														&nbsp;&nbsp;&nbsp;&nbsp; <a
														href="deletesv?id=<c:out value='${SV.ID_SinhVien}' />">Delete</a></td>
												</tr>
											</c:forEach>

											<!-- } -->
										</tbody>

									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->

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