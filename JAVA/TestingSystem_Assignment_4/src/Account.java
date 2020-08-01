
public class Account {
	private String id;
	private String name;
	int balance;
	
	public Account(String id, String name, int balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	
	public String getID () {
		return this.id;
	}
	
	public String getName () {
		return this.name;
	}
	
	public int getBalance () {
		return this.balance;
	}
	
	public void credit (int amount) {
		this.balance = this.balance + amount;
	}
	
	public void debit (int amount) {
		this.balance = this.balance + amount;
	}
	
	public void tranferTo (Account account, int amount) {
		this.balance -= amount;
		account.balance += amount;
	}
}
