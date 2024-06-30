package DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.YeuCau;
import Util.HandleExeption;
import Util.JDBCUtil;

public class YeuCauDAO {

	public YeuCauDAO() {
	}
	
	public List<YeuCau> getDSYeuCau(String mssv) throws ClassNotFoundException {
	    List<YeuCau> dsYeuCau = new ArrayList<>();

	    try (Connection connection = JDBCUtil.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM yeucau WHERE ID_SinhVien = ?")) {

	        preparedStatement.setString(1, mssv);
	        System.out.println(preparedStatement);

	        try (ResultSet rs = preparedStatement.executeQuery()) {
	            while (rs.next()) {
	                YeuCau yeuCau = new YeuCau();
	                yeuCau.setID_YeuCau(rs.getInt("ID_YeuCau"));
	                yeuCau.setTrangThai(rs.getString("TrangThai"));
	                yeuCau.setThoiGianGui(rs.getDate("ThoiGianGui"));
	                yeuCau.setID_SinhVien(rs.getString("ID_SinhVien"));
	                yeuCau.setID_DichVu(rs.getInt("ID_DichVu"));

	                dsYeuCau.add(yeuCau);
	            }
	        }
	    } catch (SQLException e) {
	        HandleExeption.printSQLException(e);
	    }

	    return dsYeuCau;
	}

	public int ThemYeuCau(YeuCau yc) throws ClassNotFoundException {
		int status = -1;
		String sql = "INSERT INTO YEUCAU (TrangThai, ThoiGianGui, ID_SinhVien, ID_DichVu) VALUES (?,?,?,?) ";
	    try (Connection connection = JDBCUtil.getConnection();
	         PreparedStatement preparedStatement = connection.
	        prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

	        preparedStatement.setString(1, yc.getTrangThai());
	        preparedStatement.setDate(2, new java.sql.Date(yc.getThoiGianGui().getTime()));
	        preparedStatement.setString(3, yc.getID_SinhVien());
	        preparedStatement.setInt(4, yc.getID_DichVu());
	        
	        System.out.println(preparedStatement);
	        int affectedRows = preparedStatement.executeUpdate();
	        if (affectedRows > 0) {
	        	try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                	status = generatedKeys.getInt(1);
	                } else {
	                    throw new SQLException("Không thể lấy ID được sinh ra.");
	                }
	            }
	        }
	    } catch (SQLException e) {
	        HandleExeption.printSQLException(e);
	    }

	    return status;
	}
	public int SuaTrangThaiYeuCau(YeuCau yc) throws ClassNotFoundException {
		int status = -1;
		String sql = "UPDATE YEUCAU SET TrangThai = ? WHERE ID_YeuCau = ?";
	    try (Connection connection = JDBCUtil.getConnection();
	         PreparedStatement preparedStatement = connection.
	        prepareStatement(sql)) {

	        preparedStatement.setString(1, yc.getTrangThai());
	        preparedStatement.setInt(2, yc.getID_YeuCau());
	        
	        System.out.println(preparedStatement);
	        status = preparedStatement.executeUpdate();

	    } catch (SQLException e) {
	        HandleExeption.printSQLException(e);
	    }

	    return status;
	}
	public String LoaiDichVuYeuCau(int ID_YeuCau) throws ClassNotFoundException {
		String status = "";
		String sql = "SELECT D.LoaiDichVu " +
	             "FROM YEUCAU Y " +
	             "JOIN DICHVU D ON Y.ID_DichVu = D.ID_DichVu And Y.ID_YeuCau = ?";
	    try (Connection connection = JDBCUtil.getConnection();
	         PreparedStatement preparedStatement = connection.
	        prepareStatement(sql)) {

	        preparedStatement.setInt(1, ID_YeuCau);
	        
	        System.out.println(preparedStatement);
	        ResultSet rs = preparedStatement.executeQuery();
	        rs.next();
	        status = rs.getString("LoaiDichVu");
	    } catch (SQLException e) {
	        HandleExeption.printSQLException(e);
	    }

	    return status;
	}
}
