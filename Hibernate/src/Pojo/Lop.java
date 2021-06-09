package pojo;

import java.util.Objects;

public class Lop {
    private LopPK khoaChinh;
    private Integer tongsinhvien;
    private Integer tongsinhviennu;
    private Integer tongsinhviennam;

    public LopPK getKhoaChinh() { return khoaChinh; }

    public void setKhoaChinh(LopPK khoaChinh) { this.khoaChinh = khoaChinh; }

    public Integer getTongsinhvien() { return tongsinhvien; }

    public void setTongsinhvien(Integer tongsinhvien) { this.tongsinhvien = tongsinhvien; }

    public Integer getTongsinhviennu() { return tongsinhviennu; }

    public void setTongsinhviennu(Integer tongsinhviennu) { this.tongsinhviennu = tongsinhviennu; }

    public Integer getTongsinhviennam() { return tongsinhviennam; }

    public void setTongsinhviennam(Integer tongsinhviennam) { this.tongsinhviennam = tongsinhviennam; }

    public Lop(LopPK khoaChinh, Integer tongsinhvien, Integer tongsinhviennu, Integer tongsinhviennam) {
        this.khoaChinh = khoaChinh;
        this.tongsinhvien = tongsinhvien;
        this.tongsinhviennu = tongsinhviennu;
        this.tongsinhviennam = tongsinhviennam;
    }

    public Lop(){}
}
