package com.bridgelabz.JavaStream;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	Scanner scanner = new Scanner(System.in);
	ArrayList<Contact> person = new ArrayList<>();

	public void mainMenuAddressBook() {

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
				addContacts();
				break;
			case 3:
				editContacts();
				break;
			case 4:
				searchContacts();
				break;
			case 5:
				showAddressBook();
				break;
			case 6:
				deleteContacts();
				break;
			case 7:
				option = true;
				break;
			}
		}
	}

	public void printDetails() {
		System.out.println("Welcome to Address Book.");
		System.out.println("\t 1 Print Choice Options. ");
		System.out.println("\t 2 Add the contact details.");
		System.out.println("\t 3 Edit the contact details.");
		System.out.println("\t 4 Display Details of Specific person.");
		System.out.println("\t 5 Display Full Address Book.");
		System.out.println("\t 6 Delete Person Details from Address Book.");
		System.out.println("\t 7 Exit Address Book App.");
	}

	public void addContacts() {

		System.out.println("Enter First Name : ");
		String fName = scanner.nextLine();
		if (person.stream().anyMatch(n -> n.getFirstName().equals(fName))) {
			System.out.println("Person Details already present, You can't add details of same person.");
			mainMenuAddressBook();
		}
		System.out.println("Enter Last Name : ");
		String lName = scanner.nextLine();
		System.out.println("Enter your City : ");
		String city = scanner.nextLine();
		System.out.println("Enter your State : ");
		String state = scanner.nextLine();
		System.out.println("Enter your Email-ID : ");
		String email = scanner.nextLine();
		System.out.println("Enter your Zip code : ");
		String zip = scanner.nextLine();
		System.out.println("Enter your Mobile Number : ");
		long mNumber = scanner.nextLong();
		scanner.nextLine();
		System.out.println();

		person.add(new Contact(fName, lName, city, state, email, zip, mNumber));
	}

	private void editContacts() {
		System.out.println("Enter the Name of the person whose details you want to Edit : ");
		String name = scanner.nextLine();
		for (int i = 0; i < person.size(); i++) {
			if (person.get(i).getFirstName().equalsIgnoreCase(name)) {

				System.out.println("Choose What you want to Update : ");
				System.out.println("\t 1.Update First Name.");
				System.out.println("\t 2.Update Last Name.");
				System.out.println("\t 3.Update City.");
				System.out.println("\t 4.Update State.");
				System.out.println("\t 5.Update Email-ID.");
				System.out.println("\t 6.Update Zip code.");
				System.out.println("\t 7.Update Mobile Number.");

				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
					System.out.println("Enter Updated First Name : ");
					person.get(i).setFirstName(scanner.nextLine());
					break;
				case 2:
					System.out.println("Enter Updated Last Name : ");
					person.get(i).setLastName(scanner.nextLine());
					break;
				case 3:
					System.out.println("Enter Updated City : ");
					person.get(i).setCity(scanner.nextLine());
					break;
				case 4:
					System.out.println("Enter Updated State : ");
					person.get(i).setState(scanner.nextLine());
					break;
				case 5:
					System.out.println("Enter Updated Email ID : ");
					person.get(i).setEmail(scanner.nextLine());
					break;
				case 6:
					System.out.println("Enter Updated Zip Code : ");
					person.get(i).setZip(scanner.nextLine());
					scanner.nextLine();
					break;
				case 7:
					System.out.println("Enter Updated Mobile Number : ");
					person.get(i).setPhoneNumber(scanner.nextLong());
					scanner.nextLine();
					break;
				}
			} else {
				System.out.println("Contact Details are not present. :( ");
			}
		}
	}

	public void searchContacts() {
		System.out.println("Enter your name to search for your details : ");
		String name = scanner.nextLine();
		for (int i = 0; i < person.size(); i++) {
			if (person.get(i).getFirstName().equalsIgnoreCase(name)) {
				System.out.println(person.get(i));
				break;
			} else
				System.out.println("Person Details are not present.");
		}
	}

	public void showAddressBook() {
		for (Contact c : person) {
			System.out.println(c);
		}
	}

	public void deleteContacts() {
		System.out.println("Enter Person Name to delete all the data related to that Person : ");
		String name = scanner.nextLine();
		for (int i = 0; i < person.size(); i++) {
			if (person.get(i).getFirstName().equalsIgnoreCase(name)) {
				person.remove(i);
				break;
			} else {
				System.out.println("Entered Name is not matching wih any Persons details.");
			}
		}
	}

	public void searchContactByState(String stateName) {
		person.stream().filter(p -> p.getState().equalsIgnoreCase(stateName)).forEach(System.out::println);
	}
	
	public void searchContactByCity(String cityName) {
		person.stream().filter(p -> p.getCity().equalsIgnoreCase(cityName)).forEach(System.out::println);
	}
	
	public long viewCountOfContactsFromSpecificCity(String cityName) {
		return person.stream().filter(p -> p.getCity().equalsIgnoreCase(cityName)).count();
	}
	
	public long viewCountOfContactsFromSpecificState(String stateName) {
		return person.stream().filter(p -> p.getState().equalsIgnoreCase(stateName)).count();
	}
	
	public void sortContactByPersonName() {
		 person.stream().sorted((s1,s2) -> s1.getFirstName().compareTo(s2.getFirstName())).forEach(System.out::println);
	}
	
	public void sortContactByPersonCity() {
		 person.stream().sorted((s1,s2) -> s1.getCity().compareTo(s2.getCity())).forEach(System.out::println);
	}
	
	public void sortContactByPersonState() {
		 person.stream().sorted((s1,s2) -> s1.getState().compareTo(s2.getState())).forEach(System.out::println);
	}
	
	public void sortContactByPersonZipCode() {
		 person.stream().sorted((s1,s2) -> s1.getZip().compareTo(s2.getZip())).forEach(System.out::println);
	}
}