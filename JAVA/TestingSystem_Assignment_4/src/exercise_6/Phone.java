package exercise_6;

import java.util.ArrayList;

public abstract class Phone{
	protected ArrayList<Info> contact;
	
	Phone() {
		contact = new ArrayList<Info>();
	}
	
	abstract void insertContact(String name, String phone);
	abstract void removeContact(String name);
	abstract void updateContact(String name, String newPhone);
	abstract void searchContact(String name);
}
