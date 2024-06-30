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
import Models.Khoa;
import Models.ToChuc;

@WebServlet("/quanlyhoatdong")
public class QuanLyHoatDongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private QuanLyDAO dao;
    public QuanLyHoatDongController() {
        super();
        
    }

	public void init(ServletConfig config) throws ServletException {
		dao = new QuanLyDAO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<HoatDong> hoatDongList = dao.selectAllHoatDong();
		request.setAttribute("hoatDongList", hoatDongList);
		List<Khoa> khoaList = dao.selectAllKhoa();
		request.setAttribute("khoaList", khoaList);
		request.getRequestDispatcher("/Admin/QuanLyHoatDong_Admin.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String tenHD = request.getParameter("name");
		String noiDung = request.getParameter("noidung");
		int drl = Integer.parseInt(request.getParameter("drl"));
		int dctxh = Integer.parseInt(request.getParameter("diemctxh"));
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
		int idDichVu = 4;
		
		HoatDong hoatDong = new HoatDong(tenHD, noiDung, drl, dctxh, ngaySinh, idDichVu);
		int idHoatDong = dao.layIDHoatDong(hoatDong);
		int khoa = Integer.parseInt(request.getParameter("khoa"));
		ToChuc toChuc = new ToChuc(idHoatDong, khoa);
		dao.insertToChuc(toChuc);
		response.sendRedirect("quanlyhoatdong");	 
	}

}
