<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Models.SinhVien" %>
<%@ page import="DAO.TaiKhoanDao" %>
<%@ page import="java.util.Base64" %>

<!DOCTYPE html>
<html lang="vi">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Thông tin sinh viên</title>

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
				<div class="container">
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
						                <td><input type="text" id="mssv" class="form-control" value="${sinhvien.ID_SinhVien}" readonly></td>
						            </tr>
						            <tr>
						                <td><label for="name" class="h4">Họ tên:</label></td>
						                <td><input type="text" id="name" class="form-control" value="${sinhvien.getHoTen()}" readonly></td>
						            </tr>
						            <tr>
						            	<td><label for="dob" class="h4">Ngày sinh:</label></td>
								        <td><input type="date" id="dob" class="form-control" value="${sinhvien.getNgaySinh()}" readonly></td>
						            </tr>
						            <tr>
						                <td><label class="h4">Giới tính:</label></td>
						                <td>
						                    <div class="form-check form-check-inline">
						                        <input class="form-check-input" type="radio" name="gender" id="male" value="male" ${sinhvien.getGioiTinh() == 1 ? 'checked' : ''}>
						                        <label class="form-check-label h4" for="male">
						                            Nam
						                        </label>
						                    </div>
						                    <div class="form-check form-check-inline">
						                        <input class="form-check-input" type="radio" name="gender" id="female" value="female" ${sinhvien.getGioiTinh() == 0 ? 'checked' : ''}>
						                        <label class="form-check-label h4" for="female">
						                            Nữ
						                        </label>
						                    </div>
						                </td>
						            </tr>
						            <tr>
						                <td><label for="cccd" class="h4">CCCD:</label></td>
						                <td><input type="text" id="cccd" class="form-control" value="${sinhvien.getCCCD()}" readonly></td>
						            </tr>
						            <tr>
						                <td><label for="faculty" class="h4">Khoa:</label></td>
						                <td><input type="text" id="faculty" class="form-control" value="${tenkhoa}" readonly></td>
						            </tr>
						            <tr>
						                <td><label for="course" class="h4">Khóa học:</label></td>
						                <td><input type="text" id="course" class="form-control" value="${sinhvien.getNamHoc()}" readonly></td>
						            </tr>
						            <tr>
						                <td><label for="rl-score" class="h4">Điểm RL:</label></td>
						                <td><input type="text" id="rl-score" class="form-control" value="${sinhvien.getDiemRL()}" readonly></td>
						            </tr>
						            <tr>
						                <td><label for="ctxh-score" class="h4">Điểm CTXH:</label></td>
						                <td><input type="text" id="ctxh-score" class="form-control" value="${sinhvien.getDiemCTXH()}"readonly></td>
						            </tr>
						        </tbody>
						    </table>
						</div>

				
				        <!-- Bảng Thông tin liên hệ -->
				        <div class="col-lg-4">
						    <table class="table">
						        <thead>
						            <tr>
						                <th colspan="2" class="h3">Thông tin liên hệ</th>
						            </tr>
						        </thead>
						        <tbody>
						            <tr>
						                <td><label for="contact-name" class="h4">Họ tên:</label></td>
						                <td><input type="text" id="contact-name" class="form-control" value="${sinhvien.getHoTen()}" readonly></td>
						            </tr>
						            <tr>
						                <td><label for="phone" class="h4">SDT:</label></td>
						                <td><input type="tel" id="phone" class="form-control" value="${sinhvien.getSDT()}" readonly></td>
						            </tr>
						            <tr>
						                <td><label for="email" class="h4">Email:</label></td>
						                <td><input type="email" id="email" class="form-control" value="${sinhvien.getEmail()}" readonly></td>
						            </tr>
						            <tr>
						                <td><label for="address" class="h4">Địa chỉ:</label></td>
						                <td><input type="text" id="address" class="form-control" value="${sinhvien.getDiaChi()}" readonly></td>
						            </tr>
						        </tbody>
						    </table>
						    <!-- Nút Đổi mật khẩu và Cập nhật thông tin -->
						    <div class="text-center mt-3">
							    <c:if test="${not empty errMsg}">
							        <p class="text-danger">${errMsg}</p>
							    </c:if>
							</div>

						    <div class="text-center mt-3">
						    	<button class="btn btn-primary mr-3" onclick="window.location.href='QuenMatKhau_SinhVien.jsp'">Đổi mật khẩu</button>
						        <button id="update-button" class="btn btn-primary ml-3">Cập nhật thông tin</button>
						        <button id="confirm-button" class="btn btn-success ml-3" style="display: none;">Xác nhận</button>
								<button id="cancel-button" class="btn btn-danger ml-3" style="display: none;">Hủy</button>
						    </div>
						</div>
						<!-- Hình ảnh -->
						<div class="col-lg-2 d-flex flex-column justify-content-center">
				            <div class="mb-3 text-center" style="height: 200px;">
					            <img id="image" src="data:image/jpeg;base64,${encodedImage}"
	                 alt="Hình ảnh" class="img-fluid mx-auto d-block mw-100 mh-100">
                 			</div>
				            <div class="text-center"><input type="file" id="selectImage" accept="image/*" style="display: inline;"></div>
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
        <i class="fas fa-angle-up">top</i>
    </a>
    <!-- Bootstrap core JavaScript-->
    
    <jsp:include page="../Scripts.jsp" />
	<script>    
		document.getElementById('selectImage').addEventListener('change', function(event) {
	        var files = event.target.files;
	        if (files && files.length > 0) {
	            var reader = new FileReader();
	            reader.onload = function() {
	                var dataURL = reader.result;
	                if (dataURL != null) {
	                    document.getElementById('image').src = dataURL;
	                }
	            };
	            reader.readAsDataURL(files[0]);
	        } else {
	            console.error("No files selected or FileReader not supported.");
	        }
	    });
	</script>
	<script>
		$(document).ready(function () {
	        var updateButton = $('#update-button');
	        var confirmButton = $('#confirm-button');
	        var cancelButton = $('#cancel-button');
	        console.log(updateButton);
	
	        updateButton.on('click', function () {
	            $('input').not('#mssv, #ctxh-score, #faculty, #course, #rl-score, #contact-name').removeAttr('readonly');
	            updateButton.hide();
	            confirmButton.show();
	            cancelButton.show();
	            $('#selectImage').show();
	        });
	
	        confirmButton.on('click', function () {
	            $('input').not('#mssv, #ctxh-score, #faculty, #course, #rl-score, #contact-name').attr('readonly', true);
	            var imageInput = document.getElementById('selectImage');

	            if (imageInput.files.length > 0) {
	                var reader = new FileReader();

	                reader.onload = function () {
	                    var dataURL = reader.result;

	                    var data = {
	                        mssv: $('#mssv').val(),
	                        name: $('#name').val(),
	                        dob: $('#dob').val(),
	                        gender: $('input[name=gender]:checked').val(),
	                        cccd: $('#cccd').val(),
	                        phone: $('#phone').val(),
	                        email: $('#email').val(),
	                        address: $('#address').val(),
	                        image: dataURL
	                    };

	                    $.ajax({
	                        type: "POST",
	                        url: "<%= request.getContextPath() %>/CapNhatSinhVien",
	                        data: data,
	                        success: function (response) {
	                            console.log(response);
	                            window.location.href = '<%= request.getContextPath() %>/ThongTinSinhVien';
	                        },
	                        error: function (error) {
	                            console.log(error);
	                        }
	                    });
	                };

	                reader.readAsDataURL(imageInput.files[0]);
	            } else {
	                var data = {
	                    mssv: $('#mssv').val(),
	                    name: $('#name').val(),
	                    dob: $('#dob').val(),
	                    gender: $('input[name=gender]:checked').val(),
	                    cccd: $('#cccd').val(),
	                    phone: $('#phone').val(),
	                    email: $('#email').val(),
	                    address: $('#address').val()
	                };

	                $.ajax({
	                    type: "POST",
	                    url: "<%= request.getContextPath() %>/CapNhatSinhVien",
	                    data: data,
	                    success: function (response) {
	                        console.log(response);
	                        window.location.href = '<%= request.getContextPath() %>/ThongTinSinhVien';
	                    },
	                    error: function (error) {
	                        console.log(error);
	                    }
	                });
	            }
	        });

	
	        cancelButton.on('click', function () {
	            $('input').not('#mssv, #ctxh-score, #faculty, #course, #rl-score, #contact-name').attr('readonly', true);
	            updateButton.show();
	            confirmButton.hide();
	            cancelButton.hide();
	            $('#selectImage').hide();
	        });
	    });
	</script>
	
</body>
</html>