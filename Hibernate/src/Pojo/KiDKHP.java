package Pojo;

import java.util.Date;

public class KiDKHP {
	private Date batDau;
	private Date ketThuc;
	private String hocKi;
	private String namHoc;
	
	public KiDKHP(){}

	public KiDKHP(Date batDau, Date ketThuc, String hocKi, String namHoc) {
		this.batDau = batDau;
		this.ketThuc = ketThuc;
		this.hocKi = hocKi;
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
	
}
