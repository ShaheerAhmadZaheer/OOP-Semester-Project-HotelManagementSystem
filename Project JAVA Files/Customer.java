import java.io.Serializable;

public class Customer implements Serializable {
	protected String name;
	protected int id;
	protected String phoneNo;
	
	public Customer(String name, int id, String phoneNo) {
		this.name = name;
		this.id = id;
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "\nName: "+name+"\nID: "+id+"\nPhone No.: "+phoneNo+"\n--------------------------------------\n";
	}
	
	//is function mein Hum Memeber record ki file check kreingy, Agar wahan Member mujood hua tuo true hojyega.
	
	public boolean isMember(Customer customer, MemberRecord mr) {
		if (mr.searchMember(customer.getName())) {
			return true;
		}
		else return false;
	}
}
