package Models;

import java.io.Serializable;
import java.util.Date;

public class CTSV implements Serializable {
    @Override
	public String toString() {
		return "CTSV [ID_CTSV=" + ID_CTSV + ", HoTen=" + HoTen + ", CCCD=" + CCCD + ", GioiTinh=" + GioiTinh
				+ ", NgaySinh=" + NgaySinh + ", SDT=" + SDT + ", Email=" + Email + ", ID_TaiKhoan=" + ID_TaiKhoan
				+ ", TrangThai=" + TrangThai + "]";
	}

	private static final long serialVersionUID = 1L;

    private int ID_CTSV;
    private String HoTen;
    private String CCCD;
    private String GioiTinh;
    private Date NgaySinh;
    private String SDT;
    private String Email;
    private int ID_TaiKhoan;
    private int TrangThai;
	private byte[] AnhCaNhan;
    
    public CTSV() {
    }
    
    public CTSV(int iD_CTSV, String hoTen, String cCCD, String gioiTinh, Date ngaySinh, String sDT, String email) {
		super();
		ID_CTSV = iD_CTSV;
		HoTen = hoTen;
		CCCD = cCCD;
		GioiTinh = gioiTinh;
		NgaySinh = ngaySinh;
		SDT = sDT;
		Email = email;
	}
    
	public CTSV(String hoTen, String cCCD, String gioiTinh, Date ngaySinh, String sDT, String email, int iD_TaiKhoan) {
		super();
		HoTen = hoTen;
		CCCD = cCCD;
		GioiTinh = gioiTinh;
		NgaySinh = ngaySinh;
		SDT = sDT;
		Email = email;
		ID_TaiKhoan = iD_TaiKhoan;
	}

	public CTSV(String hoTen, String cCCD, String gioiTinh, Date ngaySinh, String sDT, String email) {
		super();
		HoTen = hoTen;
		CCCD = cCCD;
		GioiTinh = gioiTinh;
		NgaySinh = ngaySinh;
		SDT = sDT;
		Email = email;
	}

	public CTSV(int ID_CTSV, String HoTen, String CCCD, String GioiTinh, Date NgaySinh, String SDT, String Email, int ID_TaiKhoan, int TrangThai) {
    	this.ID_CTSV = ID_CTSV;
    	this.HoTen = HoTen;
    	this.CCCD = CCCD;
    	this.GioiTinh = GioiTinh;
    	this.NgaySinh = NgaySinh;
    	this.SDT = SDT;
    	this.Email = Email;
    	this.ID_TaiKhoan = ID_TaiKhoan;
    	this.TrangThai = TrangThai;
    }
    

	public int getID_CTSV() {
        return ID_CTSV;
    }

    public void setID_CTSV(int ID_CTSV) {
        this.ID_CTSV = ID_CTSV;
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

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
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

    public int getID_TaiKhoan() {
        return ID_TaiKhoan;
    }

    public void setID_TaiKhoan(int ID_TaiKhoan) {
        this.ID_TaiKhoan = ID_TaiKhoan;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

	public byte[] getAnhCaNhan() {
		return AnhCaNhan;
	}

	public void setAnhCaNhan(byte[] anhCaNhan) {
		AnhCaNhan = anhCaNhan;
	}
}
