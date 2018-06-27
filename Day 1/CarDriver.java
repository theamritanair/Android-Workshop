public class CarDriver{

	public static void main(String args[]){
		Car car1 = new Car();
		Car car2 = new Car("Maruti", 100000, "Red");
		Car car3 = new Car();

		car1.carDetails();
		car2.carDetails();
		car3.carDetails();
		car3.setPrice(100000);
		car.setColor("White");
		car3.carDetails();
	}

}