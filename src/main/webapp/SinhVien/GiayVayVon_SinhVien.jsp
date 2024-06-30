<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Giấy vay vốn</title>

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
        <jsp:include page="./Sidebar_SinhVien.jsp" />
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
                    <jsp:include page="./Topbar_SinhVien.jsp" />

                </nav>  

                <!-- Your Slide bar and main content goes here -->
				<div class="container d-flex justify-content-center align-items-center">
			        <div class="col">
				        <h2 class="mt-4">Đăng ký vay vốn</h2>
				        <form action="<%=request.getContextPath()%>/DangKyGiayVay" method="post" accept-charset="UTF-8">
				            <div class="form-group">
				                <label for="loanAmount">Khoản vay:</label>
				                <input type="number" class="form-control" id="loanAmount" name="loanAmount" placeholder="Nhập số tiền bạn muốn vay" min="0">
				            </div>
				            <div class="form-group">
				                <label for="loanPurpose">Mục đích vay:</label>
				                <textarea class="form-control" id="loanPurpose" name="loanPurpose" rows="3" placeholder="Nhập mục đích vay của bạn"></textarea>
				            </div>
				            <button type="submit" class="btn btn-primary">Đăng ký</button>
				        </form>
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

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>
    <!-- Bootstrap core JavaScript-->
    <jsp:include page="../Scripts.jsp" />
    <% if (request.getAttribute("completeMsg") != null) { %>
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">Thông báo</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        ${completeMsg}
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Thoát</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- JavaScript to trigger the modal -->
        <script>
            $(document).ready(function() {
            	console.log('Document ready function');
                $('#myModal').modal('show');
            });
        </script>
    <% } %>
</body>
</html>