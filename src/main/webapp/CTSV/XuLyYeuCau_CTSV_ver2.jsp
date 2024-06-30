<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="Models.DichVu" %>
<%@ page import="Models.YeuCau" %>
<%@ page import="Models.HoatDong" %>
<%@ page import="Models.GiayVayVon" %>
<%@ page import="Models.GiayXacNhan" %>
<%@ page import="Models.HocBong" %>
<%@ page import="Models.NhanHocBong" %>
<%@ page import="Models.HoatDong" %>
<%@ page import="Models.ThamGiaHD" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="vi">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Xử lý yêu cầu</title>

    <!-- Custom fonts for this template-->
    
     <jsp:include page="../head.jsp" />
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

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
                    </ul>

                </nav>
                <!-- End of Topbar -->
                <div class="container">
				  <div class="row">
				    <div class="col-6">
				      <table class="table scrollable-table" style="height: 100%;;">
					    <thead>
					        <tr>
					            <th>Yêu cầu</th>
					            <th>Thời gian gửi</th>
					            <th>MSSV</th>
					            <th>Trạng Thái</th>
					        </tr>
					    </thead>
					    <tbody>
					        <c:forEach var="yeuCau" items="${dsyc}">
						       <c:forEach var="dichVu" items="${dsdv}">
					           <c:if test="${dichVu.getID_DichVu() eq yeuCau.getID_DichVu()}">
						           	<c:set var="tenYeuCau" value="${dichVu.getTenDichVu()}" />
						           	<c:set var="chiPhi" value="0" />
						           	<c:set var="noiDung" value="" />
						           	<c:set var="idXuLy" value="" />
						           	<c:forEach var="thamgiaHD" items="${dsthamgiahd}">
						           	<c:forEach var="hoatDong" items="${dshd}">
							            <c:if test="${thamgiaHD.getID_YeuCau() eq yeuCau.getID_YeuCau()}">
							            <c:if test="${thamgiaHD.getID_HoatDong() eq hoatDong.getID_HoatDong()}">
							                <c:set var="tenYeuCau" value="${hoatDong.getTenHoatDong()}" />
							                <c:set var="noiDung" value="${hoatDong.getNoiDung()}" />
						           			<c:set var="idXuLy" value="${hoatDong.getID_HoatDong()}" />
							            </c:if>
							            </c:if>
							        </c:forEach>
							        </c:forEach>
							        <c:forEach var="hocBong" items="${dshocbong}">
						           	<c:forEach var="nhanhocbong" items="${dsnhanhocbong}">
							            <c:if test="${nhanhocbong.getID_YeuCau() eq yeuCau.getID_YeuCau()}">
							            <c:if test="${nhanhocbong.getID_HocBong() eq hocBong.getID_HocBong()}">
							                <c:set var="tenYeuCau" value="${hocBong.getTenHocBong()}" />
							                <c:set var="chiPhi" value="${hocBong.getTienThuong()}" />
							                <c:set var="noiDung" value="${hocBong.getNoiDung()}" />
						           			<c:set var="idXuLy" value="${hocBong.getID_HocBong()}" />
							            </c:if>
							            </c:if>
							        </c:forEach>
							        </c:forEach>
							        <c:forEach var="giayVay" items="${dsgiayvay}">
							            <c:if test="${giayVay.getID_YeuCau() eq yeuCau.getID_YeuCau()}">
							                <c:set var="chiPhi" value="${giayVay.getSoTien()}" />
							                <c:set var="noiDung" value="${giayVay.getNoiDung()}" />
						           			<c:set var="idXuLy" value="${giayVay.getID_GiayVay()}" />
							            </c:if>
							        </c:forEach>
							        <c:forEach var="giayxn" items="${dsgiayxn}">
							            <c:if test="${giayxn.getID_YeuCau() eq yeuCau.getID_YeuCau()}">
							                <c:set var="noiDung" value="${giayxn.getNoiDung()}" />
						           			<c:set var="idXuLy" value="${giayxn.getID_GiayXN()}" />
							            </c:if>
							        </c:forEach>
						            <tr class="clickable-row" data-id="${yeuCau.getID_YeuCau()}" data-loaiyc="${dichVu.getTenDichVu()}"
						            data-trangthai="${yeuCau.getTrangThai()}" data-mssv="${yeuCau.getID_SinhVien()}"
						            data-ngaygui="${yeuCau.getThoiGianGui()}" data-tenyc="${tenYeuCau}"
						            data-chiphi="${chiPhi}" data-noidung="${noiDung}" data-idxuly="${idXuLy}"> 
						           	 	<td>
							                 ${dichVu.getTenDichVu()}
						                </td>
						                <td>${yeuCau.getThoiGianGui()}</td>
						                <td>${yeuCau.getID_SinhVien()}</td>
						                <td>
						                    <c:choose>
						                        <c:when test="${yeuCau.getTrangThai() eq 'DangXuLy'}">Đang xử lý</c:when>
						                        <c:when test="${yeuCau.getTrangThai() eq 'HoanThanh'}">Hoàn thành</c:when>
						                        <c:otherwise>Từ chối</c:otherwise>
						                    </c:choose>
						                </td>
						            </tr>
					            </c:if>
					           </c:forEach>
					        </c:forEach>
					    </tbody>
					</table>
				    </div>
				
				    <div class="col-6">
				      
				      <div class="form-group row">
				        <label for="loaiYeuCau" class="col-sm-4 col-form-label pd-0">Loại yêu cầu</label>
				        <div class="col-sm-8">
				          <input type="text" class="form-control" id="loaiYeuCau" readonly>
				        </div>
				        
				      </div>
						<div class="form-group row">
							<label for="trangThai" class="col-sm-4 col-form-label">Trạng thái</label>
					        <div class="col-sm-8">
					          <input type="text" class="form-control" id="trangThai" readonly>
					        </div>
						</div>
						
				      <!-- Row for MSSV and Ngày gửi -->
						<div class="form-group row">
						  <label for="mssv" class="col-sm-4 col-form-label">MSSV</label>
						  <div class="col-sm-8">
						    <input type="text" class="form-control" id="mssv" readonly>
						  </div>
						</div>
						<div class="form-group row">
						  <label for="ngayGui" class="col-sm-4 col-form-label">Ngày gửi</label>
						  <div class="col-sm-8">
						    <input type="date" class="form-control" id="ngayGui" readonly>
						  </div>
						</div>
						
						<!-- Row for Tên yêu cầu and Chi phí -->
						<div class="form-group row">
						  <label for="tenYeuCau" class="col-sm-4 col-form-label">Tên yêu cầu</label>
						  <div class="col-sm-8">
						    <input type="text" class="form-control" id="tenYeuCau" readonly>
						  </div>
						</div>
						<div class="form-group row">
						  <label for="chiPhi" class="col-sm-4 col-form-label">Chi phí</label>
						  <div class="col-sm-8">
						    <input type="number" class="form-control" id="chiPhi" readonly>
						  </div>
						</div>
						
						<!-- Row for Nội dung -->
						<div class="form-group row">
						  <label for="noiDung" class="col-sm-2 col-form-label">Nội dung</label>
						  <div class="col-sm-10">
						    <textarea class="form-control" id="noiDung" rows="5" readonly></textarea>
						  </div>
						</div>
						<!-- Row for button Xử lý -->
						<div class="form-group row text-center">
						    <div class="col-sm-12" onclick="openModal()">
						        <div id="btnXuLy" data-toggle="modal" data-target="#myModal" class="btn btn-primary w-50 py-3" style="font-size: 20px;display: none;" >Xử lý</div>
						    </div>
						</div>

				    </div> 
				  </div> 
				</div> 
				               
            
               <jsp:include page="../footer.jsp" />
        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->
    <!-- Bootstrap core JavaScript-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">Phản Hồi Yêu Cầu</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                	<input type="hidden" id="ID_YeuCau" value="">
                	<input type="hidden" id="ID_XuLy" value="">
                    <div class="form-group">
                        <label for="feedbackLabel">Nội dung phản hồi:</label>
                        <textarea class="form-control" id="feedbackContent" rows="5"></textarea>
                    </div>
                    <div class="text-center">
                        <button type="button" class="btn btn-danger" onclick="rejectRequest()">Từ Chối</button>
                        <button type="button" class="btn btn-success" onclick="completeRequest()">Hoàn thành</button>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Thoát</button>
            </div>
        </div>
    </div>
