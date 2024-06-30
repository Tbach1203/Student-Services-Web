package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.DichVu;
import Util.HandleExeption;
import Util.JDBCUtil;

public class DichVuDAO {

	public DichVuDAO() {
	}

	public List<DichVu> getDSDichVu() throws ClassNotFoundException {
	    List<DichVu> dsDichVu = new ArrayList<>();

	    try (Connection connection = JDBCUtil.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM DICHVU WHERE TrangThai=1")) {

	        System.out.println(preparedStatement);

	        try (ResultSet rs = preparedStatement.executeQuery()) {
	            while (rs.next()) {
	            	DichVu dichVu = new DichVu();
	                dichVu.setID_DichVu(rs.getInt("ID_DichVu"));
	                dichVu.setTenDichVu(rs.getString("TenDichVu"));
	                dichVu.setLoaiDichVu(rs.getString("LoaiDichVu"));
	                dichVu.setMoTaDichVu(rs.getString("MoTaDichVu"));
	                dichVu.setTrangThai(rs.getInt("TrangThai"));
	                dsDichVu.add(dichVu);
	            }
	        }
	    } catch (SQLException e) {
	        HandleExeption.printSQLException(e);
	    }

	    return dsDichVu;
	}
}
