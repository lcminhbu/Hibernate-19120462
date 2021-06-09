package pojo;

import java.util.Objects;

public class Taikhoangiaovu {
    private Giaovu giaovu;
    private String taikhoan;
    private String matkhau;

    public Giaovu getGiaovu() { return giaovu; }

    public void setGiaovu(Giaovu giaovu) { this.giaovu = giaovu; }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public Taikhoangiaovu(Giaovu giaovu, String taikhoan, String matkhau) {
        this.giaovu = giaovu;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
    }

    public Taikhoangiaovu(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taikhoangiaovu that = (Taikhoangiaovu) o;
        return Objects.equals(giaovu, that.giaovu) && Objects.equals(taikhoan, that.taikhoan) && Objects.equals(matkhau, that.matkhau);
    }

    @Override
    public int hashCode() {
        return Objects.hash(giaovu, taikhoan, matkhau);
    }
}
