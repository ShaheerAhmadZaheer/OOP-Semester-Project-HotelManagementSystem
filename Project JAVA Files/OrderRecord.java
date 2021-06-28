import java.io.Serializable;
import java.util.ArrayList;

public class OrderRecord implements Serializable {
	private ArrayList <Order> or = new ArrayList<>();;
	
	public void addOrder(Order order) {
		or.add(order);
	}
	
	public ArrayList <Order> getList(){
		return or;
	}
	
	public void setList(ArrayList <Order> or) {
		this.or = or;
	}
	
	public void searchOrder(int OrderNo) {
		boolean found = false;
		for (int i=0; i<=or.size()-1; i++) {
			if(or.get(i).getOrderNo()==OrderNo) {
				System.out.println("Searched Order is:\n"+or.get(i).toString());
				found = true;
			}
		}
		if (found = false) {
			System.out.println("ORDER NOT FOUND IN THE RECORD!\n");
		}
	}
	
	public void deleteOrder(int orderNo) {
		for(int i =0; i<= or.size()-1; i++) {
			if(or.get(i).getOrderNo()== orderNo) {
				or.remove(i);
				System.out.println("ORDER RECORD SUCCESSFULLY DELETED!\n");
			}	
		}
	}
	
	public void displayOrder(){
		for(int i=0; i<= or.size()-1; i++) {
			System.out.print((i+1)+". \n  "+or.get(i).toString());
		}	
	}
	

}
