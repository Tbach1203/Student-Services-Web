package Models;

import java.io.Serializable;

public class DichVu implements Serializable {
    private static final long serialVersionUID = 1L;

    private int ID_DichVu;
    private String TenDichVu;
    private String MoTaDichVu;
    private String LoaiDichVu;
    private int TrangThai;

    public DichVu() {
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

    public String getMoTaDichVu() {
        return MoTaDichVu;
    }

    public void setMoTaDichVu(String MoTaDichVu) {
        this.MoTaDichVu = MoTaDichVu;
    }

    public String getLoaiDichVu() {
        return LoaiDichVu;
    }

    public void setLoaiDichVu(String LoaiDichVu) {
        this.LoaiDichVu = LoaiDichVu;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
}
