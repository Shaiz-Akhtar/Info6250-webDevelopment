package com.entity;

public class User {

	private int id;
	private String fullName;
	private String email;
	private String phone;
	private String city;
	private String state;
	private String postalcode;
	private String password;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String fullName, String email, String phone, String city, String state, String postalcode,
			String password) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.city = city;
		this.state = state;
		this.postalcode = postalcode;
		this.password = password;

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



}
