package pojo;

import java.sql.Timestamp;

public class Sinhvien {

    private SinhvienPK khoaChinh;
    private String hoTen;
    private String diaChi;
    private Timestamp ngaySinh;
    private String gioi;
    private String khoaHoc;
    public SinhvienPK getKhoaChinh() { return khoaChinh; }

    public void setKhoaChinh(SinhvienPK khoaChinh) { this.khoaChinh = khoaChinh; }

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
}
