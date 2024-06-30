import java.util.List;

import DAO.QuanLyDAO;
import DAO.SinhVienDAO;
import Models.CTSV;
import Models.HoatDong;
import Models.Khoa;
import Models.LopHoc;
import Models.QuanLy;
import Models.SinhVien;
import DAO.TaiKhoanDao;

public class test {
	public static void main(String args[]) {
		QuanLyDAO dao = new QuanLyDAO();
		int a = dao.LayIDQuanLy("admin", "admin");
		/*
		 * List<Khoa> list = dao.selectAllKhoa(); Khoa a = dao.selectKhoa(1);
		 * 
		 * for (Khoa o : list) { System.out.println(o); }
		 */

		 System.out.println(a); 

	}
}
