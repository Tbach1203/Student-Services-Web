<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Chính sách của chúng tôi</title>

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
					<div style="display: flex; justify-content: center;">
						<h1 class="h3 mb-4 text-gray-800">Chính sách của chúng tôi</h1>
					</div>
					<hr class="sidebar-divider">
					<div>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
							sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua. Ut enim ad minim veniam, quis nostrud exercitation
							ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis
							aute irure dolor in reprehenderit in voluptate velit esse cillum
							dolore eu fugiat nulla pariatur. Excepteur sint occaecat
							cupidatat non proident, sunt in culpa qui officia deserunt mollit
							anim id est laborum.</p>
						<p>Faucibus a pellentesque sit amet porttitor eget dolor
							morbi. Risus nullam eget felis eget nunc lobortis mattis aliquam
							faucibus. Interdum consectetur libero id faucibus nisl tincidunt.
							Dignissim suspendisse in est ante. Scelerisque purus semper eget
							duis at tellus at urna condimentum. Tortor at auctor urna nunc id
							cursus. Sociis natoque penatibus et magnis dis parturient</p>
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