package core_java_Restaurant_Management_System;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RestaurantOwner {

	static HashMap<String, Float> menu;

	RestaurantOwner() {
		menu = new HashMap<String, Float>();
	}

	boolean authorize(String username, String password) {
		return username.equals("Onkar") && password.equals("1234");
	}

	/*
	 * If menu already contains the food item don't add it in menu again and return
	 * false, Else add the food item in menu and return true.
	 */
	boolean addItem(String food, float price) {
		if (menu.containsKey(food))
			return false;
		menu.put(food, price);
		return true;
	}

	/*
	 * First check if food item exists in menu. If exists then delete and return
	 * true, else return false
	 */
	boolean deleteItem(String food) {
		if (menu.containsKey(food)) {
			menu.remove(food);
			return true;
		} else
			return false;
	}

	/*
	 * First delete the existing food. If no such food is found, it adds food to the
	 * menu, else updates the price
	 */
	boolean update(String food, float price) {
		try {
			deleteItem(food);
			addItem(food, price);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	void dispalyMenu() {
		if (menu.isEmpty()) {
			System.out.println("Menu Empty. ");
			return;
		}
		Set<String> foodNames = new HashSet<String>();
		foodNames = menu.keySet();
		System.out.println("-------------------------------------");
		System.out.println("FOOD \t PRICE");
		System.out.println("-------------------------------------");
		for (String food : foodNames) {
			System.out.println(food + "\t" + menu.get(food));
		}
		System.out.println("-------------------------------------");
	}
}
