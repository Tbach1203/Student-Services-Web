package Controllers;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.QuanLyDAO;


@WebServlet("/deletehocbong")
public class XoaHocBong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private QuanLyDAO dao;
    public XoaHocBong() {
        super();

    }

	
	public void init(ServletConfig config) throws ServletException {
		dao = new QuanLyDAO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idHocBong = Integer.parseInt(request.getParameter("id"));
		dao.deleteHocBong(idHocBong);
		response.sendRedirect("quanlyhocbong");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
