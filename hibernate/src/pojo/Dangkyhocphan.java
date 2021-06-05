package pojo;

import java.sql.Timestamp;
import java.util.Objects;

public class Dangkyhocphan {
    private String maSinhVien;
    private String cmnd;
    private String maHocPhan;
    private String hocKi;
    private String namHoc;
    private Timestamp thoiGianDangKi;

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

    public String getMaHocPhan() {
        return maHocPhan;
    }

    public void setMaHocPhan(String maHocPhan) {
        this.maHocPhan = maHocPhan;
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

    public Timestamp getThoiGianDangKi() {
        return thoiGianDangKi;
    }

    public void setThoiGianDangKi(Timestamp thoiGianDangKi) {
        this.thoiGianDangKi = thoiGianDangKi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dangkyhocphan that = (Dangkyhocphan) o;
        return Objects.equals(maSinhVien, that.maSinhVien) && Objects.equals(cmnd, that.cmnd) && Objects.equals(maHocPhan, that.maHocPhan) && Objects.equals(hocKi, that.hocKi) && Objects.equals(namHoc, that.namHoc) && Objects.equals(thoiGianDangKi, that.thoiGianDangKi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSinhVien, cmnd, maHocPhan, hocKi, namHoc, thoiGianDangKi);
    }
}
