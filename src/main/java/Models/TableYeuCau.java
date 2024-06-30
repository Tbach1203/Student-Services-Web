package Models;

import java.io.Serializable;
import java.util.Date;

public class TableYeuCau implements Serializable {
    private static final long serialVersionUID = 1L;

    private int ID_YeuCau;
    private String TrangThai;
    private Date ThoiGianGui;
    private String ID_SinhVien;
    private int ID_DichVu;
    private String TenDichVu;

    public TableYeuCau() {
    }

    public int getID_YeuCau() {
        return ID_YeuCau;
    }

    public void setID_YeuCau(int ID_YeuCau) {
        this.ID_YeuCau = ID_YeuCau;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public Date getThoiGianGui() {
        return ThoiGianGui;
    }

    public void setThoiGianGui(Date ThoiGianGui) {
        this.ThoiGianGui = ThoiGianGui;
    }

    public String getID_SinhVien() {
        return ID_SinhVien;
    }

    public void setID_SinhVien(String ID_SinhVien) {
        this.ID_SinhVien = ID_SinhVien;
    }

    public int getID_DichVu() {
        return ID_DichVu;
    }

    public void setID_DichVu(int ID_DichVu) {
        this.ID_DichVu = ID_DichVu;
    }
    public String getTenDichVu() {
    	return TenDichVu;
    }
    public void setTenDichVu(String TenDichVu) {
    	this.TenDichVu = TenDichVu; 
    }
}
