package Models;

import java.io.Serializable;
import java.util.Date;

public class GiayXacNhan implements Serializable {
    private static final long serialVersionUID = 1L;

    private int ID_GiayXN;
    private String NoiDung;
    private Date NgayNhan;
    private String ID_SinhVien;
    private int ID_DichVu;
    private int TrangThai;
    private int ID_YeuCau;

    public GiayXacNhan() {
    }

    public int getID_GiayXN() {
        return ID_GiayXN;
    }

    public void setID_GiayXN(int ID_GiayXN) {
        this.ID_GiayXN = ID_GiayXN;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    public Date getNgayNhan() {
        return NgayNhan;
    }

    public void setNgayNhan(Date NgayNhan) {
        this.NgayNhan = NgayNhan;
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

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getID_YeuCau() {
        return ID_YeuCau;
    }

    public void setID_YeuCau(int ID_YeuCau) {
        this.ID_YeuCau = ID_YeuCau;
    }
}
