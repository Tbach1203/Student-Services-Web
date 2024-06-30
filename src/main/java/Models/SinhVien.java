package Models;

import java.io.Serializable;
import java.util.Date;

public class SinhVien implements Serializable {
	private static final long serialVersionUID = 1L;

	private String ID_SinhVien;
	private String HoTen;
	private String CCCD;
	private int GioiTinh;
	private Date NgaySinh;
	private String SDT;
	private String Email;
	private String NamHoc;
	private int Khoa;
	private int ID_TaiKhoan;
	private int DiemRL;
	private int DiemCTXH;
	private int TrangThai;
	private String DiaChi;
	private String tenKhoa;

	private byte[] AnhCaNhan;

	public SinhVien(String iD_SinhVien, String hoTen, String cCCD, int gioiTinh, Date ngaySinh, String sDT,
			String email, String namHoc, int khoa, int iD_TaiKhoan, int diemRL, int diemCTXH, int trangThai) {
		super();
		ID_SinhVien = iD_SinhVien;
		HoTen = hoTen;
		CCCD = cCCD;
		GioiTinh = gioiTinh;
		NgaySinh = ngaySinh;
		SDT = sDT;
		Email = email;
		NamHoc = namHoc;
		Khoa = khoa;
		ID_TaiKhoan = iD_TaiKhoan;
		DiemRL = diemRL;
		DiemCTXH = diemCTXH;
		TrangThai = trangThai;
	}
	
	

	public SinhVien(String iD_SinhVien, String hoTen, String cCCD, int gioiTinh, Date ngaySinh, String sDT,
			String email, String namHoc, String tenKhoa, int iD_TaiKhoan, int diemRL, int diemCTXH, int trangThai) {
		super();
		ID_SinhVien = iD_SinhVien;
		HoTen = hoTen;
		CCCD = cCCD;
		GioiTinh = gioiTinh;
		NgaySinh = ngaySinh;
		SDT = sDT;
		Email = email;
		NamHoc = namHoc;
		ID_TaiKhoan = iD_TaiKhoan;
		DiemRL = diemRL;
		DiemCTXH = diemCTXH;
		TrangThai = trangThai;
		this.tenKhoa = tenKhoa;
	}



	public SinhVien(String iD_SinhVien, String hoTen, Date ngaySinh, int gioiTinh, String cCCD, int khoa,
			String namHoc) {
		super();
		ID_SinhVien = iD_SinhVien;
		HoTen = hoTen;
		CCCD = cCCD;
		GioiTinh = gioiTinh;
		NgaySinh = ngaySinh;
		NamHoc = namHoc;
		Khoa = khoa;
	}

	public SinhVien(String hoTen, String cCCD, int gioiTinh, Date ngaySinh, String sDT, String email, String namHoc,
			int khoa, int iD_TaiKhoan) {
		super();
		HoTen = hoTen;
		CCCD = cCCD;
		GioiTinh = gioiTinh;
		NgaySinh = ngaySinh;
		SDT = sDT;
		Email = email;
		NamHoc = namHoc;
		Khoa = khoa;
		ID_TaiKhoan = iD_TaiKhoan;
	}

	public SinhVien() {
	}

	public String getID_SinhVien() {
		return ID_SinhVien;
	}

	public void setID_SinhVien(String ID_SinhVien) {
		this.ID_SinhVien = ID_SinhVien;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String HoTen) {
		this.HoTen = HoTen;
	}

	public String getCCCD() {
		return CCCD;
	}

	public void setCCCD(String CCCD) {
		this.CCCD = CCCD;
	}

	public int getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(int GioiTinh) {
		this.GioiTinh = GioiTinh;
	}

	public Date getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(Date NgaySinh) {
		this.NgaySinh = NgaySinh;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String SDT) {
		this.SDT = SDT;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getNamHoc() {
		return NamHoc;
	}

	public void setNamHoc(String NamHoc) {
		this.NamHoc = NamHoc;
	}

	public int getKhoa() {
		return Khoa;
	}

	public void setKhoa(int Khoa) {
		this.Khoa = Khoa;
	}

	public int getID_TaiKhoan() {
		return ID_TaiKhoan;
	}

	public void setID_TaiKhoan(int ID_TaiKhoan) {
		this.ID_TaiKhoan = ID_TaiKhoan;
	}

	public int getDiemRL() {
		return DiemRL;
	}

	public void setDiemRL(int DiemRL) {
		this.DiemRL = DiemRL;
	}

	public int getDiemCTXH() {
		return DiemCTXH;
	}

	public void setDiemCTXH(int DiemCTXH) {
		this.DiemCTXH = DiemCTXH;
	}

	public int getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(int TrangThai) {
		this.TrangThai = TrangThai;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public byte[] getAnhCaNhan() {
		return AnhCaNhan;
	}

	public void setAnhCaNhan(byte[] AnhCaNhan) {
		this.AnhCaNhan = AnhCaNhan;
	}

	public String getTenKhoa() {
		return tenKhoa;
	}

	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}

	@Override
	public String toString() {
		return "SinhVien [ID_SinhVien=" + ID_SinhVien + ", HoTen=" + HoTen + ", CCCD=" + CCCD + ", GioiTinh=" + GioiTinh
				+ ", NgaySinh=" + NgaySinh + ", SDT=" + SDT + ", Email=" + Email + ", NamHoc=" + NamHoc + ", Khoa="
				+ Khoa + ", ID_TaiKhoan=" + ID_TaiKhoan + ", DiemRL=" + DiemRL + ", DiemCTXH=" + DiemCTXH
				+ ", TrangThai=" + TrangThai + "]";
	}
}
