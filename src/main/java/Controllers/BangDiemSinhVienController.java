package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.SinhVien;
import Models.ThamGiaLopHoc;
import Models.LopHoc;
import DAO.ThamGiaLopHocDAO ;
import DAO.LopHocDAO;
/**
 * Servlet implementation class BangDiemSinhVienController
 */
@WebServlet("/BangDiemSinhVien")
public class BangDiemSinhVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BangDiemSinhVienController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BangDiemSinhVien(request, response);
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

	private void BangDiemSinhVien(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
		String maND = (String) session.getAttribute("maND");
		ThamGiaLopHocDAO  tglhDAO = new ThamGiaLopHocDAO ();
		LopHocDAO lophocDAO = new LopHocDAO();
		RequestDispatcher dispatcher;
		try {
			List<ThamGiaLopHoc> bangdiem = tglhDAO.getBangDiem(maND);
			request.setAttribute("bangdiem", bangdiem);
			List<LopHoc> dslophoc = lophocDAO.getDSLopHoc(bangdiem);
			request.setAttribute("dslophoc", dslophoc);
			dispatcher = request.getRequestDispatcher("/SinhVien/BangDiem_SinhVien.jsp");
		    dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
