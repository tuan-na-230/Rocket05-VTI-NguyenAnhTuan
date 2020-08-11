
public class Outer {
	
	public class Inner {
		System.out.println("inner");
	}
	
	public void o1() {
		System.out.println("Inner1");
	}
	
	public void o2() {
		class Inner2 {
			void inner2() {
				System.out.println("Inner2");
			}
		}
		
		Inner2 i2 = new Inner2();
		i2.inner2();
	}
}
