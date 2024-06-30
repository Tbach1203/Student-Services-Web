package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Khoa;
import Models.ToChuc;
import Util.HandleExeption;
import Util.JDBCUtil;

public class ToChucDAO {

	public ToChucDAO() {
	}
	public List<ToChuc> LayDSToChuc() throws ClassNotFoundException {
		List<ToChuc> dsToChuc = new ArrayList<>();
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = JDBCUtil.getConnection();
	        
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM TOCHUC")) {
	        System.out.println(preparedStatement);    
			ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	            	ToChuc tochuc = new ToChuc();
	            	tochuc.setID_Khoa(rs.getInt("ID_Khoa"));
	            	tochuc.setID_HoatDong(rs.getInt("ID_HoatDong"));
	            	tochuc.setTrangThai(rs.getInt("TrangThai"));
	            	tochuc.setKhoaTC();
	            	dsToChuc.add(tochuc);
	               }
	            } catch (SQLException e) {
	                HandleExeption.printSQLException(e);
	            }
		
		return dsToChuc;
	}
	
	public Khoa LayKhoaTC(int idKhoa)throws ClassNotFoundException {
		Khoa khoa = new Khoa();

		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = JDBCUtil.getConnection();
	        	PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM KHOA where ID_Khoa = ?")) {
			preparedStatement.setInt(1, idKhoa);
			System.out.println(preparedStatement);    
			ResultSet rs = preparedStatement.executeQuery();
	            
	            while (rs.next()) {
	            	khoa.setID_Khoa(rs.getInt("ID_Khoa"));
	            	khoa.setTenKhoa(rs.getString("TenKhoa"));
	            	khoa.setTrangThai(rs.getInt("TrangThai"));
	               }
	            } catch (SQLException e) {
	                HandleExeption.printSQLException(e);
	            }
		return khoa;
	}
}
