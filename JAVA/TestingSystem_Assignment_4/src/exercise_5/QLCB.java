package exercise_5;

import java.util.ArrayList;

public class QLCB {
	private ArrayList<CanBo> danhSachCanBo;
	
	public QLCB() {
		danhSachCanBo = new ArrayList<CanBo>();
	}
	
	public void themCanBo(CanBo CanBoMoi) {
		danhSachCanBo.add(CanBoMoi);
	}
	
	public void inCanBo () {
		for (int i = 0; i < danhSachCanBo.size(); i++) {
			System.out.println(danhSachCanBo.get(i));
		}
	}
	
	public void timCanBoTheoTen(String tenCanTim) {
		boolean coTimThay = false;
		for (int i = 0; i < danhSachCanBo.size(); i++) {
			if (danhSachCanBo.get(i).getHoTen() == tenCanTim) {
				System.out.println(danhSachCanBo.get(i));
				coTimThay = true;
			}	
		}
		if (!coTimThay) {
			System.out.println("Không có nhân viên nào có tên: " + tenCanTim);
		}
	}
	
	public void xoaCanBoTheoTen(String TenCanXoa) {
		boolean coTimThay = false;
		for (int i = 0; i < danhSachCanBo.size(); i++) {
			if (danhSachCanBo.get(i).getHoTen() == TenCanXoa) {
				danhSachCanBo.remove(i);
				i--;
				coTimThay = true;
			}	
		}
		if (!coTimThay) {
			System.out.println("Không có nhân viên nào có tên: " + TenCanXoa);
		}
	}
}
