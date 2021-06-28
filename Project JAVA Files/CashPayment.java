import java.io.Serializable;

public class CashPayment extends Payment implements Serializable{
	private double cashToPay;
	
	public CashPayment(Order order) {
		cashToPay = order.getPrice();
		this.order = order;
	}
	
	@Override
	void paymentSlip() {
		System.out.println("\n+++++++++++++ PAYMENT RECIEPT +++++++++++++++\nOrder No: "
				+ ""+order.getOrderNo()+"\nFood Order: "+order.getFood().toString()
				+"\nTotal Price Paid: Rs. "+order.getPrice()+"\n(PAYMENT IS DONE VIA CASH!)"
						+ "\n+++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
	}
	

}
