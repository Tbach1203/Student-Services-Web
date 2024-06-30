<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Giấy xác nhận sinh viên</title>

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
				<div class="container mh-80">
			        <div class="row table-container h6">
			            <div class="col-md-9">
			                <table class="table table-bordered text-dark scrollable-table">
						        <thead>
						            <tr>
						                <th>Thời gian đăng ký</th>
						                <th>Tên giấy tờ</th>
						                <th>STT</th>
						                <th>Chi phí</th>
						                <th>Thời gian nhận</th>
						                <th>Tình trạng</th>
						            </tr>
						        </thead>
						        <tbody class="dsgiayvay">
						            <!-- Danh sách Giấy Vay -->
						            <c:forEach var="giayVay" items="${dsgiayvay}" varStatus="status">
						                <tr class="clickable-row" data-id="${status.index}">
						                    <td><c:forEach var="yeuCau" items="${dsyeucau}">
									                <c:if test="${giayVay.ID_YeuCau eq yeuCau.ID_YeuCau}">
									                    ${yeuCau.getThoiGianGui()}
									                </c:if>
									            </c:forEach></td>
						                    <td>Giấy vay vốn</td>
						                    <td>${giayVay.getID_YeuCau()}</td>
						                    <td>${giayVay.getSoTien()}</td>
						                    <td>${giayVay.getNgayNhan()}</td>
						                    <td>
						                        <c:forEach var="yeuCau" items="${dsyeucau}">
									                <c:if test="${giayVay.ID_YeuCau eq yeuCau.ID_YeuCau}">
									                    ${yeuCau.trangThai}
									                </c:if>
									            </c:forEach>
						                    </td>
						                </tr>
						            </c:forEach>
								</tbody>
								<tbody class="dsgiayxn">
						            <!-- Danh sách Giấy Xác Nhận -->
						            <c:forEach var="giayXN" items="${dsgiayxn}" varStatus="status">
						                <tr class="clickable-row" data-id="${status.index}">
						                    <td>${giayXN.ngayNhan}</td>
						                    <td>Giấy xác nhận sinh viên</td>
						                    <td>${giayXN.ID_YeuCau}</td>
						                    <td>0</td> <!-- Thay thế bằng thuộc tính tương ứng trong đối tượng -->
						                    <td>${giayXN.ngayNhan}</td>
						                    <td>
						                       <c:forEach var="yeuCau" items="${dsyeucau}">
									                <c:if test="${giayXN.ID_YeuCau eq yeuCau.ID_YeuCau}">
									                    ${yeuCau.trangThai}
									                </c:if>
									            </c:forEach>
						                    </td>
						                </tr>
						            </c:forEach>
						        </tbody>
						    </table>
			            </div>
			            <div class="col-md-3 d-flex flex-column align-items-center mt-auto mb-auto">
			                <label class="text-dark h5">Giấy xác nhận sinh viên</label>
			                <button class="btn btn-primary" data-toggle="modal" data-target="#SignUpSucceed">Đăng ký</button>			            
			            </div>
			        </div>
			        <div class="row notes-container">
			            <div class="col-md-12">
			                <fieldset style="border: 4px solid black; padding: 10px">
					            <legend style="width: auto; border: none; padding: 0;">Ghi chú</legend>
					            <textarea id="noteTextArea" class="form-control h6 text-dark" rows="5" placeholder="Ghi chú" readonly></textarea>
					        </fieldset>
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
    
    <!-- Add SignUpSucceed -->
    <div class="modal fade" id="SignUpSucceed">
    	<div class="modal-dialog modal-lg">
	      <div class="modal-content">
	        <div class="modal-header bg-primary text-white">
	          <h5 class="modal-title">Đăng ký giấy xác nhận thành công</h5>
	        </div>
	        <div class="modal-body">
	          <form action="">
	            <div class="form-group">
	            <%
				    LocalDateTime thoiGianHienTai = LocalDateTime.now();				
				    LocalDateTime ngayMai940 = thoiGianHienTai.plusDays(1).withHour(9).withMinute(40);
				    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
				    String ngayNhan = ngayMai940.format(formatter);
				%>
	              <label for="body">Thông báo</label>
	              <textarea name="editor1" class="form-control" readonly>Bạn đã đăng ký giấy xác nhận thành công thành công
	              Liên hệ với phòng CTSV để nhận giấy vào <%= ngayNhan %></textarea>
	            </div>
	          </form>
	        </div>
	        <div class="modal-footer">
	        	<button class="btn btn-primary" data-dismiss="modal">Hủy</button>
	        	<a class="nav-link" href="<%= request.getContextPath()%>/DangKyGiayXacNhan">
	          		<button class="btn btn-primary">Hoàn thành</button>
	          	</a>
	        </div>
	      </div>
	    </div>
    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    
    <jsp:include page="../Scripts.jsp" />
	<script>
	    $(document).ready(function () {
	        $(".clickable-row").click(function () {
	            var index = $(this).data("id");
	            var noiDung = "";
				console.log("Đã click hàng");
	            if ($(this).closest("tbody").hasClass("dsgiayvay")) {
	                noiDung = "${dsgiayvay.get(index).getNoiDung()}";
	            } else {
	                noiDung = "${dsgiayxn.get(index).getNoiDung()}";
	            }
	            $("#noteTextArea").prop("readonly", false);
	            $("#noteTextArea").val(noiDung);
	            $("#noteTextArea").prop("readonly", true);
	        });
	    });
	</script>
</body>
</html>