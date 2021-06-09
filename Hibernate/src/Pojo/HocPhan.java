package pojo;

import java.util.Objects;

public class Hocphan {
    private HocphanPK khoaChinh;
    private Integer sotinchi;
    private String tenhocphan;
    private String giangvienlythuyet;
    private String phonghoc;
    private String ngayhoc;
    private String cahoc;
    private Integer soslottoida;

    public HocphanPK getKhoaChinh() { return khoaChinh; }

    public void setKhoaChinh(HocphanPK khoaChinh) { this.khoaChinh = khoaChinh; }

    public Integer getSotinchi() {
        return sotinchi;
    }

    public void setSotinchi(Integer sotinchi) {
        this.sotinchi = sotinchi;
    }

    public String getTenhocphan() {
        return tenhocphan;
    }

    public void setTenhocphan(String tenhocphan) {
        this.tenhocphan = tenhocphan;
    }

    public String getGiangvienlythuyet() {
        return giangvienlythuyet;
    }

    public void setGiangvienlythuyet(String giangvienlythuyet) {
        this.giangvienlythuyet = giangvienlythuyet;
    }

    public String getPhonghoc() {
        return phonghoc;
    }

    public void setPhonghoc(String phonghoc) {
        this.phonghoc = phonghoc;
    }

    public String getNgayhoc() {
        return ngayhoc;
    }

    public void setNgayhoc(String ngayhoc) {
        this.ngayhoc = ngayhoc;
    }

    public String getCahoc() {
        return cahoc;
    }

    public void setCahoc(String cahoc) {
        this.cahoc = cahoc;
    }

    public Integer getSoslottoida() {
        return soslottoida;
    }

    public void setSoslottoida(Integer soslottoida) {
        this.soslottoida = soslottoida;
    }

    public Hocphan(Integer sotinchi, String tenhocphan, String giangvienlythuyet, String phonghoc, String ngayhoc, String cahoc, Integer soslottoida) {
        this.sotinchi = sotinchi;
        this.tenhocphan = tenhocphan;
        this.giangvienlythuyet = giangvienlythuyet;
        this.phonghoc = phonghoc;
        this.ngayhoc = ngayhoc;
        this.cahoc = cahoc;
        this.soslottoida = soslottoida;
    }

    public Hocphan(){ };
}
