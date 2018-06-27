public class SuperDemo extends SuperExample{

	public SuperDemo(){
		super();	
		System.out.println("Child constructor");

	}

	@Override
	public void printSomething(){
		System.out.println("Method in child class");
		super.printSomething();
	}

	public static void main(String[] args){

		SuperDemo superDemo = new SuperDemo();
		superDemo.printSomething();

	}
}