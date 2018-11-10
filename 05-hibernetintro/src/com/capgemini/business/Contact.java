package com.capgemini.business;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity   //mandatory

public class Contact {
	@Id //mandatory
	private int id;	
	private String name;
	private String phoneNumber;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Contact(int id, String name, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	public Contact() {
		super();
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", phoneNumber=" + phoneNumber + ", name="
				+ name + "]";
	}
	
	

}
