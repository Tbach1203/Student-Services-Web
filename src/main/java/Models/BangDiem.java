package Models;

import java.io.Serializable;

public class BangDiem implements Serializable {
    private static final long serialVersionUID = 1L;

    private int ID_BangDiem;
    private String LoaiDiem;
    private double Diem;

    public BangDiem() {
    }

    public int getID_BangDiem() {
        return ID_BangDiem;
    }

    public void setID_BangDiem(int ID_BangDiem) {
        this.ID_BangDiem = ID_BangDiem;
    }

    public String getLoaiDiem() {
        return LoaiDiem;
    }

    public void setLoaiDiem(String LoaiDiem) {
        this.LoaiDiem = LoaiDiem;
    }

    public double getDiem() {
        return Diem;
    }

    public void setDiem(double Diem) {
        this.Diem = Diem;
    }
}
