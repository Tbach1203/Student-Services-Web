package Models;

import java.io.Serializable;
import java.util.Date;

public class PhanHoi implements Serializable {
    private static final long serialVersionUID = 1L;

    private int ID_PhanHoi;
    private String NoiDung;
    private String TrangThai;
    private Date ThoiGianPH;
    private int ID_CTSV;
    private int ID_YeuCau;

    public PhanHoi() {
    }

    public int getID_PhanHoi() {
        return ID_PhanHoi;
    }

    public void setID_PhanHoi(int ID_PhanHoi) {
        this.ID_PhanHoi = ID_PhanHoi;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public Date getThoiGianPH() {
        return ThoiGianPH;
    }

    public void setThoiGianPH(Date ThoiGianPH) {
        this.ThoiGianPH = ThoiGianPH;
    }

    public int getID_CTSV() {
        return ID_CTSV;
    }

    public void setID_CTSV(int ID_CTSV) {
        this.ID_CTSV = ID_CTSV;
    }

    public int getID_YeuCau() {
        return ID_YeuCau;
    }

    public void setID_YeuCau(int ID_YeuCau) {
        this.ID_YeuCau = ID_YeuCau;
    }
}
