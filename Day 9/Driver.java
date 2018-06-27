public class Driver{


	public static void main(String[] args) {
			
		MyFunctionalInterface obj = (a,b) -> {
		return a +b;
		};

		System.out.println(obj.method("Hello","World"));
		obj.methodA(5,10);
		MyFunctionalInterface.methodB("watermelon");

	}
}