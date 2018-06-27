public class Child extends Parent{

	protected void methodA(){
		super.methodA();
		System.out.println("Overriden A");

	}

	@Override

	public void methodB(){
		super.methodB();
		
		System.out.println("Overriden B");

	}

	public static void main(String[] args) {
		Child child = new Child();
		child.methodA();
		child.methodB();
	}
}