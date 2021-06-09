package pojo;

import java.util.Objects;

public class Khoa {
    private String makhoa;
    private String tenkhoa;

    public String getMakhoa() {
        return makhoa;
    }

    public void setMakhoa(String makhoa) {
        this.makhoa = makhoa;
    }

    public String getTenkhoa() {
        return tenkhoa;
    }

    public void setTenkhoa(String tenkhoa) {
        this.tenkhoa = tenkhoa;
    }

    public Khoa(String makhoa, String tenkhoa) {
        this.makhoa = makhoa;
        this.tenkhoa = tenkhoa;
    }

    public Khoa(){}
}
