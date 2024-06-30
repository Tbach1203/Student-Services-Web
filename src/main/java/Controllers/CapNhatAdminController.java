package Controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.QuanLyDAO;
import Models.QuanLy;

/**
 * Servlet implementation class CapNhatAdminController
 */
@WebServlet("/updateadmin")
public class CapNhatAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private QuanLyDAO dao;
	public CapNhatAdminController() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		dao = new QuanLyDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int idQuanly = Integer.parseInt(request.getParameter("id"));
		QuanLyDAO dao = new QuanLyDAO();
		QuanLy quanly = dao.selectAdmin(idQuanly);
		request.setAttribute("quanly", quanly);
		if (quanly.getAnhCaNhan() != null) {
			String encodedImage = Base64.getEncoder().encodeToString(quanly.getAnhCaNhan());
			request.setAttribute("encodedImage", encodedImage);
		}
		request.getRequestDispatcher("/Admin/CapNhatAdmin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String encodedImage = request.getParameter("encodedImage");
		String base64Image = encodedImage.replaceAll("data:image/\\w+;base64,", "");
		byte[] imageBytes = Base64.getDecoder().decode(base64Image);
		int idQuanly = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		java.util.Date ngaySinh = null;
	    try {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        String dobParameter = request.getParameter("date");
	        if (dobParameter != null && !dobParameter.isEmpty()) {
	            ngaySinh = sdf.parse(dobParameter);
	        }
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
		
		String gioitinh = request.getParameter("gender");
		String cccd = request.getParameter("cccd");
		String sdt = request.getParameter("sdt");
		String email = request.getParameter("email");
		
		QuanLy quanly = new QuanLy(idQuanly, name, ngaySinh, gioitinh, cccd, sdt, email);
		quanly.setAnhCaNhan(imageBytes);
		dao.updateAdmin(quanly);
		response.sendRedirect("ThongTinQuanLy");
	}

}
