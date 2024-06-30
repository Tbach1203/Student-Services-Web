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

    <title>Thêm sinh viên vào lớp</title>

    <!-- Custom fonts for this template-->
    <jsp:include page="../head.jsp" />
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<style>
	* Reset some default styles for better consistency */
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
					<div class = "row">
						<div class = "col-md-4">
							<h2>Bảng lớp học phần</h2>
						    <table id="TBLop" class="table table-bordered">
						      <thead>
						        <tr>
						          <th>Mã lớp</th>
						          <th>Lớp học</th>
						          <th>Tín chỉ</th>
						        </tr>
						      </thead>
						      <tbody>
						        <c:forEach var="lopHoc" items="${danhSachLopHoc}">
						        	<tr>
							 			<td> ${lopHoc.getID_LopHoc()}</td>
							 			<td> ${lopHoc.getMonHoc()}</td>
							 			<td> ${lopHoc.getTinChi()}</td>
						            </tr>
						        </c:forEach>
						      </tbody>
						    </table>
						</div>
						<div class = "md-col-4">
							<h2>Bảng danh sách lớp</h2>
						    <table id="TBSV" class="table table-bordered">
						      <thead>
						        <tr>
						          <th>MSSV</th>
						          <th>Họ tên</th>
						          <th>Xóa</th>
						        </tr>
						      </thead>
						      <tbody>
						      	<c:forEach var="sv" items="${DSSinhVien}">
						        	<tr>
							 			<td> ${sv.getID_SinhVien()}</td>
							 			<td> ${sv.getHoTen()}</td>
							 			<td> <button class="deleteButton">Xóa</button></td>
						            </tr>
						       </c:forEach>
						      </tbody>
						    </table>
						</div>
						<div class = "md-col-4">
							<h2>Thêm sinh viên vào lớp</h2>
								<label for="lophoc">Lớp học</label>
						        <select id="lophoc" class="form-control">
						        <c:forEach var="lopHoc" items="${danhSachLopHoc}">
						         	<option value="${lopHoc.getID_LopHoc()}">${lopHoc.getMonHoc()}</option>
						         </c:forEach>
						        </select>
							    
						        <label for="mssv">MSSV</label>
						        <input type="text" id="mssv" class="form-control" placeholder="MSSV" required>
						      
						    <button type="button" id="btn-them">Thêm</button>
		                <!-- /.container-fluid -->
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

    

    <jsp:include page="../Scripts.jsp" />
	<script>
						document.getElementById("TBLop").querySelectorAll("tr").forEach(function(tr) {
						  tr.addEventListener("mouseover", function() {
						    tr.style.backgroundColor = "yellow";
						  });
						
						  tr.addEventListener("mouseout", function() {
						    tr.style.backgroundColor = "";
						  });
						  tr.addEventListener("click", function() {
							  const lopHocId = tr.querySelector("td:first-child").textContent.trim();
							  const ctsvId = ${ctsvId}
							  window.location.href = "<%=request.getContextPath()%>/ThemSinhVien?ctsvId=" + ctsvId + "&lophoc=" + lopHocId;
							  });
						});
						
						
						document.getElementById("TBSV").querySelectorAll("tr").forEach(function(tr) {
							  tr.addEventListener("mouseover", function() {
							    tr.style.backgroundColor = "yellow";
							  });
							
							  tr.addEventListener("mouseout", function() {
							    tr.style.backgroundColor = "";
							  });
				
							});				
				
						
						
					        $(".deleteButton").on("click", function () {
					            var row = $(this).closest("tr");
	
					            var idSinhVien = row.find("td:first-child").text().trim();
					            const lopHocValue = ${lopHoc}
					            const ctsvId = ${ctsvId}
					            $.ajax({
					    	        url: "<%=request.getContextPath()%>/ThemSinhVien",
					    	        method: "DELETE",
					    	        contentType: "application/json; charset=utf-8",
					    	        data: JSON.stringify({
					    	            mssv: idSinhVien,
					    	            lopHoc: lopHocValue.toString()
					    	        }),
					    	        success: function (data) {
					    	        	 window.location.href = "<%=request.getContextPath()%>/ThemSinhVien?ctsvId=" + ctsvId + "&lophoc=" + lopHocValue;
					    	        },
					    	        error: function () {
					    	            console.log("Error saving data");
					    	        }
					    	    });
					        })
					        
		$("#btn-them").on("click", function(){
	    const mssvValue = $("#mssv").val(); 
	    const lopHocValue = $("#lophoc").val();
	    const ctsvId = ${ctsvId}
	    $.ajax({
	        url: "<%=request.getContextPath()%>/ThemSinhVien",
	        method: "POST",
	        contentType: "application/json; charset=utf-8",
	        data: JSON.stringify({
	            mssv: mssvValue,
	            lopHoc: lopHocValue,
	        }),
	        success: function (data) {
	        	 window.location.href = "<%=request.getContextPath()%>/ThemSinhVien?ctsvId=" + ctsvId + "&lophoc=" + lopHocValue;
	        },
	        error: function () {
	            console.log("Error saving data");
	        }
	    });		
		})
	</script>
	  
</body>
</html>