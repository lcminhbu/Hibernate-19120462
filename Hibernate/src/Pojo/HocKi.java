package Pojo;

import java.util.Date;

public class HocKi {
	private String tenHocKi;
	private String namHoc;
	private Date batDau;
	private Date ketThuc;
	private Boolean hocKiHienTai;
	
	public HocKi() {}

	public HocKi(String tenHocKi, String namHoc, Date batDau, Date ketThuc, Boolean hocKiHienTai) {
		this.tenHocKi = tenHocKi;
		this.namHoc = namHoc;
		this.batDau = batDau;
		this.ketThuc = ketThuc;
		this.hocKiHienTai = hocKiHienTai;
	}

	public String getTenHocKi() {
		return tenHocKi;
	}

	public void setTenHocKi(String tenHocKi) {
		this.tenHocKi = tenHocKi;
	}

	public String getNamHoc() {
		return namHoc;
	}

	public void setNamHoc(String namHoc) {
		this.namHoc = namHoc;
	}

	public Date getBatDau() {
		return batDau;
	}

	public void setBatDau(Date batDau) {
		this.batDau = batDau;
	}

	public Date getKetThuc() {
		return ketThuc;
	}

	public void setKetThuc(Date ketThuc) {
		this.ketThuc = ketThuc;
	}

	public Boolean getHocKiHienTai() {
		return hocKiHienTai;
	}

	public void setHocKiHienTai(Boolean hocKiHienTai) {
		this.hocKiHienTai = hocKiHienTai;
	}
}
