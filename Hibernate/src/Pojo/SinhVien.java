package pojo;

import java.sql.Timestamp;
import java.util.Objects;

public class Sinhvien {
    private String maSinhVien;
    private String hoTen;
    private String diaChi;
    private Timestamp ngaySinh;
    private String gioi;
    private String khoaHoc;
    private String cmnd;

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Timestamp getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Timestamp ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioi() {
        return gioi;
    }

    public void setGioi(String gioi) {
        this.gioi = gioi;
    }

    public String getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sinhvien sinhvien = (Sinhvien) o;
        return Objects.equals(maSinhVien, sinhvien.maSinhVien) && Objects.equals(hoTen, sinhvien.hoTen) && Objects.equals(diaChi, sinhvien.diaChi) && Objects.equals(ngaySinh, sinhvien.ngaySinh) && Objects.equals(gioi, sinhvien.gioi) && Objects.equals(khoaHoc, sinhvien.khoaHoc) && Objects.equals(cmnd, sinhvien.cmnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSinhVien, hoTen, diaChi, ngaySinh, gioi, khoaHoc, cmnd);
    }
}
