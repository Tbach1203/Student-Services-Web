package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.HoatDong;
import Util.HandleExeption;
import Util.JDBCUtil;

public class HoatDongDAO {

	public HoatDongDAO() {
	}
	
	public List<HoatDong> LayDSHoatDong() throws ClassNotFoundException {
		List<HoatDong> dsHD = new ArrayList<>();
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = JDBCUtil.getConnection();
	        	PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM HOATDONG WHERE TrangThai=1")) {
	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	            	HoatDong hd = new HoatDong();
	                hd.setID_HoatDong(rs.getInt("ID_HoatDong"));
	            	hd.setTenHoatDong(rs.getString("TenHoatDong"));
	            	hd.setDiemRL(rs.getInt("DiemRL"));
	            	hd.setDiemCTXH(rs.getInt("DiemCTXH"));
	            	hd.setNgayThamGia(rs.getDate("NgayThamGia"));
	            	hd.setID_DichVu(rs.getInt("ID_DichVu"));
	            	hd.setTrangThai(rs.getInt("TrangThai"));
	            	hd.setNoiDung(rs.getString("NoiDung"));
	            	           
	            	dsHD.add(hd);
	               }
	            } catch (SQLException e) {
	                HandleExeption.printSQLException(e);
	            }
		
		return dsHD;
	}
	public static void UpdateThamGiaHD(int idYC, int idHD) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String idSV="";
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("Select * from YEUCAU where ID_YeuCau = ?")){
					preparedStatement.setInt(1, idYC);
					System.out.println(preparedStatement);
					ResultSet rs = preparedStatement.executeQuery();
					rs.next();
					idSV = rs.getString("ID_SinhVien");
				}	catch (SQLException e) {
		            HandleExeption.printSQLException(e);
		        }
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO THAMGIAHD "
						+ "(ID_SinhVien, ID_HoatDong, ID_YeuCau, TrangThai) value (?,?,?,1)")){
					preparedStatement.setString(1, idSV);
					preparedStatement.setInt(2, idHD);
					preparedStatement.setInt(3, idYC);
					System.out.println(preparedStatement);
					preparedStatement.executeUpdate();
				}	catch (SQLException e) {
		            HandleExeption.printSQLException(e);
		        }
		int diemRL =0;
		int diemCTXH =0;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("Select * from HOATDONG "
						+ "Where ID_HoatDong = ?")){
					preparedStatement.setInt(1, idHD);
					System.out.println(preparedStatement);
					ResultSet rs = preparedStatement.executeQuery();
					rs.next();
					diemRL = rs.getInt("DiemRL");
					diemCTXH = rs.getInt("DiemCTXH"); 
				}	catch (SQLException e) {
		            HandleExeption.printSQLException(e);
		        }
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("UPDATE SINHVIEN "
						+ "SET DiemRL = DiemRL + ?, DiemCTXH = DiemCTXH + ? Where ID_SinhVien = ?")){
					preparedStatement.setInt(1, diemRL);
					preparedStatement.setInt(2, diemCTXH);
					preparedStatement.setString(3, idSV);
					System.out.println(preparedStatement);
					preparedStatement.executeUpdate();
				}	catch (SQLException e) {
		            HandleExeption.printSQLException(e);
		        }
	}
}
