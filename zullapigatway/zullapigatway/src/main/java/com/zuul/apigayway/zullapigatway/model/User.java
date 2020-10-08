package com.zuul.apigayway.zullapigatway.model;
public class User {
	private long id;
	private String fName;
	private String lName;
	private String email;
	private String userName;
	private String password;
	private Long phone;
	
	public User() {}
	public User(long id, String fName, String lName, String email, String userName, String password, Long phone) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	

}
