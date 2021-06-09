package pojo;

import java.io.Serializable;
import java.util.Objects;

public class MonHockiPK implements Serializable {
    private String mamon;
    private String hocki;
    private String namhoc;

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonHockiPK that = (MonHockiPK) o;
        return Objects.equals(mamon, that.mamon) && Objects.equals(hocki, that.hocki) && Objects.equals(namhoc, that.namhoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mamon, hocki, namhoc);
    }
}
