package pojo;

import java.util.Objects;

public class Lop {
    private Integer soSv;
    private Integer soSvNu;
    private Integer soSvNam;
    private String tenLop;
    private String maLop;
    private String hocKi;
    private String namHoc;

    public Integer getSoSv() {
        return soSv;
    }

    public void setSoSv(Integer soSv) {
        this.soSv = soSv;
    }

    public Integer getSoSvNu() {
        return soSvNu;
    }

    public void setSoSvNu(Integer soSvNu) {
        this.soSvNu = soSvNu;
    }

    public Integer getSoSvNam() {
        return soSvNam;
    }

    public void setSoSvNam(Integer soSvNam) {
        this.soSvNam = soSvNam;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
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
        Lop lop = (Lop) o;
        return Objects.equals(soSv, lop.soSv) && Objects.equals(soSvNu, lop.soSvNu) && Objects.equals(soSvNam, lop.soSvNam) && Objects.equals(tenLop, lop.tenLop) && Objects.equals(maLop, lop.maLop) && Objects.equals(hocKi, lop.hocKi) && Objects.equals(namHoc, lop.namHoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(soSv, soSvNu, soSvNam, tenLop, maLop, hocKi, namHoc);
    }
}
