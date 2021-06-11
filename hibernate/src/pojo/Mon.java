package pojo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Mon {
    private String mamon;
    private Integer sotinchi;
    private String tenmon;
    private String makhoa;
    private Set<Hocki> hockiSet = new HashSet<Hocki>(0);


    public Set<Hocki> getHockiSet() { return hockiSet; }

    public void setHockiSet(Set<Hocki> hockiSet) { this.hockiSet = hockiSet; }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    public Integer getSotinchi() {
        return sotinchi;
    }

    public void setSotinchi(Integer sotinchi) {
        this.sotinchi = sotinchi;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public String getMakhoa() {
        return makhoa;
    }

    public void setMakhoa(String makhoa) {
        this.makhoa = makhoa;
    }

    public Mon(String mamon, Integer sotinchi, String tenmon, String makhoa, Set<Hocki> hockiSet) {
        this.mamon = mamon;
        this.sotinchi = sotinchi;
        this.tenmon = tenmon;
        this.makhoa = makhoa;
        this.hockiSet = hockiSet;
    }

    public Mon(){}
}
