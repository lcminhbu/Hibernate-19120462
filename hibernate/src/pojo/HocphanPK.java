package pojo;

import java.io.Serializable;
import java.util.Objects;

public class HocphanPK implements Serializable {
    private String maHocPhan;
    private String hocKi;
    private String namHoc;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HocphanPK hocphanPK = (HocphanPK) o;
        return Objects.equals(maHocPhan, hocphanPK.maHocPhan) && Objects.equals(hocKi, hocphanPK.hocKi) && Objects.equals(namHoc, hocphanPK.namHoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maHocPhan, hocKi, namHoc);
    }
}
