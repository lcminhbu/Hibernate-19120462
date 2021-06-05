package pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class KydkhpPK implements Serializable {
    private Timestamp batDau;
    private String hocKi;
    private String namHoc;

    public Timestamp getBatDau() {
        return batDau;
    }

    public void setBatDau(Timestamp batDau) {
        this.batDau = batDau;
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
        KydkhpPK kydkhpPK = (KydkhpPK) o;
        return Objects.equals(batDau, kydkhpPK.batDau) && Objects.equals(hocKi, kydkhpPK.hocKi) && Objects.equals(namHoc, kydkhpPK.namHoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batDau, hocKi, namHoc);
    }
}
