package Pojo;

import java.util.Date;

public class SinhVien {
	
	private String id;
	private String hoTen;
	private String diaChi;
	private Date ngaySinh;
	private String gioi;
	private String khoaHoc;
	private String cmnd;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getGioi() {
		return gioi;
	}
	public void setGioi(String gioi) {
		this.gioi = gioi;
	}
	public String getKhoaHoc() {
		return khoaHoc;
	}
	public void setKhoaHoc(String khoaHoc) {
		this.khoaHoc = khoaHoc;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	
	public SinhVien() {}
	public SinhVien(String id) {
		this.id=id;
	}
	public SinhVien(String id, String hoTen, String diaChi, Date ngaySinh, String gioi, String khoaHoc, String cmnd) {
		this.id = id;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.gioi = gioi;
		this.khoaHoc = khoaHoc;
		this.cmnd = cmnd;
	}
	
}
