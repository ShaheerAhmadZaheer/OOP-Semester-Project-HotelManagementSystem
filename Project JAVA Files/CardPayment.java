import java.io.Serializable;

public class CardPayment extends Payment implements Serializable{
	private long cardNo;
	private String pass;
	
	public CardPayment(long cardNo, String password, Order order) {
		this.cardNo = cardNo;
		pass = password;
		this.order = order;
	}
	
	@Override
	public void paymentSlip() {
		System.out.println("\n+++++++++++++ PAYMENT RECIEPT +++++++++++++++\nOrder No: "
				+ ""+order.getOrderNo()+"\nFood Order: "+order.getFood().toString()
				+"\nTotal Price Paid: Rs. "+order.getPrice()+"\n(PAYMENT IS DONE VIA BANK CARD!)"
						+ "\n+++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
	}

}
