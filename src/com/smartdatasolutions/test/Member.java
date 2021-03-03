package com.smartdatasolutions.test;

import java.util.Objects;

public class Member {

	private String id;
	private String address;
	private String city;
	private String firstName;
	private String lastName;
	private String state;
	private String zip;

	// Default constructor
	public Member() {
	}

	// Parameterized constructor
	public Member(String id, String lastName, String firstName, String address, String city, String state, String zip) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String toCSVString() {
		return id + "," + firstName + "," + lastName + "," + address + "," + city + "," + zip + "\n";
	}

	/**
	 * Equals and hashCode methods are created to compare if the member objects are
	 * same or not. Source:
	 * https://www.geeksforgeeks.org/equals-hashcode-methods-java/
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Member member = (Member) obj;
		return Objects.equals(id, member.id) && Objects.equals(address, member.address)
				&& Objects.equals(city, member.city) && Objects.equals(firstName, member.firstName)
				&& Objects.equals(lastName, member.lastName) && Objects.equals(state, member.state)
				&& Objects.equals(zip, member.zip);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, address, city, firstName, lastName, state, zip);
	}
}
