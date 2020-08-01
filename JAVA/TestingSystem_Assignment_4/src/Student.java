
public class Student {
	private int id;
	private String name;
	private String hometown;
	private float diemHocLuc;
	
	Student (String name, String hometown) {
		this.name = name;
		this.hometown = hometown;
		this.diemHocLuc = 0;
	}

	public void setDiemHocLuc(float diemHocLuc) {
		this.diemHocLuc = diemHocLuc;
	}
	
	public void congDiemHocLuc(float diemThem) {
		this.diemHocLuc = this.diemHocLuc + diemThem;
	}
	
	public void print() {
		System.out.println("Họ và tên: " + this.name);
		if(this.diemHocLuc <= 4) {
			System.out.println("Học lực yếu");
		} else if (this.diemHocLuc > 4 && this.diemHocLuc <= 6) {
			System.out.println("Học lực trung bình");
		} else if (this.diemHocLuc > 6 && this.diemHocLuc <= 8) {
			System.out.println("Học lực khá");
		} else {
			System.out.println("Học lực giỏi");
		}
	}
}
