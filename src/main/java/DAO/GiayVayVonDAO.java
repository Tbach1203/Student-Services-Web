package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.GiayVayVon;
import Util.HandleExeption;
import Util.JDBCUtil;

public class GiayVayVonDAO {

	public GiayVayVonDAO() {
	}
		public List<GiayVayVon> getDSGiayVay(String mssv) throws ClassNotFoundException 
		{
			List<GiayVayVon> dsGiayVay = new ArrayList<>();
			
			Class.forName("com.mysql.jdbc.Driver");
	        try (Connection connection = JDBCUtil.getConnection();
	        	PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM GIAYVAYVON WHERE ID_SinhVien = ?")) {

	            preparedStatement.setString(1, mssv);
	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	                GiayVayVon giayVayVon = new GiayVayVon();
	                giayVayVon.setID_GiayVay(rs.getInt("ID_GiayVay"));
	                giayVayVon.setNoiDung(rs.getString("NoiDung"));
	                giayVayVon.setNgayNhan(rs.getDate("NgayNhan"));
	                giayVayVon.setID_SinhVien(rs.getString("ID_SinhVien"));
	                giayVayVon.setID_DichVu(rs.getInt("ID_DichVu"));
	                giayVayVon.setSoTien(rs.getInt("SoTien"));
	                giayVayVon.setTrangThai(rs.getInt("TrangThai"));
	                giayVayVon.setID_YeuCau(rs.getInt("ID_YeuCau"));

	                dsGiayVay.add(giayVayVon);
	               }
	            } catch (SQLException e) {
	                HandleExeption.printSQLException(e);
	            }
			
			return dsGiayVay;
		}
		public List<GiayVayVon> getAllDSGiayVay() throws ClassNotFoundException 
		{
			List<GiayVayVon> dsGiayVay = new ArrayList<>();
			
			Class.forName("com.mysql.jdbc.Driver");
	        try (Connection connection = JDBCUtil.getConnection();
	        	PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM GIAYVAYVON")) {

	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	                GiayVayVon giayVayVon = new GiayVayVon();
	                giayVayVon.setID_GiayVay(rs.getInt("ID_GiayVay"));
	                giayVayVon.setNoiDung(rs.getString("NoiDung"));
	                giayVayVon.setNgayNhan(rs.getDate("NgayNhan"));
	                giayVayVon.setID_SinhVien(rs.getString("ID_SinhVien"));
	                giayVayVon.setID_DichVu(rs.getInt("ID_DichVu"));
	                giayVayVon.setSoTien(rs.getInt("SoTien"));
	                giayVayVon.setTrangThai(rs.getInt("TrangThai"));
	                giayVayVon.setID_YeuCau(rs.getInt("ID_YeuCau"));

	                dsGiayVay.add(giayVayVon);
	               }
	            } catch (SQLException e) {
	                HandleExeption.printSQLException(e);
	            }
			
			return dsGiayVay;
		}
		public boolean ThemGiayVayVon(GiayVayVon giayvay)throws ClassNotFoundException 
		{
			boolean status = false;
			String sql = "INSERT INTO GIAYVAYVON (NoiDung, NgayNhan, ID_SinhVien, ID_DichVu, SoTien, TrangThai, ID_YeuCau)\r\n"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		    try (Connection connection = JDBCUtil.getConnection();
		         PreparedStatement preparedStatement = connection.
		        prepareStatement(sql)) {

		    	preparedStatement.setString(1, giayvay.getNoiDung());
		    	preparedStatement.setDate(2, new java.sql.Date(giayvay.getNgayNhan().getTime()));
		        preparedStatement.setString(3, giayvay.getID_SinhVien());
		        preparedStatement.setInt(4, giayvay.getID_DichVu());
		        preparedStatement.setInt(5, giayvay.getSoTien());
		        preparedStatement.setInt(6, giayvay.getTrangThai());
		        preparedStatement.setInt(7, giayvay.getID_YeuCau());
		    	
		        System.out.println(preparedStatement);
		        int affectedRows = preparedStatement.executeUpdate();
		        status = (affectedRows > 0);
		    } catch (SQLException e) {
		        HandleExeption.printSQLException(e);
		    }

		    return status;
		}
}
