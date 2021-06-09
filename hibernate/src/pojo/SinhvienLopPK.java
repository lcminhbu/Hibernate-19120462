package pojo;

import java.io.Serializable;
import java.util.Objects;

public class SinhvienLopPK implements Serializable {
    private String masinhvien;
    private int id;

    public String getMasinhvien() {
        return masinhvien;
    }

    public void setMasinhvien(String masinhvien) {
        this.masinhvien = masinhvien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinhvienLopPK that = (SinhvienLopPK) o;
        return id == that.id && Objects.equals(masinhvien, that.masinhvien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(masinhvien, id);
    }
}
