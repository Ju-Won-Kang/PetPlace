package com.petplace.purchase.model.dto;

import java.sql.Date;

/**
 * packageName    : com.petplace.purchase.model.dto
 * fileName       : PurchaseList
 * author         : jun
 * date           : 2024. 9. 30.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 30.        jun       최초 생성
 */
public class PurchaseList {
    private int purchaseNo;      	// 구매코드
    private String productName;     // 상품명
    private int quantity;           // 구매수량
    private String memberId;        // 주문자 아이디
    private String payType;         // 결제수단
    private int amountPrice;        // 결제금액
    private String request;         // 요청사항
    private Date purchaseDate;    // 결제일
    private String wayBill;            // 운송장 번호
    private String multiDetail;     // 다중 구매 내용

    public PurchaseList() {
    }

	public PurchaseList(int purchaseNo, String productName, int quantity, String memberId, String payType,
			int amountPrice, String request, Date purchaseDate, String wayBill, String multiDetail) {
		super();
		this.purchaseNo = purchaseNo;
		this.productName = productName;
		this.quantity = quantity;
		this.memberId = memberId;
		this.payType = payType;
		this.amountPrice = amountPrice;
		this.request = request;
		this.purchaseDate = purchaseDate;
		this.wayBill = wayBill;
		this.multiDetail = multiDetail;
	}

	public int getPurchaseNo() {
		return purchaseNo;
	}

	public void setPurchaseNo(int purchaseNo) {
		this.purchaseNo = purchaseNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public int getAmountPrice() {
		return amountPrice;
	}

	public void setAmountPrice(int amountPrice) {
		this.amountPrice = amountPrice;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getWayBill() {
		return wayBill;
	}

	public void setWayBill(String wayBill) {
		this.wayBill = wayBill;
	}

	public String getMultiDetail() {
		return multiDetail;
	}

	public void setMultiDetail(String multiDetail) {
		this.multiDetail = multiDetail;
	}

	@Override
	public String toString() {
		return "PurchaseList [purchaseNo=" + purchaseNo + ", productName=" + productName + ", quantity=" + quantity
				+ ", memberId=" + memberId + ", payType=" + payType + ", amountPrice=" + amountPrice + ", request="
				+ request + ", purchaseDate=" + purchaseDate + ", wayBill=" + wayBill + ", multiDetail=" + multiDetail
				+ "]";
	}



    
}
