package question_2_5;

public class classicPhone extends Phone implements VuKhi {

	classicPhone(String name) {
		super(name);
	}

	@Override
	public void nghe() {
		System.out.println("Gui tin nhan tren clasic phone " + this.name);
	}

	@Override
	public void goi() {
		System.out.println("Gui tin nhan tren clasic phone " + this.name);
	}

	@Override
	public void guiTinNhan() {
		System.out.println("Gui tin nhan tren clasic phone " + this.name);
	}

	@Override
	public void nhanTinNhan() {
		System.out.println("Gui tin nhan tren clasic phone " + this.name);
	}
	
	public void ngheRadio() {
		System.out.println("Gui tin nhan tren clasic phone " + this.name);
	}

	@Override
	public void tanCongKeXau(String tenKeXau) {
		System.out.println("dung clasic phone " + this.name + " tan cong" + tenKeXau);
	}
	
}
