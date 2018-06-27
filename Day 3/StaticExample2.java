public class StaticExample2{

	public static String string = "Hello";
	private int number = 234;

	public static void printSomethingAgain(){

		System.out.println("A static method");
	}

	public void printSomething(){
		printSomethingAgain();
		System.out.println("hahah "+"this is some string" + string);
		System.out.println("Some number" + number);
	}

	
}