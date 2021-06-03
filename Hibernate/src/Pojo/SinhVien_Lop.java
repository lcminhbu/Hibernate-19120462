package Pojo;

public class SinhVien_Lop {
	private String maSV;
	private String cmnd;
	private String maLop;
	private String hocKi;
	private String namHoc;
	
	public SinhVien_Lop() {}

	public SinhVien_Lop(String maSV, String cmnd, String maLop, String hocKi, String namHoc) {
		this.maSV = maSV;
		this.cmnd = cmnd;
		this.maLop = maLop;
		this.hocKi = hocKi;
		this.namHoc = namHoc;
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

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
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
