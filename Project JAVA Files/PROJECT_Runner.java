import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PROJECT_Runner {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		int choose = 0;
		int choose1 = 0;
		int choose2=0;
		int serialNo;
		long cardNo;
		String pass;
		String type;
		String name;
		double price;
		int id;
		String phoneNo;
		
		FoodRecord fr = new FoodRecord();
		MemberRecord mr = new MemberRecord();
		OrderRecord or = new OrderRecord();
		
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("========================HOTEL MANAGEMENT SYSTEM (FOR FOOD ONLY)========================");
			System.out.println("- PRESS 1 TO IF YOU ARE \"ADMIN\".");
			System.out.println("- PRESS 2 TO IF YOU ARE \"CUSTOMER\" (FOR ORDERING FOOD).");
			System.out.println("- PRESS 3 TO \"EXIT\" THE PROGRAM.");
			System.out.print("Enter Here: ");

			try {
				choose = input.nextInt();
			}catch(InputMismatchException e){
                System.out.println("ONLY DIGITS ARE ALLOWED!");
                input.nextLine();
			}
			
			
			while (choose == 1) {
				System.out.println("\n===============================WELCOME TO ADMIN WINDOW================================\n");
				System.out.println("\n- PRESS 1 TO ADD NEW FOOD ITEM.\n");
				System.out.println("\n- PRESS 2 TO SEARCH FOOD ITEM.\n");
				System.out.println("\n- PRESS 3 TO DELETE FOOD ITEM.\n");
				System.out.println("\n- PRESS 4 TO VIEW FOOD ITEMS.\n");
				System.out.println("\n- PRESS 5 TO ADD CUSTOMER TO MEMBERS LIST.\n");
				System.out.println("\n- PRESS 6 TO DELETE MEMBER  FROM MEMBER LIST.\n");
				System.out.println("\n- PRESS 7 TO SEARCH MEMBER FROM MEMBER LIST.\n");
				System.out.println("\n- PRESS 8 TO VIEW MEMBER LIST.\n");
				System.out.println("\n- PRESS 9 TO DELETE ORDER FROM ORDER RECORD.\n");
				System.out.println("\n- PRESS 10 TO VIEW ORDER RECORD.\n");
				System.out.println("\n- PRESS 11 TO EXIT THE ADMIN WINDOW.\n");
				System.out.print("Enter Here: ");
				
				
				try {
					choose1 = input.nextInt();
				}catch(InputMismatchException e1){
                    System.out.println("ONLY DIGITS ARE ALLOWED!");
                    input.nextLine();
				}
				
				if (choose1 ==1 ) {
					System.out.println("\n========================= ADD FOOD WINDOW =============================\n");
					System.out.print("Enter Food TYPE ( Desi / Fast Food): ");
					input.nextLine();
					type = input.nextLine();
					
					System.out.print("Enter Food NAME: ");
					name = input.nextLine();
					
					System.out.print("Enter Food PRICE: ");
					price = input.nextDouble();
					
					fr.addFood(new Food(type, name, price));
					
					//Update File krni hai OutputObjectStream use kr k
					ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("foodData.txt"));
					os.writeObject(fr);
					os.close();
					
					System.out.println("\nFOOD ADDED SUCCESSFULLY!\n");
					
				}
				
				else if (choose1 == 2) {
					System.out.println("\n========================= SEARCH FOOD WINDOW =============================\n");
					System.out.print("Enter Food NAME to be searched: ");
					input.nextLine();
					name = input.nextLine();
					
					fr.searchFood(name);
					
				}
				
				else if (choose1 == 3) {
					System.out.println("\n========================= DELETE FOOD WINDOW =============================\n");
					System.out.print("Enter Food NAME to be deleted: ");
					input.nextLine();
					name = input.nextLine();
					
					fr.deleteFood(name);
					//update the file using ObjectOutputStream
					ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("foodData.txt"));
					os.writeObject(fr);
					os.close();
				}
				
				else if (choose1 == 4) {
					System.out.println("\n========================= VIEWING FOOD ITEMS =============================\n");
					
					try {
						ObjectInputStream is = new ObjectInputStream(new FileInputStream("foodData.txt"));
						FoodRecord f = (FoodRecord) is.readObject();
						fr =f;
						System.out.println("Food List is as Follows: ");
						fr.displayFood();
						is.close();
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
				else if (choose1 ==5 ) {
					System.out.println("\n========================= ADDING MEMBER WINDOW =============================\n");
					System.out.print("Enter Customer NAME: ");
					input.nextLine();
					name = input.nextLine();
					
					System.out.print("Enter Customer ID ");
					id = input.nextInt();
					
					System.out.print("Enter Customer PHONE NUMBER: ");
					input.nextLine();
					phoneNo = input.nextLine();
					
					mr.addMember(new Customer(name, id, phoneNo));
					
					ObjectOutputStream os1 = new ObjectOutputStream(new FileOutputStream("memberData.txt"));
					os1.writeObject(mr);
					os1.close();
					
					System.out.println("MEMBER ADDED SUCCESSFULLY!");
				}
				
				else if (choose1 == 6) {
					System.out.println("\n========================= DELETE MEMBER WINDOW =============================\n");
					System.out.print("Enter Member NAME to be deleted: ");
					input.nextLine();
					name = input.nextLine();
					
					mr.deleteMember(name);
					//update the file using ObjectOutputStream
					ObjectOutputStream os1 = new ObjectOutputStream(new FileOutputStream("memberData.txt"));
					os1.writeObject(mr);
					os1.close();
				}
				
				else if (choose1 == 7) {
					System.out.println("\n========================= SEARCH MEMBER WINDOW =============================\n");
					System.out.print("Enter Member NAME to be searched: ");
					input.nextLine();
					name = input.nextLine();
					
					
					if (mr.searchMember(name)) {
						System.out.println("MEMBER DOES NOT EXIST!\n");
					}
				}
				
				else if (choose1 == 8) {
					System.out.println("\n========================= VIEW MEMBER LIST WINDOW =============================\n");
					try {
						ObjectInputStream is1 = new ObjectInputStream(new FileInputStream("memberData.txt"));
						MemberRecord m =(MemberRecord) is1.readObject();
						mr = m;
						System.out.println("Member List is as follows: ");
						mr.displayMembers();
						is1.close();
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				else if (choose1 == 9) {
					System.out.println("\n========================= DELETE ORDER RECORD =============================\n");
					System.out.print("Enter Order ID to be deleted: ");
					id = input.nextInt();
					
					or.deleteOrder(id);
					//update the file using ObjectOutputStream
					ObjectOutputStream os2 = new ObjectOutputStream(new FileOutputStream("orderData.txt"));
					os2.writeObject(or);
					os2.close();
				}
				
				else if (choose1 == 10) {
					System.out.println("\n========================= VIEW ORDER RECORD =============================\n");
					try {
						ObjectInputStream is2 = new ObjectInputStream(new FileInputStream("orderData.txt"));
						OrderRecord o =(OrderRecord) is2.readObject();
						or = o;
						System.out.println("Order Record is as follows: \n");
						or.displayOrder();
						is2.close();
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						 //TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				else if (choose1 == 11) {
					choose = 0;
				}
				
			}
			
			while (choose == 2) {
				System.out.println("\n===============================WELCOME TO CUSTOMER MENU================================\n");
				
				System.out.println("Enter your NAME: ");
				input1.nextLine();
				name = input1.nextLine();
				
				System.out.println("Enter your ID: ");
				id = input1.nextInt();
				
				System.out.println("Enter your Phone Number: ");
				input1.nextLine();
				phoneNo = input1.nextLine();
				
				System.out.println("\n++++++++++++++++++++++++++++++  MENU  ++++++++++++++++++++++++++++++++++\n");
				
				try {
					ObjectInputStream is = new ObjectInputStream(new FileInputStream("foodData.txt"));
					FoodRecord food1 = (FoodRecord) is.readObject();
					fr = food1;
					fr.displayFood();
					is.close();
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("\n---------------------------------------------------------------------------\n");
				System.out.println("To order, Enter \"SERIAL NO.\" of the Food on the Menu: ");
				System.out.print("Enter Here ---> ");
				
				serialNo = input1.nextInt();
				
				Order order = new Order((or.getList().size()+1), fr.getFood(serialNo-1));
				
				or.addOrder(order);
				
				
				System.out.println("DO YOU WANT DISCOUNT ON YOUR ORDER? \nEnter \"1\" for YES and \"2\" for NO: ");
				

				try {
					choose2 = input1.nextInt();
				}catch(InputMismatchException e){
                    System.out.println("ONLY DIGITS ARE ALLOWED!");
                    input1.nextLine();
				}
				
				if (choose2 == 1) {
					if(order.discount(new Customer(name, id, phoneNo), mr)) {
						ObjectOutputStream os2 = new ObjectOutputStream(new FileOutputStream("orderData.txt"));
						System.out.println("DO YOU WANT TO BECOME A MEMBER? Enter \"1\" for YES and \"2\" for NO: ");
						
						try {
							choose2 = input1.nextInt();
						}catch(InputMismatchException e){
		                    System.out.println("ONLY DIGITS ARE ALLOWED!");
		                    input1.nextLine();
						}
						
						
						if (choose2 == 1) {
							mr.addMember(new Customer(name, id, phoneNo));
							System.out.println("YOU HAVE BECOME A MEMBER! APPLYING DISCOUNT TO YOUR ORDER....\n");
							order.discount(new Customer(name, id, phoneNo), mr);
							os2.writeObject(or);
							os2.close();
							
						}
						else if (choose2 == 2) {
							os2.writeObject(or);
							os2.close();
							System.out.println("Discount Offer is only valid for MEMBERS.");
						}
					}
				}
				
				else if (choose2 == 2) { 
					ObjectOutputStream os2 = new ObjectOutputStream(new FileOutputStream("orderData.txt"));
					os2.writeObject(or);
					os2.close();
					System.out.println("Okay! No Discount being put on the order...");
				}
					
				System.out.println("\n------------------------- SELECT PAYMENT METHOD ------------------------------\n");
				System.out.println("Select PAYMENT Method:\n-Enter \"1\" for CASH PAYMENT. \n-ENTER \"2\" for CARD(Online) PAYMENT:\n" );
				
				try {
					choose2 = input1.nextInt();
				}catch(InputMismatchException e){
                    System.out.println("ONLY DIGITS ARE ALLOWED!");
                    input1.nextLine();
				}
				
				if (choose2 == 1) {
					Payment pay = new CashPayment(order);
					pay.paymentSlip();
				}
					
				else if (choose2 == 2) {
					System.out.println("\n------------------------- CARD(Online) PAYMENT -----------------------------\n");
						
					System.out.println("Enter CARD NUMBER: \n");
					cardNo = input1.nextLong();
						
					System.out.println("Enter Your PASSWORD: \n");
					input1.nextLine();
					pass = input1.nextLine();		
						
					Payment pay = new CardPayment(cardNo, pass, order);
					pay.paymentSlip();
				}
					
				System.out.println("\n---------------------------------------------------------------------------\n");
				System.out.println("          THANK YOU FOR ORDERING FROM HERE! ENJOY YOUR FOOD :)                 ");
				System.out.println("---------------------------------------------------------------------------\n");
					
				choose =0;
					
				}
			
			if (choose == 3) {
				System.out.println("PROGRAM IS EXITING...");
				System.exit(0);
			}
			
			
			}
			
			
			
		}

	}


