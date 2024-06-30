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
import Models.Khoa;
import Models.LopHoc;


@WebServlet("/quanlylophoc")
public class QuanLyLopHoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private QuanLyDAO dao;
    public QuanLyLopHoc() {
        super();

    }

	
	public void init(ServletConfig config) throws ServletException {
		dao = new QuanLyDAO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<LopHoc> lopHocList = dao.selectAllLopHoc();
		request.setAttribute("lopHocList", lopHocList);
		request.getRequestDispatcher("/Admin/QuanLyLopHoc_Admin.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String monHoc = request.getParameter("monHoc");
		String tenLopHoc = request.getParameter("tenLop");
		int tinChi = Integer.parseInt(request.getParameter("tinChi"));
		LopHoc lopHoc = new LopHoc(monHoc, tenLopHoc, tinChi);
		dao.inserLopHoc(lopHoc);
		response.sendRedirect("quanlylophoc");
	}

}
