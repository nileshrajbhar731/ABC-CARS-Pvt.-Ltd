package com.lithan.ABC_Cars_Pte_Ltd.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
    private String fullName;
	private String userName;
	private String password;
	private String mailid;
	private String role;
	
	public User() {
		
	}

	public User(Long userId, String fullName, String userName, String password, String mailid, String role) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.userName = userName;
		this.password = password;
		this.mailid = mailid;
		this.role = role;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName + ", userName=" + userName + ", password=" + password
				+ ", mailid=" + mailid + ", role=" + role + "]";
	}

	

	
}

