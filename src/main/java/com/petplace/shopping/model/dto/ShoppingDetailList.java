package com.petplace.shopping.model.dto;

public class ShoppingDetailList {
	private String productNo;           // 상품번호
    private String productName;         // 상품명
    private int price;                  // 가격
    private String productImg;			// 썸네일 이미지
    private String detailImg;			// 상세이미지
    private int reviewCount;			// 리뷰 개수
    private int Star;					// 별점
    private int company;				// 택배사(제조사?)
    private String ingredient;			// 주원료
    private String origin;				// 원산지
    private int productWeight;			// 중량
    private int kcal;					// 칼로리
    
    
	public ShoppingDetailList() {
		super();
	}

	
	
	public ShoppingDetailList(String productNo, String productName, int price, String productImg, String detailImg,
			int star, int reviewCount, int company, String ingredient, String origin, int productWeight, int kcal) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.price = price;
		this.productImg = productImg;
		this.detailImg = detailImg;
		Star = star;
		this.reviewCount = reviewCount;
		this.company = company;
		this.ingredient = ingredient;
		this.origin = origin;
		this.productWeight = productWeight;
		this.kcal = kcal;
	}



	public String getDetailImg() {
		return detailImg;
	}



	public void setDetailImg(String detailImg) {
		this.detailImg = detailImg;
	}



	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
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

	public int getCompany() {
		return company;
	}

	public void setCompany(int company) {
		this.company = company;
	}

	public String getingredient() {
		return ingredient;
	}

	public void setingredient(String ingredient) {
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


	

	@Override
	public String toString() {
		return "ShoppingDetailList [productNo=" + productNo + ", productName=" + productName + ", price=" + price
				+ ", productImg=" + productImg + ", detailImg=" + detailImg + ", Star=" + Star + ", reviewCount="
				+ reviewCount + ", company=" + company + ", ingredient=" + ingredient + ", origin=" + origin
				+ ", productWeight=" + productWeight + ", kcal=" + kcal + "]";
	}


	
    
    

}
