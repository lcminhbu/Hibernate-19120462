package pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class KidangkyhocphanPK implements Serializable {
    private String hocki;
    private String namhoc;
    private Timestamp thoigianbatdau;

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

    public Timestamp getThoigianbatdau() {
        return thoigianbatdau;
    }

    public void setThoigianbatdau(Timestamp thoigianbatdau) {
        this.thoigianbatdau = thoigianbatdau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KidangkyhocphanPK that = (KidangkyhocphanPK) o;
        return Objects.equals(hocki, that.hocki) && Objects.equals(namhoc, that.namhoc) && Objects.equals(thoigianbatdau, that.thoigianbatdau);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hocki, namhoc, thoigianbatdau);
    }
}
