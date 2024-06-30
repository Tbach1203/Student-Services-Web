package Controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.QuanLyDAO;
import Models.CTSV;
import Models.QuanLy;

@WebServlet("/updatectsv")
public class CapNhatCTSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private QuanLyDAO dao;

	public CapNhatCTSV() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		dao = new QuanLyDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int idctsv = Integer.parseInt(request.getParameter("id"));
		QuanLyDAO dao = new QuanLyDAO();
		CTSV ctsv = dao.selectCTSV(idctsv);
		request.setAttribute("ctsv", ctsv);
		if(ctsv.getAnhCaNhan() != null) {
            String encodedImage = Base64.getEncoder().encodeToString(ctsv.getAnhCaNhan());
            request.setAttribute("encodedImage", encodedImage);
        }
		request.getRequestDispatcher("/Admin/CapNhatCTSV.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int idctsv = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String cccd = request.getParameter("cccd");
		String gioitinh = request.getParameter("gender");
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

		String sdt = request.getParameter("sdt");
		String email = request.getParameter("email");

		CTSV ctsv = new CTSV(idctsv, name, cccd, gioitinh, ngaySinh, sdt, email);
		dao.updateCTSV(ctsv);
		response.sendRedirect("quanlyctsv");
	}
}
