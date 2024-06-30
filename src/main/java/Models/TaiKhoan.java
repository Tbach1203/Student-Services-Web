package Models;

import java.io.Serializable;

public class TaiKhoan implements Serializable {
    private static final long serialVersionUID = 1L;

    private int ID_TaiKhoan;
    private String TaiKhoan;
    private String MatKhau;
    private String PhanQuyen;
    private int TrangThai;

    public TaiKhoan() {
    }
    

    public TaiKhoan(String taiKhoan, String matKhau, String phanQuyen) {
		super();
		TaiKhoan = taiKhoan;
		MatKhau = matKhau;
		PhanQuyen = phanQuyen;
	}


	public int getID_TaiKhoan() {
        return ID_TaiKhoan;
    }

    public void setID_TaiKhoan(int ID_TaiKhoan) {
        this.ID_TaiKhoan = ID_TaiKhoan;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getPhanQuyen() {
        return PhanQuyen;
    }

    public void setPhanQuyen(String PhanQuyen) {
        this.PhanQuyen = PhanQuyen;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
}
