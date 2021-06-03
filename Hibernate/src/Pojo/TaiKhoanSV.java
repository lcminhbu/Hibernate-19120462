package Pojo;

public class TaiKhoanSV {
	
	private String id;
	private String cmnd;
	private String tk;
	private String mk;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getTk() {
		return tk;
	}
	public void setTk(String tk) {
		this.tk = tk;
	}
	public String getMk() {
		return mk;
	}
	public void setMk(String mk) {
		this.mk = mk;
	}
	
	public TaiKhoanSV() {
	}
	public TaiKhoanSV(String id, String cmnd, String tk, String mk) {
		this.id = id;
		this.cmnd = cmnd;
		this.tk = tk;
		this.mk = mk;
	}
}
