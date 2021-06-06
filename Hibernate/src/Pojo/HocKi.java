package pojo;

import java.sql.Timestamp;

public class Hocki {
    private HockiPK khoaChinh;
    private Timestamp ngayBatDau;
    private Timestamp ngayKetThuc;
    private Byte hocKiHienTai;

    public HockiPK getKhoaChinh() { return khoaChinh; }

    public void setKhoaChinh(HockiPK khoaChinh) { this.khoaChinh = khoaChinh; }

    public Timestamp getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Timestamp ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Timestamp getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Timestamp ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Byte getHocKiHienTai() {
        return hocKiHienTai;
    }

    public void setHocKiHienTai(Byte hocKiHienTai) {
        this.hocKiHienTai = hocKiHienTai;
    }
}
