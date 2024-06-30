package Models;

import java.io.Serializable;

public class ThamGiaHD implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ID_SinhVien;
    private int ID_HoatDong;
    private int TrangThai;
    private int ID_YeuCau;

    public ThamGiaHD() {
    }

    public String getID_SinhVien() {
        return ID_SinhVien;
    }

    public void setID_SinhVien(String ID_SinhVien) {
        this.ID_SinhVien = ID_SinhVien;
    }

    public int getID_HoatDong() {
        return ID_HoatDong;
    }

    public void setID_HoatDong(int ID_HoatDong) {
        this.ID_HoatDong = ID_HoatDong;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

	public int getID_YeuCau() {
		return ID_YeuCau;
	}

	public void setID_YeuCau(int iD_YeuCau) {
		ID_YeuCau = iD_YeuCau;
	}
}
