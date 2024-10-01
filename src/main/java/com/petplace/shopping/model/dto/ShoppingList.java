package com.petplace.shopping.model.dto;

import java.sql.Date;

public class ShoppingList {
    private String productNo;           // 상품번호
    private String productCategory;     // 상품카테고리명
    private String productName;         // 상품명
    private int price;                  // 가격
    private String productImg;
    private int Star;
    private int reviewCount;
	
    public ShoppingList() {
		super();
	}

	public ShoppingList(String productNo, String productCategory, String productName, int price, String productImg,
			int star, int reviewCount) {
		super();
		this.productNo = productNo;
		this.productCategory = productCategory;
		this.productName = productName;
		this.price = price;
		this.productImg = productImg;
		Star = star;
		this.reviewCount = reviewCount;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public int getStar() {
		return Star;
	}

	public void setStar(int star) {
		Star = star;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	@Override
	public String toString() {
		return "ShoppingAllList [productNo=" + productNo + ", productCategory=" + productCategory + ", productName="
				+ productName + ", price=" + price + ", productImg=" + productImg + ", Star=" + Star + ", reviewCount="
				+ reviewCount + "]";
	}
    
	
}
