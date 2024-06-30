package Controllers;

import java.io.IOException;
 
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

import DAO.TaiKhoanDao;
import Utility.EmailUtility;
import java.util.Random;


@WebServlet("/GuiOTP")
public class GuiOTPController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String host;
    private String port;
    private String user;
    private String pass;

    public void init() {
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tk = request.getParameter("username");
		String email = request.getParameter("email");
		TaiKhoanDao tkDAO = new TaiKhoanDao();
		HttpSession session = request.getSession();
		boolean check = false;
		try {
			check = tkDAO.CheckTrueMail(tk, email);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(!check)
		{
			session.setAttribute("SendMessage", "Sai email");
            return;
		}
		Random random = new Random();
		int OTP = random.nextInt(900000) + 100000;
		
		session.setAttribute("TRUEOTP", String.valueOf(OTP));
		String subject = "OTP";
        String content = "Your OTP is "+ OTP + "; DO NOT SHARE THIS OTP";
        String resultMessage = "";
        try {
            EmailUtility.sendEmail(host, port, user, pass, email, subject,
                    content);
            resultMessage = "The e-mail was sent successfully to " + email;
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
        	session.setAttribute("SendMessage", resultMessage);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
