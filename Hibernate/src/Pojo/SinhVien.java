package pojo;

import java.sql.Timestamp;
import java.util.Objects;

public class Sinhvien {
    private String masinhvien;
    private String hoten;
    private String diachi;
    private String sdt;
    private String gioi;
    private Timestamp ngaysinh;
    private String makhoa;

    public String getMasinhvien() {
        return masinhvien;
    }

    public void setMasinhvien(String masinhvien) {
        this.masinhvien = masinhvien;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioi() {
        return gioi;
    }

    public void setGioi(String gioi) {
        this.gioi = gioi;
    }

    public Timestamp getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Timestamp ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getMakhoa() {
        return makhoa;
    }

    public void setMakhoa(String makhoa) {
        this.makhoa = makhoa;
    }

    public Sinhvien(String masinhvien, String hoten, String diachi, String sdt, String gioi, Timestamp ngaysinh, String makhoa) {
        this.masinhvien = masinhvien;
        this.hoten = hoten;
        this.diachi = diachi;
        this.sdt = sdt;
        this.gioi = gioi;
        this.ngaysinh = ngaysinh;
        this.makhoa = makhoa;
    }

    public Sinhvien(){}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sinhvien sinhvien = (Sinhvien) o;
        return Objects.equals(masinhvien, sinhvien.masinhvien) && Objects.equals(hoten, sinhvien.hoten) && Objects.equals(diachi, sinhvien.diachi) && Objects.equals(sdt, sinhvien.sdt) && Objects.equals(gioi, sinhvien.gioi) && Objects.equals(ngaysinh, sinhvien.ngaysinh) && Objects.equals(makhoa, sinhvien.makhoa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(masinhvien, hoten, diachi, sdt, gioi, ngaysinh, makhoa);
    }
}
