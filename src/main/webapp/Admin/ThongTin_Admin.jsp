<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="Models.QuanLy"%>
<%@ page import="DAO.QuanLyDAO"%>
<%@ page import="DAO.TaiKhoanDao"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Thông tin cá nhân</title>

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
					<h1 class="h3 mb-4 text-gray-800">Profile</h1>

					<div class="row">

						<!-- Area Chart -->
						<div class="col-xl-7 col-lg-7">
							<div class="card shadow mb-4">
								<!-- Card Header - Dropdown -->
								<div
									class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
									<h6 class="m-0 font-weight-bold text-primary">Thông tin cá
										nhân</h6>
								</div>
								<!-- Card Body -->
								<div class="card-body">
									<div class=" row">
										<!-- Hiển thị thông tin từ đối tượng quanly -->
										<div class="col-xl-5 col-lg-4 col-md-6 col-sm-6"
											style="text-align: left; width: 50%;">Mã số admin:</div>
										<div class="col-xl-7 col-lg-8 col-md-6 col-sm-6"
											style="text-align: left; width: 50%;" name="id">${quanly.ID_QuanLy}
										</div>
										<div style="margin-top: 40px;"></div>
										<div class="col-xl-5 col-lg-4 col-md-6 col-sm-6"
											style="text-align: left; width: 50%;">Họ tên:</div>
										<div class="col-xl-7 col-lg-8 col-md-6 col-sm-6"
											style="text-align: left; width: 50%;">${quanly.getHoTen()}</div>
										<div style="margin-top: 40px;"></div>
										<div class="col-xl-5 col-lg-4 col-md-6 col-sm-6"
											style="text-align: left; width: 50%;">Ngày sinh:</div>
										<div class="col-xl-7 col-lg-8 col-md-6 col-sm-6"
											style="text-align: left; width: 50%;">${quanly.getNgaySinh()}</div>
										<div style="margin-top: 40px;"></div>
										<div class="col-xl-5 col-lg-4 col-md-6 col-sm-6"
											style="text-align: left; width: 50%;">Giới tính:</div>
										<div class="col-xl-7 col-lg-8 col-md-6 col-sm-6"
											style="text-align: left; width: 50%;">${quanly.getGioiTinh()}</div>
										<div style="margin-top: 40px;"></div>
										<div class="col-xl-5 col-lg-4 col-md-6 col-sm-6"
											style="text-align: left; width: 50%;">CCCD:</div>
										<div class="col-xl-7 col-lg-8 col-md-6 col-sm-6"
											style="text-align: left; width: 50%;">${quanly.getCCCD()}</div>
										<div style="margin-top: 40px;"></div>
										<div class="col-xl-5 col-lg-4 col-md-6 col-sm-6"
											style="text-align: left; width: 50%;">SDT:</div>
										<div class="col-xl-7 col-lg-8 col-md-6 col-sm-6"
											style="text-align: left; width: 50%;">${quanly.getSDT()}</div>
										<div style="margin-top: 40px;"></div>
										<div class="col-xl-5 col-lg-4 col-md-6 col-sm-6"
											style="text-align: left; width: 50%;">Email:</div>
										<div class="col-xl-7 col-lg-8 col-md-6 col-sm-6"
											style="text-align: left; width: 50%;">${quanly.getEmail()}</div>
										<!-- và các thuộc tính khác -->
									</div>

								</div>
							</div>
						</div>
						<div class="col-xl-5 col-lg-5">
							<div class="card shadow mb-4">
								<!-- Card Header - Dropdown -->
								<div
									class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
									<h6 class="m-0 font-weight-bold text-primary">Admin</h6>

								</div>
								<!-- Card Body -->
								<div class="card-body">
									<div class="mb-3 text-center" style=" height: 157px;">
							            <img id="image" src="data:image/jpeg;base64,${encodedImage}"
			                 alt="Hình ảnh" class="img-fluid mx-auto d-block mw-100 mh-100">
		                 			</div>
									<input type="hidden" name="encodedImage" id="encodedImage" value="${encodedImage}">
									<div style="margin-top: 15px;"></div>
									<div style="display: flex; justify-content: center;">
										<div class="my-2"></div>
										<a href="updateadmin?id=${quanly.ID_QuanLy}"
											class="btn btn-primary btn-icon-split"> <span
											class="text">Cập nhật thông tin</span>
										</a>
									</div>
									<div style="margin-top: 15px;"></div>
									<div style="display: flex; justify-content: center;">
										<div class="my-2"></div>
										<a href="<%=request.getContextPath()%>/Admin/DoiMK_Admin.jsp" class="btn btn-primary btn-icon-split"> <span
											class="text">Đổi mật khẩu</span>
										</a>
									</div>

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

	<!-- Scroll to Top Button làm tiếp đi oke-->
	<jsp:include page="../Scripts.jsp" />

</body>

</html>