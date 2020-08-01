package exercise_6;

public class demo {
	public static void main(String[] args) {
		VietnamesePhone vnp = new VietnamesePhone();
		vnp.insertContact("tuan", "9019010");
		vnp.insertContact("tuan", "9019010");
		vnp.insertContact("tuan", "9019010");
		vnp.insertContact("tu", "9019010");
		
		vnp.removeContact("tu");
		
		vnp.updateContact("tuan","12312412");
		
		vnp.searchContact("tuan");
		
		for(int i=0; i< vnp.size(); i++) {
			System.out.println(vnp.toString(i));
		}
		
	}
}
