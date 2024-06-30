package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.SinhVien;
import Util.HandleExeption;
import Util.JDBCUtil;

public class SinhVienDAO {
	private static final String INSERT_SVS_SQL = "INSERT INTO sinhvien"
			+ "  (ID_SinhVien, HoTen, CCCD, GioiTinh, NgaySinh, SDT, Email, NamHoc, Khoa, DiemRL, DiemCTXH) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_SV_BY_ID = "select * where ID_SinhVien =?";
	private static final String SELECT_ALL_SV = "select ID_SinhVien, HoTen, CCCD, GioiTinh, NgaySinh, SDT, Email, NamHoc, Khoa, ID_TaiKhoan, DiemRL, DiemCTXH, TrangThai from SINHVIEN";
	private static final String DELETE_USERS_SQL = "delete from sinhvien where ID_SinhVien = ?;";
	private static final String UPDATE_SV_SQL = "update sinhvien set HoTen = ?, CCCD = ?, GioiTinh = ?, NgaySinh = ?, SDT = ?, Email = ?, NamHoc = ?, Khoa = ?, DiemRL = ?, DiemCTXH = ? where ID_SinhVien = ?;";

	public void insertUser(SinhVien sinhvien) throws SQLException {
		// try-with-resource statement will auto close the connection.
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_SVS_SQL);
			preparedStatement.setString(1, sinhvien.getHoTen());
			preparedStatement.setString(2, sinhvien.getCCCD());
			preparedStatement.setInt(3, sinhvien.getGioiTinh());
			preparedStatement.setDate(4, (Date) sinhvien.getNgaySinh());
			preparedStatement.setString(5, sinhvien.getSDT());
			preparedStatement.setString(6, sinhvien.getEmail());
			preparedStatement.setString(7, sinhvien.getNamHoc());
			preparedStatement.setInt(8, sinhvien.getKhoa());
			preparedStatement.setInt(9, sinhvien.getDiemRL());
			preparedStatement.setInt(10, sinhvien.getDiemCTXH());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
	}

	public boolean updateUser(SinhVien sinhvien) throws SQLException {
		boolean rowUpdated = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(UPDATE_SV_SQL);
			statement.setString(1, sinhvien.getHoTen());
			statement.setString(2, sinhvien.getCCCD());
			statement.setInt(3, sinhvien.getGioiTinh());
			statement.setDate(4, (Date) sinhvien.getNgaySinh());
			statement.setString(5, sinhvien.getSDT());
			statement.setString(6, sinhvien.getEmail());
			statement.setString(7, sinhvien.getNamHoc());
			statement.setInt(8, sinhvien.getKhoa());
			statement.setInt(9, sinhvien.getDiemRL());
			statement.setInt(10, sinhvien.getDiemCTXH());

			rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return rowUpdated;
	}

	public SinhVien selectSV(String iD_SinhVien) {
		SinhVien sinhvien = null;
		// Step 1: Establishing a Connection
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_SV_BY_ID);
			preparedStatement.setString(1, iD_SinhVien);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String hoTen = rs.getString("HoTen");
				String cCCD = rs.getString("CCCD");
				int gioiTinh = rs.getInt("GioiTinh");
				Date ngaySinh = rs.getDate("NgaySinh");
				String sdt = rs.getString("SDT");
				String email = rs.getString("Email");
				String namHoc = rs.getString("NamHoc");
				int khoa = rs.getInt("Khoa");
				int idTK = rs.getInt("ID_TaiKhoan");
				int diemRL = rs.getInt("DiemRL");
				int diemCTXH = rs.getInt("DiemCTXH");
				int trangthai = rs.getInt("TrangThai");
				sinhvien = new SinhVien(iD_SinhVien, hoTen, cCCD, gioiTinh, ngaySinh, sdt, email, namHoc, khoa, idTK,
						diemRL, diemCTXH, trangthai);
			}
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return sinhvien;
	}

	public List<SinhVien> selectAllSV() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<SinhVien> sinhviens = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection conn = JDBCUtil.getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_SV);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String iD_SinhVien = rs.getString("ID_SinhVien");
				String hoTen = rs.getString("HoTen");
				String cCCD = rs.getString("CCCD");
				int gioiTinh = rs.getInt("GioiTinh");
				Date ngaySinh = rs.getDate("NgaySinh");
				String sdt = rs.getString("SDT");
				String email = rs.getString("Email");
				String namHoc = rs.getString("NamHoc");
				int khoa = rs.getInt("Khoa");
				int idTK = rs.getInt("ID_TaiKhoan");
				int diemRL = rs.getInt("DiemRL");
				int diemCTXH = rs.getInt("DiemCTXH");
				int trangthai = rs.getInt("TrangThai");
				sinhviens.add(new SinhVien(iD_SinhVien, hoTen, cCCD, gioiTinh, ngaySinh, sdt, email, namHoc, khoa, idTK,
						diemRL, diemCTXH, trangthai));
			}
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return sinhviens;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(DELETE_USERS_SQL);
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return rowDeleted;
	}

}
