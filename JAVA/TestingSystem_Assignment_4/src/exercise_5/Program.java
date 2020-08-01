package exercise_5;

import java.util.ArrayList;

public class Program {
	public static void main(String[] args) {
		QLCB manager =  new QLCB();
		
		manager.themCanBo(new NhanVien("luc", 16, "nam", "Ha Noi", "Nhan vien"));
		manager.themCanBo(new NhanVien("Quynh", 16, "nam", "Ha Noi", "Nhan vien"));
		manager.themCanBo(new NhanVien("Quynh", 17, "nam", "Ha Noi", "Nhan vien"));
		manager.themCanBo(new NhanVien("Quynh", 18, "nam", "Ha Noi", "Nhan vien"));
		
//		manager.inCanBo();
		
		manager.timCanBoTheoTen("Son Tung");
		manager.timCanBoTheoTen("Quynh");
		manager.xoaCanBoTheoTen("luc");
		System.out.println("______________");
		manager.inCanBo();
	  }
}
