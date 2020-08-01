package exercise_5;

public abstract class Student extends Person {
	protected String id;

	public Student(String name, String id) {
		super(name);
		this.id = id;
	}
}
