package pojo;

import java.sql.Timestamp;
import java.util.Objects;

public class Kydkhp {
    private Timestamp batDau;
    private Timestamp ketThuc;
    private String hocKi;
    private String namHoc;

    public Timestamp getBatDau() {
        return batDau;
    }

    public void setBatDau(Timestamp batDau) {
        this.batDau = batDau;
    }

    public Timestamp getKetThuc() {
        return ketThuc;
    }

    public void setKetThuc(Timestamp ketThuc) {
        this.ketThuc = ketThuc;
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
        Kydkhp kydkhp = (Kydkhp) o;
        return Objects.equals(batDau, kydkhp.batDau) && Objects.equals(ketThuc, kydkhp.ketThuc) && Objects.equals(hocKi, kydkhp.hocKi) && Objects.equals(namHoc, kydkhp.namHoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batDau, ketThuc, hocKi, namHoc);
    }
}
