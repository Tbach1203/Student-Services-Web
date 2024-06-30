
package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import Models.CTSV;
import Models.HoatDong;
import Models.HocBong;
import Models.Khoa;
import Models.LopHoc;
import Models.QuanLy;
import Models.SinhVien;
import Models.TaiKhoan;
import Models.ToChuc;
import Util.HandleExeption;
import Util.JDBCUtil;

public class QuanLyDAO {
	// admin
	private static final String UPDATE_ADMIN_SQL = "UPDATE QUANLY SET HoTen=?,  NgaySinh=?, GioiTinh=?,CCCD=?,SDT=?, Email=?, AnhCaNhan=? WHERE ID_QuanLY = ? and TrangThai = 1";
	private static final String SELECT_ADMIN_BY_ID = "select * from QUANLY where ID_QuanLy =? and TrangThai = 1";

	// sv
	private static final String SELECT_SV_BY_ID = "select * from SINHVIEN where ID_SinhVien =? and TrangThai = 1";
	private static final String SELECT_ALL_SV = "select ID_SinhVien, HoTen, CCCD, GioiTinh, NgaySinh, SDT, Email, NamHoc, Khoa, ID_TaiKhoan, DiemRL, DiemCTXH, TrangThai from SINHVIEN where TrangThai = 1";
	private static final String UPDATE_SV_SQL = "update SINHVIEN set HoTen=?,  NgaySinh=?, GioiTinh=?,CCCD=?, NamHoc = ?, Khoa = ? where ID_SinhVien = ?";
	private static final String DELETE_SV_SQL = "UPDATE SINHVIEN SET TrangThai = 0 WHERE ID_SinhVien = ?";

	// ctsv
	private static final String INSERT_CTSV_SQL = "INSERT INTO CTSV"
			+ "(HoTen, CCCD, GioiTinh, NgaySinh, SDT, Email, ID_TaiKhoan) VALUES" + " (?, ?, ?, ?, ?, ?, ?)";
	private static final String SELECT_CTSV_BY_ID = "select * from CTSV where ID_CTSV =? and TrangThai = 1";
	private static final String SELECT_ALL_CTSV = "select ID_CTSV, HoTen, NgaySinh, GioiTinh, CCCD, SDT, Email from CTSV where TrangThai = 1";
	private static final String UPDATE_CTSV_SQL = "UPDATE CTSV SET HoTen=?, CCCD=?, GioiTinh=?, NgaySinh=?, SDT=?, Email=? WHERE ID_CTSV = ?";
	private static final String DELETE_CTSV_SQL = "UPDATE CTSV SET TrangThai = 0 WHERE ID_CTSV = ?";

	// khoa
	private static final String INSERT_KHOA_SQL = "INSERT INTO KHOA" + "  (TenKhoa) VALUES " + " (?)";
	private static final String SELECT_ALL_KHOA = "select * from KHOA where TrangThai = 1";
	private static final String DELETE_KHOA_SQL = "UPDATE KHOA SET TrangThai = 0 WHERE ID_Khoa = ?";

	// lophoc
	private static final String INSERT_LOPHOC_SQL = "INSERT INTO LOPHOC" + "  (MonHoc, TenLopHoc, TinChi, TrangThai) VALUES "
			+ " (?,?,?,1)";
	private static final String SELECT_ALL_LOPHOC = "select * from LOPHOC where TrangThai = 1";
	private static final String DELETE_LOPHOC_SQL = "UPDATE LOPHOC SET TrangThai = 0 WHERE ID_LopHoc = ?";

	// HoatDong
	private static final String INSERT_HOATDONG_SQL = "INSERT INTO HOATDONG"
			+ "  (TenHoatDong, NoiDung, DiemRL, DiemCTXH, NgayThamGia, ID_DichVu, TrangThai) VALUES " + " (?,?,?,?,?,?,1)";
	private static final String SELECT_ALL_HOATDONG = "select * from HOATDONG where TrangThai = 1";
	private static final String DELETE_HOATDONG_SQL = "UPDATE HOATDONG SET TrangThai = 0 WHERE ID_HoatDong = ?";

