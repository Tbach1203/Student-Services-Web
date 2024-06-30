package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.GiayVayVonDAO;
import DAO.GiayXacNhanDAO;
import DAO.YeuCauDAO;
import Models.GiayVayVon;
import Models.GiayXacNhan;
import Models.YeuCau;

@WebServlet("/DangKyGiayVay")
public class DangKyGiayVayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DangKyGiayVayController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DangKyGiayVay(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private void DangKyGiayVay(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
		String mssv = (String) session.getAttribute("maND");
	    
		YeuCau yc = new YeuCau();
		GiayVayVon giayvay = new GiayVayVon();
		
		LocalDateTime thoiGianHienTai = LocalDateTime.now();
		Timestamp timestamp = Timestamp.valueOf(thoiGianHienTai);
		yc.setID_DichVu(3);
		yc.setID_SinhVien(mssv);
		yc.setThoiGianGui(new Date(timestamp.getTime()));
		yc.setTrangThai("DangXuLy");
		
		LocalDateTime ngayNhanMoi = thoiGianHienTai.plusDays(7).withHour(9).withMinute(0);
		timestamp = Timestamp.valueOf(ngayNhanMoi);
		request.setCharacterEncoding("UTF-8");
		int sotien = Integer.parseInt(request.getParameter("loanAmount"));
		String noidung = request.getParameter("loanPurpose");
		giayvay.setID_DichVu(3);
		giayvay.setID_SinhVien(mssv);
		giayvay.setNgayNhan(new Date(timestamp.getTime()));	
		giayvay.setSoTien(sotien);
		giayvay.setNoiDung(noidung);
		giayvay.setTrangThai(1);
		
		GiayVayVonDAO giayVayVonDAO = new GiayVayVonDAO();
	    YeuCauDAO yeucauDAO = new YeuCauDAO();
	    RequestDispatcher dispatcher;
		try {			
			int id_yc = yeucauDAO.ThemYeuCau(yc);
			giayvay.setID_YeuCau(id_yc);
			giayVayVonDAO.ThemGiayVayVon(giayvay);
			request.setAttribute("completeMsg", "Đăng ký thành công vui lòng đến nhận tại phòng CTSV vào lúc "+ giayvay.getNgayNhan());   
		    dispatcher = request.getRequestDispatcher("/SinhVien/GiayVayVon_SinhVien.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}    
	}
}
