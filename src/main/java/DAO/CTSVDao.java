package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import Models.CTSV;
import Util.HandleExeption;
import Util.JDBCUtil;
public class CTSVDao {
	public CTSVDao() {
		
	}
	private static final String SELECT_CTSV_BY_ID = "select ID_CTSV,HoTen,CCCD,GioiTinh,NgaySinh,SDT,Email,ID_TaiKhoan,TrangThai,AnhCaNhan from CTSV where ID_CTSV =?";
	private static final String UPDATE_CTSV_BY_ID = "UPDATE CTSV SET SDT = ?, Email = ?, AnhCaNhan= ? WHERE ID_CTSV = ?;";
	public static CTSV selectctsv(int CTSVId) {
        CTSV ctsv = null;
        // Step 1: Establishing a Connection
        try (Connection connection = JDBCUtil.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CTSV_BY_ID);) {
            preparedStatement.setLong(1, CTSVId);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
           
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("ID_CTSV");
                String hoten = rs.getString("HoTen");
                String cccd = rs.getString("CCCD");
                String gioitinh = rs.getString("GioiTinh");
                Date ngaysinh = rs.getDate("NgaySinh");
                String sdt = rs.getString("SDT");
                String email = rs.getString("Email");
                int id_TaiKhoan = rs.getInt("ID_TaiKhoan");
                int trangthai = rs.getInt("TrangThai");
                ctsv = new CTSV(id, hoten, cccd, gioitinh, ngaysinh, sdt, email, id_TaiKhoan, trangthai);
                ctsv.setAnhCaNhan(rs.getBytes("AnhCaNhan"));
            }
        } catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
        }
        return ctsv;
	}
	public static void updateThongTinCTSV(String SDT, String Email, int CTSVId, byte[] encodedImage)
	{
		try(Connection connection = JDBCUtil.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CTSV_BY_ID);){
			preparedStatement.setString(1, SDT); 
			preparedStatement.setString(2, Email);
			preparedStatement.setBytes(3, encodedImage);
			preparedStatement.setInt(4, CTSVId);
	            // Step 3: Execute the query or update query
	        preparedStatement.executeUpdate();
	           
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
        }
		
	}
}
