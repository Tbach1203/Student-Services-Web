package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.NhanHocBong;
import Util.HandleExeption;
import Util.JDBCUtil;

public class NhanHocBongDAO {

	public NhanHocBongDAO() {
	}
	public List<NhanHocBong> LayDSNhanHocBong() throws ClassNotFoundException {
		List<NhanHocBong> dshb = new ArrayList<>();
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = JDBCUtil.getConnection();
	        	PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM NHANHOCBONG Where TrangThai=1")) {
	        System.out.println(preparedStatement);    
			ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	            	NhanHocBong hb = new NhanHocBong();
	                hb.setID_HocBong(rs.getInt("ID_HocBong"));
	            	hb.setID_YeuCau(rs.getInt("ID_YeuCau"));
	            	hb.setTrangThai(rs.getInt("TrangThai"));
	            	dshb.add(hb);
	               }
	            } catch (SQLException e) {
	                HandleExeption.printSQLException(e);
	            }
		
		return dshb;
	}
	public boolean isDaNhanHocBong(String mssv, int ID_HocBong) throws ClassNotFoundException {
	    boolean status = false;
	    Class.forName("com.mysql.jdbc.Driver");

	    try (Connection connection = JDBCUtil.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(
	             "SELECT * FROM NHANHOCBONG nh " +
	             "JOIN YEUCAU y ON nh.ID_YeuCau = y.ID_YeuCau " +
	             "WHERE nh.ID_HocBong = ? AND y.ID_SinhVien = ?")) {
	        preparedStatement.setInt(1, ID_HocBong);
	        preparedStatement.setString(2, mssv);

	        System.out.println(preparedStatement);

	        try (ResultSet rs = preparedStatement.executeQuery()) {
	            status = rs.next();
	        }
	    } catch (SQLException e) {
	    	HandleExeption.printSQLException(e);
	    }

	    return status;
	}
	
	public boolean ThemNhanHocBong(NhanHocBong nhanhocbong)throws ClassNotFoundException {
	    boolean status = false;
	    Class.forName("com.mysql.jdbc.Driver");

	    try (Connection connection = JDBCUtil.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(
	             "INSERT INTO NHANHOCBONG (ID_HocBong, ID_YeuCau, TrangThai)\r\n"
	             + "VALUES (?, ?, ?);")) {
	    	preparedStatement.setInt(1, nhanhocbong.getID_HocBong());
	    	preparedStatement.setInt(2, nhanhocbong.getID_YeuCau());
	    	preparedStatement.setInt(3, nhanhocbong.getTrangThai());

	        System.out.println(preparedStatement);

	        int rowsAffected = preparedStatement.executeUpdate();
	        status = rowsAffected > 0;
	    } catch (SQLException e) {
	    	HandleExeption.printSQLException(e);
	    }

	    return status;
	}
	
}
