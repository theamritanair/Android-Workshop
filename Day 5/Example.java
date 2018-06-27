public class Example{

	public staticvoid methodA(String a, int b,MyInterface myInterface){

	System.out.println(a +" "+b);
	myInterface.sayHello();
}

	public static void main(String[] args) {



		methodA("Bond",007,new MyInterface(){

			public void saySomething(){

				System.out.println("something");
			}
			public void sayHello(){

				System.out.println("Hello");
			}
		});
		//MyInterface myInterface = new MyInterface(){}; //X

		//correct
	// 	MyInterface myInterface = new MyInterface(){
	// 		public void saySomething(){

	// 			System.out.println("Something!");

	// 		}
	// 		public void sayHello(){

	// 			System.out.println("Hello");
	// 		}
	// 	};

	// }
}