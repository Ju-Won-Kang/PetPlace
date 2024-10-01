package com.petplace.purchase.model.vo;

/**
 * packageName    : com.petplace.purchase.model.vo
 * fileName       : Purchase
 * author         : jun
 * date           : 2024. 9. 30.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 30.        jun       최초 생성
 */
public class Purchase {
    private int purchaseNo;      // 구매코드
    private String memberId;        // 주문자 아이디
    private int productNo;       // 상품번호
    private int quantity;           // 구매수량
    private int amountPrice;        // 결제금액
    private String purchaseDate;    // 결제일
    private String payType;         // 결제수단
    private String request;         // 요청사항
    private String cardNo;          // 카드번호
    private int wayBill;            // 운송장 번호
    private String multiDetail;     // 다중 구매 내용

    public Purchase() {
    }

    public Purchase(int purchaseNo, String memberId, int productNo, int quantity, int amountPrice, String purchaseDate, String payType, String request, String cardNo, int wayBill, String multiDetail) {
        this.purchaseNo = purchaseNo;
        this.memberId = memberId;
        this.productNo = productNo;
        this.quantity = quantity;
        this.amountPrice = amountPrice;
        this.purchaseDate = purchaseDate;
        this.payType = payType;
        this.request = request;
        this.cardNo = cardNo;
        this.wayBill = wayBill;
        this.multiDetail = multiDetail;
    }

    public int getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(int purchaseNo) {
        this.purchaseNo = purchaseNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmountPrice() {
        return amountPrice;
    }

    public void setAmountPrice(int amountPrice) {
        this.amountPrice = amountPrice;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getWayBill() {
        return wayBill;
    }

    public void setWayBill(int wayBill) {
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
        return "Purchase{" +
                "purchaseNo='" + purchaseNo + '\'' +
                ", memberId='" + memberId + '\'' +
                ", productNo='" + productNo + '\'' +
                ", quantity=" + quantity +
                ", amountPrice=" + amountPrice +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", payType='" + payType + '\'' +
                ", request='" + request + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", wayBill=" + wayBill +
                ", multiDetail='" + multiDetail + '\'' +
                '}';
    }
}
