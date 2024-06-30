package Controllers;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.QuanLyDAO;


@WebServlet("/deletelophoc")
public class XoaLopHocController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private QuanLyDAO dao;
    public XoaLopHocController() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		dao = new QuanLyDAO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idLopHoc = Integer.parseInt(request.getParameter("id"));
		dao.deleteLopHoc(idLopHoc);
		response.sendRedirect("quanlylophoc");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
