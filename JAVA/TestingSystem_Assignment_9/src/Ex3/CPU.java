package Ex3;

public class CPU {
	private float price;
	
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public class Processor {
		private float coreAmount;
		private float menuFacturer;
		
		Processor(float coreAmount, float menuFacturer) {
			this.coreAmount = coreAmount;
			this.menuFacturer = menuFacturer;
		}
		
		public float getCache() {
			return (float) 4.3;
		}

		public float getCoreAmount() {
			return coreAmount;
		}

		public void setCoreAmount(float coreAmount) {
			this.coreAmount = coreAmount;
		}

		public float getMenuFacturer() {
			return menuFacturer;
		}

		public void setMenuFacturer(float menuFacturer) {
			this.menuFacturer = menuFacturer;
		}
	}
	
	public class Ram {
		private float memory;
		private float menuFacturer;
		
		Ram(float memory, float menuFacturer) {
			this.memory = memory;
			this.menuFacturer = menuFacturer;
		}
		
		public float getClockSpeed() {
			return (float) 5.5;
		}

		public float getMemory() {
			return memory;
		}

		public void setMemory(float memory) {
			this.memory = memory;
		}

		public float getMenuFacturer() {
			return menuFacturer;
		}

		public void setMenuFacturer(float menuFacturer) {
			this.menuFacturer = menuFacturer;
		}
	}
}
