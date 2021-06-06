package pojo;

import java.util.Objects;

public class SinhvienLop {
    private String maSinhVien;
    private SinhvienLopPK khoaChinh;

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public SinhvienLopPK getKhoaChinh() { return khoaChinh; }

    public void setKhoaChinh(SinhvienLopPK khoaChinh) { this.khoaChinh = khoaChinh; }
}
