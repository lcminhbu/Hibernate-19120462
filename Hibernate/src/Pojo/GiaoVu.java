package pojo;

import java.sql.Timestamp;
import java.util.Objects;

public class Giaovu {
    private String maGiaoVu;
    private String hoTen;
    private String diaChi;
    private String gioi;
    private Timestamp ngaySinh;

    public String getMaGiaoVu() {
        return maGiaoVu;
    }

    public void setMaGiaoVu(String maGiaoVu) {
        this.maGiaoVu = maGiaoVu;
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

    public String getGioi() {
        return gioi;
    }

    public void setGioi(String gioi) {
        this.gioi = gioi;
    }

    public Timestamp getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Timestamp ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Giaovu giaovu = (Giaovu) o;
        return Objects.equals(maGiaoVu, giaovu.maGiaoVu) && Objects.equals(hoTen, giaovu.hoTen) && Objects.equals(diaChi, giaovu.diaChi) && Objects.equals(gioi, giaovu.gioi) && Objects.equals(ngaySinh, giaovu.ngaySinh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maGiaoVu, hoTen, diaChi, gioi, ngaySinh);
    }
}
