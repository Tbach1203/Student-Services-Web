package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.PhanHoi;
import Models.YeuCau;
import Util.HandleExeption;
import Util.JDBCUtil;

public class PhanHoiDAO {

	public PhanHoiDAO() {
	}
	public List<PhanHoi> getDSPhanHoi(String mssv) throws ClassNotFoundException {
	    List<PhanHoi> dsPhanHoi = new ArrayList<>();
	    List<YeuCau> dsYeuCau = new ArrayList<>();
	    YeuCauDAO yeucauDAO = new YeuCauDAO();
	    dsYeuCau = yeucauDAO.getDSYeuCau(mssv);

	    try (Connection connection = JDBCUtil.getConnection();) {
	        for (YeuCau yeuCau : dsYeuCau) {
	            try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM phanhoi WHERE ID_YeuCau = ?")) {
	                preparedStatement.setInt(1, yeuCau.getID_YeuCau());
	                System.out.println(preparedStatement);

	                try (ResultSet rs = preparedStatement.executeQuery()) {
	                    while (rs.next()) {
	                        PhanHoi phanhoi = new PhanHoi();
	                        phanhoi.setID_YeuCau(rs.getInt("ID_YeuCau"));
	                        phanhoi.setTrangThai(rs.getString("TrangThai"));
	                        phanhoi.setThoiGianPH(rs.getDate("ThoiGianPH"));
	                        phanhoi.setID_CTSV(rs.getInt("ID_CTSV"));
	                        phanhoi.setID_PhanHoi(rs.getInt("ID_PhanHoi"));
	                        phanhoi.setNoiDung(rs.getString("NoiDung"));
	                        dsPhanHoi.add(phanhoi);
	                    }
	                }
	            } catch (SQLException e) {
	                HandleExeption.printSQLException(e);
	            }
	        }
	    } catch (SQLException e) {
	        HandleExeption.printSQLException(e);
	    }

	    return dsPhanHoi;
	}

}
