public interface MyFunctionalInterface {

	String method(String a, String b);

	default void methodA(int a, int b){

		System.out.println("Sum:" + (a+b));
		methodC();
	}

	static void methodB(String input ){

		System.out.println(input);
	}

	private void methodC(){

		System.out.println("Private Method");
	}
}
