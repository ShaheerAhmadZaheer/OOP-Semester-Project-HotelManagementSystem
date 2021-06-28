
import java.io.Serializable;
import java.util.ArrayList;

public class FoodRecord implements Serializable {
	private ArrayList <Food> fr = new ArrayList<>();;
	
	public void addFood(Food food) {
		fr.add(food);
	}
	
	public ArrayList <Food> getList(){
		return fr;
	}
	
	public void setList(ArrayList <Food> fr) {
		this.fr = fr;
	}
	
	public void searchFood(String foodName) {
		boolean found = false;
		for (int i=0; i<=fr.size()-1; i++) {
			if(fr.get(i).getName().equals(foodName)) {
				System.out.println("Searched Food is:\n--------------------------------------\n"+fr.get(i).toString());
				found = true;
			}
		}
		if (found = false) {
			System.out.println("FOOD NOT FOUND IN THE RECORD!\n");
		}
	}
	
	public void deleteFood(String foodName) {
		boolean found = false;
		for(int i =0; i<= fr.size()-1; i++) {
			if(fr.get(i).getName().equals(foodName)) {
				fr.remove(i);
				System.out.println("FOOD SUCCESSFULLY DELETED!\n");
				found = true;
			}	
		}
		//if(found == false) {
			//System.out.println("FOOD ALREADY DOES NOT EXIST!");
		//}
	}
	
	public void displayFood(){
		for(int i=0; i<= fr.size()-1; i++) {
			System.out.print("Serial No. "+(i+1)+" ---> ");
			System.out.println(fr.get(i).toString());
		}
	}
	
	public Food getFood(int index) {
		Food f =null;
		f = fr.get(index);
		return f;
	}
}
