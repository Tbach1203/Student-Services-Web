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

import DAO.HoatDongDAO;
import DAO.HocBongDAO;
import DAO.ThamGiaHoatDongDAO;
import DAO.ToChucDAO;
import DAO.YeuCauDAO;
import Models.HoatDong;
import Models.HocBong;
import Models.ThamGiaHD;
import Models.ToChuc;
import Models.YeuCau;

@WebServlet("/DSHocBong")
public class HocBongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HocBongController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DSHocBong(request, response);
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
	private void DSHocBong(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, ServletException, IOException {
		HocBongDAO hocbongDAO = new HocBongDAO();
		HttpSession session = request.getSession();
		String mssv = (String) session.getAttribute("maND");
	    RequestDispatcher dispatcher;
		try {
			List<HocBong> dshb = hocbongDAO.LayDSHocBong(mssv);
			request.setAttribute("dshb", dshb);
		    dispatcher = request.getRequestDispatcher("/SinhVien/DangKyHocBong_SinhVien.jsp");
		    dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}    
	}

}
