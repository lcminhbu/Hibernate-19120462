package pojo;

import java.sql.Timestamp;

public class Kydkhp {
    private KydkhpPK khoaChinh;

    public KydkhpPK getKhoaChinh() { return khoaChinh; }

    public void setKhoaChinh(KydkhpPK khoaChinh) { this.khoaChinh = khoaChinh; }

    private Timestamp ketThuc;

    public Timestamp getKetThuc() {
        return ketThuc;
    }

    public void setKetThuc(Timestamp ketThuc) {
        this.ketThuc = ketThuc;
    }

}
