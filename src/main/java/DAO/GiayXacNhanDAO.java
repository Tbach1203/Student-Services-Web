package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.GiayXacNhan;
import Models.YeuCau;
import Util.HandleExeption;
import Util.JDBCUtil;

public class GiayXacNhanDAO {

	public GiayXacNhanDAO() {
	}
	
	public List<GiayXacNhan> getDSGiayXN(String mssv) throws ClassNotFoundException 
	{
		List<GiayXacNhan> dsGiayXN = new ArrayList<>();
		
		Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection
                .prepareStatement("select * from giayxacnhan where ID_SinhVien = ?")) {
        		preparedStatement.setString(1, mssv);
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    GiayXacNhan giayxn = new GiayXacNhan();
                    giayxn.setID_GiayXN(rs.getInt("ID_GiayXN"));
                    giayxn.setNoiDung(rs.getString("NoiDung"));
                    giayxn.setNgayNhan(rs.getDate("NgayNhan"));
                    giayxn.setID_SinhVien(rs.getString("ID_SinhVien"));
                    giayxn.setID_DichVu(rs.getInt("ID_DichVu"));
                    giayxn.setTrangThai(rs.getInt("TrangThai"));
                    giayxn.setID_YeuCau(rs.getInt("ID_YeuCau"));

                    dsGiayXN.add(giayxn);
                }
            } catch (SQLException e) {
                HandleExeption.printSQLException(e);
            }
		
		return dsGiayXN;
	}
	public List<GiayXacNhan> getAllDSGiayXN() throws ClassNotFoundException 
	{
		List<GiayXacNhan> dsGiayXN = new ArrayList<>();
		
		Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection
                .prepareStatement("select * from giayxacnhan")) {
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    GiayXacNhan giayxn = new GiayXacNhan();
                    giayxn.setID_GiayXN(rs.getInt("ID_GiayXN"));
                    giayxn.setNoiDung(rs.getString("NoiDung"));
                    giayxn.setNgayNhan(rs.getDate("NgayNhan"));
                    giayxn.setID_SinhVien(rs.getString("ID_SinhVien"));
                    giayxn.setID_DichVu(rs.getInt("ID_DichVu"));
                    giayxn.setTrangThai(rs.getInt("TrangThai"));
                    giayxn.setID_YeuCau(rs.getInt("ID_YeuCau"));

                    dsGiayXN.add(giayxn);
                }
            } catch (SQLException e) {
                HandleExeption.printSQLException(e);
            }
		
		return dsGiayXN;
	}
	public boolean ThemGiayXN(GiayXacNhan giayxn) throws ClassNotFoundException {
	    boolean status = false;
		String sql = "INSERT INTO GIAYXACNHAN (NoiDung, NgayNhan, ID_SinhVien, ID_DichVu, TrangThai, ID_YeuCau)\r\n"
				+ "VALUES (?, ?, ?, ?, 1, ?)";
	    try (Connection connection = JDBCUtil.getConnection();
	         PreparedStatement preparedStatement = connection.
	        prepareStatement(sql)) {

	        preparedStatement.setString(1, giayxn.getNoiDung());
	        preparedStatement.setDate(2, new java.sql.Date(giayxn.getNgayNhan().getTime()));
	        preparedStatement.setString(3, giayxn.getID_SinhVien());
	        preparedStatement.setInt(4, giayxn.getID_DichVu());
	        preparedStatement.setInt(5, giayxn.getID_YeuCau());
	        
	        System.out.println(preparedStatement);
	        int affectedRows = preparedStatement.executeUpdate();
	        status = (affectedRows > 0);
	    } catch (SQLException e) {
	        HandleExeption.printSQLException(e);
	    }

	    return status;
	}
	
}
