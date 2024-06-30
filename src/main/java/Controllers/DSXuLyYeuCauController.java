package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.XuLyYeuCauDao;
import DAO.DichVuDAO;
import DAO.GiayVayVonDAO;
import DAO.GiayXacNhanDAO;
import DAO.HoatDongDAO;
import DAO.HocBongDAO;
import DAO.NhanHocBongDAO;
import DAO.ThamGiaHoatDongDAO;
import Models.DichVu;
import Models.GiayVayVon;
import Models.GiayXacNhan;
import Models.HoatDong;
import Models.HocBong;
import Models.NhanHocBong;
import Models.ThamGiaHD;
import Models.YeuCau;

@WebServlet("/DSXuLyYeuCau")
public class DSXuLyYeuCauController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DSXuLyYeuCauController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DSXuLyYeuCau(request, response);
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
	private void DSXuLyYeuCau(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, ServletException, IOException {
	    RequestDispatcher dispatcher;
		try {
			DichVuDAO dichvuDAO = new DichVuDAO();
			GiayXacNhanDAO giayxnDAO = new GiayXacNhanDAO();
			GiayVayVonDAO giayvayDAO = new GiayVayVonDAO();
			HoatDongDAO hoatdongDAO = new HoatDongDAO();
			ThamGiaHoatDongDAO thamgiahdDAO = new ThamGiaHoatDongDAO();
			HocBongDAO hocbongDAO = new HocBongDAO();
			NhanHocBongDAO nhanhocbongDAO = new NhanHocBongDAO();
			
			List<DichVu> dsdv = dichvuDAO.getDSDichVu();
			List<YeuCau> dsyc = XuLyYeuCauDao.selectDSYeuCau();
			List<GiayXacNhan> dsgiayxn = giayxnDAO.getAllDSGiayXN();
			List<GiayVayVon> dsgiayvay = giayvayDAO.getAllDSGiayVay();
			List<HoatDong> dshd = hoatdongDAO.LayDSHoatDong();
			List<ThamGiaHD> dsthamgiahd = thamgiahdDAO.LayDSThamGiaHD();
			List<HocBong> dshocbong = hocbongDAO.LayDSTatCaHocBong();
			List<NhanHocBong> dsnhanhocbong = nhanhocbongDAO.LayDSNhanHocBong();
			request.setAttribute("dsyc", dsyc);
			request.setAttribute("dsdv", dsdv);
			request.setAttribute("dsgiayxn", dsgiayxn);
			request.setAttribute("dsgiayvay", dsgiayvay);
			request.setAttribute("dsthamgiahd", dsthamgiahd);
			request.setAttribute("dshd", dshd);
			request.setAttribute("dshocbong", dshocbong);
			request.setAttribute("dsnhanhocbong", dsnhanhocbong);
		    dispatcher = request.getRequestDispatcher("/CTSV/XuLyYeuCau_CTSV_ver2.jsp");
		    dispatcher.forward(request, response);
		} catch (SQLException e ) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}   
	}
}
