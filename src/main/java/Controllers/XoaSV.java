package Controllers;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.QuanLyDAO;
import DAO.SinhVienDAO;
import Models.QuanLy;


@WebServlet("/deletesv")
public class XoaSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private QuanLyDAO dao;
    public XoaSV() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		dao = new QuanLyDAO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idsv = request.getParameter("id");
		dao.deleteSV(idsv);
		response.sendRedirect("quanlysinhvien");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
