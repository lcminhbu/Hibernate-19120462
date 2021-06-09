package pojo;

import java.util.Objects;

public class Taikhoansinhvien {
    private Sinhvien sinhvien;
    private String taikhoan;
    private String matkhau;

    public Sinhvien getSinhvien() { return sinhvien; }

    public void setSinhvien(Sinhvien sinhvien) { this.sinhvien = sinhvien; }

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

    public Taikhoansinhvien(Sinhvien sinhvien, String taikhoan, String matkhau) {
        this.sinhvien = sinhvien;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
    }

    public Taikhoansinhvien(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taikhoansinhvien that = (Taikhoansinhvien) o;
        return Objects.equals(sinhvien, that.sinhvien) && Objects.equals(taikhoan, that.taikhoan) && Objects.equals(matkhau, that.matkhau);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sinhvien, taikhoan, matkhau);
    }
}
