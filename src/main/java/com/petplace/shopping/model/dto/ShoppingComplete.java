package com.petplace.shopping.model.dto;

import java.sql.Date;

public class ShoppingComplete {
	private String memberName;
	private String phone;
	private String email;
	private String address;
	private String request;
	private int wayBill;
	private String productName;
	private int amountPrice;
	private Date purchaseDate;
	
	public ShoppingComplete() {
		super();
	}

	public ShoppingComplete(String memberName, String phone, String email, String address, String request, int wayBill,
			String productName, int amountPrice, Date purchaseDate) {
		super();
		this.memberName = memberName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.request = request;
		this.wayBill = wayBill;
		this.productName = productName;
		this.amountPrice = amountPrice;
		this.purchaseDate = purchaseDate;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public int getWayBill() {
		return wayBill;
	}

	public void setWayBill(int wayBill) {
		this.wayBill = wayBill;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getAmountPrice() {
		return amountPrice;
	}

	public void setAmountPrice(int amountPrice) {
		this.amountPrice = amountPrice;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public String toString() {
		return "ShoppingComplete [memberName=" + memberName + ", phone=" + phone + ", email=" + email + ", address="
				+ address + ", request=" + request + ", wayBill=" + wayBill + ", productName=" + productName
				+ ", amountPrice=" + amountPrice + ", purchaseDate=" + purchaseDate + "]";
	}
	
	
}
