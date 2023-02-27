package com.entity;

public class Appointment {
	
	private String id;
	private int userId;
	private String fullName;
	private String gender;
	private String age;
	private String appointmentDate;
	private String email;
	private String phone;
	private String diseases;
	private String docName;
	private String address;
	private String status;
	
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Appointment( String fullName, String gender, String age, String appointmentDate, String email,
			String phone, String diseases, String docName, String address, String status) {
		super();
//		this.userId = userId;
		this.fullName = fullName;
		this.gender = gender;
		this.age = age;
		this.appointmentDate = appointmentDate;
		this.email = email;
		this.phone = phone;
		this.diseases = diseases;
		this.docName = docName;
		this.address = address;
		this.status = status;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getAppointmentDate() {
		return appointmentDate;
	}


	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
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


	public String getDiseases() {
		return diseases;
	}


	public void setDiseases(String diseases) {
		this.diseases = diseases;
	}


	public String getDocName() {
		return docName;
	}


	public void setDocName(String docName) {
		this.docName = docName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Appointment [id=" + id + ", userId=" + userId + ", fullName=" + fullName + ", gender=" + gender
				+ ", age=" + age + ", appointmentDate=" + appointmentDate + ", email=" + email + ", phone=" + phone
				+ ", diseases=" + diseases + ", docName=" + docName + ", address=" + address + ", status=" + status
				+ "]";
	}


	
	
	
	
}
