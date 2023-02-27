package com.entity;

public class Doctor {


	
	private String id;

	
	private String fullName;
	private String dob;
	private String qualification;
	private String specialist;
	private String email;
	private String mob;
	private String password;


	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Doctor(String fullName, String dob, String qualification, String specialist, String email, String mob,
			String password) {
		super();
		this.fullName = fullName;
		this.dob = dob;
		this.qualification = qualification;
		this.specialist = specialist;
		this.email = email;
		this.mob = mob;
		this.password = password;
	}
	
	
	

	

	public Doctor(String id, String fullName, String dob, String qualification, String specialist, String email,
			String mob, String password) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.dob = dob;
		this.qualification = qualification;
		this.specialist = specialist;
		this.email = email;
		this.mob = mob;
		this.password = password;
	}

	
	
	 public Doctor(String fullName, String specialist, String email, String mob) {
	        this.fullName = fullName;
	        this.specialist = specialist;
	        this.email = email;
	        this.mob = mob;
	    }
	
	
	
	
	
	//Made change int to string

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public String getSpecialist() {
		return specialist;
	}


	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}




	public String getMob() {
		return mob;
	}


	public void setMob(String mob) {
		this.mob = mob;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Doctor [id=" + id + ", fullName=" + fullName + ", dob=" + dob + ", qualification=" + qualification
				+ ", specialist=" + specialist + ", email=" + email + ", mob=" + mob + ", password=" + password + "]";
	}



}
