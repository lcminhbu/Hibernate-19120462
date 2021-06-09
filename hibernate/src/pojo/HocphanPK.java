package pojo;

import java.io.Serializable;
import java.util.Objects;

public class HocphanPK implements Serializable {
    private String mahocphan;
    private Mon mon;

    public String getMahocphan() {
        return mahocphan;
    }

    public void setMahocphan(String mahocphan) {
        this.mahocphan = mahocphan;
    }

    public Mon getMon() { return mon; }

    public void setMon(Mon mon) { this.mon = mon; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HocphanPK hocphanPK = (HocphanPK) o;
        return Objects.equals(mahocphan, hocphanPK.mahocphan) && Objects.equals(mon, hocphanPK.mon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mahocphan, mon);
    }
}
