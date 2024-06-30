<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Models.HoatDong" %>
<%@ page import="Models.Khoa" %>
<%@ page import="Models.ToChuc" %>
<%@ page import="Models.YeuCau" %>
<%@ page import="Models.ThamGiaHD" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Đăng ký hoạt động</title>

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
			            <div class="col-6">
			               <!--<div class="form-group row">
							    <label for="activityType" class="col-sm-7 col-form-label">Trạng thái hoạt động:</label>
							    <div class="col-sm-5">
							        <select class="form-control" id="activityStatus">
							            <option>Chưa diễn ra</option>
							            <option>Đã hoàn thành</option>
							            <option>Tất cả</option>
							        </select>
							    </div>
							</div> -->

			                <table class="table table-bordered">
						        <thead>
						            <tr>
						                <th>Tên hoạt động</th>
						                <th>Ngày tổ chức</th>
						                <th>Khoa tổ chức</th>
						            </tr>
						        </thead>
						        <tbody>
						            <c:forEach var="hd" items="${dshd}" varStatus="status">
						            <c:forEach var="tochuc" items="${dstochuc}">
									  <c:if test="${tochuc.getID_HoatDong() eq hd.getID_HoatDong()}">
									  	<c:set var="statusValue" value="Chưa đăng ký"/>
								            <c:forEach var="thamgiahd" items="${dsthamgiahd}">
								                <c:if test="${thamgiahd.getID_HoatDong() eq hd.getID_HoatDong()}">
								                    <c:forEach var="yeucau" items="${dsyeucau}">
								                        <c:if test="${yeucau.getID_YeuCau() eq thamgiahd.getID_YeuCau()}">
								                            <c:choose>
								                                <c:when test="${yeucau.getTrangThai() eq 'DangXuLy'}">
								                                    <c:set var="statusValue" value="Đã đăng ký"/>
								                                </c:when>
								                                <c:when test="${yeucau.getTrangThai() eq 'Hoanthanh'}">
								                                    <c:set var="statusValue" value="Đã tham gia"/>
								                                </c:when>
								                                <c:when test="${yeucau.getTrangThai() eq 'TuChoi'}">
								                                    <c:set var="statusValue" value="Bị từ chối"/>
								                                </c:when>
								                            </c:choose>
								                        </c:if>
								                    </c:forEach>
								                </c:if>
								            </c:forEach>
									    <tr class="clickable-row" data-id="${hd.getID_HoatDong()}" data-tenhoatdong="${hd.getTenHoatDong()}"
									    data-ngaythamgia="${hd.getNgayThamGia()}" data-khoatochuc="${tochuc.getKhoaTC().getTenKhoa()}"
									    data-diemrl="${hd.getDiemRL()}" data-diemctxh ="${hd.getDiemCTXH()}" data-noidung ="${hd.getNoiDung()}"
									    data-trangthai="${statusValue}"
									    >
									        <td>${hd.getTenHoatDong()}</td>
									        <td>${hd.getNgayThamGia()}</td>
									        <td>
									            ${tochuc.getKhoaTC().getTenKhoa()}
										    </td>
									    </tr>
									  </c:if>
									</c:forEach>
									</c:forEach>
						        </tbody>
						    </table>
			            </div>
			            <div class="col-6">
			                <form action="<%=request.getContextPath()%>/DangKyHoatDong" method="post">
			                    <input type="hidden" id="idHoatDong" name="idHoatDong" value=""/>
			                    <div class="form-group">
			                        <label for="activityName">Tên hoạt động:</label>
			                        <input type="text" class="form-control" name="activityName" id="activityName">
			                    </div>
			                    <div class="form-group">
			                        <label for="organizer">Tổ chức:</label>
			                        <input type="text" class="form-control" id="organizer">
			                    </div>
			                    <div class="form-row">
							        <div class="form-group col-md-6">
							            <label for="rlPoints">Điểm RL:</label>
							            <input type="number" class="form-control" id="rlPoints" min="0">
							        </div>
							        <div class="form-group col-md-6">
							            <label for="ctxhPoints">Điểm CTXH:</label>
							            <input type="number" class="form-control" id="ctxhPoints" min="0">
							        </div>
							    </div>
			                    <div class="form-group">
			                        <label for="date">Ngày tổ chức:</label>
			                        <input type="date" class="form-control" id="date">
			                        <label for="status">Trạng thái:</label>
			                        <input type="text" class="form-control" id="status">
			                    </div>
			                    <div class="form-group">
			                        <label for="description">Mô tả:</label>
			                        <textarea class="form-control" id="description" rows="3"></textarea>
			                    </div>
			                    <button type="submit" class="btn btn-primary" id="btnSubmit" style="display: none;">Đăng ký hoạt động</button>
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
    
    <!-- Custum JavaScript-->
	<script>
	    $(document).ready(function () {
	        $(".clickable-row").click(function () {
	            console.log("Đã click");
	            var idHoatDong = $(this).data("id");
	            var tenHoatDong = $(this).data("tenhoatdong");
	            var ngayThamGia = $(this).data("ngaythamgia");
	            var khoaToChuc = $(this).data("khoatochuc");
	            var diemRL = $(this).data("diemrl");
	            var diemCTXH = $(this).data("diemctxh");
				var noidung = $(this).data("noidung");
				var trangthai = $(this).data("trangthai");
				var btnSubmit = $('#btnSubmit');
				if (trangthai === "Chưa đăng ký") {
				    btnSubmit.show();
				} else {
				    btnSubmit.hide();
				}
				$("#idHoatDong").val(idHoatDong);
	            $("#activityName").val(tenHoatDong).prop("readonly", true);
	            $("#organizer").val(khoaToChuc).prop("readonly", true);
	            $("#rlPoints").val(diemRL).prop("readonly", true);
	            $("#ctxhPoints").val(diemCTXH).prop("readonly", true);
	            $("#date").val(ngayThamGia).prop("readonly", true);
	            $("#description").val(noidung).prop("readonly", true);
	            $("#status").val(trangthai).prop("readonly", true);
	        });
	    });
	</script>
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