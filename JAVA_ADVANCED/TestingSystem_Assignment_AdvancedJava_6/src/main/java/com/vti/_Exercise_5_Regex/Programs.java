package com.vti._Exercise_5_Regex;

public class Programs {

	public static void main(String[] args) {
		Regex regex = new Regex();
		
		System.out.println("\n\n***********PASSWORD***********");
		String pass = "Hrdas!";
		regex.isCheckPassword(pass);
		
		
		System.out.println("\n\n***********EMAIL***********");
		String email = "Hrd.aas.ddfffff@vtiacademy.com";
		regex.isCheckEmail(email);
		
		
		System.out.println("\n\n***********PHONE***********");
		String phone = "+084332782799";
		regex.isCheckPhone(phone);
		
		
		System.out.println("\n\n***********PATH***********");
		String path = "D:\\My Drive\\Teaching\\EPD_03\\Assignments\\image.txt";
		regex.isCheckPath(path);
		
		
		System.out.println("\n\n***********DATE***********");
		String date = "05/01/2020";
		regex.isCheckDate(date);
	}

}
