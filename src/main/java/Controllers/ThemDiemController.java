package Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import DAO.LopHocDAO;
import DAO.ThamGiaLopHocDAO;
import Models.LopHoc;
import Models.ThamGiaLopHoc;

/**
 * Servlet implementation class ThemDiemController
 */
@WebServlet("/ThemDiem")
public class ThemDiemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */ 
    public ThemDiemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<LopHoc> danhSachLopHoc = new ArrayList<>(); 
			danhSachLopHoc = LopHocDAO.selectLopHoc();
			
	        request.setAttribute("danhSachLopHoc", danhSachLopHoc);
 
	        int lopHoc = 0;
	        if(request.getParameter("lophoc") != null) {
				lopHoc = Integer.parseInt(request.getParameter("lophoc"));			
	        }
	        request.setAttribute("lopHoc", lopHoc);
	        HttpSession session = request.getSession();
			String maND = (String) session.getAttribute("maND");
	        int ctsvId = Integer.parseInt(maND);
	        request.setAttribute("ctsvId", ctsvId);
	        
	        List<ThamGiaLopHoc> DSSinhVienLop = new ArrayList<>();
	        
	        if (lopHoc != 0) {
	        	DSSinhVienLop = ThamGiaLopHocDAO.selectSinhVienThamGia(lopHoc);
	        }
	        request.setAttribute("DSSinhVienLop", DSSinhVienLop);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/CTSV/ThemDiem_CTSV.jsp");
	        dispatcher.forward(request, response);
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        StringBuilder jsonData = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonData.append(line);
        }
        JSONObject jsonObject = new JSONObject(jsonData.toString());
        int lopHoc = Integer.parseInt(jsonObject.getString("lopHoc"));
        String mssv = jsonObject.getString("mssv");
        float diemQT = Float.parseFloat(jsonObject.getString("diemQT"));
        float diemCK = Float.parseFloat(jsonObject.getString("diemCK"));
        
        ThamGiaLopHocDAO.updateDiemSinhVien(lopHoc, mssv, diemQT, diemCK);
	}

}
