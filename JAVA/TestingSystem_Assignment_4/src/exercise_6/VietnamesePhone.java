package exercise_6;

public class VietnamesePhone extends Phone {
	VietnamesePhone() {
		super();
	}
	@Override
	void insertContact(String name, String phone) {
		Info info = new Info(name, phone);
		contact.add(info);
	}

	@Override
	void removeContact(String name) {
		for(int i = 0; i< contact.size(); i++) {
			if(contact.get(i).name == name) {
				contact.remove(i);
				i--;
			}
		}
	}

	@Override
	void updateContact(String name, String newPhone) {
		for(int i = 0; i< contact.size(); i++) {
			if(contact.get(i).name == name) {
				Info info = new Info(name, newPhone);
				contact.set(i, info);
			}
		}
	}

	@Override
	void searchContact(String name) {
		for(int i = 0; i< contact.size(); i++) {
			if(contact.get(i).name == name) {
				contact.get(i);
				System.out.println(contact.get(i).name);
				System.out.println(contact.get(i).phone);
			}
		}
	}
	
	public String toString(int i) {
			return contact.get(i).name + contact.get(i).phone;
	}
	
	public int size() {
		return contact.size();
	}
}
