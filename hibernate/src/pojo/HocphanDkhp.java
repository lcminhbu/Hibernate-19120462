package pojo;

import java.sql.Timestamp;
import java.util.Objects;

public class HocphanDkhp {
    private HocphanDkhpPK khoaChinh;
    private Timestamp thoigianbatdau;

    public HocphanDkhpPK getKhoaChinh() { return khoaChinh; }

    public void setKhoaChinh(HocphanDkhpPK khoaChinh) { this.khoaChinh = khoaChinh; }

    public Timestamp getThoigianbatdau() {
        return thoigianbatdau;
    }

    public void setThoigianbatdau(Timestamp thoigianbatdau) {
        this.thoigianbatdau = thoigianbatdau;
    }

    public HocphanDkhp(HocphanDkhpPK khoaChinh, Timestamp thoigianbatdau) {
        this.khoaChinh = khoaChinh;
        this.thoigianbatdau = thoigianbatdau;
    }

    public HocphanDkhp(){}
}
