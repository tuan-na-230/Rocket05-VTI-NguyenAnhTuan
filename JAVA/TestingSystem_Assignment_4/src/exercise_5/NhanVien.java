package exercise_5;

public class NhanVien extends CanBo {
	private String congViec;

	public NhanVien(String hoTen, int tuoi, String gioiTinh, String diaChi, String congViec) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		this.congViec = congViec;
	}
}
