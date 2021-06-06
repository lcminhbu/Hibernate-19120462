package pojo;

import java.sql.Timestamp;
import java.util.Objects;

public class Dangkyhocphan {
    private String maSinhVien;
    private DangkyhocphanPK khoaChinh;

    public DangkyhocphanPK getKhoaChinh() {
        return khoaChinh;
    }

    public void setKhoaChinh(DangkyhocphanPK khoaChinh) {
        this.khoaChinh = khoaChinh;
    }

    private Timestamp thoiGianDangKi;

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public Timestamp getThoiGianDangKi() {
        return thoiGianDangKi;
    }

    public void setThoiGianDangKi(Timestamp thoiGianDangKi) {
        this.thoiGianDangKi = thoiGianDangKi;
    }

}
