package Ex3;

public class Car {
	private String name;
	private String type;
	
	Car (String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public class Engine {
		private String engineType;
		
		Engine(String engineType) {
			this.engineType = engineType;
		}

		public String getEngineType() {
			return engineType;
		}

		public void setEngineType(String engineType) {
			this.engineType = engineType;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
