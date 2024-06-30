package Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.QuanLyDAO;
import Models.CTSV;
import Models.Khoa;


@WebServlet("/quanlykhoa")
public class QuanLyKhoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private QuanLyDAO dao;
    public QuanLyKhoaController() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		dao = new QuanLyDAO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<Khoa> khoaList = dao.selectAllKhoa();
		request.setAttribute("khoaList", khoaList);
		request.getRequestDispatcher("/Admin/QuanLyKhoa_Admin.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String tenKhoa = request.getParameter("tenKhoa");
		Khoa khoa = new Khoa(tenKhoa);
		dao.inserKhoa(khoa);
		response.sendRedirect("quanlykhoa");
	}

}
