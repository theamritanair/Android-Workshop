public class DriverFunctional implements MyFunctionalInterface{


	public void saySomething(){

		System.out.println("Functional Interface");
	}


	public static void main(String[] args) {
		
		MyFunctionalInterface driver = () -> System.out.println("Lambda yaya");
		driver.saySomething();

	MyFunctionalInterface interfacedriver = new MyFunctionalInterface(){

			public void saySomething(){
			System.out.println("anonymous yay");
		}

		};
		
		interfacedriver.saySomething();
		DriverFunctional drive = new DriverFunctional();
		drive.saySomething();


	}
}
