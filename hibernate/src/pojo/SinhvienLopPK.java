package pojo;

import java.io.Serializable;
import java.util.Objects;

public class SinhvienLopPK implements Serializable {
    private String cmnd;
    private String maLop;
    private String hocKi;
    private String namHoc;

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
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
        SinhvienLopPK that = (SinhvienLopPK) o;
        return Objects.equals(cmnd, that.cmnd) && Objects.equals(maLop, that.maLop) && Objects.equals(hocKi, that.hocKi) && Objects.equals(namHoc, that.namHoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cmnd, maLop, hocKi, namHoc);
    }
}
