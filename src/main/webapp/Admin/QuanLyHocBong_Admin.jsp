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

<title>Quản lý học bổng</title>

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
					<h1 class="h3 mb-2 text-gray-800">Quản lý học bổng</h1>
					<!-- DataTales Example -->
					<div class="row">
						<div class="ccol-xl-6 col-lg-6 col-md-12 col-sm-12">
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">Thông tin
										học bổng</h6>
								</div>
								<div class="card-body">
									<div style="margin-top: 20px;"></div>
									<div class="table-responsive">
										<table class="table table-bordered" id=" dataTable"
											width="100%" cellspacing="0"">
											<thead>
												<tr>
													<th>Mã học bổng</th>
													<th>Tên học bổng</th>
													<th>Nội dung</th>
													<th>Điều kiện</th>
													<th>Số lượng</th>
													<th>Tiền thưởng</th>
													<th>Dịch vụ</th>
													<th>Actions</th>
												</tr>
											</thead>
											<tbody>
												<!--   for (Todo todo: todos) {  -->
												<c:forEach var="HB" items="${hocBongList}">

													<tr>
														<td><c:out value="${HB.ID_HocBong}" /></td>
														<td><c:out value="${HB.getTenHocBong()}" /></td>
														<td><c:out value="${HB.getNoiDung()}" /></td>
														<td><c:out value="${HB.getDieuKien()}" /></td>
														<td><c:out value="${HB.getSoLuong()}" /></td>
														<td><c:out value="${HB.getTienThuong()}" /></td>
														<td><c:out value="${HB.getID_DichVu()}" /></td>
														<td><a
															href="deletehocbong?id=<c:out value='${HB.ID_HocBong}' />">Delete</a></td>
													</tr>
												</c:forEach>

											</tbody>

										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="ccol-xl-6 col-lg-6 col-md-12 col-sm-12">
							<form action="<%=request.getContextPath()%>/quanlyhocbong" method="post">
								<table class="table">
									<tbody>
										<tr>
											<td><label class="h5">Tên học bổng:</label></td>
											<td><input type="text" id="tenHB" name="tenHB"
												class="form-control"></td>
										</tr>
										<tr>
											<td><label class="h5">Nội dung:</label></td>
											<td><input type="text" id="tenHB" name="noidung"
												class="form-control"></td>
										</tr>
										<tr>
											<td><label class="h5">Điều kiện:</label></td>
											<td><input type="text" id="DK" name="dieukien"
												class="form-control"></td>
										</tr>
										<tr>
											<td><label class="h5">Số lượng:</label></td>
											<td><input type="text" id="SLConLai" name="soluong"
												class="form-control"></td>
										</tr>
										<tr>
											<td><label class="h5">Tiền thưởng:</label></td>
											<td><input type="text" id="SLConLai" name="tienthuong"
												class="form-control"></td>
										</tr>

									</tbody>
								</table>
								<div class="text-center mt-3">
									<button type="submit" class="btn btn-primary mr-3">Thêm học bổng</button>
								</div>
							</form>
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