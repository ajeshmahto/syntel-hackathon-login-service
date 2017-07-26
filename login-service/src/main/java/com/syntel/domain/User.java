package com.syntel.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name = "User.verifyLogin", query = "SELECT u FROM User u WHERE u.mobileNumber = ?1 and u.password=?2")
public class User {
	
	@Id
	private String mobileNumber;
	private String emailId;
	private String name;
	private String password;
	private int userType;
	
	public User(){}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	

}
