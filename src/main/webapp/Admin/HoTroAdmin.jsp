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

<title>Hỗ trợ</title>

<!-- Custom fonts for this template-->
<jsp:include page="../head.jsp" />
</head>

<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<jsp:include page="./sidebar_admin.jsp" />

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
					<h1 class="h3 mb-4 text-gray-800">Hỗ trợ</h1>
					<div>
						<label class="h5">Bạn gặp các vấn đề khi sử dụng ứng dụng?</label>
					</div>
					<div>
						<label> <i class="fa fa-arrow-right"></i> <label
							class="h6">Liên hệ chúng tôi theo SDT: 19093123</label>
						</label>
					</div>
					<div style="margin-top: 20px;"></div>
					<div>
						<label> <label class="h5">Bạn muốn thay đổi mật
								khẩu?</label>
						</label>
					</div>
					<div>
						<label> <i class="fa fa-arrow-right"></i> <label>
								Click vào: <a target="_blank" href="<%=request.getContextPath()%>/Admin/DoiMK_Admin.jsp">Đổi mật khẩu</a>
						</label>
						</label>
					</div>
					<div style="margin-top: 20px;"></div>
					<div>
						<div>
							<div class="my-2"></div>
							<a href="chinhsach" class="btn btn-primary btn-icon-split">
								<span class="text">Chính sách</span>
							</a>
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