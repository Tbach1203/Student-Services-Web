package Models;

public class NhanHocBong {
    private int ID_HocBong;
    private int ID_YeuCau;
    private int TrangThai;

    public NhanHocBong() {
    }

    public NhanHocBong(int idHocBong, int idYeuCau, int trangThai) {
        this.setID_HocBong(idHocBong);
        this.setID_YeuCau(idYeuCau);
        this.setTrangThai(trangThai);
    }

	public int getID_HocBong() {
		return ID_HocBong;
	}

	public void setID_HocBong(int iD_HocBong) {
		ID_HocBong = iD_HocBong;
	}

	public int getID_YeuCau() {
		return ID_YeuCau;
	}

	public void setID_YeuCau(int iD_YeuCau) {
		ID_YeuCau = iD_YeuCau;
	}

	public int getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(int trangThai) {
		TrangThai = trangThai;
	}

}
