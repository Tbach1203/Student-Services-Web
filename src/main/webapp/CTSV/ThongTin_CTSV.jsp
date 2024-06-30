<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Ứng dụng dịch vụ sinh viên</title>

    <!-- Custom fonts for this template-->
    <jsp:include page="../head.jsp" />
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<style>
	  /* Reset some default styles for better consistency */
	  body, h1, h2, h3, p, ul, li {
	    margin: 0;
	    padding: 0;
	  }
	
	  body {
	    font-family: 'Arial', sans-serif;
	    line-height: 1.6;
	    background-color: #f8f9fa;
	  }
	
	  /* Style for tables */
	  table {
	    width: 100%;
	    margin-bottom: 20px;
	    border-collapse: collapse;
	    background-color: #fff;
	    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	  }
	
	  th, td {
	    padding: 10px;
	    text-align: center;
	    border: 1px solid #dee2e6;
	  }
	
	  th {
	    background-color: #007bff;
	    color: #fff;
	  }
	
	  /* Style for buttons */
	  button {
	    margin-top: 10px;
	    padding: 10px;
	    background-color: #007bff;
	    color: #fff;
	    border: none;
	    cursor: pointer;
	  }
	
	  /* Style for the container */
	  .container-fluid {
	    padding: 20px;
	  }
	
	  /* Style for the row */
	  .row {
	    display: flex;
	    flex-wrap: wrap;
	    justify-content: space-between;
	  }
	
	  /* Style for each column */
	  .col-md-4 {
	    flex-basis: calc(33.33% - 20px); /* Adjust the width as needed, considering margin */
	    margin-bottom: 20px;
	  }
	
	  /* Additional styling for select and input */
	  label {
	    margin-top: 10px;
	    display: block;
	    font-weight: bold;
	  }
	
	  select, input {
	    width: 100%;
	    padding: 10px;
	    margin-top: 5px;
	    margin-bottom: 15px;
	    box-sizing: border-box;
	    border: 1px solid #ced4da;
	    border-radius: 4px;
	    background-color: #fff;
	  }
	</style>
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


                    <!-- Topbar Navbar -->
                    <jsp:include page="./Topbar_CTSV.jsp" />

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">
                
                    <h2>Thông tin cá nhân</h2>
                    <div class="row">
                    
                        <div class="col-md-6">
                            
					         <div class="form-group">
                                <label for="msctsv">MSCTSV</label>
                                <label for="msctsv" class="form-control">${ctsv.ID_CTSV}</label>
                            </div>
                            <div class="form-group">
                                <label for="ten">Họ Tên</label>
                                <label for="ten" class="form-control">${ctsv.getHoTen()}</label>
                            </div>
                            <div class="form-group">
                                <label for="ngaysinh">Ngày sinh</label>
                                <input type="date" class="form-control" id="ngaysinh" value="${ctsv.getNgaySinh()}">
                            </div>
                            <div class="form-group">
                                <label for="gioitinh">Giới tính</label>
                                <label for="gioitinh" class="form-control">${ctsv.getGioiTinh()}</label>
                            </div>
                            <div class="form-group">
                                <label for="cccd">CCCD</label>
                                <label for="cccd" class="form-control">${ctsv.getCCCD()}</label>
                            </div>
                            
                            
                        </div>
                        <div class="col-md-6">
	                       <div class="form-group">
                                <label for="sodienthoai">Số điện thoại</label>
                                <input type="" id="sdt"  class="form-control" value="${ctsv.getSDT()}">
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="text" id= "email" class="form-control" value="${ctsv.getEmail()}">
                            </div>
                            
	                        <div class = "row">
	                        <!-- Hình ảnh -->
							<input type="hidden" name="encodedImage" id="encodedImage" value="${encodedImage}">
							<div class="col-md-12 d-flex flex-column justify-content-center">
					            <div class="mb-3 text-center" style="height: 200px;">
						            <img id="image" src="data:image/jpeg;base64,${encodedImage}"
		                 alt="Hình ảnh" class="img-fluid mx-auto d-block mw-100 mh-100">
	                 			</div>
					            <div class="text-center"><input type="file" id="selectImage" accept="image/*"></div>
				        	</div>
	                        <div class="col-md-6">
	                            <button type="button" class="btn btn-success" id="updateButton">Cập nhật thông tin liên lạc</button>
	                        </div>
                            <div class="col-md-6">
	                            <button type="button" class="btn btn-primary" id="reset-password-button">Đổi mật khẩu</button>
	                        </div>
	                        </div>
                        </div>
                    </div>
                    
                    
                </div>
                <!-- /.container-fluid -->

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
$('#selectImage').show();	
$('#confirm-button').show();
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
$("#updateButton").on("click", function(){
	console.log("Đã click update");
    const sdtValue = $("#sdt").val(); 
    const emailValue = $("#email").val();
    const encodedImage = $("#encodedImage").val();
	const url = "<%=request.getContextPath()%>/ThongTin_CTSV";
    $.ajax({
        url: url,
        method: "PUT",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            sdt: sdtValue,
            email: emailValue,
            encodedImage: encodedImage,
        }),
        success: function (data) {
        	 window.location.href = url
        },
        error: function () {
            console.log("Error saving data");
        }
    });		
	})
	
	$("#reset-password-button").on("click", function(){
	    const sdtValue = $("#sdt").val(); 
		window.location.href = "/DichVuSinhVien/reset-password"
		})	
	document.getElementById('selectImage').addEventListener('change', function(event) {
	        var files = event.target.files;
	        if (files && files.length > 0) {
	            var reader = new FileReader();
	            reader.onload = function() {
	                var dataURL = reader.result;
	                if (dataURL != null) {
	                    document.getElementById('image').src = dataURL;
	                    document.getElementById('encodedImage').value = dataURL;
	                }
	            };
	            reader.readAsDataURL(files[0]);
	        } else {
	            console.error("No files selected or FileReader not supported.");
	        }
	    });	
</script>
</body>
</html>