</div>
     <jsp:include page="../Scripts.jsp" />
     <script>
        $(document).ready(function () {
            $(".clickable-row").click(function () {
            	var idYeuCau = $(this).data("id");
                var loaiYeuCau = $(this).data("loaiyc");
                var trangThai = $(this).data("trangthai");
                var mssv = $(this).data("mssv");
                var ngayGui = $(this).data("ngaygui");
                var tenYeuCau = $(this).data("tenyc");
                var chiPhi = $(this).data("chiphi");
                var noiDung = $(this).data("noidung");
                var idxuly = $(this).data("idxuly");

                $("#ID_YeuCau").val(idYeuCau);
                $("#ID_XuLy").val(idxuly);
                $("#loaiYeuCau").val(loaiYeuCau);
                $("#trangThai").val(trangThai === "DangXuLy" ? "Đang xử lý" : (trangThai === "HoanThanh" ? "Hoàn thành" : "Từ chối"));
                $("#mssv").val(mssv);
                $("#ngayGui").val(ngayGui);
                $("#tenYeuCau").val(tenYeuCau);
                $("#chiPhi").val(chiPhi);
                $("#noiDung").prop("readonly", false);
                $("#noiDung").val(noiDung);
                $("#noiDung").prop("readonly", true);
                if (trangThai === "DangXuLy") {
                    $("#btnXuLy").show();
                } else {
                    $("#btnXuLy").hide();
                }
            });
            function openModal() {
                $('#myModal').modal('show');
                
            };
        });

        function rejectRequest() {
        	sendRequest("TuChoi");
        };

        function completeRequest() {
        	console.log("Đã click hoàn thành");
        	sendRequest("HoanThanh");
        };
        function sendRequest(hanhDong) {
        	var idYeuCau = $('#ID_YeuCau').val();
        	var idxuly = $('#ID_XuLy').val();
        	var noiDung = $('#feedbackContent').val();

            $.ajax({
                type: 'POST',
                url: '<%=request.getContextPath()%>/XuLyYeuCau',
                data: {
                    ID_YeuCau: idYeuCau,
                    HanhDong: hanhDong,
                    NoiDung: noiDung,
                    ID_XuLy: idxuly
                },
                success: function(response) {
                    alert("Đã phản hồi thành công!");
                    window.location.href = '<%= request.getContextPath() %>/DSXuLyYeuCau';
                    
                },
                error: function(error) {
                    console.error("Error sending request", error);
                }
            });
        };
    </script>
</body>
</html>