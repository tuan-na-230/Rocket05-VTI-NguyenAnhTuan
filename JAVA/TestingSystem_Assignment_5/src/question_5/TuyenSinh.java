package question_5;
import java.util.ArrayList;

public class TuyenSinh implements ITuyenSinh {
	protected ArrayList<Examinee> Examinees ;
	
	TuyenSinh () {
		Examinees = new ArrayList<Examinee>();
	}

	@Override
	public void themMoiSinhVien(int sbd, String hoTen, String diaChi, int mucUuTien, KhoiThi khoiThi) {
		// TODO Auto-generated method stub
		Examinee exam = new Examinee(sbd, hoTen, diaChi, mucUuTien, KhoiThi.A);
		Examinees.add(exam);
	}

	@Override
	public void printSinhVien(int i) {
		// TODO Auto-generated method stub
		System.out.println(Examinees.get(i).toString());
	}

	@Override
	public void searchBySBD(int sbd) {
		// TODO Auto-generated method stub
		for(int i = 0; i< Examinees.size(); i++) {
			if(Examinees.get(i).getSbd() == sbd) {
				printSinhVien(i);
			}
		}
	}

	@Override
	public void thoat() {
		// TODO Auto-generated method stub
		System.exit(0);
	}

}
