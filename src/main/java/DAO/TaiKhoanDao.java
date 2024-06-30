package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Util.HandleExeption;
import Util.JDBCUtil;
import Models.TaiKhoan;

import Models.CTSV;
import Models.SinhVien;
import Models.QuanLy;

public class TaiKhoanDao {

	public TaiKhoanDao() {
	}
	
	
	public int DangNhap(TaiKhoan tk) throws ClassNotFoundException {
		int status = -1;
	        Class.forName("com.mysql.jdbc.Driver");
	        try (Connection connection = JDBCUtil.getConnection();
	                // Step 2:Create a statement using connection object
	                PreparedStatement preparedStatement = connection
	                .prepareStatement("select * from taikhoan where TaiKhoan = ? and MatKhau = ? ")) {
	                preparedStatement.setString(1, tk.getTaiKhoan());
	                preparedStatement.setString(2, tk.getMatKhau());

	                System.out.println(preparedStatement);
	                ResultSet rs = preparedStatement.executeQuery();
	                rs.next();
	                status = rs.getInt("ID_TaiKhoan");

	            } catch (SQLException e) {
	                HandleExeption.printSQLException(e);
	            }
	            return status;
	}
		
	public String LayPhanQuyen(TaiKhoan tk)throws ClassNotFoundException {
		String phanQuyen = "";
		try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection
                .prepareStatement("select PhanQuyen from taikhoan where TaiKhoan = ?")) {
                preparedStatement.setString(1, tk.getTaiKhoan());

                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                rs.next();
                phanQuyen = rs.getString("PhanQuyen");

            } catch (SQLException e) {
                HandleExeption.printSQLException(e);
            }
		return phanQuyen;
	}
	public String MaNguoiDung(TaiKhoan tk)throws ClassNotFoundException {
		String maND = "";
		try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection
                .prepareStatement("select ID_"+tk.getPhanQuyen()
                +" from "+tk.getPhanQuyen()+" where ID_TaiKhoan = ?")) {
                preparedStatement.setInt(1, tk.getID_TaiKhoan());

                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                rs.next();
                if("sinhvien".equals(tk.getPhanQuyen()))
                	maND = rs.getString("ID_"+tk.getPhanQuyen());
                else
                	maND = String.valueOf(rs.getInt("ID_"+tk.getPhanQuyen()));

            } catch (SQLException e) {
                HandleExeption.printSQLException(e);
            }
		return maND;
	}

	public CTSV getCTSV(String maND)throws ClassNotFoundException {
		CTSV ctsv = new CTSV();
		
		try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection
                .prepareStatement("select * from ctsv where ID_CTSV = ? and TrangThai = 1")) {
                preparedStatement.setInt(1, Integer.parseInt(maND));

                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                rs.next();
                ctsv.setID_CTSV(Integer.parseInt(rs.getString("ID_CTSV")));
                ctsv.setHoTen(rs.getString("HoTen"));
                ctsv.setCCCD(rs.getString("CCCD"));
                ctsv.setGioiTinh(rs.getString("GioiTinh"));
                ctsv.setNgaySinh(rs.getDate("NgaySinh"));
                ctsv.setSDT(rs.getString("SDT"));
                ctsv.setEmail(rs.getString("Email"));

            } catch (SQLException e) {
                HandleExeption.printSQLException(e);
            }
            return ctsv;
	}
	
	public SinhVien getSinhVien(String maND) throws ClassNotFoundException {
	    SinhVien sinhVien = new SinhVien();
	    
	    try (Connection connection = JDBCUtil.getConnection();
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select * from SINHVIEN where ID_SinhVien = ? and TrangThai = 1")) {
	            preparedStatement.setString(1, maND);

	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            if (rs.next()) {
	                sinhVien.setID_SinhVien(rs.getString("ID_SinhVien"));
	                sinhVien.setHoTen(rs.getString("HoTen"));
	                sinhVien.setCCCD(rs.getString("CCCD"));
	                sinhVien.setGioiTinh(rs.getInt("GioiTinh"));
	                sinhVien.setNgaySinh(rs.getDate("NgaySinh"));
	                sinhVien.setSDT(rs.getString("SDT"));
	                sinhVien.setEmail(rs.getString("Email"));
	                sinhVien.setNamHoc(rs.getString("NamHoc"));
	                sinhVien.setKhoa(rs.getInt("Khoa"));
	                sinhVien.setDiemRL(rs.getInt("DiemRL"));
	                sinhVien.setDiemCTXH(rs.getInt("DiemCTXH"));
	                sinhVien.setDiaChi(rs.getString("DiaChi"));
	                sinhVien.setAnhCaNhan(rs.getBytes("AnhCaNhan"));
	            }

	        } catch (SQLException e) {
	            HandleExeption.printSQLException(e);
	        }
	        return sinhVien;
	}
	
	public QuanLy getQuanLy(String maND) throws ClassNotFoundException {
	    QuanLy quanLy = new QuanLy();
	    
	    try (Connection connection = JDBCUtil.getConnection();
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select * from QUANLY where ID_QuanLy = ?")) {
	            preparedStatement.setInt(1, Integer.parseInt(maND));

	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            if (rs.next()) {
	                quanLy.setID_QuanLy(rs.getInt("ID_QuanLy"));
	                quanLy.setHoTen(rs.getString("HoTen"));
	                quanLy.setCCCD(rs.getString("CCCD"));
	                quanLy.setGioiTinh(rs.getString("GioiTinh"));
	                quanLy.setNgaySinh(rs.getDate("NgaySinh"));
	                quanLy.setSDT(rs.getString("SDT"));
	                quanLy.setEmail(rs.getString("Email"));
	                quanLy.setID_TaiKhoan(rs.getInt("ID_TaiKhoan"));
	                quanLy.setTrangThai(rs.getInt("TrangThai"));
	                quanLy.setAnhCaNhan(rs.getBytes("AnhCaNhan"));
	            }

	        } catch (SQLException e) {
	            HandleExeption.printSQLException(e);
	        }
	        return quanLy;
	}
	
	public boolean updateSinhVien(SinhVien sinhvien)throws ClassNotFoundException {
		boolean status = false;
		
		try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("UPDATE SINHVIEN SET HoTen=?, CCCD=?, GioiTinh=?, NgaySinh=?, "
                                + "SDT=?, Email=?, DiaChi=?, AnhCaNhan=? WHERE ID_SinhVien = ?")) {

            preparedStatement.setString(1, sinhvien.getHoTen());
            preparedStatement.setString(2, sinhvien.getCCCD());
            preparedStatement.setInt(3, sinhvien.getGioiTinh());
            preparedStatement.setDate(4, new java.sql.Date(sinhvien.getNgaySinh().getTime()));
            preparedStatement.setString(5, sinhvien.getSDT());
            preparedStatement.setString(6, sinhvien.getEmail());
            preparedStatement.setString(7, sinhvien.getDiaChi());
            preparedStatement.setBytes(8, sinhvien.getAnhCaNhan());
            preparedStatement.setString(9, sinhvien.getID_SinhVien());

            int rowsAffected = preparedStatement.executeUpdate();
            status = rowsAffected > 0;

        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        }
		return status;
	}
	
	
	public int LayID_TaiKhoan(TaiKhoan tk)throws ClassNotFoundException {
		int ID = 0;
		try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection
                .prepareStatement("select ID_TaiKhoan from taikhoan where TaiKhoan = ?")) {
                preparedStatement.setString(1, tk.getTaiKhoan());

                ResultSet rs = preparedStatement.executeQuery();
                rs.next();
                ID = rs.getInt("ID_TaiKhoan");

            } catch (SQLException e) {
                HandleExeption.printSQLException(e);
            }
		return ID;
	}
	
	public boolean CheckTrueMail(String tk, String email)throws ClassNotFoundException {
		boolean status = false;
		TaiKhoan taikhoan = new TaiKhoan();
		taikhoan.setTaiKhoan(tk);
		String phanQuyen = this.LayPhanQuyen(taikhoan);
		taikhoan.setPhanQuyen(phanQuyen);
		try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection
                .prepareStatement("select * from taikhoan where TaiKhoan = ?")) {
                preparedStatement.setString(1, tk);

                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                rs.next();
                taikhoan.setID_TaiKhoan(rs.getInt("ID_TaiKhoan"));

            } catch (SQLException e) {
                HandleExeption.printSQLException(e);
            }
		String maND = this.MaNguoiDung(taikhoan);
		try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("Select * from " + phanQuyen +" where ID_"+phanQuyen +" = ?")) {

			if(phanQuyen.equals("sinhvien"))
				preparedStatement.setString(1, maND);
			else
				preparedStatement.setInt(1, Integer.parseInt(maND));

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
            	if(rs.getString("Email").equals(email))
            	{
            		status = true;
            		break;
            	}
            }

        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        }
		return status;		
				
	}
	
	public boolean updateMK(TaiKhoan tk)throws ClassNotFoundException {
		boolean status = false;
		
		try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("UPDATE TAIKHOAN SET MatKhau = ? WHERE TaiKhoan = ?")) {
			preparedStatement.setString(1, tk.getMatKhau());
			preparedStatement.setString(2, tk.getTaiKhoan());
            
            int rowsAffected = preparedStatement.executeUpdate();
            status = rowsAffected > 0;

        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        }
		return status;
	}
}
