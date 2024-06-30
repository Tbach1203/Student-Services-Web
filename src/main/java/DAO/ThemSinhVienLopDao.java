package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.SinhVien;
import Models.ThamGiaLopHoc;
import Util.JDBCUtil;

public class ThemSinhVienLopDao {
	private static final String SELECT_DSLOP = "SELECT sv.ID_SinhVien, sv.HoTen FROM SINHVIEN sv INNER JOIN THAMGIALOPHOC tgl ON sv.ID_SinhVien = tgl.ID_SinhVien WHERE tgl.ID_LopHoc = ? AND tgl.TrangThai = 1;";
	private static final String DELETE_SVLOP = "UPDATE THAMGIALOPHOC SET TrangThai = 0 Where ID_LopHoc = ? and ID_SinhVien = ?;";
	private static final String ADD_SVLOP = "INSERT INTO THAMGIALOPHOC VALUES(?, ?, 0, 0, 1)";
	
	private static final String SELECTSINHVIEN = "SELECT * FROM SINHVIEN WHERE ID_SinhVien = ? and TrangThai = 1;";
	private static final String SELECT_SVLOP = "SELECT * FROM THAMGIALOPHOC WHERE ID_SinhVien = ? and ID_LopHoc = ?";
	private static final String UPDATETRANGTHAI = "UPDATE THAMGIALOPHOC SET TrangThai = 1 WHERE ID_SinhVien = ? and ID_LopHoc = ?;";
	public static List<SinhVien> selectDSLop(int idLopHoc) throws SQLException {
	    List<SinhVien> dtDSLop = new ArrayList<>();

	    try (
	        Connection connection = JDBCUtil.getConnection();
	    	PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DSLOP);){
	        preparedStatement.setInt(1, idLopHoc);
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	        	SinhVien sinhvienlop = new SinhVien();
	            sinhvienlop.setID_SinhVien(rs.getString("ID_SinhVien"));
	            sinhvienlop.setHoTen(rs.getString("HoTen"));
	            dtDSLop.add(sinhvienlop);
	        }
	    }
	    return dtDSLop;
	}
	
	public static void deleteSVLop(int idLopHoc, String idSV) throws SQLException {

	    try (
	        Connection connection = JDBCUtil.getConnection();
	    	PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SVLOP);){
	        preparedStatement.setInt(1, idLopHoc);
	        preparedStatement.setString(2, idSV);
	        preparedStatement.executeUpdate();

	    }
	}
	
	public static void addSVLop(int idLopHoc, String idSV) throws SQLException {

	    try (
	    		
	    		
	        Connection connection = JDBCUtil.getConnection();
	    		
	    	// CHECK STUDENT IS EXISTS
	    	PreparedStatement preparedStatement1 = connection.prepareStatement(SELECTSINHVIEN);
	    	PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_SVLOP);
	    	PreparedStatement preparedStatement3 = connection.prepareStatement(UPDATETRANGTHAI);
	    	PreparedStatement preparedStatement = connection.prepareStatement(ADD_SVLOP);)
	    	{
	    	preparedStatement1.setString(1, idSV);
	    	ResultSet rs = preparedStatement1.executeQuery();
	    	if(!rs.next()) {
	    		return; 
	    	}
	    	preparedStatement2.setString(1, idSV);
	    	preparedStatement2.setInt(2, idLopHoc);
	    	ResultSet rs1 = preparedStatement2.executeQuery();
	    	if(rs1.next()) {
	    		preparedStatement3.setString(1,idSV);
	    		preparedStatement3.setInt(2, idLopHoc);
	    		preparedStatement3.executeUpdate();
	    		return;
	    	}
	    
	    	preparedStatement.setString(1, idSV);
	        preparedStatement.setInt(2, idLopHoc);
	        preparedStatement.executeUpdate();

	    }
	   
	}
	
}
