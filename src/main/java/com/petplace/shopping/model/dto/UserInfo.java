package com.petplace.shopping.model.dto;

public class UserInfo {
	private String userName;
//	private String email;
	private String phone;
	private String address;
	
	
	public UserInfo() {
		super();
	}


	public UserInfo(String userName, String phone, String address) {
		super();
		this.userName = userName;
		this.phone = phone;
		this.address = address;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "UserInfo [userName=" + userName + ", phone=" + phone + ", address=" + address + "]";
	}



}
