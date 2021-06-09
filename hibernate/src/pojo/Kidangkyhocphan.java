package pojo;

import java.sql.Timestamp;
import java.util.Objects;

public class Kidangkyhocphan {
    private KidangkyhocphanPK khoaChinh;
    private Timestamp thoigianketthuc;

    public KidangkyhocphanPK getKhoaChinh() { return khoaChinh; }

    public void setKhoaChinh(KidangkyhocphanPK khoaChinh) { this.khoaChinh = khoaChinh; }

    public Timestamp getThoigianketthuc() {
        return thoigianketthuc;
    }

    public void setThoigianketthuc(Timestamp thoigianketthuc) {
        this.thoigianketthuc = thoigianketthuc;
    }

    public Kidangkyhocphan(KidangkyhocphanPK khoaChinh, Timestamp thoigianketthuc) {
        this.khoaChinh = khoaChinh;
        this.thoigianketthuc = thoigianketthuc;
    }

    public Kidangkyhocphan(){}
}
