package com.vti._Exercise_5_Regex;

import java.util.regex.*;

public class Regex {
	
	public boolean isCheckPassword(String pass) {
		
		Pattern regex = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[#?!@$%^&*-]).{6,20}$");
		Matcher matcher = regex.matcher(pass);
		
		if (matcher.matches()) {
			System.out.println(pass+": Password được chấp thuận!");
			return true;
		}
		else {
			System.out.println(pass+": Password sai định dạng! Yêu cầu phải từ 6 đến 20 ký tự, có ít nhất 1 ký tự đặc biệt và ít nhất 1 chữ viết hoa");
			return false;
		}
	}
	
	public boolean isCheckEmail(String email) {

		Pattern regex = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@vtiacademy.com{1,10}$");
		Matcher matcher = regex.matcher(email);
		
		if (matcher.matches()) {
			System.out.println(email+": Email được chấp thuận!");
			return true;
		}
		else {
			System.out.println(email+": Email sai định dạng!");
			return false;
		}
	}
	
	public boolean isCheckPhone(String phone) {

		Pattern regex = Pattern.compile("^(\\+\\d{2}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
		Matcher matcher = regex.matcher(phone);
		
		if (matcher.matches()) {
			System.out.println(phone+": Phone được chấp thuận!");
			return true;
		}
		else {
			System.out.println(phone+": Phone sai định dạng!");
			return false;
		}
	}
	
	public boolean isCheckPath(String path) {

		Pattern regex = Pattern.compile("([a-zA-Z]:)?(\\\\[\\w\\a-zA-Z0-9_.-]+)+\\\\?");
		Matcher matcher = regex.matcher(path);
		
		if (matcher.matches()) {
			System.out.println(path+": Path được chấp thuận!");
			return true;
		}
		else {
			System.out.println(path+": Path sai định dạng!");
			return false;
		}
	}
	
	public boolean isCheckDate(String date) {

		Pattern regex = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/([0-9][0-9])?[0-9][0-9]$");
		Matcher matcher = regex.matcher(date);
		
		Pattern regex1 = Pattern.compile("^\\d{4}\\-(0[1-9]|1[0-2])\\-(0[1-9]|[12][0-9]|3[01])$");
		Matcher matcher1 = regex1.matcher(date);
		
		int check = 0;
		
		if (matcher.matches()) {
			System.out.println(date+": Date được chấp thuận định dạng dd/MM/yyyy!");
			check++;
		}
		if (matcher1.matches()) {
			System.out.println(date+": Date được chấp thuận định dạng yyyy-MM-dd!");
			check++;
		}
		
		if(check == 1) {
			return true;
		}
		else {
			System.out.println(date+": Date sai định dạng. Nhập theo định dạng dd/MM/yyyy hoặc yyyy-MM-dd!");
			return false;
		}
		
	}

}
