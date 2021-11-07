package com.bridgelabz.JavaStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MasterBook {

	Scanner scanner = new Scanner(System.in);
	HashMap<String, AddressBook> masterBook = new HashMap<>();

	public static void main(String[] args) {
		MasterBook masterBook = new MasterBook();
		masterBook.mainMenuMasterBook();
	}

	public void mainMenuMasterBook() {
		boolean option = false;
		int choice = 1;
		printDetails();
		while (!option) {
			System.out.println("Enter Your Choice : ");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				printDetails();
				break;
			case 2:
				addAddressBook();
				break;
			case 3:
				addContactsInAddressBook();
				break;
			case 4: 
				searchContactsByCityName();
				break;
			case 5: 
				searchContactByStateName();
			case 6:
				option = true;
			}
		}
	}

	public void printDetails() {
		System.out.println("Welcome to the Master Book.");
		System.out.println("Press : ");
		System.out.println("\t 1. Print Menu Again.");
		System.out.println("\t 2. Add New Address Book to the Master Book");
		System.out.println("\t 3. Add contact in the Existing Address Book");
		System.out.println("\t 4. Search contact via city name : ");
		System.out.println("\t 5. Search contact via state name : ");
		System.out.println("\t 6. Exit");
	}

	public void addAddressBook() {
		System.out.println("Enter the Name of the City for which you want to add Address Book: ");
		String cityName = scanner.nextLine();
		masterBook.put(cityName, new AddressBook());
		System.out.println("Address Book Added : ");
		System.out.println("Would You like to add contact in this Address Book : ");
		System.out.println("1 Add contact in this Address Book : ");
		System.out.println("2 Main menu : ");
		int choice = scanner.nextInt();
		scanner.nextLine();
		if (choice == 1) {
			masterBook.get(cityName).mainMenuAddressBook();
		} else {
			mainMenuMasterBook();
		}
	}

	public void addContactsInAddressBook() {
		System.out.println("Enter the name of address Book in which you want to add contact : ");
		String addressBookName = scanner.nextLine();
		if (masterBook.get(addressBookName) == null) {
			System.out.println("Address Book Not Exist. Create new Address Book.");
		} else {
			masterBook.get(addressBookName).mainMenuAddressBook();
		}
	}
	
	public void searchContactsByCityName() {
		System.out.println("Enter the name of the city : ");
		String cityName = scanner.nextLine();
		for (Map.Entry<String, AddressBook> entry : masterBook.entrySet()) {
			entry.getValue().searchContactByCity(cityName);
		}
	}
	
	public void searchContactByStateName() {
		System.out.println("Enter the name of State : ");
		String stateName = scanner.nextLine();
		for(Map.Entry<String, AddressBook> entry : masterBook.entrySet()) {
			entry.getValue().searchContactByState(stateName);
		}
	}
	
	public void viewCountOfContactsFromSpecificCityName() {
		long totalCount = 0;
		long count = 0;
		System.out.println("Enter the name of the City : ");
		String cityName = scanner.nextLine();
		for (Map.Entry<String, AddressBook> entry : masterBook.entrySet()) {
			count = entry.getValue().viewCountOfContactsFromSpecificCity(cityName);
			totalCount += count;
		}
		System.out.println("Total contacts from " + cityName + " city is " + totalCount);
	}
	
	public void viewCountOfContactFromSpecificStateName() {
		long totalCount = 0;
		long count = 0;
		System.out.println("Enter the name of the State : ");
		String stateName = scanner.nextLine();
		for (Map.Entry<String, AddressBook> entry : masterBook.entrySet()) {
			count = entry.getValue().viewCountOfContactsFromSpecificCity(stateName);
			totalCount += count;
		}
		System.out.println("Total contacts from " + stateName + " state is " + totalCount);
	
	}
}