package pojo;

import java.sql.Timestamp;
import java.util.Objects;

public class SinhvienHocphan {
    private SinhvienHocphanPK khoaChinh;
    private String mahocphan;
    private Timestamp thoigiandangki;

    public SinhvienHocphanPK getKhoaChinh() {
        return khoaChinh;
    }

    public void setKhoaChinh(SinhvienHocphanPK khoaChinh) {
        this.khoaChinh = khoaChinh;
    }

    public String getMahocphan() {
        return mahocphan;
    }

    public void setMahocphan(String mahocphan) {
        this.mahocphan = mahocphan;
    }

    public Timestamp getThoigiandangki() {
        return thoigiandangki;
    }

    public void setThoigiandangki(Timestamp thoigiandangki) {
        this.thoigiandangki = thoigiandangki;
    }

    public SinhvienHocphan(SinhvienHocphanPK khoaChinh, String mahocphan, Timestamp thoigiandangki) {
        this.khoaChinh = khoaChinh;
        this.mahocphan = mahocphan;
        this.thoigiandangki = thoigiandangki;
    }

    public SinhvienHocphan(){}
}
