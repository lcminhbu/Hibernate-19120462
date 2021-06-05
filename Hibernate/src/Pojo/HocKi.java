package pojo;

import java.sql.Timestamp;
import java.util.Objects;

public class Hocki {
    private String tenHocKi;
    private String namHoc;
    private Timestamp ngayBatDau;
    private Timestamp ngayKetThuc;
    private Byte hocKiHienTai;

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

    public Timestamp getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Timestamp ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Timestamp getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Timestamp ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Byte getHocKiHienTai() {
        return hocKiHienTai;
    }

    public void setHocKiHienTai(Byte hocKiHienTai) {
        this.hocKiHienTai = hocKiHienTai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hocki hocki = (Hocki) o;
        return Objects.equals(tenHocKi, hocki.tenHocKi) && Objects.equals(namHoc, hocki.namHoc) && Objects.equals(ngayBatDau, hocki.ngayBatDau) && Objects.equals(ngayKetThuc, hocki.ngayKetThuc) && Objects.equals(hocKiHienTai, hocki.hocKiHienTai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenHocKi, namHoc, ngayBatDau, ngayKetThuc, hocKiHienTai);
    }
}
