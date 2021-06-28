
import java.io.Serializable;
import java.util.ArrayList;

public class MemberRecord implements Serializable{
	private ArrayList <Customer> mr = new ArrayList<>();
	
	public ArrayList <Customer> getList(){
		return mr;
	}
	
	public void setList(ArrayList <Customer> mr) {
		this.mr = mr;
	}
	
	public void addMember(Customer customer) {
		mr.add(customer);
	}
	
	public void deleteMember(String customerName) {
		boolean found = false;
		for(int i =0; i<= mr.size()-1; i++) {
			if(mr.get(i).getName().equals(customerName)) {
				mr.remove(i);
				System.out.println("MEMBER SUCCESSFULLY DELETED!\n");
				found = true;
			}	
		}
		if (found = false) {
			System.out.println("MEMBER NOT FOUND IN THE RECORD!");
		}
	}
	
	public boolean searchMember(String customerName) {
		boolean found = false ;
		for (int i=0; i<=mr.size()-1; i++) {
			if(mr.get(i).getName().equals(customerName)) {
				System.out.println("Searched Member is:\n"+mr.get(i).toString());
				found = true;
			}
		}
		if (found) {
			return found;
		}
		else return found;
	}
	
	public void displayMembers(){
		for(int i=0; i<= mr.size()-1; i++) {
			System.out.print((i+1)+". \n  "+mr.get(i).toString());
		}	
	}
}
