package Pojo;

public class HocPhan {
	private String maHocPhan;
	private String hocKi;
	private String namHoc;
	private String tenHocPhan;
	private int soSlotToiDa;
	private String ngayHoc;
	private String caHoc;
	private String phongHoc;
	private int soTC;
	private String giaoVienLyThuyet;
	
	public HocPhan(String maHocPhan, String hocKi, String namHoc, String tenHocPhan, int soSlotToiDa, String ngayHoc,
			String caHoc, String phongHoc, int soTC, String giaoVienLyThuyet) {
		this.maHocPhan = maHocPhan;
		this.hocKi = hocKi;
		this.namHoc = namHoc;
		this.tenHocPhan = tenHocPhan;
		this.soSlotToiDa = soSlotToiDa;
		this.ngayHoc = ngayHoc;
		this.caHoc = caHoc;
		this.phongHoc = phongHoc;
		this.soTC = soTC;
		this.giaoVienLyThuyet = giaoVienLyThuyet;
	}
	public HocPhan() {
	}
	
	public String getMaHocPhan() {
		return maHocPhan;
	}
	public void setMaHocPhan(String maHocPhan) {
		this.maHocPhan = maHocPhan;
	}
	public String getHocKi() {
		return hocKi;
	}
	public void setHocKi(String hocKi) {
		this.hocKi = hocKi;
	}
	public String getNamHoc() {
		return namHoc;
	}
	public void setNamHoc(String namHoc) {
		this.namHoc = namHoc;
	}
	public String getTenHocPhan() {
		return tenHocPhan;
	}
	public void setTenHocPhan(String tenHocPhan) {
		this.tenHocPhan = tenHocPhan;
	}
	public int getSoSlotToiDa() {
		return soSlotToiDa;
	}
	public void setSoSlotToiDa(int soSlotToiDa) {
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
	public int getSoTC() {
		return soTC;
	}
	public void setSoTC(int soTC) {
		this.soTC = soTC;
	}
	public String getGiaoVienLyThuyet() {
		return giaoVienLyThuyet;
	}
	public void setGiaoVienLyThuyet(String giaoVienLyThuyet) {
		this.giaoVienLyThuyet = giaoVienLyThuyet;
	}
}
