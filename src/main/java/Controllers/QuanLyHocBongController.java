package Controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.QuanLyDAO;
import Models.HoatDong;
import Models.HocBong;
import Models.Khoa;


@WebServlet("/quanlyhocbong")
public class QuanLyHocBongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuanLyDAO dao;
    
    public QuanLyHocBongController() {
        super();

    }

	
	public void init(ServletConfig config) throws ServletException {
		dao = new QuanLyDAO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<HocBong> hocBongList = dao.selectAllHocBong();
		request.setAttribute("hocBongList", hocBongList);
		request.getRequestDispatcher("/Admin/QuanLyHocBong_Admin.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String tenHB = request.getParameter("tenHB");
		String noiDung = request.getParameter("noidung");
		float dieuKien = Float.parseFloat(request.getParameter("dieukien"));
		int soLuong = Integer.parseInt(request.getParameter("soluong"));
		int tienThuong = Integer.parseInt(request.getParameter("tienthuong"));
		int idDichVu = 1;
		HocBong hocBong = new HocBong(tenHB, noiDung, dieuKien, soLuong, tienThuong, idDichVu);
		dao.inserHocBong(hocBong);
		response.sendRedirect("quanlyhocbong");
	}

}
