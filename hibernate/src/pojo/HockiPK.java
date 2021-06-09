package pojo;

import java.io.Serializable;
import java.util.Objects;

public class HockiPK implements Serializable {
    private String hocki;
    private String namhoc;

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
        HockiPK hockiPK = (HockiPK) o;
        return Objects.equals(hocki, hockiPK.hocki) && Objects.equals(namhoc, hockiPK.namhoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hocki, namhoc);
    }
}
