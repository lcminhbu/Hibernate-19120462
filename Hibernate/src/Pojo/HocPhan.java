package pojo;

public class Hocphan {

    private HocphanPK khoaChinh;
    private String tenHocPhan;
    private Integer soSlotToiDa;
    private String ngayHoc;
    private String caHoc;
    private String phongHoc;
    private Integer soTc;
    private String giaoVienLyThuyet;

    public HocphanPK getKhoaChinh() { return khoaChinh; }

    public void setKhoaChinh(HocphanPK khoaChinh) { this.khoaChinh = khoaChinh; }

    public String getTenHocPhan() {
        return tenHocPhan;
    }

    public void setTenHocPhan(String tenHocPhan) {
        this.tenHocPhan = tenHocPhan;
    }

    public Integer getSoSlotToiDa() {
        return soSlotToiDa;
    }

    public void setSoSlotToiDa(Integer soSlotToiDa) {
        this.soSlotToiDa = soSlotToiDa;
    }

    public String getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(String ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public String getCaHoc() {
        return caHoc;
    }

    public void setCaHoc(String caHoc) {
        this.caHoc = caHoc;
    }

    public String getPhongHoc() {
        return phongHoc;
    }

    public void setPhongHoc(String phongHoc) {
        this.phongHoc = phongHoc;
    }

    public Integer getSoTc() {
        return soTc;
    }

    public void setSoTc(Integer soTc) {
        this.soTc = soTc;
    }

    public String getGiaoVienLyThuyet() {
        return giaoVienLyThuyet;
    }

    public void setGiaoVienLyThuyet(String giaoVienLyThuyet) {
        this.giaoVienLyThuyet = giaoVienLyThuyet;
    }

}
