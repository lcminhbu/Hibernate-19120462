package pojo;

import java.io.Serializable;
import java.util.Objects;

public class SinhvienPK implements Serializable {
    private String maSinhVien;
    private String cmnd;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinhvienPK that = (SinhvienPK) o;
        return Objects.equals(maSinhVien, that.maSinhVien) && Objects.equals(cmnd, that.cmnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSinhVien, cmnd);
    }
}
