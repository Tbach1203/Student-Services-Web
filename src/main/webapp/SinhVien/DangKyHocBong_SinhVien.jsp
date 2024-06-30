<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="Models.HocBong" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Đăng ký học bổng</title>

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
				 <div class="container">
			        <div class="row">
			            <div class="col-8">
			                <table class="table text-dark table-bordered">
			                    <thead>
			                        <tr>
			                            <th>Tên học bổng</th>
			                            <th>Điều kiện</th>
			                            <th>Số lượng</th>
			                            <th>Tiền thưởng</th>
			                        </tr>
			                    </thead>
			                    <tbody>
			                        <c:forEach var="hocbong" items="${dshb}" varStatus="status">
			                            <tr class="clickable-row"
			                            data-id="${hocbong.getID_HocBong()}" data-noidung="${hocbong.getNoiDung()}"
			                            data-isdanhan = "${hocbong.getisDaNhan()}"
			                             >
			                                <td>${hocbong.getTenHocBong()}</td>
			                                <td>${hocbong.getDieuKien()}</td>
			                                <td>${hocbong.getSoLuong()}</td>
			                                <td>${hocbong.getTienThuong()}</td>
			                            </tr>
                        			</c:forEach>
			                    </tbody>
			                </table>
			            </div>
			            <div class="col-4">
			                <div class="d-flex justify-content-center">
							    <button type="button" id="btnSubmit" class="btn btn-primary mb-3" style="display: none;">Đăng ký học bổng</button>
								<p id="errorDaDangKy" class="text-danger" style="display: none;">Bạn đã đăng ký học bổng này rồi!</label>
							</div>
			                <form>
			                    <div class="form-group">
			                        <label for="scholarshipDescription">Mô tả học bổng:</label>
			                        <textarea class="form-control" id="scholarshipDescription" rows="3"></textarea>
    								<input type="hidden" id="hiddenHocBongId" name="hiddenHocBongId" value="">
			                    </div>
			                </form>
			            </div>
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
    <script>
	    $(document).ready(function () {
	        $(".clickable-row").click(function () {
	            console.log("Đã click");
	            var idHocBong = $(this).data("id");
				var noidung = $(this).data("noidung");
				var isDaNhan = $(this).data("isdanhan");
				
				console.log(idHocBong);
				var btnSubmit = $('#btnSubmit');
				var errorDaDangKy = $('#errorDaDangKy');
				if (isDaNhan === false || isDaNhan === "false") {
				    btnSubmit.show();
				    errorDaDangKy.hide();
				} else {
				    btnSubmit.hide();
				    errorDaDangKy.show();
				}
				$("#scholarshipDescription").val(noidung).prop("readonly", true);
				$("#hiddenHocBongId").val(idHocBong).prop("readonly", true);
	        });
	        
	        $("#btnSubmit").click(function () {
	        	var idHocBong = $("#hiddenHocBongId").val(); 
	            console.log(idHocBong);
	            var data = {
	                ID_HocBong: idHocBong
	            };

	            $.ajax({
	                type: "POST",
	                url: "<%= request.getContextPath() %>/DangKyHocBong",
	                data: data,
	                success: function (response) {
	                    console.log(response);
	                    window.location.href = '<%= request.getContextPath() %>/DSHocBong';
	                },
	                error: function (error) {
	                    console.log(error);
	                }
	            });
	        });
	    });
	</script>

 	<% if (session.getAttribute("completeMsgDKHocBong") != null) { %>
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
                        ${completeMsgDKHocBong}
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