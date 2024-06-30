package Models;

import java.io.Serializable;

public class ThamGiaLopHoc implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idSinhVien;
    private int idLopHoc;
    private float diemQuaTrinh;
    private float diemCuoiKy;
    private int trangThai;
    
    public ThamGiaLopHoc() {
    }
    
    public ThamGiaLopHoc(String idSinhVien, int idLopHoc, float diemQuaTrinh, float diemCuoiKy, int trangThai) {
        this.idSinhVien = idSinhVien;
        this.idLopHoc = idLopHoc;
        this.diemQuaTrinh = diemQuaTrinh;
        this.diemCuoiKy = diemCuoiKy;
        this.trangThai = trangThai;
    }

    // getters and setters
    public String getID_SinhVien() {
        return idSinhVien;
    }

    public void setIdSinhVien(String idSinhVien) {
        this.idSinhVien = idSinhVien;
    }

    public int getID_LopHoc() {
        return idLopHoc;
    }

    public void setIdLopHoc(int idLopHoc) {
        this.idLopHoc = idLopHoc;
    }

    public float getDiemQuaTrinh() {
        return diemQuaTrinh;
    }

    public void setDiemQuaTrinh(float diemQuaTrinh) {
        this.diemQuaTrinh = diemQuaTrinh;
    }

    public float getDiemCuoiKy() {
        return diemCuoiKy;
    }

    public void setDiemCuoiKy(float diemCuoiKy) {
        this.diemCuoiKy = diemCuoiKy;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
