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

import DAO.GiayXacNhanDAO;
import DAO.NhanHocBongDAO;
import DAO.YeuCauDAO;
import Models.GiayXacNhan;
import Models.HocBong;
import Models.NhanHocBong;
import Models.YeuCau;


@WebServlet("/DangKyHocBong")
public class DangKyHocBongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DangKyHocBongController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DangKyHocBong(request, response);
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
	private void DangKyHocBong(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
		String mssv = (String) session.getAttribute("maND");
		int idHocBong = -1;
		 try {
		        idHocBong = Integer.parseInt(request.getParameter("ID_HocBong"));
		    } catch (NumberFormatException e) {
		        e.printStackTrace();
		    }
		YeuCau yc = new YeuCau();
		NhanHocBong nhanhocbong = new NhanHocBong();
		
		LocalDateTime thoiGianHienTai = LocalDateTime.now();
		Timestamp timestamp = Timestamp.valueOf(thoiGianHienTai);
		yc.setID_DichVu(1);
		yc.setID_SinhVien(mssv);
		yc.setThoiGianGui(new Date(timestamp.getTime()));
		yc.setTrangThai("DangXuLy");
		
		nhanhocbong.setID_HocBong(idHocBong);
		nhanhocbong.setTrangThai(1);;
		
	    NhanHocBongDAO nhanhocbongDAO = new NhanHocBongDAO();
	    YeuCauDAO yeucauDAO = new YeuCauDAO();
	    RequestDispatcher dispatcher;
		try {			
			int id_yc = yeucauDAO.ThemYeuCau(yc);
			nhanhocbong.setID_YeuCau(id_yc);
			nhanhocbongDAO.ThemNhanHocBong(nhanhocbong);
			session.setAttribute("completeMsgDKHocBong", "Đã đăng ký học bổng, chờ phê duyệt");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}    
	}
}
