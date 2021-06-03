package Pojo;

import java.util.Date;

public class DKHP {
	private String maSV;
	private String cmnd;
	private String maHocPhan;
	private String hocKi;
	private String namHoc;
	private Date thoiGianDangKi;
	
	public DKHP() {}
	
	public DKHP(String maSV, String cmnd, String maHocPhan, String hocKi, String namHoc, Date thoiGianDangKi) {
		this.maSV = maSV;
		this.cmnd = cmnd;
		this.maHocPhan = maHocPhan;
		this.hocKi = hocKi;
		this.namHoc = namHoc;
		this.thoiGianDangKi = thoiGianDangKi;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
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

	public Date getThoiGianDangKi() {
		return thoiGianDangKi;
	}

	public void setThoiGianDangKi(Date thoiGianDangKi) {
		this.thoiGianDangKi = thoiGianDangKi;
	}
}
