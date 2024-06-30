<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="vi">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Hỗ trợ CTSV</title>

<!-- Custom fonts for this template	-->
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
        	<jsp:include page="./Sidebar_CTSV.jsp" />
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Navigation -->
                    <jsp:include page="./Topbar_CTSV.jsp" />

                </nav>  

				<!-- Your Slide bar and main content goes here -->
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
						<label> <label class="h5">Bạn đã quên mật
								khẩu hoặc muốn đổi mật khẩu?</label>
						</label>
					</div>
					<div>
						<label> <i class="fa fa-arrow-right"></i> <label>
								Click vào: <a target="_blank" href="../QuenMatKhau.jsp">Đổi mật khẩu</a>
						</label>
						</label>
					</div>
					<div style="margin-top: 20px;"></div>
					<div>
						<div>
							<div class="my-2"></div>
							<a href="./ChinhSach_SinhVien.jsp" class="btn btn-primary btn-icon-split"> <span
								class="text">Chính sách</span>
							</a>
						</div>
					</div>
				</div>
				<!-- End of Main Content -->

				<!-- Footer -->
    				<jsp:include page="../footer.jsp" />
				<!-- End of Footer -->

			</div>
			<!-- End of Content Wrapper -->

		</div>
		<!-- End of Page Wrapper -->
		
		<!-- Bootstrap core JavaScript-->
		<jsp:include page="../Scripts.jsp" />
</body>
</html>