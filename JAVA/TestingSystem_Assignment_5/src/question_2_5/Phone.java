package question_2_5;

public abstract class Phone {
	protected String name;
	
	Phone (String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	abstract public void nghe();
	abstract public void goi();
	abstract public void guiTinNhan();
	abstract public void nhanTinNhan();
}
