package pojo;

import java.io.Serializable;
import java.util.Objects;

public class HockiPK implements Serializable {
    private String tenHocKi;
    private String namHoc;

    public String getTenHocKi() {
        return tenHocKi;
    }

    public void setTenHocKi(String tenHocKi) {
        this.tenHocKi = tenHocKi;
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
        HockiPK hockiPK = (HockiPK) o;
        return Objects.equals(tenHocKi, hockiPK.tenHocKi) && Objects.equals(namHoc, hockiPK.namHoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenHocKi, namHoc);
    }
}
