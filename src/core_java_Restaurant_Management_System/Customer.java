package core_java_Restaurant_Management_System;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Customer extends RestaurantOwner implements GST{
	
	/*
	 * "order" HashMap to store the food items and its quantity ordered by customer.
	 * GST is an interface which has GSTInterestRate
	 */
	
	
	HashMap<String, Integer> order;
	GST gst;
	
	Customer(){
		order = new HashMap<String, Integer>();
		gst = null;
	}
	
	void displayMenu() {
		super.dispalyMenu();
	}
	
	
	/*
	 * Check if the order HashMap is empty. If its empty then return, else display
	 * all the food items and its quantity ordered by customer.
	 */
	
	
	void displayOrder(){
		if (order.isEmpty()) {
			System.out.println("No items in order. ");
			return;
		}
		
		Set<String> foodNames = new HashSet<String>();
		foodNames = order.keySet();
		System.out.println("-------------------------------------");
		System.out.println("FOOD \t QUANTITY \t PRICE \t TOTAL");
		System.out.println("-------------------------------------");
		for (String food : foodNames) {
			System.out.println(food + "\t" + order.get(food) + "\t" + menu.get(food) + "\t" + menu.get(food) * order.get(food));
		}
		System.out.println("-------------------------------------\n");
	}
	
	
	
	/*
	 * Check if the menu contains the food item ordered by the customer. If it does
	 * not exist in menu return false, else add the food item in customer's order.
	 */
	boolean orderFood(String food, int quantity) {
		if(!super.menu.containsKey(food))
			return false;
		order.put(food, quantity);
		return true;
	}
	
	
	/*
	 * Check if the order contains the food item ordered by the customer. If it does
	 * not exist in order return false, else remove the food item from customer's
	 * order.
	 */
	boolean removeFood(String food) {
		if(!order.containsKey(food)) {
			return false;
		}
		else {
			order.remove(food);
			return true;
		}
	}
	
	/*
	 * If the food item already exists in order, first remove the food item and then
	 * add the updated (food,quantity) in order. If food item does not exist in
	 * order it will just add it as a new entry.
	 */
	
	boolean update(String food,int quantity) {
		try {
			removeFood(food);
			order.put(food, quantity);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
//	Here we calculate the total amount for the food items ordered, including GST.
	double totalBill() {
		double amount = 0;
		Set<String> foodNames = new HashSet<String>();
		foodNames = order.keySet();
		for (String food : foodNames) {
			amount += (super.menu.get(food) * order.get(food));
		}
		double tax = gst.GSTTaxPercent * amount /100;
		return amount + tax;
	}
	
}






























