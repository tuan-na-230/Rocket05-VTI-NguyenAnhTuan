package Ex2;

import java.sql.Date;

public class Question_1 {
	

	public static void main(String[] args) {
		System.out.println(getSomeDate());
	}
	@SuppressWarnings("deprecation")
	public static Date getSomeDate() {
		Date date = new Date(2020, 05, 18);
		return date;
	}
}
