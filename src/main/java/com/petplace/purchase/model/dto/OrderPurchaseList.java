package com.petplace.purchase.model.dto;

public class OrderPurchaseList {
	private int memberName;	//이름
	private int memberId; 	//아이디
    private String email;	//이메일 (ERD에 안보임)
    private int phone;		//전화번호
    private String address;	//주소지
    private String request;	//요청사항 (구매내역 table)
    private int totalProductPrice; 	//총상품가격(ERD에 없음, 따로 값을 넣어줘야하나)	      
    private String amountPrice;		//총 결제금액

}
