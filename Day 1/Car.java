public class Car{

	//datatypes
	private String brand;
	private int price;
	private String color;

	//constructors
	public Car(){
		//default constructor
	}

	public Car(String brand, int price, String color){
		this.brand = brand;
		this.price = price;
		this.color= color;
	}

	public Car(String brand){
		this.brand=brand;
	}

	public String getBrand(){
		return this.brand;
	}

	public void setBrand(String brand){
		this.brand = brand;
	}

	public String getColor(){
		return this.color;
	}

	public void setColor(){
		this.color = color;
	}

	public void setPrice(){
		this.price = price;
	}

	public int getPrice(){
		return this.price;
	}

	public void setCar(String brand, int price, String color){
		this.brand = brand;
		this.price = price;
		this.color= color;
	}
	public float getDiscount(int discount){
		float cost = (float) price*(discount/100);
		return price-cost;
	}
	public void carDetails(String brand, int price, String color){
		System.out.println("The brand of the car is" + this.brand +"the color is" +  this.color +"the price is" + this.price);
	}

	

}