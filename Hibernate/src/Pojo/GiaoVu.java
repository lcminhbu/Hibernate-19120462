package pojo;

import java.sql.Timestamp;
import java.util.Objects;

public class Giaovu {
    private String magiaovu;
    private String hoten;
    private String diachi;
    private String sdt;
    private String gioi;
    private Timestamp ngaysinh;
    private String makhoa;

    public String getMagiaovu() {
        return magiaovu;
    }

    public void setMagiaovu(String magiaovu) {
        this.magiaovu = magiaovu;
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

    public Giaovu(String magiaovu, String hoten, String diachi, String sdt, String gioi, Timestamp ngaysinh, String makhoa) {
        this.magiaovu = magiaovu;
        this.hoten = hoten;
        this.diachi = diachi;
        this.sdt = sdt;
        this.gioi = gioi;
        this.ngaysinh = ngaysinh;
        this.makhoa = makhoa;
    }
    public Giaovu(){ }
}
