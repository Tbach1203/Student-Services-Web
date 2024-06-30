package Controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.QuanLyDAO;
import Models.Khoa;
import Models.QuanLy;
import Models.SinhVien;

@WebServlet("/updatesv")
public class CapNhatSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuanLyDAO dao;

	public CapNhatSV() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		dao = new QuanLyDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String idsv = request.getParameter("id");
		QuanLyDAO dao = new QuanLyDAO();
		SinhVien sv = dao.selectSV(idsv);
		if(sv.getAnhCaNhan() != null) {
            String encodedImage = Base64.getEncoder().encodeToString(sv.getAnhCaNhan());
            request.setAttribute("encodedImage", encodedImage);
        }
		request.setAttribute("sv", sv);
		List<Khoa> khoaList = dao.selectAllKhoa();
		request.setAttribute("khoaList", khoaList);
		request.getRequestDispatcher("/Admin/CapNhatSV.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String idsv = request.getParameter("id");
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
		
		int gioitinh = Integer.parseInt(request.getParameter("gender"));
		String cccd = request.getParameter("cccd");
		int khoa = Integer.parseInt(request.getParameter("khoa"));
		String khoahoc = request.getParameter("khoaHoc");
		
		SinhVien sv = new SinhVien(idsv, name, ngaySinh, gioitinh, cccd, khoa, khoahoc);
		dao.updateSV(sv);
		response.sendRedirect("quanlysinhvien");

	}

}
