package pojo;

import java.io.Serializable;
import java.util.Objects;

public class DangkyhocphanPK implements Serializable {
    private String cmnd;
    private String maHocPhan;
    private String hocKi;
    private String namHoc;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DangkyhocphanPK that = (DangkyhocphanPK) o;
        return Objects.equals(cmnd, that.cmnd) && Objects.equals(maHocPhan, that.maHocPhan) && Objects.equals(hocKi, that.hocKi) && Objects.equals(namHoc, that.namHoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cmnd, maHocPhan, hocKi, namHoc);
    }
}
