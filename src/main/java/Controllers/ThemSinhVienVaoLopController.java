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
import DAO.ThemSinhVienLopDao;
import Models.LopHoc;
import Models.SinhVien;
import Models.ThamGiaLopHoc;

/**
 * Servlet implementation class ThemSinhVienVaoLopController
 */
@WebServlet("/ThemSinhVien")    
public class ThemSinhVienVaoLopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemSinhVienVaoLopController() {
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
	        
	        List<SinhVien> DSSinhVien = new ArrayList<>();
	        
	        if (lopHoc != 0) {
	        	DSSinhVien = ThemSinhVienLopDao.selectDSLop(lopHoc);
	        }
	        request.setAttribute("DSSinhVien", DSSinhVien);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/CTSV/ThemSinhVienVaoLop_CTSV.jsp");
	        dispatcher.forward(request, response);
	        
		}
	        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			BufferedReader reader = request.getReader();
	        StringBuilder jsonData = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            jsonData.append(line);
	        } 
	        JSONObject jsonObject = new JSONObject(jsonData.toString());
	        
	        int lopHoc = Integer.parseInt(jsonObject.getString("lopHoc"));
	        String mssv = jsonObject.getString("mssv");
	        
	        
	        ThemSinhVienLopDao.addSVLop(lopHoc, mssv);
	        
		}
	    catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		
		BufferedReader reader = request.getReader();
        StringBuilder jsonData = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonData.append(line);
        } 
        JSONObject jsonObject = new JSONObject(jsonData.toString());
        int lopHoc = Integer.parseInt(jsonObject.getString("lopHoc"));
        String mssv = jsonObject.getString("mssv");
        
        
        ThemSinhVienLopDao.deleteSVLop(lopHoc, mssv);
	}
		    catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
