package pojo;

import java.util.Objects;

public class Hocphan {
    private String maHocPhan;
    private String hocKi;
    private String namHoc;
    private String tenHocPhan;
    private Integer soSlotToiDa;
    private String ngayHoc;
    private String caHoc;
    private String phongHoc;
    private Integer soTc;
    private String giaoVienLyThuyet;

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

    public String getTenHocPhan() {
        return tenHocPhan;
    }

    public void setTenHocPhan(String tenHocPhan) {
        this.tenHocPhan = tenHocPhan;
    }

    public Integer getSoSlotToiDa() {
        return soSlotToiDa;
    }

    public void setSoSlotToiDa(Integer soSlotToiDa) {
        this.soSlotToiDa = soSlotToiDa;
    }

    public String getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(String ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public String getCaHoc() {
        return caHoc;
    }

    public void setCaHoc(String caHoc) {
        this.caHoc = caHoc;
    }

    public String getPhongHoc() {
        return phongHoc;
    }

    public void setPhongHoc(String phongHoc) {
        this.phongHoc = phongHoc;
    }

    public Integer getSoTc() {
        return soTc;
    }

    public void setSoTc(Integer soTc) {
        this.soTc = soTc;
    }

    public String getGiaoVienLyThuyet() {
        return giaoVienLyThuyet;
    }

    public void setGiaoVienLyThuyet(String giaoVienLyThuyet) {
        this.giaoVienLyThuyet = giaoVienLyThuyet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hocphan hocphan = (Hocphan) o;
        return Objects.equals(maHocPhan, hocphan.maHocPhan) && Objects.equals(hocKi, hocphan.hocKi) && Objects.equals(namHoc, hocphan.namHoc) && Objects.equals(tenHocPhan, hocphan.tenHocPhan) && Objects.equals(soSlotToiDa, hocphan.soSlotToiDa) && Objects.equals(ngayHoc, hocphan.ngayHoc) && Objects.equals(caHoc, hocphan.caHoc) && Objects.equals(phongHoc, hocphan.phongHoc) && Objects.equals(soTc, hocphan.soTc) && Objects.equals(giaoVienLyThuyet, hocphan.giaoVienLyThuyet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maHocPhan, hocKi, namHoc, tenHocPhan, soSlotToiDa, ngayHoc, caHoc, phongHoc, soTc, giaoVienLyThuyet);
    }
}
