package pojo;

import java.util.Objects;

public class Taikhoansinhvien {
    private String maSinhVien;
    private String cmnd;
    private String tk;
    private String mk;

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

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taikhoansinhvien that = (Taikhoansinhvien) o;
        return Objects.equals(maSinhVien, that.maSinhVien) && Objects.equals(cmnd, that.cmnd) && Objects.equals(tk, that.tk) && Objects.equals(mk, that.mk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSinhVien, cmnd, tk, mk);
    }
}
