package com.bridgelabz.JavaStream;
public class Contact {
	private String firstName, lastName, city, state, email;
	private int zip;
	private long phoneNumber;

	public Contact(String firstName, String lastName, String city, String state, String email, int zip,
			long phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.state = state;
		this.email = email;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getEmail() {
		return email;
	}

	public int getZip() {
		return zip;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "\n First Name = " + firstName + "\n Last Name = " + lastName + "\n  City = " + city + "\n State = " + state
				+ "\n Email ID = " + email + "\n Zip Code = " + zip + "\n Phone Number = " + phoneNumber;
	}
}