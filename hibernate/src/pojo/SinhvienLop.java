package pojo;

import java.util.Objects;

public class SinhvienLop {
    private String maSinhVien;
    private String cmnd;
    private String maLop;
    private String hocKi;
    private String namHoc;

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getHocKi() {
        return hocKi;
    }

    public void setHocKi(String hocKi) {
        this.hocKi = hocKi;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinhvienLop that = (SinhvienLop) o;
        return Objects.equals(maSinhVien, that.maSinhVien) && Objects.equals(cmnd, that.cmnd) && Objects.equals(maLop, that.maLop) && Objects.equals(hocKi, that.hocKi) && Objects.equals(namHoc, that.namHoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSinhVien, cmnd, maLop, hocKi, namHoc);
    }
}
