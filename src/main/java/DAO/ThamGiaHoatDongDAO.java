package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.ThamGiaHD;
import Models.ToChuc;
import Util.HandleExeption;
import Util.JDBCUtil;

public class ThamGiaHoatDongDAO {

	public ThamGiaHoatDongDAO() {
	}
	public List<ThamGiaHD> LayDSThamGiaHD(String mssv) throws ClassNotFoundException {
		List<ThamGiaHD> dsThamGiaHD = new ArrayList<>();
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = JDBCUtil.getConnection();
	        	PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM thamgiahd where ID_SinhVien = ?")) {
			preparedStatement.setString(1, mssv);
			System.out.println(preparedStatement);    
			ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	            	ThamGiaHD tghd = new ThamGiaHD();
	            	tghd.setID_SinhVien(rs.getString("ID_SinhVien"));
	            	tghd.setID_HoatDong(rs.getInt("ID_HoatDong"));
	            	tghd.setTrangThai(rs.getInt("TrangThai"));
	            	tghd.setID_YeuCau(rs.getInt("ID_YeuCau"));
	            	dsThamGiaHD.add(tghd);
	               }
	            } catch (SQLException e) {
	                HandleExeption.printSQLException(e);
	            }
		
		return dsThamGiaHD;
	}
	public List<ThamGiaHD> LayDSThamGiaHD() throws ClassNotFoundException {
		List<ThamGiaHD> dsThamGiaHD = new ArrayList<>();
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = JDBCUtil.getConnection();
	        	PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM thamgiahd")) {
			
			System.out.println(preparedStatement);    
			ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	            	ThamGiaHD tghd = new ThamGiaHD();
	            	tghd.setID_SinhVien(rs.getString("ID_SinhVien"));
	            	tghd.setID_HoatDong(rs.getInt("ID_HoatDong"));
	            	tghd.setTrangThai(rs.getInt("TrangThai"));
	            	tghd.setID_YeuCau(rs.getInt("ID_YeuCau"));
	            	dsThamGiaHD.add(tghd);
	               }
	            } catch (SQLException e) {
	                HandleExeption.printSQLException(e);
	            }
		
		return dsThamGiaHD;
	}
	
	public boolean ThemThamGiaHD(ThamGiaHD thamgiahd) throws ClassNotFoundException {
		boolean status = false;
		String sql = "INSERT INTO ThamGiaHD (ID_SinhVien, ID_HoatDong, TrangThai, ID_YeuCau)\r\n"
				+ "VALUES (?, ?, ?, ?)";
	    try (Connection connection = JDBCUtil.getConnection();
	         PreparedStatement preparedStatement = connection.
	        prepareStatement(sql)) {

	    	preparedStatement.setString(1, thamgiahd.getID_SinhVien());
	    	preparedStatement.setInt(2, thamgiahd.getID_HoatDong());
	        preparedStatement.setInt(3, thamgiahd.getTrangThai());
	        preparedStatement.setInt(4, thamgiahd.getID_YeuCau());

	    	
	        System.out.println(preparedStatement);
	        int affectedRows = preparedStatement.executeUpdate();
	        status = (affectedRows > 0);
	    } catch (SQLException e) {
	        HandleExeption.printSQLException(e);
	    }

	    return status;
	}
}
