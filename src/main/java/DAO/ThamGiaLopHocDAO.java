package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.LopHoc;
import Models.ThamGiaLopHoc;
import Util.HandleExeption;
import Util.JDBCUtil;

public class ThamGiaLopHocDAO {
	private static final String SELECT_SINHVIENLOPHOC = "SELECT ID_SinhVien, DiemQuaTrinh, DiemCuoiKy from ThamGiaLopHoc where ID_LopHoc = ? and TrangThai = 1;";
	private static final String UPDATE_DIEMSINHVIEN = "UPDATE thamgialophoc set DiemQuaTrinh = ?, DiemCuoiKy = ? Where ID_LopHoc = ? AND ID_SinhVien = ?;";
	
	public static List<ThamGiaLopHoc> selectSinhVienThamGia(int idLopHoc) throws SQLException {
	    List<ThamGiaLopHoc> dtSinhVienLop = new ArrayList<>();

	    try (
	        Connection connection = JDBCUtil.getConnection();
	    	PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SINHVIENLOPHOC);){
	        preparedStatement.setInt(1, idLopHoc);
	        ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	            ThamGiaLopHoc sinhvienlop = new ThamGiaLopHoc();
	            sinhvienlop.setIdSinhVien(rs.getString("ID_SinhVien"));
	            sinhvienlop.setDiemQuaTrinh(rs.getFloat("DiemQuaTrinh"));
	            sinhvienlop.setDiemCuoiKy(rs.getFloat("DiemCuoiKy"));
	            dtSinhVienLop.add(sinhvienlop);
	        }
	    }
	    return dtSinhVienLop;
	}
	public static void updateDiemSinhVien(int idLopHoc, String idSinhVien, float diemQT, float diemCK)
	{
		try (
		        Connection connection = JDBCUtil.getConnection();
		    	PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DIEMSINHVIEN);){
				preparedStatement.setFloat(1, diemQT);
				preparedStatement.setFloat(2, diemCK);
				preparedStatement.setInt(3, idLopHoc);
		        preparedStatement.setString(4, idSinhVien);
		        preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
            HandleExeption.printSQLException(e);
        }
	}
	public ThamGiaLopHocDAO() {
	}
	public List<ThamGiaLopHoc> getBangDiem(String mssv) throws ClassNotFoundException {
		List<ThamGiaLopHoc> bangDiem = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection
                .prepareStatement("select * from thamgialophoc where ID_SinhVien = ? and TrangThai = 1 ")) {
                preparedStatement.setString(1, mssv);

                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next())
                {
                	ThamGiaLopHoc tglh = new ThamGiaLopHoc();
                	tglh.setIdLopHoc(rs.getInt("ID_LopHoc"));
                	tglh.setDiemQuaTrinh(rs.getFloat("DiemQuaTrinh"));
                	tglh.setDiemCuoiKy(rs.getFloat("DiemCuoiKy"));
                	bangDiem.add(tglh);
                }

            } catch (SQLException e) {
                HandleExeption.printSQLException(e);
            }
        
        return bangDiem;
	}
}