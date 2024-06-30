package Models;

import java.io.Serializable;
import java.util.Date;

public class HoatDong implements Serializable {
    private static final long serialVersionUID = 1L;

    private int ID_HoatDong;
    private String TenHoatDong;
    private String NoiDung;
    private int DiemRL;
    private int DiemCTXH;
    private Date NgayThamGia;
    private int ID_DichVu;
    private int TrangThai;

    public HoatDong() {
    }
    
    public HoatDong(String tenHoatDong, String noiDung, int diemRL, int diemCTXH, Date ngayThamGia, int iD_DichVu) {
		super();
		TenHoatDong = tenHoatDong;
		NoiDung = noiDung;
		DiemRL = diemRL;
		DiemCTXH = diemCTXH;
		NgayThamGia = ngayThamGia;
		ID_DichVu = iD_DichVu;
	}

	public HoatDong(int iD_HoatDong, String tenHoatDong, String noiDung, int diemRL, int diemCTXH, Date ngayThamGia,
			int iD_DichVu, int trangThai) {
		super();
		ID_HoatDong = iD_HoatDong;
		TenHoatDong = tenHoatDong;
		NoiDung = noiDung;
		DiemRL = diemRL;
		DiemCTXH = diemCTXH;
		NgayThamGia = ngayThamGia;
		ID_DichVu = iD_DichVu;
		TrangThai = trangThai;
	}

    public int getID_HoatDong() {
        return ID_HoatDong;
    }

    public void setID_HoatDong(int ID_HoatDong) {
        this.ID_HoatDong = ID_HoatDong;
    }

    public String getTenHoatDong() {
        return TenHoatDong;
    }

    public void setTenHoatDong(String TenHoatDong) {
        this.TenHoatDong = TenHoatDong;
    }
    
    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
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

    public Date getNgayThamGia() {
        return NgayThamGia;
    }

    public void setNgayThamGia(Date NgayThamGia) {
        this.NgayThamGia = NgayThamGia;
    }

    public int getID_DichVu() {
        return ID_DichVu;
    }

    public void setID_DichVu(int ID_DichVu) {
        this.ID_DichVu = ID_DichVu;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

	
}
