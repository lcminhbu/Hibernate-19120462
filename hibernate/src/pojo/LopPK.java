package pojo;

import java.io.Serializable;
import java.util.Objects;

public class LopPK implements Serializable {
    private int id;
    private String hocki;
    private String namhoc;
    private String mamon;
    private String mahocphan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHocki() {
        return hocki;
    }

    public void setHocki(String hocki) {
        this.hocki = hocki;
    }

    public String getNamhoc() {
        return namhoc;
    }

    public void setNamhoc(String namhoc) {
        this.namhoc = namhoc;
    }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    public String getMahocphan() {
        return mahocphan;
    }

    public void setMahocphan(String mahocphan) {
        this.mahocphan = mahocphan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LopPK lopPK = (LopPK) o;
        return id == lopPK.id && Objects.equals(hocki, lopPK.hocki) && Objects.equals(namhoc, lopPK.namhoc) && Objects.equals(mamon, lopPK.mamon) && Objects.equals(mahocphan, lopPK.mahocphan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hocki, namhoc, mamon, mahocphan);
    }
}
