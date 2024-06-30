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
import DAO.ThamGiaHoatDongDAO;
import DAO.YeuCauDAO;
import Models.GiayVayVon;
import Models.YeuCau;
import Models.ThamGiaHD;

@WebServlet("/DangKyHoatDong")
public class DangKyHoatDongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DangKyHoatDongController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DangKyHoatDong(request, response);
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
	private void DangKyHoatDong(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
		String mssv = (String) session.getAttribute("maND");
	    int idhd = -1;
	    try {
	        idhd = Integer.parseInt(request.getParameter("idHoatDong"));
	    } catch (NumberFormatException e) {
	        e.printStackTrace();
	    }
		
		YeuCau yc = new YeuCau();
		ThamGiaHD thamgiahd = new ThamGiaHD();
		
		LocalDateTime thoiGianHienTai = LocalDateTime.now();
		Timestamp timestamp = Timestamp.valueOf(thoiGianHienTai);
		yc.setID_DichVu(4);
		yc.setID_SinhVien(mssv);
		yc.setThoiGianGui(new Date(timestamp.getTime()));
		yc.setTrangThai("DangXuLy");
		
		thamgiahd.setID_SinhVien(mssv);
		thamgiahd.setID_HoatDong(idhd);
		thamgiahd.setTrangThai(1);
		
		ThamGiaHoatDongDAO thamgiaHDDAO = new ThamGiaHoatDongDAO();
	    YeuCauDAO yeucauDAO = new YeuCauDAO();
	    RequestDispatcher dispatcher;
		try {			
			int id_yc = yeucauDAO.ThemYeuCau(yc);
			thamgiahd.setID_YeuCau(id_yc);
			request.setAttribute("completeMsg", "Đăng ký thành công hoạt động ");   
		    dispatcher = request.getRequestDispatcher("/DSHoatDong");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}    
	}

}
