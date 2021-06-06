package pojo;

public class Lop {
    private Integer soSv;
    private Integer soSvNu;
    private Integer soSvNam;
    private String tenLop;
    private LopPK khoaChinh;

    public Integer getSoSv() {
        return soSv;
    }

    public void setSoSv(Integer soSv) {
        this.soSv = soSv;
    }

    public Integer getSoSvNu() {
        return soSvNu;
    }

    public void setSoSvNu(Integer soSvNu) {
        this.soSvNu = soSvNu;
    }

    public Integer getSoSvNam() {
        return soSvNam;
    }

    public void setSoSvNam(Integer soSvNam) {
        this.soSvNam = soSvNam;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public LopPK getKhoaChinh() { return khoaChinh; }

    public void setKhoaChinh(LopPK khoaChinh) { this.khoaChinh = khoaChinh; }
}
