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

import DAO.HoatDongDAO;
import DAO.HocBongDAO;
import DAO.XuLyYeuCauDao;
import DAO.YeuCauDAO;
import Models.PhanHoi;
import Models.YeuCau;

@WebServlet("/XuLyYeuCau")
public class XuLyYeuCau_ver2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public XuLyYeuCau_ver2Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			XuLyYeuCau(request, response);
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
	private void XuLyYeuCau(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
		String maND = (String) session.getAttribute("maND");
		String noidungPH = request.getParameter("NoiDung");
		String hanhDong = request.getParameter("HanhDong");
		int ID_YeuCau = Integer.parseInt(request.getParameter("ID_YeuCau"));
		YeuCauDAO yeucauDAO = new YeuCauDAO();
		RequestDispatcher dispatcher;
		try {
			YeuCau yeuCau = new YeuCau();
			yeuCau.setID_YeuCau(ID_YeuCau);
			yeuCau.setTrangThai(hanhDong);
			yeucauDAO.SuaTrangThaiYeuCau(yeuCau);
			PhanHoi phanhoi = new PhanHoi();
			LocalDateTime thoiGianHienTai = LocalDateTime.now();
			Timestamp timestamp = Timestamp.valueOf(thoiGianHienTai);
			phanhoi.setID_CTSV(Integer.parseInt(maND));
			phanhoi.setID_YeuCau(ID_YeuCau);
			phanhoi.setNoiDung(noidungPH);
			phanhoi.setTrangThai(hanhDong);
			phanhoi.setThoiGianPH(new Date(timestamp.getTime()));
			XuLyYeuCauDao.themPhanHoi(phanhoi);
			
			String loaidv = yeucauDAO.LoaiDichVuYeuCau(ID_YeuCau);
			int ID_XuLy = Integer.parseInt(request.getParameter("ID_XuLy"));
			switch (loaidv) {
		    case "HOCBONG":
		    	HocBongDAO.UpdateSoLuongHocBong(ID_YeuCau,ID_XuLy);
		        break;
		    case "HOATDONG":
		    	HoatDongDAO.UpdateThamGiaHD(ID_YeuCau, ID_XuLy);
		        break;
		    default:
		        break;
		}
			
			dispatcher = request.getRequestDispatcher("/SinhVien/BangDiem_SinhVien.jsp");
		    dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
