<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Đổi mật khẩu</title>

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
				<div class="container h-100">
			        <div class="row h-100 justify-content-center align-items-center">
			            <table class="table">
						    <tbody>
						        <tr>
						            <td><label for="username" class="h4">Tài khoản:</label></td>
						            <td><input type="text" id="username" class="form-control"></td>
						        </tr>
						        <tr>
						            <td><label for="email" class="h4">Email:</label></td>
						            <td>
						                <div class="row">
						                    <div class="col"><input type="email" id="email" class="form-control"></div>
						                    <div class="col-auto"><button id="sendOTPBtn" class="btn btn-primary">Gửi mã</button></div>
						                </div>
						            </td>
						        </tr>
						        <tr>
						            <td><label for="otp" class="h4">OTP:</label></td>
						            <td>
						                <div class="row">
						                    <div class="col"><input type="text" id="otp" name="otp" class="form-control"></div>
						                    <div class="col-auto"><button class="btn btn-primary" id="confirmOTPBtn">Xác nhận mã</button></div>
						                </div>
						            </td>
						        </tr>
						        <tr id="new-password-row" style="display: none;">
						            <td><label for="new-password" class="h4">Mật khẩu mới:</label></td>
						            <td><input type="password" id="new-password" class="form-control"></td>
						        </tr>
						        <tr>
						            <td></td>
						            <td><button id="changePasswordBtn" class="btn btn-primary" style="display: none;">Đổi mật khẩu</button></td>
						        </tr>
						    </tbody>
						</table>

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
    <script>
    $(document).ready(function () {
    	var username = sessionStorage.getItem('username');
        var email = sessionStorage.getItem('email');

        $("#username").val(username);
        $("#email").val(email);
        $("#sendOTPBtn").click(function () {
            var username = $("#username").val();
            var email = $("#email").val();
			console.log("Đã click");
            if (username && email) {
                $.ajax({
                    type: "POST",
                    url: "<%= request.getContextPath() %>/GuiOTP",
                    data: { username: username, email: email },
                    success: function (response) {
                        console.log(response);
                        console.log(username);
                        sessionStorage.setItem('username', username);
                        sessionStorage.setItem('email', email);
                        window.location.href = '<%= request.getContextPath() %>/QuenMatKhau.jsp';
                    },
                    error: function (error) {
                        console.log(error);
                    }
                });
            } else {
                alert("Vui lòng nhập đầy đủ thông tin Tài khoản và Email.");
            }
        });
        $("#confirmOTPBtn").click(function () {
        	console.log("Đã click xác nhận");
            var enteredOTP = $("#otp").val();
            var trueOTP = "${sessionScope.TRUEOTP}";

        	console.log(trueOTP);
            if (enteredOTP === trueOTP) {
                <% session.removeAttribute("TRUEOTP");%>
                $("#new-password-row, #changePasswordBtn").show();
                $("#sendOTPBtn").prop("disabled", true);
            	$("#confirmOTPBtn").prop("disabled", true);
            } else {            	
                alert("OTP is incorrect. Please try again.");
            }
        });
        $("#changePasswordBtn").click(function () {
            var username = $("#username").val();
            var newPassword = $("#new-password").val();

            $.ajax({
                type: "POST",
                url: "<%= request.getContextPath() %>/DoiMatKhau",
                data: {
                    username: username,
                    newPassword: newPassword
                },
                success: function (response) {
                    alert("Mật khẩu đã được thay đổi thành công!");
                	window.location.href = '<%= request.getContextPath() %>/DangNhap.jsp';
                },
                error: function (error) {
                    console.log("Error changing password: ", error);
                }
            });
        });
    });
</script>
<% if (session.getAttribute("SendMessage") != null) { %>
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
                        ${SendMessage}
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
                <% session.removeAttribute("SendMessage");%>
            });
        </script>
    <% } %>
</body>
</html>