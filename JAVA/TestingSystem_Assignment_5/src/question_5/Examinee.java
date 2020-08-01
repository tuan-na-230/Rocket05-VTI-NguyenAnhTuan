package question_5;

public class Examinee {
	protected int sbd;
	protected String hoTen;
	protected String diaChi;
	protected int mucUuTien;
	protected KhoiThi khoiThi;

	public Examinee(int sbd, String hoTen, String diaChi, int mucUuTien, KhoiThi khoiThi) {
		super();
		this.sbd = sbd;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.mucUuTien = mucUuTien;
		this.khoiThi = khoiThi;
	}

	@Override
	public String toString() {
		return "Examinee [sbd=" + sbd + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", mucUuTien=" + mucUuTien
				+ ", khoiThi=" + khoiThi + "]";
	}

	public int getSbd() {
		return sbd;
	}

	public void setSbd(int sbd) {
		this.sbd = sbd;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getMucUuTien() {
		return mucUuTien;
	}

	public void setMucUuTien(int mucUuTien) {
		this.mucUuTien = mucUuTien;
	}

	public KhoiThi getKhoiThi() {
		return khoiThi;
	}

	public void setKhoiThi(KhoiThi khoiThi) {
		this.khoiThi = khoiThi;
	}

	
}
