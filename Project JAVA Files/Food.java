import java.io.Serializable;

public class Food implements Serializable{
	private String type;
	private String name;
	private  double price;
	
	
	public Food(String type, String name, double price) {
		this.type = type;
		this.name = name;
		this.price = price;
	}
	
	public boolean withColdDrink() {
		return true;
	}
	
	public boolean withSalad() {
		return true;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return " Name: "+name+"   Type: "+type+"   Price: "+price+"/-"+"\n--------------------------------------\n";
	}

}
