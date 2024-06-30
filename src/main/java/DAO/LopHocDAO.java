package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Models.LopHoc;
import Models.ThamGiaLopHoc;
import Util.HandleExeption;
import Util.JDBCUtil;

public class LopHocDAO {
	public LopHocDAO(){}
	private static final String SELECT_LOPHOC = "SELECT ID_LopHoc, MonHoc, TinChi FROM LopHoc;";
	 public static List<LopHoc> selectLopHoc() throws SQLException {
	        List<LopHoc> dtLopHoc = new ArrayList<>();

	        try (Connection connection = JDBCUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOPHOC);
	             ResultSet rs = preparedStatement.executeQuery()) {

	            while (rs.next()) {
	            	LopHoc lopHoc = new LopHoc();
	            	lopHoc.setID_LopHoc(rs.getInt("ID_LopHoc"));
	                lopHoc.setMonHoc(rs.getString("MonHoc"));
	                lopHoc.setTinChi(rs.getInt("TinChi"));
	                dtLopHoc.add(lopHoc);
	            }
	        }
	        catch (SQLException exception) {
	            HandleExeption.printSQLException(exception);
	        }
	        return dtLopHoc;
	    }

		public List<LopHoc> getDSLopHoc(List<ThamGiaLopHoc> bangDiem) throws ClassNotFoundException 
		{
			List<LopHoc> dslophoc = new ArrayList<>();
			Class.forName("com.mysql.jdbc.Driver");
			for (ThamGiaLopHoc tglh : bangDiem) {
		        try (Connection connection = JDBCUtil.getConnection();
		                PreparedStatement preparedStatement = connection
		                .prepareStatement("select * from LopHoc where ID_LopHoc = ? and TrangThai = 1")) {
		                preparedStatement.setInt(1, tglh.getID_LopHoc());

		                System.out.println(preparedStatement);
		                ResultSet rs = preparedStatement.executeQuery();
		                rs.next();
		                LopHoc lophoc = new LopHoc();
		                lophoc.setID_LopHoc(rs.getInt("ID_LopHoc"));
		                lophoc.setMonHoc(rs.getString("MonHoc"));
		                lophoc.setTinChi(rs.getInt("TinChi"));
		                lophoc.setTenLopHoc(rs.getString("TenLopHoc"));
		                dslophoc.add(lophoc);
		            } catch (SQLException e) {
		                HandleExeption.printSQLException(e);
		            }
	        }
			
			return dslophoc;
		}
}
