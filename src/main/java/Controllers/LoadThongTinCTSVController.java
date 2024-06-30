package Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import DAO.CTSVDao;
import Models.CTSV;

/**
 * Servlet implementation class CTSVControllers
 */
@WebServlet("/ThongTin_CTSV")
public class LoadThongTinCTSVController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoadThongTinCTSVController() {
        super();
    }
    private CTSVDao ctsvDao;

    public void init() {
		ctsvDao = new CTSVDao();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String maND = (String) session.getAttribute("maND");
		int ctsvId = Integer.parseInt(maND);
        CTSV ctsv = CTSVDao.selectctsv(ctsvId);
        request.setAttribute("ctsv", ctsv); 
        if (ctsv.getAnhCaNhan() != null) {
			String encodedImage = Base64.getEncoder().encodeToString(ctsv.getAnhCaNhan());
			request.setAttribute("encodedImage", encodedImage);
		}
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CTSV/ThongTin_CTSV.jsp");
        dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String maND = (String) session.getAttribute("maND");
		int ctsvId = Integer.parseInt(maND);
		BufferedReader reader = request.getReader();
        StringBuilder jsonData = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonData.append(line);
        }
        JSONObject jsonObject = new JSONObject(jsonData.toString());
        String sdt = jsonObject.getString("sdt");
        String email = jsonObject.getString("email");
        String image = jsonObject.getString("encodedImage");
		String base64Image = image.replaceAll("data:image/\\w+;base64,", "");
		byte[] encodedImage = Base64.getDecoder().decode(base64Image);
        CTSVDao.updateThongTinCTSV(sdt, email, ctsvId, encodedImage);

	}

}
