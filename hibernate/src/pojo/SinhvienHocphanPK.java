package pojo;

import java.io.Serializable;
import java.util.Objects;

public class SinhvienHocphanPK implements Serializable {
    private String masinhvien;
    private String hocki;
    private String namhoc;
    private String mamon;

    public String getMasinhvien() {
        return masinhvien;
    }

    public void setMasinhvien(String masinhvien) {
        this.masinhvien = masinhvien;
    }

    public String getHocki() {
        return hocki;
    }

    public void setHocki(String hocki) {
        this.hocki = hocki;
    }

    public String getNamhoc() {
        return namhoc;
    }

    public void setNamhoc(String namhoc) {
        this.namhoc = namhoc;
    }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinhvienHocphanPK that = (SinhvienHocphanPK) o;
        return Objects.equals(masinhvien, that.masinhvien) && Objects.equals(hocki, that.hocki) && Objects.equals(namhoc, that.namhoc) && Objects.equals(mamon, that.mamon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(masinhvien, hocki, namhoc, mamon);
    }
}
