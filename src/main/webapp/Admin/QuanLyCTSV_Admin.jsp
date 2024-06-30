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

<title>Quản lý CTSV</title>

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
					<h1 class="h3 mb-2 text-gray-800">Quản lý CTSV</h1>
					<!-- DataTales Example -->
					<div>
						<div class="card shadow mb-4">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">Thông tin
									CTSV</h6>
							</div>
							<div class="card-body">
								<div class="row">
									<div class="col-xl-5">
										<a href="insertctsv" class="btn btn-primary btn-icon-split">
											<span class="text">Thêm CTSV</span>
										</a>
									</div>

								</div>
								<div style="margin-top: 20px;"></div>
								<div class="table-responsive">
									<table class="table table-bordered" id=" myTable" width="100%"
										cellspacing="0"">
										<thead>
											<tr>
												<th>ID_CTSV</th>
												<th>Họ tên</th>
												<th>CCCD</th>
												<th>Giới tính</th>
												<th>Ngày sinh</th>
												<th>SDT</th>
												<th>Email</th>
												<th>Actions</th>
											</tr>
										</thead>
										<tbody>
											<!--   for (Todo todo: todos) {  -->
											<c:forEach var="ctsv" items="${ctsvList}">

												<tr>
													<td><c:out value="${ctsv.ID_CTSV}" /></td>
													<td><c:out value="${ctsv.getHoTen()}" /></td>
													<td><c:out value="${ctsv.getCCCD()}" /></td>
													<td><c:out value="${ctsv.getGioiTinh()}" /></td>
													<td><c:out value="${ctsv.getNgaySinh()}" /></td>
													<td><c:out value="${ctsv.getSDT()}" /></td>
													<td><c:out value="${ctsv.getEmail()}" /></td>
													<td><a
														href="updatectsv?id=<c:out value='${ctsv.ID_CTSV}' />">Edit</a>
														&nbsp;&nbsp;&nbsp;&nbsp; <a
														href="deletectsv?id=<c:out value='${ctsv.ID_CTSV}' />">Delete</a></td>
												</tr>
											</c:forEach>
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

	<!-- Logout Modal-->
	<!-- Bootstrap core JavaScript-->
	<jsp:include page="../Scripts.jsp" />

</body>

</html>