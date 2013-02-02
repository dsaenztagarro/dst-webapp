package com.davlanca.webapp.model;

public class People {
	
	private int peopleID;
	private String firstName;
	private String lastName;
	
	public People(int peopleID, String firstName, String lastName) {
		this.peopleID = peopleID;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public int getPeopleID() {
		return peopleID;
	}
	public void setPeopleID(int peopleID) {
		this.peopleID = peopleID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
