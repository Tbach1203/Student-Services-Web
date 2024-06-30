package Models;

import java.io.Serializable;

import DAO.ToChucDAO;

public class ToChuc implements Serializable {
    private static final long serialVersionUID = 1L;

    private int ID_HoatDong;
    private int ID_Khoa;
    private int TrangThai;
    private Khoa KhoaTC;

    public ToChuc() {
    }

    public ToChuc(int iD_HoatDong, int iD_Khoa) {
		super();
		ID_HoatDong = iD_HoatDong;
		ID_Khoa = iD_Khoa;
	}



	public int getID_HoatDong() {
        return ID_HoatDong;
    }

    public void setID_HoatDong(int ID_HoatDong) {
        this.ID_HoatDong = ID_HoatDong;
    }

    public int getID_Khoa() {
        return ID_Khoa;
    }

    public void setID_Khoa(int ID_Khoa) {
        this.ID_Khoa = ID_Khoa;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

	public Khoa getKhoaTC() {
		return KhoaTC;
	}

	public void setKhoaTC() {
		ToChucDAO tochucDAO = new ToChucDAO();
		try {
			KhoaTC = tochucDAO.LayKhoaTC(this.ID_Khoa);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
