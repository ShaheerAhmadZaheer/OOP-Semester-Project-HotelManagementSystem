import java.io.Serializable;

public abstract class Payment implements Serializable {
	protected Order order;
	
	
	abstract void paymentSlip();
}
