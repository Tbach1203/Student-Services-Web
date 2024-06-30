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

import DAO.GiayVayVonDAO;
import DAO.GiayXacNhanDAO;
import DAO.HoatDongDAO;
import DAO.KhoaDAO;
import DAO.ThamGiaHoatDongDAO;
import DAO.ToChucDAO;
import DAO.YeuCauDAO;
import Models.GiayVayVon;
import Models.GiayXacNhan;
import Models.HoatDong;
import Models.Khoa;
import Models.ThamGiaHD;
import Models.ToChuc;
import Models.YeuCau;


@WebServlet("/DSHoatDong")
public class HoatDongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HoatDongController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DSHoatDong(request, response);
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
	private void DSHoatDong(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, ServletException, IOException {
		
		HttpSession session = request.getSession();
		String mssv = (String) session.getAttribute("maND");
	    
		HoatDongDAO hoatdongDAO = new HoatDongDAO();
		ToChucDAO tochucDAO = new ToChucDAO();
		ThamGiaHoatDongDAO thamgiahdDAO = new ThamGiaHoatDongDAO();
		YeuCauDAO yeucauDAO = new YeuCauDAO();
	    RequestDispatcher dispatcher;
		try {
			List<HoatDong> dshd = hoatdongDAO.LayDSHoatDong();
			List<ToChuc> dstochuc = tochucDAO.LayDSToChuc();
			List<ThamGiaHD> dsthamgiahd = thamgiahdDAO.LayDSThamGiaHD(mssv);
			List<YeuCau> dsyeucau = yeucauDAO.getDSYeuCau(mssv);
			request.setAttribute("dshd", dshd);
			request.setAttribute("dstochuc", dstochuc);
			request.setAttribute("dsthamgiahd", dsthamgiahd);
			request.setAttribute("dsyeucau", dsyeucau);
			String completeMsg = request.getParameter("completeMsg");
			request.setAttribute("completeMsg", completeMsg);
		    dispatcher = request.getRequestDispatcher("/SinhVien/DangKyHoatDong_SinhVien.jsp");
		    dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}    
	}
}
