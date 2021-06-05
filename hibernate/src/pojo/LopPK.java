package pojo;

import java.io.Serializable;
import java.util.Objects;

public class LopPK implements Serializable {
    private String maLop;
    private String hocKi;
    private String namHoc;

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
        LopPK lopPK = (LopPK) o;
        return Objects.equals(maLop, lopPK.maLop) && Objects.equals(hocKi, lopPK.hocKi) && Objects.equals(namHoc, lopPK.namHoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maLop, hocKi, namHoc);
    }
}
