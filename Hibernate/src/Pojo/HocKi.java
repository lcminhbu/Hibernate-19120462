package pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Hocki {
    private HockiPK khoaChinh;
    private Timestamp thoigianbatdau;
    private Timestamp thoigianketthuc;
    private Byte hockihientai;
    private Set<Mon> monSet = new HashSet<Mon>(0);

    public HockiPK getKhoaChinh() { return khoaChinh; }

    public void setKhoaChinh(HockiPK khoaChinh) { this.khoaChinh = khoaChinh; }

    public Timestamp getThoigianbatdau() {
        return thoigianbatdau;
    }

    public void setThoigianbatdau(Timestamp thoigianbatdau) {
        this.thoigianbatdau = thoigianbatdau;
    }

    public Timestamp getThoigianketthuc() {
        return thoigianketthuc;
    }

    public void setThoigianketthuc(Timestamp thoigianketthuc) {
        this.thoigianketthuc = thoigianketthuc;
    }

    public Byte getHockihientai() {
        return hockihientai;
    }

    public void setHockihientai(Byte hockihientai) {
        this.hockihientai = hockihientai;
    }

    public Set<Mon> getMonSet() { return monSet; }

    public void setMonSet(Set<Mon> monSet) { this.monSet = monSet; }

    public Hocki() { }

    public Hocki(HockiPK khoaChinh, Timestamp thoigianbatdau, Timestamp thoigianketthuc, Byte hockihientai, Set<Mon> monSet) {
        this.khoaChinh = khoaChinh;
        this.thoigianbatdau = thoigianbatdau;
        this.thoigianketthuc = thoigianketthuc;
        this.hockihientai = hockihientai;
        this.monSet = monSet;
    }

    public String hocKiVaNam(){
        return this.khoaChinh.getHocki()+" "+this.khoaChinh.getNamhoc();
    }
}
