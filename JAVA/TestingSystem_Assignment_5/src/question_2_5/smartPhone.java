package question_2_5;

public class smartPhone extends Phone implements VuKhi {
	smartPhone(String name) {
		super(name);
	}
	@Override
	public void nghe() {
		System.out.println("Nghe tren smart phone " + this.name);
	}

	@Override
	public void goi() {
		System.out.println("Goi tren smart phone " + this.name);
	}

	@Override
	public void guiTinNhan() {
		System.out.println("Gui tin nhan tren smart phone " + this.name);
	}

	@Override
	public void nhanTinNhan() {
		System.out.println("Nhan tin nhan tren smart phone " + this.name);
	}
	
	public void suDung3G() {
		System.out.println("Su dung 3g tren smart phone " + this.name);
	}
	
	public void chupHinh() {
		System.out.println("chup hinh tren smart phone " + this.name);
	}

	@Override
	public void tanCongKeXau(String tenKeXau) {
		System.out.println("dung smart phone " + this.name + " tan cong" + tenKeXau);
	}
}
