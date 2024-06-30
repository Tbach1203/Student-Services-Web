package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import Models.PhanHoi;
import Models.TableYeuCau;
import Models.YeuCau;
import Util.HandleExeption;
import Util.JDBCUtil;

public class XuLyYeuCauDao {
	private static final String SELECTYEUCAU = "SELECT * FROM YEUCAU";
	private static final String XULYYEUCAU = "UPDATE YEUCAU SET TrangThai = ? WHERE ID_YeuCau = ?;";
	private static final String THEMPHANHOI = "INSERT INTO phanhoi(NoiDung, TrangThai, ThoiGianPH, ID_CTSV, ID_YeuCau) VALUES (?, ?, ?, ?, ?);";
//	private static final String SELECTNOIDUNGDICHVU = "SELECT NoiDung, C"
	public static List<YeuCau> selectDSYeuCau() throws SQLException {
	    List<YeuCau> dtDSYeuCau = new ArrayList<>();

	    try (
	        Connection connection = JDBCUtil.getConnection();
	    	PreparedStatement preparedStatement = connection.prepareStatement(SELECTYEUCAU);){
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	        	YeuCau yeucau = new YeuCau();
	        	yeucau.setID_YeuCau(rs.getInt("ID_YeuCau"));
	        	yeucau.setID_SinhVien(rs.getString("ID_SinhVien"));
	        	yeucau.setID_DichVu(rs.getInt("ID_DichVu"));
	        	yeucau.setThoiGianGui(rs.getDate("ThoiGianGui"));
	        	yeucau.setTrangThai(rs.getString("TrangThai"));
	            dtDSYeuCau.add(yeucau);
	        }
	    }
	    return dtDSYeuCau;
	}
	
	public static void themPhanHoi(PhanHoi phanhoi) throws SQLException {
	    try (
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(THEMPHANHOI)) {
	        preparedStatement.setString(1, phanhoi.getNoiDung());
	        preparedStatement.setString(2, phanhoi.getTrangThai());
	        preparedStatement.setDate(3, new Date(phanhoi.getThoiGianPH().getTime()));
	        preparedStatement.setInt(4, phanhoi.getID_CTSV());
	        preparedStatement.setInt(5, phanhoi.getID_YeuCau());
	        preparedStatement.executeUpdate();
	    } 
	}
	
}
