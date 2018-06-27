public class Car{

	String carName;
	int fuelCapacity;

	public Car(int fuelCapacity, String carName){

		this.fuelCapacity = fuelCapacity;
		this.carName = carName;

	}

	public void drive(int distance)throws CarOutOfFuelException{

		if(fuelCapacity>0 && fuelCapacity>distance){

			System.out.println("Yay. I'm driving a " + carName);
		}
		else{
			throw new CarOutOfFuelException("No fuel :(");
		}
		fuelCapacity -=distance;

	}
}