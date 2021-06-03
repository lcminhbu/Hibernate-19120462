package Pojo;

public class Lop {
	private int soSV;
	private int soSVNu;
	private int soSVNam;
	private String tenLop;
	private String maLop;
	private String hocKi;
	private String namHoc;
	public Lop(int soSV, int soSVNu, int soSVNam, String tenLop, String maLop, String hocKi, String namHoc) {
		this.soSV = soSV;
		this.soSVNu = soSVNu;
		this.soSVNam = soSVNam;
		this.tenLop = tenLop;
		this.maLop = maLop;
		this.hocKi = hocKi;
		this.namHoc = namHoc;
	}
	
	public Lop() {}

	public int getSoSV() {
		return soSV;
	}

	public void setSoSV(int soSV) {
		this.soSV = soSV;
	}

	public int getSoSVNu() {
		return soSVNu;
	}

	public void setSoSVNu(int soSVNu) {
		this.soSVNu = soSVNu;
	}

	public int getSoSVNam() {
		return soSVNam;
	}

	public void setSoSVNam(int soSVNam) {
		this.soSVNam = soSVNam;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
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