	// HocBong
	private static final String INSERT_HOCBONG_SQL = "INSERT INTO HOCBONG"
			+ "  (TenHocBong, NoiDung, DieuKien, SoLuong, TienThuong, ID_DichVu, TrangThai) VALUES " + " (?,?,?,?,?,?,1)";
	private static final String SELECT_ALL_HOCBONG = "select * from HOCBONG where SoLuong > 0";
	private static final String DELETE_HOCBONG_SQL = "UPDATE HOCBONG SET SoLuong = 0 WHERE ID_HocBong = ?";

	// TaiKhoan
	private static final String INSERT_TAIKHOAN_SQL = "INSERT INTO TAIKHOAN"
			+ "  (TaiKhoan, MatKhau, PhanQuyen) VALUES " + " (?,?,?)";
	
	//ToChuc
	private static final String INSERT_TOCHUC_SQL = "INSERT INTO TOCHUC"
			+ "  (ID_HoatDong, ID_Khoa, TrangThai) VALUES " + "(?,?,1)";

	// Admin
	public QuanLy selectAdmin(int idquanly) {
		QuanLy quanly = null;
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ADMIN_BY_ID);
			preparedStatement.setInt(1, idquanly);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID_QuanLy");
				String hoten = rs.getString("HoTen");
				String cccd = rs.getString("CCCD");
				String gioitinh = rs.getString("GioiTinh");
				Date ngaysinh = rs.getDate("NgaySinh");
				String sdt = rs.getString("SDT");
				String email = rs.getString("Email");
				int id_TaiKhoan = rs.getInt("ID_TaiKhoan");
				int trangthai = rs.getInt("TrangThai");
				quanly = new QuanLy(id, hoten, cccd, gioitinh, ngaysinh, sdt, email, id_TaiKhoan, trangthai);
				quanly.setAnhCaNhan(rs.getBytes("AnhCaNhan"));
			}
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return quanly;
	}

	public boolean updateAdmin(QuanLy quanly) {
		boolean rowUpdated = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(UPDATE_ADMIN_SQL);
			statement.setString(1, quanly.getHoTen());
			statement.setDate(2, new java.sql.Date(quanly.getNgaySinh().getTime()));
			statement.setString(3, quanly.getGioiTinh());
			statement.setString(4, quanly.getCCCD());
			statement.setString(5, quanly.getSDT());
			statement.setString(6, quanly.getEmail());
			statement.setBytes(7, quanly.getAnhCaNhan());
			statement.setInt(8, quanly.getID_QuanLy());
			rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return rowUpdated;
	}

	// SV
	public void insertSV(SinhVien sinhVien) {
		try (Connection conn = JDBCUtil.getConnection()) {
			String storedProcedure = "{CALL ThemSinhVien(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			try (CallableStatement cs = conn.prepareCall(storedProcedure)) {
				cs.setString(1, sinhVien.getHoTen());
				cs.setString(2, sinhVien.getCCCD());
				cs.setInt(3, sinhVien.getGioiTinh());
				cs.setDate(4, new java.sql.Date(sinhVien.getNgaySinh().getTime()));
				cs.setString(5, sinhVien.getSDT());
				cs.setString(6, sinhVien.getEmail());
				cs.setString(7, sinhVien.getNamHoc());
				cs.setInt(8, sinhVien.getKhoa());
				cs.setInt(9, sinhVien.getID_TaiKhoan());

				cs.executeUpdate();
			}
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
	}

	public boolean updateSV(SinhVien sinhvien) {
		boolean rowUpdated = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(UPDATE_SV_SQL);
			statement.setString(1, sinhvien.getHoTen());
			statement.setDate(2, new java.sql.Date(sinhvien.getNgaySinh().getTime()));
			statement.setInt(3, sinhvien.getGioiTinh());
			statement.setString(4, sinhvien.getCCCD());
			statement.setString(5, sinhvien.getNamHoc());
			statement.setInt(6, sinhvien.getKhoa());
			statement.setString(7, sinhvien.getID_SinhVien());
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
			System.out.println(preparedStatement);
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
				sinhvien.setAnhCaNhan(rs.getBytes("AnhCaNhan"));
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
				String tenKhoa = LayTenKhoaTheoID(khoa);
				int idTK = rs.getInt("ID_TaiKhoan");
				int diemRL = rs.getInt("DiemRL");
				int diemCTXH = rs.getInt("DiemCTXH");
				int trangthai = rs.getInt("TrangThai");
				SinhVien sv = new SinhVien(iD_SinhVien, hoTen, cCCD, gioiTinh, ngaySinh, sdt, email, namHoc, tenKhoa,
						idTK, diemRL, diemCTXH, trangthai);
				
				sinhviens.add(sv);
			}
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return sinhviens;
	}

	public boolean deleteSV(String id) {
		boolean rowDeleted = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(DELETE_SV_SQL);
			statement.setString(1, id);
			statement.executeUpdate();
			rowDeleted = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return rowDeleted;
	}

	// CTSV
	public void insertCTSV(CTSV ctsv) {
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_CTSV_SQL);
			preparedStatement.setString(1, ctsv.getHoTen());
			preparedStatement.setString(2, ctsv.getCCCD());
			preparedStatement.setString(3, ctsv.getGioiTinh());
			preparedStatement.setDate(4, new java.sql.Date(ctsv.getNgaySinh().getTime()));
			preparedStatement.setString(5, ctsv.getSDT());
			preparedStatement.setString(6, ctsv.getEmail());
			preparedStatement.setInt(7, ctsv.getID_TaiKhoan());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
	}

	public CTSV selectCTSV(int idctsv) {
		CTSV ctsv = null;
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_CTSV_BY_ID);
			preparedStatement.setInt(1, idctsv);
			ResultSet rs = preparedStatement.executeQuery();
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
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return ctsv;
	}

	public List<CTSV> selectAllCTSV() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<CTSV> ctsvs = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection conn = JDBCUtil.getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_CTSV);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int iD_SinhVien = rs.getInt("ID_CTSV");
				String hoTen = rs.getString("HoTen");
				String cCCD = rs.getString("CCCD");
				String gioiTinh = rs.getString("GioiTinh");
				Date ngaySinh = rs.getDate("NgaySinh");
				String sdt = rs.getString("SDT");
				String email = rs.getString("Email");
				ctsvs.add(new CTSV(iD_SinhVien, hoTen, cCCD, gioiTinh, ngaySinh, sdt, email));
			}
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return ctsvs;
	}

	public boolean updateCTSV(CTSV ctsv) {
		boolean rowUpdated = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(UPDATE_CTSV_SQL);
			statement.setString(1, ctsv.getHoTen());
			statement.setString(2, ctsv.getCCCD());
			statement.setString(3, ctsv.getGioiTinh());
			statement.setDate(4, new java.sql.Date(ctsv.getNgaySinh().getTime()));
			statement.setString(5, ctsv.getSDT());
			statement.setString(6, ctsv.getEmail());
			statement.setInt(7, ctsv.getID_CTSV());
			rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return rowUpdated;
	}

	public boolean deleteCTSV(int id) {
		boolean rowDeleted = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(DELETE_CTSV_SQL);
			statement.setInt(1, id);
			statement.executeUpdate();
			rowDeleted = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return rowDeleted;
	}

	// Khoa
	public void inserKhoa(Khoa khoa) {
		// try-with-resource statement will auto close the connection.
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_KHOA_SQL);
			preparedStatement.setString(1, khoa.getTenKhoa());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
	}

	public List<Khoa> selectAllKhoa() {

		List<Khoa> khoas = new ArrayList<>();

		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_KHOA);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int iDKhoa = rs.getInt("ID_Khoa");
				String tenKhoa = rs.getString("TenKhoa");
				int trangThai = rs.getInt("TrangThai");
				khoas.add(new Khoa(iDKhoa, tenKhoa, trangThai));
			}
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return khoas;
	}

	public boolean deleteKhoa(int id) {
		boolean rowDeleted = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(DELETE_KHOA_SQL);
			statement.setInt(1, id);
			statement.executeUpdate();
			rowDeleted = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return rowDeleted;
	}

	// LopHoc
	public void inserLopHoc(LopHoc lopHoc) {
		// try-with-resource statement will auto close the connection.
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_LOPHOC_SQL);
			preparedStatement.setString(1, lopHoc.getMonHoc());
			preparedStatement.setString(2, lopHoc.getTenLopHoc());
			preparedStatement.setInt(3, lopHoc.getTinChi());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
	}

	public List<LopHoc> selectAllLopHoc() {

		List<LopHoc> lopHocs = new ArrayList<>();

		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_LOPHOC);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int iDLopHoc = rs.getInt("ID_LopHoc");
				String monHoc = rs.getString("MonHoc");
				String tenLopHoc = rs.getString("TenLopHoc");
				int tinChi = rs.getInt("TinChi");
				int trangThai = rs.getInt("TrangThai");
				lopHocs.add(new LopHoc(iDLopHoc, monHoc, tenLopHoc, tinChi, trangThai));
			}
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return lopHocs;
	}

	public boolean deleteLopHoc(int id) {
		boolean rowDeleted = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(DELETE_LOPHOC_SQL);
			statement.setInt(1, id);
			statement.executeUpdate();
			rowDeleted = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return rowDeleted;
	}

	// HoatDong
	public void inserHoatDong(HoatDong hoatDong) {
		// try-with-resource statement will auto close the connection.
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_HOATDONG_SQL);
			preparedStatement.setString(1, hoatDong.getTenHoatDong());
			preparedStatement.setString(2, hoatDong.getNoiDung());
			preparedStatement.setInt(3, hoatDong.getDiemRL());
			preparedStatement.setInt(4, hoatDong.getDiemCTXH());
			preparedStatement.setDate(5, new java.sql.Date(hoatDong.getNgayThamGia().getTime()));
			preparedStatement.setInt(6, hoatDong.getID_DichVu());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
	}

	public List<HoatDong> selectAllHoatDong() {

		List<HoatDong> hoatDongs = new ArrayList<>();

		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_HOATDONG);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int idHoatDong = rs.getInt("ID_HoatDong");
				String tenHoatDong = rs.getString("TenHoatDong");
				String noiDung = rs.getString("NoiDung");
				int diemRL = rs.getInt("DiemRL");
				int diemCTXH = rs.getInt("DiemCTXH");
				Date ngayThamGia = rs.getDate("NgayThamGia");
				int idDichVu = rs.getInt("ID_DichVu");
				int trangThai = rs.getInt("TrangThai");
				hoatDongs.add(new HoatDong(idHoatDong, tenHoatDong, noiDung, diemRL, diemCTXH, ngayThamGia, idDichVu,
						trangThai));
			}
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return hoatDongs;
	}

	public boolean deleteHoatDong(int idHoatDong) {
		boolean rowDeleted = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(DELETE_HOATDONG_SQL);
			statement.setInt(1, idHoatDong);
			statement.executeUpdate();
			rowDeleted = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return rowDeleted;
	}

	// HocBong
	public void inserHocBong(HocBong hocBong) {
		// try-with-resource statement will auto close the connection.
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_HOCBONG_SQL);
			preparedStatement.setString(1, hocBong.getTenHocBong());
			preparedStatement.setString(2, hocBong.getNoiDung());
			preparedStatement.setFloat(3, hocBong.getDieuKien());
			preparedStatement.setInt(4, hocBong.getSoLuong());
			preparedStatement.setInt(5, hocBong.getTienThuong());
			preparedStatement.setInt(6, hocBong.getID_DichVu());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
	}

	public List<HocBong> selectAllHocBong() {

		List<HocBong> hocBongs = new ArrayList<>();

		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_HOCBONG);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int idHocBong = rs.getInt("ID_HocBong");
				String tenHocBong = rs.getString("TenHocBong");
				String noiDung = rs.getString("NoiDung");
				float dieuKien = rs.getFloat("DieuKien");
				int soLuong = rs.getInt("SoLuong");
				int tienThuong = rs.getInt("TienThuong");
				int idDichVu = rs.getInt("ID_DichVu");
				hocBongs.add(new HocBong(idHocBong, tenHocBong, noiDung, dieuKien, soLuong, tienThuong, idDichVu));
			}
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return hocBongs;
	}

	public boolean deleteHocBong(int idHocBong) {
		boolean rowDeleted = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(DELETE_HOCBONG_SQL);
			statement.setInt(1, idHocBong);
			statement.executeUpdate();
			rowDeleted = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return rowDeleted;
	}

	public String LayTenKhoaTheoID(int ID_Khoa) {
		String tenKhoa = null;

		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT TenKhoa FROM KHOA WHERE ID_Khoa = ?");
			preparedStatement.setInt(1, ID_Khoa);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				// Nếu có kết quả, lấy tên khoa
				tenKhoa = rs.getString("TenKhoa");
			}
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return tenKhoa;
	}

	public void insertTK(TaiKhoan taiKhoan) {
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_TAIKHOAN_SQL);
			preparedStatement.setString(1, taiKhoan.getTaiKhoan());
			preparedStatement.setString(2, taiKhoan.getMatKhau());
			preparedStatement.setString(3, taiKhoan.getPhanQuyen());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
	}

	public int LayIDTaiKhoan(String taiKhoan, String matKhau) {
		int idTK = 0;

		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn
					.prepareStatement("SELECT ID_TaiKhoan FROM TAIKHOAN WHERE TaiKhoan = ? AND MatKhau = ?");
			preparedStatement.setString(1, taiKhoan);
			preparedStatement.setString(2, matKhau);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				idTK = rs.getInt("ID_TaiKhoan");
			}
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return idTK;
	}

	public int LayIDQuanLy(String taiKhoan, String matKhau) {
		int idQuanLy = 0;

		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT ID_QuanLy FROM QUANLY WHERE ID_TaiKhoan IN (SELECT ID_TaiKhoan FROM TAIKHOAN WHERE TaiKhoan = ? AND MatKhau = ?)");
			preparedStatement.setString(1, taiKhoan);
			preparedStatement.setString(2, matKhau);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				// Nếu có kết quả, lấy tên khoa
				idQuanLy = rs.getInt("ID_QuanLy");
			}
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return idQuanLy;
	}
	
	public void insertToChuc(ToChuc toChuc) {
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_TOCHUC_SQL);
			preparedStatement.setInt(1, toChuc.getID_HoatDong());
			preparedStatement.setInt(2, toChuc.getID_Khoa());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
	}
	
	public int layIDHoatDong(HoatDong hoatDong) {
		int idHoatDong = 0;
		String sql = INSERT_HOATDONG_SQL;
	    try (Connection connection = JDBCUtil.getConnection();
	         PreparedStatement preparedStatement = connection.
	        prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

	    	preparedStatement.setString(1, hoatDong.getTenHoatDong());
			preparedStatement.setString(2, hoatDong.getNoiDung());
			preparedStatement.setInt(3, hoatDong.getDiemRL());
			preparedStatement.setInt(4, hoatDong.getDiemCTXH());
			preparedStatement.setDate(5, new java.sql.Date(hoatDong.getNgayThamGia().getTime()));
			preparedStatement.setInt(6, hoatDong.getID_DichVu());
	        
	        System.out.println(preparedStatement);
	        int affectedRows = preparedStatement.executeUpdate();
	        if (affectedRows > 0) {
	        	try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                	idHoatDong = generatedKeys.getInt(1);
	                } else {
	                    throw new SQLException("Không thể lấy ID được sinh ra.");
	                }
	            }
	        }
	    } catch (SQLException e) {
	        HandleExeption.printSQLException(e);
	    }
	    System.out.println(idHoatDong);

	    return idHoatDong;
	}

}
