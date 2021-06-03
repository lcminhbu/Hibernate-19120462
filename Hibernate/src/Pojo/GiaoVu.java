package Pojo;

import java.util.Date;

public class GiaoVu {
	private String id;
	private String hoTen;
	private String diaChi;
	private String gioi;
	private Date ngaySinh;
	
	public GiaoVu() {}
	public GiaoVu(String id, String hoTen, String diaChi, String gioi, Date ngaySinh) {
		this.id = id;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.gioi = gioi;
		this.ngaySinh = ngaySinh;
	}
	
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
	public String getGioi() {
		return gioi;
	}
	public void setGioi(String gioi) {
		this.gioi = gioi;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
}
