<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Models.LopHoc" %>
<%@ page import="Models.ThamGiaLopHoc" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Bảng điểm</title>

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
				<div class="container ">
			        <div class="row mt-2">
			            <div class="col-md-2"><label class="text-dark h5">MSSV:</label></div>
			            <div class="col-md-10"><label class="text-dark h5">${sinhvien.getID_SinhVien()}</label></div>
			        </div>
			        <div class="row mt-2">
			            <div class="col-md-2 "><label class="text-dark h5">Họ tên:</label></div>
			            <div class="col-md-10 "><label class="text-dark h5">${sinhvien.getHoTen()}</label></div>
			        </div>
			        <div class="row mt-4 bg-white">
			            <div class="col-md-12">
			                <div class="scrollable-table">
			                    <table class="table table-bordered text-dark h5">
							        <thead>
							            <tr>
							                <th>Lớp học</th>
							                <th>Môn học</th>
							                <th>Tín chỉ</th>
							                <th>Điểm quá trình</th>
							                <th>Điểm cuối kỳ</th>
							            </tr>
							        </thead>
							        <% List<LopHoc> dslophoc = (List<LopHoc>) request.getAttribute("dslophoc");
						               for (LopHoc lophoc : dslophoc) { %>
						                <tr>
						                    <td><%= lophoc.getTenLopHoc() %></td>
						                    <td><%= lophoc.getMonHoc() %></td>
						                    <td><%= lophoc.getTinChi() %></td>
						                   
						                    <% List<ThamGiaLopHoc> dsThamGia = (List<ThamGiaLopHoc>) request.getAttribute("bangdiem");
						                       for (ThamGiaLopHoc tglh : dsThamGia) {
						                           if (tglh.getID_LopHoc() == lophoc.getID_LopHoc()) { %>
						                               <td><%= tglh.getDiemQuaTrinh() %></td>
						                               <td><%= tglh.getDiemCuoiKy() %></td>
						                           <% } %>
						                    <% } %>
						                </tr>
						            <% } %>
							        </tbody>
   								 </table>
			                </div>
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
</body>
</html>