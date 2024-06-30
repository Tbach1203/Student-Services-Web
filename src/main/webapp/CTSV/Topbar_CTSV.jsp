<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

					<ul class="navbar-nav" style="width: 100%;">                    
                    	<li class ="nav-item">
							<a class ="nav-link text-gray-900 medium" href="<%=request.getContextPath()%>/ThongTin_CTSV">Trang Chủ</a>
						</li>
						<li class ="nav-item">
							<a class ="nav-link text-gray-900 medium" href="<%= request.getContextPath()%>/CTSV/HoTroCTSV_CTSV.jsp">Hỗ Trợ</a>
						</li>
                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow ml-auto">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-4 d-none d-lg-inline text-gray-900 medium">${ctsv.getHoTen()}</span>
								<lord-icon
								    src="https://cdn.lordicon.com/kthelypq.json"
								    trigger="hover"
								    style="width:50px;height:50px">
								</lord-icon>
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="<%= request.getContextPath()%>/CTSV">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Thông tin cá nhân
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="<%= request.getContextPath()%>/DangXuat">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Đăng xuất
                                </a>
                            </div>
                        </li>
                    </ul>
</body>