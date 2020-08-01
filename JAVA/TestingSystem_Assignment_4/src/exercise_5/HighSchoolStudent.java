package exercise_5;

public class HighSchoolStudent extends Student {
	protected String clazz;
	protected String desiredUniversity;
	public HighSchoolStudent(String name, String id, String clazz, String desiredUniversity) {
		super(name, id);
		this.clazz = clazz;
		this.desiredUniversity = desiredUniversity;
	}
}
