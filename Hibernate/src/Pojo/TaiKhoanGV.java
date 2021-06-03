package Pojo;

public class TaiKhoanGV {

	private String id;
	private String tk;
	private String mk;
	
	public TaiKhoanGV() {}
	public TaiKhoanGV(String id, String tk, String mk) {
		this.id = id;
		this.tk = tk;
		this.mk = mk;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
}
