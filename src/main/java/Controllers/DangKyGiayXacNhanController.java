package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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

@WebServlet("/DangKyGiayXacNhan")
public class DangKyGiayXacNhanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DangKyGiayXacNhanController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DangKyGiayXacNhan(request, response);
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
	private void DangKyGiayXacNhan(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
		String mssv = (String) session.getAttribute("maND");
	    
		YeuCau yc = new YeuCau();
		GiayXacNhan giayxn = new GiayXacNhan();
		
		LocalDateTime thoiGianHienTai = LocalDateTime.now();
		Timestamp timestamp = Timestamp.valueOf(thoiGianHienTai);
		yc.setID_DichVu(2);
		yc.setID_SinhVien(mssv);
		yc.setThoiGianGui(new Date(timestamp.getTime()));
		yc.setTrangThai("DangXuLy");
		
		LocalDateTime ngayNhanMoi = thoiGianHienTai.plusDays(1).withHour(9).withMinute(40);
		timestamp = Timestamp.valueOf(ngayNhanMoi);
		giayxn.setID_DichVu(2);
		giayxn.setID_SinhVien(mssv);
		giayxn.setNgayNhan(new Date(timestamp.getTime()));	
		
	    GiayXacNhanDAO giayXacNhanDAO = new GiayXacNhanDAO();
	    YeuCauDAO yeucauDAO = new YeuCauDAO();
	    RequestDispatcher dispatcher;
		try {			
			int id_yc = yeucauDAO.ThemYeuCau(yc);
			giayxn.setID_YeuCau(id_yc);
			giayxn.setNoiDung("Giay de xac nhan sinh vien co ma so "+ mssv + " là sinh vien truong");
			giayXacNhanDAO.ThemGiayXN(giayxn);
			
		    dispatcher = request.getRequestDispatcher("/ThongTinDSGiayXacNhan");
		    dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}    
	}
}

