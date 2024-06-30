package Controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.QuanLyDAO;
import Models.Khoa;
import Models.SinhVien;
import Models.TaiKhoan;

@WebServlet("/insertsv")
public class ThemSVControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private QuanLyDAO dao;

	public ThemSVControll() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		dao = new QuanLyDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<Khoa> khoaList = dao.selectAllKhoa();
		request.setAttribute("khoaList", khoaList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/ThemSV.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String tk = request.getParameter("taikhoan");
		String matKhau = request.getParameter("matkhau");
		String phanQuyen = "sinhvien";
		TaiKhoan taiKhoan = new TaiKhoan(tk, matKhau, phanQuyen);
		dao.insertTK(taiKhoan);
		
		String hoTen = request.getParameter("name");
		String cccd = request.getParameter("cccd");
		int gioiTinh = Integer.parseInt(request.getParameter("gender"));

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
		String namHoc = request.getParameter("khoaHoc");
		int khoa = Integer.parseInt(request.getParameter("khoa"));
		int id_TaiKhoan = dao.LayIDTaiKhoan(tk, matKhau);
		SinhVien sinhVien = new SinhVien(hoTen, cccd, gioiTinh, ngaySinh, sdt, email, namHoc, khoa, id_TaiKhoan);
		dao.insertSV(sinhVien);
		
		response.sendRedirect("quanlysinhvien");
	}

}
