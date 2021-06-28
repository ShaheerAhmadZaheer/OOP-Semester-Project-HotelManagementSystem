import java.io.Serializable;

public class Order implements Serializable{
	protected int orderNo;
	protected double price;
	protected Food food;
	private double x;
	
	public Order(int orderNo, Food food) {
		this.orderNo = orderNo;
		this.price = food.getPrice();
		this.food = food;
	}
	
	public Food getFood() {
		return food;
	}
	
	public int getOrderNo() {
		return orderNo;
	}
	
	public double getPrice() {
		return price;
	}
	
	//Customer mein jo isMember ka function hai woh check kr k discount deingy
	
	public boolean discount(Customer customer, MemberRecord mr) {
		boolean noDiscount = true;
		if (customer.isMember(customer, mr)) {
			x = (20*price)/100;
			price = price - x;
			System.out.println("You have availed 20% of discount on your Order!\n");
			System.out.println("Your Updated Order Slip is as Follows:"
					+ " \n\n++++++++++++++++++++++++ YOUR ORDER +++++++++++++++++++++++++\n"+toString());
			noDiscount=false;
			return noDiscount;
		}
		else {
			System.out.println("Customer is not a Member! Membership is MANDATORY for Discount!");
			return noDiscount;
		}	
	}
	@Override
	public String toString() {
		return "Order ID: "+orderNo+"\nFood Ordered: "
				+food.toString()+"\nTotal Bill: "
				+price+"\n ----------------------------------------------------------------\n";
	}
}
