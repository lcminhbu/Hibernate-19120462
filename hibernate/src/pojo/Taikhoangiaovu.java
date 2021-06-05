package pojo;

import java.util.Objects;

public class Taikhoangiaovu {
    private String maGiaoVu;
    private String tk;
    private String mk;

    public String getMaGiaoVu() {
        return maGiaoVu;
    }

    public void setMaGiaoVu(String maGiaoVu) {
        this.maGiaoVu = maGiaoVu;
    }

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taikhoangiaovu that = (Taikhoangiaovu) o;
        return Objects.equals(maGiaoVu, that.maGiaoVu) && Objects.equals(tk, that.tk) && Objects.equals(mk, that.mk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maGiaoVu, tk, mk);
    }
}
