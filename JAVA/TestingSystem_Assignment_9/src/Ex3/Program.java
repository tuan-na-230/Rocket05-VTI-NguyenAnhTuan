package Ex3;

public class Program {
	public static void main(String[] args) {
		//Question_1
		CPU cpu = new CPU();
		CPU.Processor processor = cpu.new Processor(1,2);
		System.out.println(processor.getCache());
		CPU.Ram ram = cpu.new Ram(1,2);
		System.out.println(ram.getClockSpeed());
		
		//Question_2
		Car car = new Car("Mazda", "8WD");
		Car.Engine engine = car.new Engine("Cryler");
		System.out.println(engine.getEngineType());
		
		//Question_3
		//Đây là inner class
		//Đây là inner class
		
		//Question_4
		//Ngày: 31/10/2017
		//Giờ: 10:15:30
	}
}
