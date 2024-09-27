package com.petplace.shopping.model.vo;

import java.sql.Date;

public class Shopping {
    private String productNo;           // 상품번호
    private String productCategory;     // 상품카테고리명
    private String company;             // 제조사
    private String productName;         // 상품명
    private int price;                  // 가격
    private int inventory;              // 상품재고수량
    private String ingredient;          // 주원료
    private String origin;              // 원산지
    private int productWeight;          // 중량
    private int kcal;                   // 칼로리
    private Date enrollDate;            // 등록날짜
    private Date modifyDate;            // 수정날짜
    private String status;              // 상태
    private String productImg;
	
    public Shopping() {
		super();
	}
    
	public Shopping(String productNo, String productName, int price, String productImg) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.price = price;
		this.productImg = productImg;
	}

	public Shopping(String productNo, String productCategory, String company, String productName, int price,
			int inventory, String ingredient, String origin, int productWeight, int kcal, Date enrollDate,
			Date modifyDate, String status, String productImg) {
		super();
		this.productNo = productNo;
		this.productCategory = productCategory;
		this.company = company;
		this.productName = productName;
		this.price = price;
		this.inventory = inventory;
		this.ingredient = ingredient;
		this.origin = origin;
		this.productWeight = productWeight;
		this.kcal = kcal;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
		this.productImg = productImg;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public int getProductWeight() {
		return productWeight;
	}

	public void setProductWeight(int productWeight) {
		this.productWeight = productWeight;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	@Override
	public String toString() {
		return "Shopping [productNo=" + productNo + ", productCategory=" + productCategory + ", company=" + company
				+ ", productName=" + productName + ", price=" + price + ", inventory=" + inventory + ", ingredient="
				+ ingredient + ", origin=" + origin + ", productWeight=" + productWeight + ", kcal=" + kcal
				+ ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", status=" + status + ", productImg="
				+ productImg + "]";
	}
    
    
}
