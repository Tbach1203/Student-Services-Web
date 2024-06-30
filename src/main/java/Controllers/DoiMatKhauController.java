package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.TaiKhoanDao;
import Models.TaiKhoan;

@WebServlet("/DoiMatKhau")
public class DoiMatKhauController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TaiKhoanDAO = null;
       
    public DoiMatKhauController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String newPassword = request.getParameter("newPassword");
        
        TaiKhoan tk = new TaiKhoan();
        tk.setTaiKhoan(username);
        tk.setMatKhau(newPassword);
        TaiKhoanDao taikhoanDAO = new TaiKhoanDao();
        try {
			taikhoanDAO.updateMK(tk);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
