package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
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
import DAO.YeuCauDAO;
import Models.GiayVayVon;
import Models.GiayXacNhan;
import Models.YeuCau;

/**
 * Servlet implementation class GiayXacNhanController
 */
@WebServlet("/ThongTinDSGiayXacNhan")
public class GiayXacNhanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GiayXacNhanController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ThongTinDS(request, response);
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
	private void ThongTinDS(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
		String mssv = (String) session.getAttribute("maND");
	    
	    GiayVayVonDAO giayVayVonDAO = new GiayVayVonDAO();
	    GiayXacNhanDAO giayXacNhanDAO = new GiayXacNhanDAO();
	    YeuCauDAO yeucauDAO = new YeuCauDAO();
	    RequestDispatcher dispatcher;
		try {
			List<GiayVayVon> dsgiayvay = giayVayVonDAO.getDSGiayVay(mssv);
			List<GiayXacNhan> dsgiayxn = giayXacNhanDAO.getDSGiayXN(mssv);
			List<YeuCau> dsyeucau = yeucauDAO.getDSYeuCau(mssv);
			request.setAttribute("dsgiayvay", dsgiayvay);
		    request.setAttribute("dsgiayxn", dsgiayxn);
		    request.setAttribute("dsyeucau", dsyeucau);

		    dispatcher = request.getRequestDispatcher("/SinhVien/GiayXacNhan_SinhVien.jsp");
		    dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}    
	}
}

