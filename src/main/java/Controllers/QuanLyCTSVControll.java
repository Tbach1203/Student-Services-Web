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
import Models.SinhVien;

@WebServlet("/quanlyctsv")
public class QuanLyCTSVControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuanLyDAO dao;

	public QuanLyCTSVControll() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		dao = new QuanLyDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<CTSV> ctsvList = dao.selectAllCTSV();
		request.setAttribute("ctsvList", ctsvList);
		request.getRequestDispatcher("/Admin/QuanLyCTSV_Admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
