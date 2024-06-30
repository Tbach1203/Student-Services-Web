package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.PhanHoiDAO;
import Models.PhanHoi;


@WebServlet("/DSPhanHoi")
public class DSPhanHoiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DSPhanHoiController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DSPhanHoi(request, response);
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

	private void DSPhanHoi(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
		String mssv = (String) session.getAttribute("maND");
	    
	    PhanHoiDAO phanhoiDAO = new PhanHoiDAO();
	    RequestDispatcher dispatcher;
		try {		
			List<PhanHoi> dsphanhoi = new ArrayList<>();
			dsphanhoi = phanhoiDAO.getDSPhanHoi(mssv);
			request.setAttribute("dsphanhoi", dsphanhoi);
		    dispatcher = request.getRequestDispatcher("./SinhVien/index_SinhVien.jsp");
		    dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}    
	}
}
