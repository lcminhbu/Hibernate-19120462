package pojo;

import java.util.Objects;

public class SinhvienLop {
    private SinhvienLopPK khoaChinh;
    private String hocki;
    private String namhoc;
    private String mamon;
    private String mahocphan;

    public SinhvienLopPK getKhoaChinh() { return khoaChinh; }

    public void setKhoaChinh(SinhvienLopPK khoaChinh) { this.khoaChinh = khoaChinh; }

    public String getHocki() {
        return hocki;
    }

    public void setHocki(String hocki) {
        this.hocki = hocki;
    }

    public String getNamhoc() {
        return namhoc;
    }

    public void setNamhoc(String namhoc) {
        this.namhoc = namhoc;
    }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    public String getMahocphan() {
        return mahocphan;
    }

    public void setMahocphan(String mahocphan) {
        this.mahocphan = mahocphan;
    }

    public SinhvienLop(SinhvienLopPK khoaChinh, String hocki, String namhoc, String mamon, String mahocphan) {
        this.khoaChinh = khoaChinh;
        this.hocki = hocki;
        this.namhoc = namhoc;
        this.mamon = mamon;
        this.mahocphan = mahocphan;
    }

    public SinhvienLop(){}
}
